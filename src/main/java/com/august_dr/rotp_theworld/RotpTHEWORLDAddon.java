package com.august_dr.rotp_theworld;

import com.august_dr.rotp_theworld.init.*;
import com.github.standobyte.jojo.JojoModConfig;
import com.github.standobyte.jojo.init.ModStatusEffects;
import com.github.standobyte.jojo.init.power.JojoCustomRegistries;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RotpTHEWORLDAddon.MOD_ID)
public class RotpTHEWORLDAddon {
    public static final String MOD_ID = "rotp_theworld";
    private static final Logger LOGGER = LogManager.getLogger();

    public RotpTHEWORLDAddon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModTileEntities.TILE_ENTITIES.register(modEventBus);
        InitEntities.ENTITIES.register(modEventBus);
        InitSounds.SOUNDS.register(modEventBus);
        InitStands.ACTIONS.register(modEventBus);
        InitStands.STANDS.register(modEventBus);

        ModEffects.EFFECTS.register(modEventBus);
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}