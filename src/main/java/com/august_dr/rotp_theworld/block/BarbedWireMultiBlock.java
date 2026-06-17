package com.august_dr.rotp_theworld.block;

import com.august_dr.rotp_theworld.tileentity.BarbedWireTileEntity;
import com.august_dr.rotp_theworld.init.ModTileEntities;
import com.august_dr.rotp_theworld.util.mc.damage.DamageUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.block.Block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class BarbedWireMultiBlock extends Block {

    private static final int PART_WITH_TILE_ENTITY = 4;
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final IntegerProperty PART = IntegerProperty.create("barbed_wire_part", 0, 5);
    protected static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 5.0D, 4.0D, 16.0D, 11.0D, 11.0D);
    protected static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 5.0D, 4.0D, 16.0D, 11.0D, 11.0D);
    protected static final VoxelShape WEST_SHAPE = Block.box(4.0D, 5.0D, 0.0D, 11.0D, 11.0D, 16.0D);
    protected static final VoxelShape EAST_SHAPE = Block.box(5.0D, 5.0D, 0.0D, 11.0D, 11.0D, 16.0D);

    public BarbedWireMultiBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(PART, PART_WITH_TILE_ENTITY));
    }

    @Override
    public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        int multiBlockPart = state.getValue(PART);
        Direction right = rightDirection(state);
        BlockPos leftUpPos = pos.relative(right, -(multiBlockPart % 2)).relative(Direction.UP, multiBlockPart / 2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (j * 2 + i != multiBlockPart) {
                    BlockPos blockPos = leftUpPos.relative(right, i).relative(Direction.DOWN, j);
                    BlockState blockState = world.getBlockState(blockPos);
                    if (blockState.getBlock() == this && blockState.getValue(PART) == j * 2 + i) {
                        world.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 35);
                        world.levelEvent(player, 2001, blockPos, Block.getId(blockState));
                    }
                }
            }
        }
        super.playerWillDestroy(world, pos, state, player);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getClickedPos();
        if (blockpos.getY() < 254) {
            World world = context.getLevel();
            Direction right = context.getHorizontalDirection().getClockWise();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!world.getBlockState(blockpos.above(j).relative(right, i)).canBeReplaced(context)) {
                        return null;
                    }
                }
            }
            Direction left = context.getHorizontalDirection().getCounterClockWise();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!world.getBlockState(blockpos.above(j).relative(left, i)).canBeReplaced(context)) {
                        return null;
                    }
                }
            }
            return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
        }
        return null;
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        BlockPos up1 = pos.above();
        world.setBlock(up1, state.setValue(PART, 3), 3);
        Direction right = rightDirection(state);
        world.setBlock(pos.relative(right), state.setValue(PART, 4), 3);
        world.setBlock(up1.relative(right), state.setValue(PART, 5), 3);
        Direction left = leftDirection(state);
        world.setBlock(pos.relative(left), state.setValue(PART, 1), 3);
        world.setBlock(up1.relative(left), state.setValue(PART, 2), 3);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Deprecated
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return mirror == Mirror.NONE ? state : state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        switch(state.getValue(FACING)) {
            case EAST:
                return EAST_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case NORTH:
            default:
                return NORTH_SHAPE;
        }
    }

    private static final float DAMAGE_AMOUNT = 3;

    @Override
    public void entityInside(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClientSide()) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;

                if (DamageUtil.dealWireDamage(livingEntity, DAMAGE_AMOUNT, null)) {
                    livingEntity.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 15, 2, false, false, true));

                    Effect bleedingEffect = ForgeRegistries.POTIONS.getValue(new ResourceLocation("rotp_theworld", "bleeding"));
                    if (bleedingEffect != null) {
                        livingEntity.addEffect(new EffectInstance(bleedingEffect, 200, 0, false, false, true));
                    }

                    BlockPos tileEntityPos = posByPart(state, pos, PART_WITH_TILE_ENTITY);
                    TileEntity tileEntity = world.getBlockEntity(tileEntityPos);
                    if (tileEntity instanceof BarbedWireTileEntity) {
                        ((BarbedWireTileEntity) tileEntity).incAbsorbed();
                    }
                }
            }
        }
    }

    private BlockPos posByPart(BlockState state, BlockPos startingPos, int desiredPart) {
        int startingPart = state.getValue(PART);
        int downOffset = desiredPart / 2 - startingPart / 2;
        int rightOffset = desiredPart % 2 - startingPart % 2;
        if (rightOffset != 0) {
            Direction right = rightDirection(state);
            return startingPos.relative(right, rightOffset).relative(Direction.DOWN, downOffset);
        }
        int leftOffset = desiredPart % 2 - startingPart % 2;
        if (leftOffset != 0) {
            Direction left = leftDirection(state);
            return startingPos.relative(left, leftOffset).relative(Direction.DOWN, downOffset);
        }
        return startingPos.relative(Direction.DOWN, downOffset);
    }
    private Direction rightDirection(BlockState state) {
        return state.getValue(FACING).getClockWise();
    }
    private Direction leftDirection(BlockState state) {
        return state.getValue(FACING).getCounterClockWise();
    }


    @Override
    public boolean hasTileEntity(BlockState state) {
        return state.getValue(PART) == PART_WITH_TILE_ENTITY;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.BARBED_WIRE.get().create();
    }
}

