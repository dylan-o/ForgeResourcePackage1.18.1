package com.idtech.enchantment;

import com.idtech.Utils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ElectricityEnchantment extends Enchantment {

    // Set up Enchantment Instance
    public static Enchantment INSTANCE = new ElectricityEnchantment(Rarity.VERY_RARE, EquipmentSlot.MAINHAND).setRegistryName("electricity");

    // Constructor
    protected ElectricityEnchantment(Rarity rarityIn, EquipmentSlot... slots) {
        super(rarityIn, EnchantmentCategory.WEAPON, slots);
    }


    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinCost(int enchantmentLevel) {
        return 30 + 10 * (enchantmentLevel - 1);
    }
    public int getMaxCost(int enchantmentLevel) {
        return super.getMinCost(enchantmentLevel) + 50;
    }
    // Above are the minimum and maximum enchantibility levels needed on a weapon to enchant an item with Wither Touch enchantment
    // This currently works similar to the enchantability levels of efficiency, based on the current enchantment level of the player

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTradeable(){ return true; }

    @Override
    public boolean isDiscoverable(){ return true; }

    @Override
    public boolean isAllowedOnBooks(){ return true; }

    @Override
    public boolean isTreasureOnly(){ return false; }

    /**
     * Called whenever a mob is damaged with an item that has this enchantment on it.
     */
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        // When a weapon with this enchantment is used to hit a mob, it will strike the mob with lightning
        if (target instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)target;

            // Summon lightning bolt
            Utils.strikeLightning(user.level, target.getOnPos());
        }
    }


}