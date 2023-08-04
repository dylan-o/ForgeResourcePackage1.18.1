package com.idtech.item.tools;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.item.ItemMod;
import net.minecraft.world.item.*;

public class EnderShovelItem extends ShovelItem {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new EnderShovelItem(ItemMod.ENDER_TIER, 100, 100, properties)
            .setRegistryName(BaseMod.MODID,"endershovel");

    public EnderShovelItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
