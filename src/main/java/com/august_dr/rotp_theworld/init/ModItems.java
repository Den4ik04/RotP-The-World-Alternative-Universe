package com.august_dr.rotp_theworld.init;

import com.august_dr.rotp_theworld.RotpTHEWORLDAddon;
import com.august_dr.rotp_theworld.item.RevolverItem;
import com.github.standobyte.jojo.JojoMod;
import com.august_dr.rotp_theworld.init.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RotpTHEWORLDAddon.MOD_ID);

    public static final RegistryObject<RevolverItem> REVOLVER = ITEMS.register("revolver",
            () -> new RevolverItem(new Item.Properties().tab(JojoMod.MAIN_TAB).stacksTo(1)));

    public static final RegistryObject<BlockItem> BARBED_WIRE = ITEMS.register("barbed_wire",
            () -> new BlockItem(ModBlocks.BARBED_WIRE.get(), new Item.Properties().tab(JojoMod.MAIN_TAB).stacksTo(8)));
}