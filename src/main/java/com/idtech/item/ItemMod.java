package com.idtech.item;

import com.idtech.ModTab;
import com.idtech.item.tools.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemMod {

    //BASIC ITEMS
    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", ModTab.INSTANCE);
    public static final Item COFFEE_MUG = ItemUtils.buildBasicItem("coffeemug", ModTab.INSTANCE);
    public static final Item GEL = ItemUtils.buildBasicItem("gel", ModTab.INSTANCE);
    public static final Item END_ROCK = ItemUtils.buildBasicItem("end_rock", ModTab.INSTANCE);

    //FOODS

    public static FoodProperties yummyFood = (new FoodProperties.Builder().nutrition(5).saturationMod(1.4f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 1), 1.0f)
            .alwaysEat().build());
    public static Item yummyFoodItem = ItemUtils.buildFoodItem("yummyfood", yummyFood);

    // TOOL TIERS
    public static Tier ENDER_TIER = new ForgeTier(5, 2400, 10.0F, 5.0F, 10, null, ()->{return Ingredient.of(ItemMod.END_ROCK);});
    public static Tier GEL_TIER = new ForgeTier(2, 100, 3.0f, 0.0F, 25, null, ()->{return Ingredient.of(ItemMod.GEL);});

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        event.getRegistry().register(STRUCTURE_GEL);
        event.getRegistry().register(COFFEE_MUG);
        event.getRegistry().register(GEL);
        event.getRegistry().register(END_ROCK);

        // ITEMS
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        event.getRegistry().register(CustomTridentItem.INSTANCE);
        event.getRegistry().register(ZooSwordItem.INSTANCE);
        event.getRegistry().register(CustomMusicDisc.INSTANCE);
        event.getRegistry().register(MegalovaniaMusicDisc.INSTANCE);
        event.getRegistry().register(CaveSoundMusicDisc.INSTANCE);

        // TOOLS
        event.getRegistry().register(GelPickaxeItem.INSTANCE);
        event.getRegistry().register(GelAxeItem.INSTANCE);
        event.getRegistry().register(GelSwordItem.INSTANCE);
        event.getRegistry().register(GelShovelItem.INSTANCE);
        event.getRegistry().register(GelHoeItem.INSTANCE);
        event.getRegistry().register(EnderPickaxeItem.INSTANCE);
        event.getRegistry().register(EnderAxeItem.INSTANCE);
        event.getRegistry().register(EnderShovelItem.INSTANCE);
        event.getRegistry().register(EnderSwordItem.INSTANCE);
        event.getRegistry().register(EnderHoeItem.INSTANCE);

        // FOOD
        event.getRegistry().register(yummyFoodItem);
        event.getRegistry().register(YuckyFoodItem.INSTANCE);

        // ARMOR
        event.getRegistry().register(CustomArmorItem.HELM);
        event.getRegistry().register(CustomArmorItem.CHEST);
        event.getRegistry().register(CustomArmorItem.LEGS);
        event.getRegistry().register(CustomArmorItem.BOOTS);
        event.getRegistry().register(OverworldHelmet.INSTANCE);

        //PROJECTILES
        event.getRegistry().register(FireballWandItem.INSTANCE);
        event.getRegistry().register(BombArrowItem.INSTANCE);
        event.getRegistry().register(LightningArrowItem.INSTANCE);
    }
}
