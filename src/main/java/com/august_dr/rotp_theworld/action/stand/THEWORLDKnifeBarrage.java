package com.august_dr.rotp_theworld.action.stand;

import com.august_dr.rotp_theworld.init.InitSounds;
import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityAction;
import com.github.standobyte.jojo.entity.itemprojectile.KnifeEntity;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;


public class THEWORLDKnifeBarrage extends StandEntityAction {

    public THEWORLDKnifeBarrage(StandEntityAction.Builder builder) {
        super(builder);
    }

    @Override
    public ActionConditionResult checkConditions(LivingEntity player, IStandPower powerInstance, ActionTarget target) {
        if (player instanceof PlayerEntity) {
            if (getKnifeCount((PlayerEntity) player) < 16) {
                return ActionConditionResult.createNegative(new TranslationTextComponent("rotp_theworld.message.not_enough_knives"));
            }
        }
        return super.checkConditions(player, powerInstance, target);
    }

    @Override
    public boolean noAdheringToUserOffset(IStandPower standPower, StandEntity standEntity) {
        return false;
    }

    @Override
    public void standPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        super.standPerform(world, standEntity, userPower, task);

        standEntity.setStandPose(StandPose.BARRAGE);

        if (!world.isClientSide) {
            LivingEntity user = userPower.getUser();
            if (user instanceof PlayerEntity) {
                consumeKnives((PlayerEntity) user, 16);
                world.playSound(null, standEntity.getX(), standEntity.getY(), standEntity.getZ(),
                        InitSounds.THE_WORLD_KNIFE_BARRAGE_VOICE.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
        }
    }

    @Override
    public void standTickWindup(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        super.standTickWindup(world, standEntity, userPower, task);
        standEntity.setStandPose(StandPose.BARRAGE);
        fixStandRotation(standEntity, userPower.getUser());
    }

    @Override
    public void standTickPerform(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        super.standTickPerform(world, standEntity, userPower, task);

        standEntity.setStandPose(StandPose.BARRAGE);
        LivingEntity user = userPower.getUser();
        fixStandRotation(standEntity, user);

        int ticksLeft = task.getTicksLeft();
        if (ticksLeft % 2 == 0) {
            if (!world.isClientSide) {
                KnifeEntity knife = new KnifeEntity(world, standEntity);

                LivingEntity aimingEntity = standEntity.isManuallyControlled() ? standEntity : user;
                Vector3d eyePos = aimingEntity.getEyePosition(1.0F);
                Vector3d lookDir = aimingEntity.getLookAngle();
                Vector3d targetPos = eyePos.add(lookDir.scale(60.0D));

                double spawnY = knife.getEyeY() - 0.4D;
                knife.setPos(knife.getX(), spawnY, knife.getZ());

                Vector3d shootVec = targetPos.subtract(knife.getX(), spawnY, knife.getZ()).normalize();

                float velocity = 2.50F;
                float inaccuracy = 4.50F;
                knife.shoot(shootVec.x, shootVec.y, shootVec.z, velocity, inaccuracy);

                knife.setBaseDamage(3.75F);
                knife.pickup = AbstractArrowEntity.PickupStatus.ALLOWED;

                world.addFreshEntity(knife);
                world.playSound(null, standEntity.getX(), standEntity.getY(), standEntity.getZ(),
                        InitSounds.THE_WORLD_KNIVES_THROW.get(), SoundCategory.PLAYERS, 0.5F, 1.0F);
            }
        }
    }

    @Override
    public void standTickRecovery(World world, StandEntity standEntity, IStandPower userPower, StandEntityTask task) {
        super.standTickRecovery(world, standEntity, userPower, task);
    }

    private void fixStandRotation(StandEntity standEntity, LivingEntity user) {
        if (standEntity.isManuallyControlled()) {
            return;
        }
        if (user != null) {
            float yaw = user.yRot;
            float pitch = user.xRot;

            standEntity.yRot = yaw;
            standEntity.yRotO = yaw;
            standEntity.yBodyRot = yaw;
            standEntity.yBodyRotO = yaw;
            standEntity.yHeadRot = yaw;
            standEntity.yHeadRotO = yaw;
            standEntity.xRot = pitch;
            standEntity.xRotO = pitch;
        }
    }

    private int getKnifeCount(PlayerEntity player) {
        int count = 0;
        for (ItemStack stack : player.inventory.items) {
            if (!stack.isEmpty() && stack.getItem().getRegistryName() != null && stack.getItem().getRegistryName().toString().equals("jojo:knife")) {
                count += stack.getCount();
            }
        }
        return count;
    }

    private void consumeKnives(PlayerEntity player, int amount) {
        int remaining = amount;
        for (ItemStack stack : player.inventory.items) {
            if (!stack.isEmpty() && stack.getItem().getRegistryName() != null && stack.getItem().getRegistryName().toString().equals("jojo:knife")) {
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
}
