package com.idtech.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemMod {

    //BASIC ITEMS
    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", CreativeModeTab.TAB_MISC);
    public static final Item COFFEE_MUG = ItemUtils.buildBasicItem("coffeemug", CreativeModeTab.TAB_MISC);
    public static final Item GEL_ORE = ItemUtils.buildBasicItem("gelore", CreativeModeTab.TAB_MISC);
    //FOODS


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        event.getRegistry().register(STRUCTURE_GEL);
        event.getRegistry().register(COFFEE_MUG);
        event.getRegistry().register(GEL_ORE);

        // ITEMS
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        event.getRegistry().register(CustomTridentItem.INSTANCE);

        // TOOLS
        event.getRegistry().register(GelPickaxeItem.INSTANCE);

        // FOOD

        // ARMOR
        event.getRegistry().register(CustomArmorItem.HELM);
        event.getRegistry().register(CustomArmorItem.CHEST);
        event.getRegistry().register(CustomArmorItem.LEGS);
        event.getRegistry().register(CustomArmorItem.BOOTS);

        //PROJECTILES

    }
}
