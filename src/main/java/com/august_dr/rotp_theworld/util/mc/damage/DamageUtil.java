package com.august_dr.rotp_theworld.util.mc.damage;

import com.github.standobyte.jojo.JojoModConfig;
import com.github.standobyte.jojo.advancements.ModCriteriaTriggers;
import com.github.standobyte.jojo.capability.entity.LivingUtilCapProvider;
import com.github.standobyte.jojo.capability.entity.hamonutil.EntityHamonChargeCap;
import com.github.standobyte.jojo.capability.entity.hamonutil.EntityHamonChargeCapProvider;
import com.github.standobyte.jojo.entity.HamonSendoOverdriveEntity;
import com.github.standobyte.jojo.entity.RoadRollerEntity;
import com.github.standobyte.jojo.entity.stand.StandEntity;
import com.github.standobyte.jojo.init.ModItems;
import com.github.standobyte.jojo.init.ModParticles;
import com.github.standobyte.jojo.init.power.non_stand.ModPowers;
import com.github.standobyte.jojo.init.power.non_stand.hamon.ModHamonActions;
import com.github.standobyte.jojo.init.power.non_stand.hamon.ModHamonSkills;
import com.github.standobyte.jojo.power.impl.nonstand.INonStandPower;
import com.github.standobyte.jojo.power.impl.nonstand.type.hamon.HamonData;
import com.github.standobyte.jojo.power.impl.nonstand.type.hamon.HamonUtil;
import com.github.standobyte.jojo.util.general.MathUtil;
import com.github.standobyte.jojo.util.mc.damage.IModdedDamageSource;
import com.github.standobyte.jojo.util.mc.damage.StandLinkDamageSource;
import com.github.standobyte.jojo.util.mod.JojoModUtil;
import com.google.common.collect.Multimap;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPartEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.CombatRules;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DamageUtil {

    public static final DamageSource WIRE_DAMAGE = new DamageSource("wireDamage");

    public static boolean dealWireDamage(LivingEntity entity, float amount, @Nullable Entity src) {
            DamageSource dmgSource =
                    src == null ? WIRE_DAMAGE : new EntityDamageSource(WIRE_DAMAGE.getMsgId(), src);
            return entity.hurt(dmgSource, amount);

    }
}
