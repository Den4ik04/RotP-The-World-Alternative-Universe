package com.august_dr.rotp_theworld.action.stand;

import com.github.standobyte.jojo.action.stand.StandEntityHeavyAttack;
import com.github.standobyte.jojo.action.stand.punch.StandEntityPunch;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.util.mc.damage.StandEntityDamageSource;
import net.minecraft.entity.Entity;

public class THEWORLDKnockbackPunch extends StandEntityHeavyAttack {

    public THEWORLDKnockbackPunch(Builder builder) {super(builder);
    }

    @Override
    public StandEntityPunch punchEntity(StandEntity stand, Entity target, StandEntityDamageSource dmgSource) {
        return super.punchEntity(stand, target, dmgSource)
                .addKnockback(0.75F + stand.getLastHeavyFinisherValue())
                .knockbackXRot(-30F)
                .disableBlocking((float) stand.getProximityRatio(target) - 0.25F);
    }
}
