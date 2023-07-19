package com.idtech.enchantment;

import com.idtech.Utils;
import com.idtech.entity.ghost.GhostEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Random;

public class EnemyReinforcementsCurse extends Enchantment {

    // Set up Enchantment Instance
    public static Enchantment INSTANCE = new EnemyReinforcementsCurse(Rarity.VERY_RARE, EquipmentSlot.MAINHAND).setRegistryName("enemy_spawn_curse");

    // Constructor
    protected EnemyReinforcementsCurse(Rarity rarityIn, EquipmentSlot... slots) {
        super(rarityIn, EnchantmentCategory.WEAPON, slots);
    }

    Random rand = new Random();
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
    public boolean isCurse(){ return  true;}

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
        // When a weapon with this enchantment is used to hit a mob, it might spawn another mob
        if (target instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)target;
            LivingEntity spawn = null;
            int random = rand.nextInt(100);
            if (random == 0) {
                spawn = new WitherSkeleton(EntityType.WITHER_SKELETON, user.level);
            } else if (random == 1) {
                spawn = new GhostEntity(GhostEntity.TYPE, user.level);
            } else if (random == 2) {
                spawn = new CaveSpider(EntityType.CAVE_SPIDER, user.level);
            } else if (random == 3) {
                spawn = new Blaze(EntityType.BLAZE, user.level);
            } else if (random == 4) {
                spawn = new Ghast(EntityType.GHAST, user.level);
            } else if (random == 5) {
                spawn = new Giant(EntityType.GIANT, user.level);
            } else if (random == 6) {
                spawn = new Witch(EntityType.WITCH, user.level);
            } else if (random == 7) {
                spawn = new Ravager(EntityType.RAVAGER, user.level);
            } else if (random == 8) {
                spawn = new Illusioner(EntityType.ILLUSIONER, user.level);
            }  else if (random == 9) {
                spawn = new PiglinBrute(EntityType.PIGLIN_BRUTE, user.level);
            } else if (random < 20) {
                spawn = new Spider(EntityType.SPIDER, user.level);
            } else if (random < 30) {
                spawn = new Silverfish(EntityType.SILVERFISH, user.level);
            } else if (random < 40) {
                spawn = new Skeleton(EntityType.SKELETON, user.level);
            } else if (random < 50) {
                spawn = new Zombie(EntityType.ZOMBIE, user.level);
            }


            if(spawn != null){
                // Spawn Entity
                Utils.spawnEntity(user.level, spawn, livingentity.getOnPos().above());
            }
        }
    }


}