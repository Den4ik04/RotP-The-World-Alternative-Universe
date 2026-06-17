package com.august_dr.rotp_theworld.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

public class BleedingEffect extends Effect {
    public BleedingEffect() {
        super(EffectType.HARMFUL, 0x8A0303);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide()) {
            entity.hurt(DamageSource.MAGIC, 1.0F + (float) amplifier * 0.5F);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}