package com.idtech.item;

import com.idtech.ModTab;
import com.idtech.entity.projectile.BombArrow;
import com.idtech.entity.projectile.LightningArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LightningArrowItem extends ArrowItem
{
    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new LightningArrowItem(properties).setRegistryName("lightningarrow");

    public LightningArrowItem(Properties properties)
    {
        super (properties);
    }

    @Override
    public AbstractArrow createArrow(Level levelIn, ItemStack stack, LivingEntity shooter) {
        LightningArrow arrowEntity = new LightningArrow(levelIn, shooter);
        return arrowEntity;
    }
}