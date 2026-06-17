package com.august_dr.rotp_theworld.init;

import com.august_dr.rotp_theworld.RotpTHEWORLDAddon;
import com.august_dr.rotp_theworld.block.BarbedWireMultiBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RotpTHEWORLDAddon.MOD_ID);

    public static final RegistryObject<BarbedWireMultiBlock> BARBED_WIRE = BLOCKS.register("barbed_wire",
            () -> new BarbedWireMultiBlock(Block.Properties.copy(Blocks.IRON_BARS).harvestLevel(0).requiresCorrectToolForDrops().noCollission().isValidSpawn((state, reader, pos, entityType) -> false)));

}
