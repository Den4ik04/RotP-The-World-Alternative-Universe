package com.august_dr.rotp_theworld.action.stand;

import java.util.function.Supplier;
import java.util.stream.Stream;

import com.github.standobyte.jojo.action.ActionTarget;
import com.github.standobyte.jojo.action.stand.StandEntityMeleeBarrage;
import com.github.standobyte.jojo.action.stand.TimeStop;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityTask;
import com.github.standobyte.jojo.power.impl.stand.IStandPower;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.SoundEvent;

public class THEWORLDBarrage extends StandEntityMeleeBarrage {
    private final Supplier<SoundEvent> wryyyyyyyyyyy;

    public THEWORLDBarrage(StandEntityMeleeBarrage.Builder builder, Supplier<SoundEvent> greatestHighShout) {
        super(builder);
        this.wryyyyyyyyyyy = greatestHighShout == null ? () -> null : greatestHighShout;
    }

    @Override
    protected SoundEvent getShout(LivingEntity user, IStandPower power, ActionTarget target, boolean wasActive) {
        boolean playWry = wasActive && TimeStop.vampireTimeStopDuration(user);

        user.getPersistentData().putBoolean("DiegoWryActive", playWry);

        return playWry ? wryyyyyyyyyyy.get() : super.getShout(user, power, target, wasActive);
    }

    @Override
    public Stream<SoundEvent> getSounds(StandEntity standEntity, IStandPower standPower, Phase phase, StandEntityTask task) {
        if (phase == Phase.PERFORM && standPower.getUser().getPersistentData().getBoolean("DiegoWryActive")) {
            return Stream.empty();
        }

        return super.getSounds(standEntity, standPower, phase, task);
    }
}