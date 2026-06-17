package com.august_dr.rotp_theworld.action.stand;

import com.github.standobyte.jojo.action.ActionConditionResult;
import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.TimeResume;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.text.TranslationTextComponent;

public class THEWORLDTimeResume extends TimeResume {

    public THEWORLDTimeResume(Builder builder) {
        super(builder);
    }

    @Override
    protected ActionConditionResult checkSpecificConditions(LivingEntity user, IStandPower power, ActionTarget target) {
        return super.checkSpecificConditions(user, power, target);
    }
}