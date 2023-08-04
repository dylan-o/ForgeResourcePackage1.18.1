package com.idtech.item;

import com.idtech.ModTab;
import com.idtech.entity.projectile.ExplosionProjectile;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;

public class FireballWandItem extends Item {
    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new FireballWandItem(properties).setRegistryName("fireballwand");

    public FireballWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        if (!levelIn.isClientSide) {
            ExplosionProjectile projectile = new ExplosionProjectile(levelIn, playerIn);

            // projectile consumption from inventory
            IItemHandler inventory = new PlayerMainInvWrapper(playerIn.getInventory());
            for (int i = 0; i < inventory.getSlots(); i++) {
                if (inventory.getStackInSlot(i).getItem() == Items.APPLE) {
                    projectile.setItem(new ItemStack(Items.APPLE, 1));
                    projectile.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 1.5F, 1.0F);
                    inventory.getStackInSlot(i).shrink(1);
                    levelIn.addFreshEntity(projectile);
                    levelIn.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.NEUTRAL, 0.5F,
                            0.4F / (levelIn.getRandom().nextFloat() * 0.4F + 0.8F));
                    i = 99;
                }
            }
        }

        if (!playerIn.getAbilities().instabuild) {
            //itemstack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, levelIn.isClientSide());
    }
}