package com.idtech.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;

public class EnchantmentMod {

    //register enchantments
    public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().register(WitherTouchEnchantment.INSTANCE);
        event.getRegistry().register(BlindFighterCurseEnchantment.INSTANCE);
        event.getRegistry().register(ElectricityEnchantment.INSTANCE);
    }

}