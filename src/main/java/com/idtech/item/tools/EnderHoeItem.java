package com.idtech.item.tools;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.item.ItemMod;
import net.minecraft.world.item.*;

public class EnderHoeItem extends HoeItem {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new EnderHoeItem(ItemMod.ENDER_TIER, 50, 100,  properties)
            .setRegistryName(BaseMod.MODID, "enderhoe");

    public EnderHoeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
