package com.august_dr.rotp_theworld.tileentity;

import com.august_dr.rotp_theworld.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class BarbedWireTileEntity extends TileEntity implements ITickableTileEntity {
    private int absorbedLife;
    
    public BarbedWireTileEntity() {
        super(ModTileEntities.BARBED_WIRE.get());
    }

    protected BarbedWireTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }
    
    @Override
    public void load(BlockState state, CompoundNBT compound) {
        super.load(state, compound);
        absorbedLife = compound.getInt("AbsorbedLife");
    }
    
    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        compound.putInt("AbsorbedLife", absorbedLife);
        return compound;
    }

    @Override
    public void tick() {
    }
    
    public void incAbsorbed() {
        absorbedLife++;
        setChanged();
        BlockState blockState = this.getBlockState();
        level.sendBlockUpdated(worldPosition, blockState, blockState, 2);
    }
    
    public int getAbsorbedLife() {
        return absorbedLife;
    }
}
