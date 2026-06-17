package com.august_dr.rotp_theworld.init;

import com.august_dr.rotp_theworld.entity.stand.stands.THEWORLDEntity;
import com.github.standobyte.jojo.entity.stand.StandEntityType;
import com.github.standobyte.jojo.init.power.stand.EntityStandRegistryObject.EntityStandSupplier;
import com.github.standobyte.jojo.power.impl.stand.stats.TimeStopperStandStats;
import com.github.standobyte.jojo.power.impl.stand.type.EntityStandType;

public class AddonStands {

    public static final EntityStandSupplier<EntityStandType<TimeStopperStandStats>, StandEntityType<THEWORLDEntity>>
    THE_WORLD = new EntityStandSupplier<>(InitStands.STAND_THE_WORLD);
}
