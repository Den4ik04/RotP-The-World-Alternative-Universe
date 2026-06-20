package com.august_dr.rotp_theworld.client;

import com.august_dr.rotp_theworld.RotpTHEWORLDAddon;
import com.august_dr.rotp_theworld.client.render.entity.renderer.SilverBulletHorseRenderer;
import com.august_dr.rotp_theworld.client.render.entity.renderer.stand.THEWORLDRenderer;
import com.august_dr.rotp_theworld.init.AddonStands;

import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = RotpTHEWORLDAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientInit {
    
    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(AddonStands.THE_WORLD.getEntityType(), THEWORLDRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityType.HORSE, SilverBulletHorseRenderer::new);
    }
}
