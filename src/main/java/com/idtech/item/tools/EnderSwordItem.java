package com.idtech.item.tools;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.item.ItemMod;
import net.minecraft.world.item.*;

public class EnderSwordItem extends SwordItem {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new EnderSwordItem(ItemMod.ENDER_TIER, 50, 100,  properties)
            .setRegistryName(BaseMod.MODID, "endersword");

    public EnderSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
