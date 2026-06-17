package com.august_dr.rotp_theworld.action.stand;

import com.august_dr.rotp_theworld.init.InitSounds;
import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mod.JojoModUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

public class BarbedWireTrap extends StandEntityAction {

    public BarbedWireTrap(Builder builder) {
        super(builder);
    }

    @Override
    public TargetRequirement getTargetRequirement() {
        return TargetRequirement.ENTITY;
    }

    @Override
    public ActionConditionResult checkConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        if (!isTimeStoppedByUser(user)) {
            return ActionConditionResult.createNegative(new TranslationTextComponent("rotp_theworld.message.only_in_time_stop"));
        }

        if (user instanceof PlayerEntity) {
            int wireCount = getBarbedWireCount((PlayerEntity) user);
            if (wireCount < 6) {
                return ActionConditionResult.createNegative(new TranslationTextComponent("rotp_theworld.message.need_barbed_wire"));
            }
        }

        if (target.getType() != ActionTarget.TargetType.ENTITY) {
            return ActionConditionResult.createNegative(new TranslationTextComponent("rotp_theworld.message.target_entity"));
        }

        return super.checkConditions(user, power, target);
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        super.standPerform(world, standEntity, userPower, task);

        if (!world.isClientSide) {
            LivingEntity user = userPower.getUser();
            Entity target = task.getTarget().getEntity();

            if (user instanceof PlayerEntity && target != null) {
                BlockPos groundPos = findGroundBelow(world, target.blockPosition());
                if (groundPos == null || target.getY() - groundPos.getY() > 2) {
                    if (user instanceof PlayerEntity) {
                        ((PlayerEntity) user).displayClientMessage(new TranslationTextComponent("rotp_theworld.message.too_high"), true);
                    }
                    return;
                }

                consumeBarbedWire((PlayerEntity) user, 6);
                placeBarbedWireAround(world, groundPos);
                JojoModUtil.sayVoiceLine(user, InitSounds.DIEGO_AND_NOW_THE_FUN_BEGINS.get());
            }
        }
    }

    private boolean isTimeStoppedByUser(LivingEntity user) {
        return com.github.standobyte.jojo.capability.world.TimeStopHandler.isTimeStopped(user.level, user.blockPosition())
                || user.hasEffect(com.github.standobyte.jojo.init.ModStatusEffects.TIME_STOP.get());
    }

    private int getBarbedWireCount(PlayerEntity player) {
        int count = 0;
        for (ItemStack stack : player.inventory.items) {
            if (!stack.isEmpty() && stack.getItem().getRegistryName() != null
                    && stack.getItem().getRegistryName().toString().equals("rotp_theworld:barbed_wire")) {
                count += stack.getCount();
            }
        }
        return count;
    }

    private void consumeBarbedWire(PlayerEntity player, int amount) {
        int remaining = amount;
        for (ItemStack stack : player.inventory.items) {
            if (!stack.isEmpty() && stack.getItem().getRegistryName() != null
                    && stack.getItem().getRegistryName().toString().equals("rotp_theworld:barbed_wire")) {
                int count = stack.getCount();
                if (count >= remaining) {
                    stack.shrink(remaining);
                    break;
                } else {
                    remaining -= count;
                    stack.setCount(0);
                }
            }
        }
    }

    private BlockPos findGroundBelow(World world, BlockPos start) {
        for (int y = 0; y <= 3; y++) {
            BlockPos checkPos = start.below(y);
            BlockState state = world.getBlockState(checkPos);
            if (state.getMaterial().isSolid() && !state.getMaterial().isReplaceable()) {
                return checkPos;
            }
        }
        return null;
    }

    private boolean canReplace(BlockState state) {
        Block block = state.getBlock();
        return block == Blocks.AIR ||
                block == Blocks.GRASS ||
                block == Blocks.TALL_GRASS ||
                block == Blocks.FERN ||
                block == Blocks.LARGE_FERN ||
                block == Blocks.DEAD_BUSH ||
                block.getTags().contains(net.minecraft.tags.BlockTags.LEAVES.getName()) ||
                block.getTags().contains(net.minecraft.tags.BlockTags.FLOWERS.getName()) ||
                block.getTags().contains(net.minecraft.tags.BlockTags.SMALL_FLOWERS.getName()) ||
                state.getMaterial().isReplaceable();
    }

    private void placeBarbedWireAround(World world, BlockPos ground) {
        Block barbedWire = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("rotp_theworld", "barbed_wire"));
        if (barbedWire == null) return;

        placeWireColumn(world, ground.north(2).west(), barbedWire, Direction.SOUTH);
        placeWireColumn(world, ground.north(2), barbedWire, Direction.SOUTH);
        placeWireColumn(world, ground.north(2).east(), barbedWire, Direction.SOUTH);

        placeWireColumn(world, ground.south(2).west(), barbedWire, Direction.NORTH);
        placeWireColumn(world, ground.south(2), barbedWire, Direction.NORTH);
        placeWireColumn(world, ground.south(2).east(), barbedWire, Direction.NORTH);

        placeWireColumn(world, ground.east(2).north(), barbedWire, Direction.WEST);
        placeWireColumn(world, ground.east(2), barbedWire, Direction.WEST);
        placeWireColumn(world, ground.east(2).south(), barbedWire, Direction.WEST);

        placeWireColumn(world, ground.west(2).north(), barbedWire, Direction.EAST);
        placeWireColumn(world, ground.west(2), barbedWire, Direction.EAST);
        placeWireColumn(world, ground.west(2).south(), barbedWire, Direction.EAST);
    }

    private void placeWireColumn(World world, BlockPos base, Block barbedWire, Direction facing) {
        for (int y = 1; y <= 3; y++) {
            BlockPos placePos = base.above(y);
            if (canReplace(world.getBlockState(placePos))) {
                BlockState state = barbedWire.defaultBlockState();
                if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                    state = state.setValue(BlockStateProperties.HORIZONTAL_FACING, facing);
                }
                world.setBlock(placePos, state, 3);
            }
        }
    }
}
