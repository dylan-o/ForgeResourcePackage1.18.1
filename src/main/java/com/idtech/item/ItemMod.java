package com.idtech.item;

import com.idtech.ModTab;
import com.idtech.item.tools.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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

        // TOOLS
        event.getRegistry().register(GelPickaxeItem.INSTANCE);
        event.getRegistry().register(GelAxeItem.INSTANCE);
        event.getRegistry().register(GelSwordItem.INSTANCE);
        event.getRegistry().register(GelShovelItem.INSTANCE);
        event.getRegistry().register(GelHoeItem.INSTANCE);
        event.getRegistry().register(EnderPickaxeItem.INSTANCE);
        event.getRegistry().register(EnderAxeItem.INSTANCE);

        // FOOD

        // ARMOR
        event.getRegistry().register(CustomArmorItem.HELM);
        event.getRegistry().register(CustomArmorItem.CHEST);
        event.getRegistry().register(CustomArmorItem.LEGS);
        event.getRegistry().register(CustomArmorItem.BOOTS);
        event.getRegistry().register(OverworldHelmet.INSTANCE);
        //PROJECTILES

    }
}
