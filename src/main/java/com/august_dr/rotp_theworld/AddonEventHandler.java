package com.august_dr.rotp_theworld;

import com.august_dr.rotp_theworld.init.InitSounds;
import com.august_dr.rotp_theworld.init.InitStands;
import com.github.standobyte.jojo.capability.world.TimeStopHandler;
import com.github.standobyte.jojo.capability.world.WorldUtilCapProvider;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import com.github.standobyte.jojo.util.mod.JojoModUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.ChunkPos;
import net.minecraftforge.event.entity.living.PotionEvent.PotionExpiryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RotpTHEWORLDAddon.MOD_ID)
public class AddonEventHandler {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onTSEffectExpired(PotionExpiryEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity.level.isClientSide()) {
            return;
        }
        if (event.getPotionEffect().getEffect() != ModStatusEffects.TIME_STOP.get()) {
            return;
        }

        ChunkPos chunkPos = new ChunkPos(entity.blockPosition());
        if (!TimeStopHandler.isTimeStopped(entity.level, chunkPos)) {
            return;
        }

        entity.level.getCapability(WorldUtilCapProvider.CAPABILITY).ifPresent(worldCap -> {
            if (worldCap.getTimeStopHandler().getTimeStopTicks(chunkPos) >= 40
                    && IStandPower.getStandPowerOptional(entity).map(stand ->
                    stand.hasPower() && stand.getType() == InitStands.STAND_THE_WORLD.getStandType()).orElse(false)) {
                JojoModUtil.sayVoiceLine(entity, InitSounds.DIEGO_CANT_MOVE.get());
            }
        });
    }
}
