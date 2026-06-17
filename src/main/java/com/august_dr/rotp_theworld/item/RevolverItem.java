package com.august_dr.rotp_theworld.item;

import com.august_dr.rotp_theworld.init.InitSounds;
import com.github.standobyte.jojo.client.ClientUtil;
import com.august_dr.rotp_theworld.entity.damaging.projectile.RevolverBulletEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.KeybindTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RevolverItem extends Item {
    
    public RevolverItem(Properties properties) {super(properties);
    }

    @Override
    public void onUseTick(World world, LivingEntity entity, ItemStack stack, int remainingTicks) {
        int ammo = getAmmo(stack);
        int t = remainingTicks % 43;
        boolean shotTick = t == 0 || t == 7 || t == 14 || t == 21 || t == 28 || t == 35 || t == 42;
        if (remainingTicks <= 1) {
            entity.releaseUsingItem();
            return;
        }
        if (!world.isClientSide()) {
            if (ammo > 0) {
                if (shotTick) {
                    RevolverBulletEntity bullet = new RevolverBulletEntity(entity, world);
                    bullet.shootFromRotation(entity, 20F, 0);
                    world.addFreshEntity(bullet);
                    consumeAmmo(stack);
                }
            }
            else {
                entity.releaseUsingItem();
            }
        }
        if (ammo > 0) {
            if (shotTick) {
                Random random = entity.getRandom();
                entity.playSound(InitSounds.REVOLVER_SHOT.get(), 1.0F, 1.0F + (random.nextFloat() - 0.5F) * 0.3F);
                if (entity.getType() == EntityType.PLAYER ? world.isClientSide() : !world.isClientSide()) {
                    float recoil = 1F + Math.min((1F - (float) remainingTicks / (float) getUseDuration(stack)) * 6F, 3F);
                    entity.yRot += (random.nextFloat() - 0.5F) * 0.3F * recoil;
                    entity.xRot += -random.nextFloat() * 0.75F * recoil;
                }
            }
        }
        else {
            entity.playSound(InitSounds.REVOLVER_NO_AMMO.get(), 1.0F, 1.0F);
        }
    }
    
    private static final int MAX_AMMO = 6;
    private int getAmmo(ItemStack gun) {
        return gun.getOrCreateTag().getInt("Ammo");
    }
    
    private boolean consumeAmmo(ItemStack gun) {
        int ammo = getAmmo(gun);
        if (ammo < 0) {
            gun.getTag().putInt("Ammo", 0);
            return false;
        }
        if (ammo > 0) {
            gun.getTag().putInt("Ammo", --ammo);
            return true;
        }
        return false;
    }
    
    private boolean reload(ItemStack stack, LivingEntity entity, World world) {
        int ammoToLoad = MAX_AMMO - getAmmo(stack);
        if (ammoToLoad > 0) {
            if (entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) entity;
                ammoToLoad = consumeAmmo(player, ammoToLoad);
                if (!world.isClientSide()) {
                    player.getCooldowns().addCooldown(this, ammoToLoad * 2);
                }
            }
            if (ammoToLoad > 0) {
                if (!world.isClientSide()) {
                    stack.getTag().putInt("Ammo", getAmmo(stack) + ammoToLoad);
                }
                return true;
            }
        }
        return false;
    }

    private static final int GUNPOWDER_TO_BULLET = 1;
    private int consumeAmmo(PlayerEntity player, int ammoToLoad) {
        if (!player.abilities.instabuild) {
            List<ItemStack> ironNuggets = new ArrayList<>();
            int ironNuggetsCount = 0;
            List<ItemStack> gunpowder = new ArrayList<>();
            int gunpowderCount = 0;
            
            for (int i = 0; i < player.inventory.getContainerSize(); ++i) {
                ItemStack inventoryStack = player.inventory.getItem(i);
                if (inventoryStack.getItem() == Items.IRON_NUGGET) {
                    ironNuggets.add(inventoryStack);
                    ironNuggetsCount += inventoryStack.getCount();
                }
                else if (inventoryStack.getItem() == Items.GUNPOWDER) {
                    gunpowder.add(inventoryStack);
                    gunpowderCount += inventoryStack.getCount();
                }
            }
            
            ammoToLoad = Math.min(Math.min(ironNuggetsCount, gunpowderCount / GUNPOWDER_TO_BULLET), ammoToLoad);
            ironNuggetsCount = ammoToLoad;
            gunpowderCount = ammoToLoad * GUNPOWDER_TO_BULLET;

            for (ItemStack ironNuggetsStack : ironNuggets) {
                int consumed = Math.min(ironNuggetsStack.getCount(), ironNuggetsCount);
                if (!player.level.isClientSide()) {
                    ironNuggetsStack.shrink(consumed);
                }
                ironNuggetsCount -= consumed;
                if (ironNuggetsCount == 0) break;
            }
            for (ItemStack gunpowderStack : gunpowder) {
                int consumed = Math.min(gunpowderStack.getCount(), gunpowderCount);
                if (!player.level.isClientSide()) {
                    gunpowderStack.shrink(consumed);
                }
                gunpowderCount -= consumed;
                if (gunpowderCount == 0) break;
            }
        }
        return ammoToLoad;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return getAmmo(stack) < MAX_AMMO;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1 - ((double) getAmmo(stack) / (double) MAX_AMMO);
    }

    @Override
    public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.allowdedIn(group)) {
            ItemStack stack = new ItemStack(this);
            stack.getOrCreateTag().putInt("Ammo", MAX_AMMO);
            items.add(stack);
        }
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (player.isShiftKeyDown()) {
            return reload(stack, player, world) ? ActionResult.consume(stack) : ActionResult.fail(stack);
        }
        else {
            player.startUsingItem(hand);
            return ActionResult.consume(stack);
        }
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 85;
    }
    
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        tooltip.add(new TranslationTextComponent("item.rotp_theworld.revolver.reload_prompt",
                new KeybindTextComponent("key.sneak"), new KeybindTextComponent("key.use")).withStyle(TextFormatting.GRAY));
        
        ClientUtil.addItemReferenceQuote(tooltip, this);
    }
}
