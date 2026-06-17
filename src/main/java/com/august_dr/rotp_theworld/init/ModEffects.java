package com.august_dr.rotp_theworld.init;

import com.august_dr.rotp_theworld.RotpTHEWORLDAddon;
import com.august_dr.rotp_theworld.effect.BleedingEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, RotpTHEWORLDAddon.MOD_ID);

    public static final RegistryObject<Effect> BLEEDING = EFFECTS.register("bleeding", BleedingEffect::new);
}