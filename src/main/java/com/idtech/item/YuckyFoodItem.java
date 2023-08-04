package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.Utils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Random;

public class YuckyFoodItem extends Item{
    public static FoodProperties foodProperties = (new FoodProperties.Builder().nutrition(5).saturationMod(1.4f).alwaysEat().build());
    public static Item INSTANCE = new YuckyFoodItem(new Item.Properties().tab(ModTab.INSTANCE).food(foodProperties)).setRegistryName(BaseMod.MODID, "yuckyfood");
    private Random rand = new Random();

    public YuckyFoodItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 500, 1));
        if(rand.nextDouble() < 0.1){
            Entity creeper = EntityType.CREEPER.create(level);
            Utils.spawnEntity(level, creeper, livingEntity.getOnPos().above());
        }
        return this.isEdible() ? livingEntity.eat(level, itemStack) : itemStack;
    }
}
