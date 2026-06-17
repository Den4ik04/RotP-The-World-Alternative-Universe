package com.august_dr.rotp_theworld.action.stand;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.TimeStop;
import com.github.standobyte.jojo.entity.stand.StandPose;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "rotp_theworld")
public class THEWORLDTimeStop extends TimeStop {

    public THEWORLDTimeStop(Builder builder) {
        super(builder);
    }

    public static final StandPose TIME_STOP = new StandPose("time_stop");

    @Override
    protected boolean autoSummonStand(IStandPower power) {
        return super.autoSummonStand(power) || power.getResolveLevel() < 2;
    }

    @Override
    public int getHoldDurationToFire(IStandPower power) {
        return 0;
    }

    @Override
    public boolean cancelHeldOnGettingAttacked(IStandPower power, DamageSource dmgSource, float dmgAmount) {
        return true;
    }

    // --- HORSE TIME STOP IMMUNITY ---
    private static final java.util.Map<java.util.UUID, Entity> lastRiddenVehicle = new java.util.concurrent.ConcurrentHashMap<>();

    @SubscribeEvent
    public static void onLivingUpdate(net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (!entity.level.isClientSide()) {
            if (entity.getRandom().nextInt(200) == 0) {
                long now = System.currentTimeMillis();
                heavyPunchedInTimeStop.entrySet().removeIf(entry -> (now - entry.getValue()) > 15000);
            }
            if (entity.hasEffect(com.github.standobyte.jojo.init.ModStatusEffects.TIME_STOP.get())) {
                Entity vehicle = entity.getVehicle();
                if (vehicle instanceof LivingEntity && !((LivingEntity) vehicle).hasEffect(com.github.standobyte.jojo.init.ModStatusEffects.TIME_STOP.get())) {
                    ((LivingEntity) vehicle).addEffect(new net.minecraft.potion.EffectInstance(
                            com.github.standobyte.jojo.init.ModStatusEffects.TIME_STOP.get(), 20, 0, false, false, true));
                }
            }
            if (entity instanceof net.minecraft.entity.player.PlayerEntity) {
                net.minecraft.entity.player.PlayerEntity player = (net.minecraft.entity.player.PlayerEntity) entity;
                Entity vehicle = player.getVehicle();
                if (vehicle != null) {
                    lastRiddenVehicle.put(player.getUUID(), vehicle);
                } else {
                    Entity lastVehicle = lastRiddenVehicle.remove(player.getUUID());
                    if (lastVehicle != null && lastVehicle.isAlive()) {
                        double distSqr = player.distanceToSqr(lastVehicle);
                        if (distSqr > 9.0) {
                            lastVehicle.teleportTo(player.getX(), player.getY(), player.getZ());
                            lastVehicle.fallDistance = 0;
                            player.fallDistance = 0;
                            player.startRiding(lastVehicle, true);
                        }
                    }
                }
            }
        }
    }

    // --- HEAVY PUNCH KILL IN TS SOUND LOGIC ---
    private static final java.util.Map<java.util.UUID, Long> heavyPunchedInTimeStop = new java.util.concurrent.ConcurrentHashMap<>();

    @SubscribeEvent
    public static void onLivingHurt(net.minecraftforge.event.entity.living.LivingHurtEvent event) {
        LivingEntity target = event.getEntityLiving();
        if (target != null && !target.level.isClientSide()) {
            DamageSource source = event.getSource();
            Entity attacker = source.getEntity();
            if (attacker instanceof net.minecraft.entity.player.PlayerEntity) {
                net.minecraft.entity.player.PlayerEntity player = (net.minecraft.entity.player.PlayerEntity) attacker;

                if (com.github.standobyte.jojo.capability.world.TimeStopHandler.isTimeStopped(player.level, player.blockPosition())
                        || player.hasEffect(com.github.standobyte.jojo.init.ModStatusEffects.TIME_STOP.get())) {

                    boolean hasTheWorld = IStandPower.getStandPowerOptional(player)
                            .map(stand -> stand.hasPower() && stand.getType() == com.august_dr.rotp_theworld.init.InitStands.STAND_THE_WORLD.getStandType())
                            .orElse(false);

                    if (hasTheWorld) {
                        String msgId = source.getMsgId();
                        if (msgId != null && (
                                msgId.toLowerCase().contains("heavy") ||
                                        msgId.toLowerCase().contains("knockback") ||
                                        msgId.toLowerCase().contains("finisher") ||
                                        msgId.toLowerCase().contains("strong")
                        )) {
                            heavyPunchedInTimeStop.put(target.getUUID(), System.currentTimeMillis());
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(net.minecraftforge.event.entity.living.LivingDeathEvent event) {
        LivingEntity target = event.getEntityLiving();
        if (target != null && !target.level.isClientSide()) {
            java.util.UUID uuid = target.getUUID();
            Long punchedTime = heavyPunchedInTimeStop.remove(uuid);
            if (punchedTime != null && (System.currentTimeMillis() - punchedTime) < 15000) {
                DamageSource source = event.getSource();
                Entity attacker = source.getEntity();
                if (attacker instanceof net.minecraft.entity.player.PlayerEntity) {
                    net.minecraft.entity.player.PlayerEntity player = (net.minecraft.entity.player.PlayerEntity) attacker;
                    boolean hasTheWorld = IStandPower.getStandPowerOptional(player)
                            .map(stand -> stand.hasPower() && stand.getType() == com.august_dr.rotp_theworld.init.InitStands.STAND_THE_WORLD.getStandType())
                            .orElse(false);
                    if (hasTheWorld) {
                        com.github.standobyte.jojo.util.mod.JojoModUtil.sayVoiceLine(player, com.august_dr.rotp_theworld.init.InitSounds.DIEGO_THIS_IS_THE_WORLD.get());
                    }
                }
            }
        }
    }
}