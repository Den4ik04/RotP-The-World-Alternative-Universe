package com.august_dr.rotp_theworld.client.render.entity.renderer;

import com.august_dr.rotp_theworld.RotpTHEWORLDAddon;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.entity.passive.horse.CoatColors;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.util.ResourceLocation;

public class SilverBulletHorseRenderer extends MobRenderer<HorseEntity, HorseModel<HorseEntity>> {
    private static final ResourceLocation SILVER_BULLET_TEXTURE = new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "textures/entity/horse/silver_bullet.png");
    
    private static final ImmutableMap<CoatColors, ResourceLocation> LOCATION_BY_VARIANT = ImmutableMap.<CoatColors, ResourceLocation>builder()
        .put(CoatColors.WHITE, new ResourceLocation("minecraft:textures/entity/horse/horse_white.png"))
        .put(CoatColors.CREAMY, new ResourceLocation("minecraft:textures/entity/horse/horse_creamy.png"))
        .put(CoatColors.CHESTNUT, new ResourceLocation("minecraft:textures/entity/horse/horse_chestnut.png"))
        .put(CoatColors.BROWN, new ResourceLocation("minecraft:textures/entity/horse/horse_brown.png"))
        .put(CoatColors.BLACK, new ResourceLocation("minecraft:textures/entity/horse/horse_black.png"))
        .put(CoatColors.GRAY, new ResourceLocation("minecraft:textures/entity/horse/horse_gray.png"))
        .put(CoatColors.DARKBROWN, new ResourceLocation("minecraft:textures/entity/horse/horse_darkbrown.png"))
        .build();

    public SilverBulletHorseRenderer(EntityRendererManager manager) {
        super(manager, new HorseModel<>(0.0F), 0.75F);
    }

    @Override
    public ResourceLocation getTextureLocation(HorseEntity horse) {
        if (horse.hasCustomName() && "Silver Bullet".equals(horse.getCustomName().getString())) {
            return SILVER_BULLET_TEXTURE;
        }
        return LOCATION_BY_VARIANT.get(horse.getVariant());
    }
}