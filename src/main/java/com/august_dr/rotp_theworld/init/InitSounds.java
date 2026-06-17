package com.august_dr.rotp_theworld.init;

import java.util.function.Supplier;

import com.august_dr.rotp_theworld.RotpTHEWORLDAddon;
import com.github.standobyte.jojo.JojoMod;
import com.github.standobyte.jojo.init.ModSounds;
import com.github.standobyte.jojo.util.mc.MultiSoundEvent;
import com.github.standobyte.jojo.util.mc.OstSoundList;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RotpTHEWORLDAddon.MOD_ID);

    public static final Supplier<SoundEvent> THE_WORLD_PUNCH_LIGHT = ModSounds.STAND_PUNCH_LIGHT;

    public static final Supplier<SoundEvent> THE_WORLD_UNSUMMON = ModSounds.STAND_UNSUMMON_DEFAULT;
    public static final Supplier<SoundEvent> THE_WORLD_PUNCH_HEAVY = ModSounds.STAND_PUNCH_HEAVY;

    public static final Supplier<SoundEvent> THE_WORLD_BARRAGE = ModSounds.STAND_PUNCH_LIGHT;

    public static final RegistryObject<SoundEvent> THE_WORLD_SUMMON = SOUNDS.register("the_world_summon",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_summon")));

    public static final RegistryObject<SoundEvent> THE_WORLD_MUDA = SOUNDS.register("the_world_muda",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_muda")));

    public static final RegistryObject<SoundEvent> THE_WORLD_MUDA_LONG = SOUNDS.register("the_world_muda_long",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_muda_long")));

    public static final RegistryObject<SoundEvent> THE_WORLD_MUDA_MUDA_MUDA = SOUNDS.register("the_world_muda_muda_muda",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_muda_muda_muda")));

    public static final RegistryObject<SoundEvent> THE_WORLD_KNIFE_BARRAGE_VOICE = SOUNDS.register("the_world_knife_barrage_voice",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_knife_barrage_voice")));

    public static final RegistryObject<SoundEvent> THE_WORLD_BARRAGE_VOICE = SOUNDS.register("the_world_barrage_voice",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_barrage_voice")));

    public static final RegistryObject<SoundEvent> THE_WORLD_TIME_STOP = SOUNDS.register("the_world_time_stop",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_time_stop")));

    public static final RegistryObject<SoundEvent> THE_WORLD_TIME_RESUME = SOUNDS.register("the_world_time_resume",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_time_resume")));

    public static final RegistryObject<SoundEvent> THE_WORLD_TIME_STOP_BLINK = SOUNDS.register("the_world_time_stop_blink",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_time_stop_blink")));

    public static final RegistryObject<SoundEvent> DIEGO_THE_WORLD = SOUNDS.register("diego_the_world",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_the_world")));

    public static final RegistryObject<SoundEvent> DIEGO_MUDA = SOUNDS.register("diego_muda",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_muda")));

    public static final RegistryObject<SoundEvent> DIEGO_MUDA_MUDA = SOUNDS.register("diego_muda_muda",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_muda_muda")));

    public static final RegistryObject<SoundEvent> DIEGO_WRY = SOUNDS.register("diego_wry",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_wry")));

    public static final RegistryObject<SoundEvent> DIEGO_DIE = SOUNDS.register("diego_die",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_die")));

    public static final RegistryObject<SoundEvent> DIEGO_THIS_IS_THE_WORLD = SOUNDS.register("diego_this_is_the_world",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_this_is_the_world")));

    public static final RegistryObject<SoundEvent> DIEGO_TIME_STOP = SOUNDS.register("diego_time_stop",
            () -> new MultiSoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_toki_yo_tomare"), new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_tomare_toki_yo")));

    public static final RegistryObject<SoundEvent> DIEGO_TIME_RESUMES = SOUNDS.register("diego_time_resumes",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_time_resumes")));

    public static final RegistryObject<SoundEvent> DIEGO_TIMES_UP = SOUNDS.register("diego_times_up",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_times_up")));

    public static final RegistryObject<SoundEvent> DIEGO_5_SECONDS = SOUNDS.register("diego_5_seconds",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_5_seconds")));

    public static final RegistryObject<SoundEvent> DIEGO_ONE_MORE = SOUNDS.register("diego_one_more",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_one_more")));

    public static final RegistryObject<SoundEvent> DIEGO_CANT_MOVE = SOUNDS.register("diego_cant_move",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_cant_move")));

    public static final RegistryObject<SoundEvent> REVOLVER_SHOT = SOUNDS.register("revolver_shot",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "revolver_shot")));

    public static final RegistryObject<SoundEvent> REVOLVER_NO_AMMO = SOUNDS.register("revolver_no_ammo",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "revolver_no_ammo")));

    public static final RegistryObject<SoundEvent> DIEGO_AND_NOW_THE_FUN_BEGINS = SOUNDS.register("diego_and_now_the_fun_begins",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "diego_and_now_the_fun_begins")));

    public static final RegistryObject<SoundEvent> THE_WORLD_KNIVES_THROW = SOUNDS.register("the_world_knives_throw",
            () -> new SoundEvent(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_knives_throw")));

    static final OstSoundList THE_WORLD_OST = new OstSoundList(new ResourceLocation(RotpTHEWORLDAddon.MOD_ID, "the_world_ost"), SOUNDS);
}