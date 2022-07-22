package com.idtech.enchantment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class TunnelVisionCurseEnchantment extends Enchantment {

    // Set up Enchantment Instance
    public static Enchantment INSTANCE = new TunnelVisionCurseEnchantment(Rarity.UNCOMMON, EquipmentSlot.FEET).setRegistryName("blind_fighter");

    // Constructor
    protected TunnelVisionCurseEnchantment(Rarity rarityIn, EquipmentSlot... slots) {
        super(rarityIn, EnchantmentCategory.ARMOR_HEAD, slots);
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
    public boolean isCurse() {
        return true;
    }

    /**
     * Called whenever a mob is damaged with an item that has this enchantment on it.
     */
    @Override
    public void doPostHurt(LivingEntity user, Entity attacker, int level) {
        user.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,level*200, 1));
    }

}