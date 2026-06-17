package com.august_dr.rotp_theworld.client.event;

import com.github.standobyte.jojo.capability.world.TimeStopHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "rotp_theworld", value = Dist.CLIENT)
public class TheWorldSoundHandler {

    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent event) {
        if (event.getSound() == null || event.getSound().getLocation() == null) {
            return;
        }

        String soundPath = event.getSound().getLocation().getPath();

        if (soundPath.contains("diego_wry")) {
            if (!isWorldTimeStopActive()) {
                event.setResultSound(null);
            }
        }

        if (soundPath.contains("the_world_muda_muda_muda")) {
            if (isWorldTimeStopActive()) {
                event.setResultSound(null);
            }
        }
    }

    private static boolean isWorldTimeStopActive() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) {
            return false;
        }
        return TimeStopHandler.isTimeStopped(mc.level, mc.player.blockPosition());
    }
}