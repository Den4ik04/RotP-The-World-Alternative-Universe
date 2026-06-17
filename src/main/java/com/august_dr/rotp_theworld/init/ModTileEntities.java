package com.august_dr.rotp_theworld.init;

import com.august_dr.rotp_theworld.tileentity.BarbedWireTileEntity;
import com.github.standobyte.jojo.JojoMod;
import com.august_dr.rotp_theworld.init.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, JojoMod.MOD_ID);

    public static final RegistryObject<TileEntityType<BarbedWireTileEntity>> BARBED_WIRE = TILE_ENTITIES.register("barbed_wire",
            () -> TileEntityType.Builder.of(BarbedWireTileEntity::new, ModBlocks.BARBED_WIRE.get()).build(null));
}
