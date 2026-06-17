package com.august_dr.rotp_theworld.action.stand;

import com.august_dr.rotp_theworld.init.InitSounds;
import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.punch.StandEntityPunch;
import com.github.standobyte.jojo.capability.entity.EntityUtilCap;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import com.github.standobyte.jojo.util.mod.JojoModUtil;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.SoundEvent;

import java.util.function.Supplier;

public class THEWORLDHeavyPunch extends StandEntityHeavyAttack {

    public THEWORLDHeavyPunch(Builder builder) {
        super(builder);
    }

    @Override
    public StandEntityPunch punchEntity(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
        return new TheWorldHeavyPunchInstance(stand, target, dmgSource)
                .copyProperties(super.punchEntity(stand, target, dmgSource))
                .armorPiercing((float) stand.getAttackDamage() * 0.01F)
                .knockbackYRotDeg(-90F)
                .knockbackXRot(0F)
                .addKnockback(5)
                .impactSound(ModSounds.THE_WORLD_PUNCH_HEAVY_ENTITY);
    }

    public static class TheWorldHeavyPunchInstance extends HeavyPunchInstance {
        private Supplier<SoundEvent> voiceLineOnKill = () -> null;

        public TheWorldHeavyPunchInstance(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
            super(stand, target, dmgSource);
            voiceLineOnKill = InitSounds.DIEGO_THIS_IS_THE_WORLD;
        }

        @Override
        protected void afterAttack(StandEntity stand, Entity target, StandEntityDamageSource dmgSource, StandEntityTask task, boolean hurt, boolean killed) {
            if (!stand.level.isClientSide() && hurt && !target.canUpdate()) {
                EntityUtilCap.queueOnTimeResume(target, () -> target.playSound(ModSounds.THE_WORLD_PUNCH_HEAVY_TS_IMPACT.get(), 1.0F, 1.0F));
            }
            if (killed) {
                SoundEvent voiceLine = voiceLineOnKill.get();
                if (voiceLine != null) {
                    LivingEntity user = stand.getUser();
                    if (user != null) {
                        JojoModUtil.sayVoiceLine(user, voiceLine);
                    }
                }
            }
            super.afterAttack(stand, target, dmgSource, task, hurt, killed);
        }
    }
}