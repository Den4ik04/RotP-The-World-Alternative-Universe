package com.august_dr.rotp_theworld.client.render.entity.renderer.stand;

import com.august_dr.rotp_theworld.RotpTHEWORLDAddon;
import com.august_dr.rotp_theworld.client.render.entity.model.stand.THEWORLDModel;
import com.august_dr.rotp_theworld.entity.stand.stands.THEWORLDEntity;
import com.github.standobyte.jojo.client.render.entity.renderer.stand.StandEntityRenderer;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class THEWORLDRenderer extends StandEntityRenderer<THEWORLDEntity, THEWORLDModel> {
    
    public THEWORLDRenderer(EntityRendererManager renderManager) {
        super(renderManager, new THEWORLDModel(), new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "textures/entity/stand/the_world.png"), 0);
    }
}
