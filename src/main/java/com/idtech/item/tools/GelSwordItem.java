package com.idtech.item.tools;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.item.ItemMod;
import net.minecraft.world.item.*;

public class GelSwordItem extends SwordItem {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new GelSwordItem(ItemMod.GEL_TIER, 50, 100,  properties)
            .setRegistryName(BaseMod.MODID, "gelsword");

    public GelSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
