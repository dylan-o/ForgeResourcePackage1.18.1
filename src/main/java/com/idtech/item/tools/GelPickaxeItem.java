package com.idtech.item.tools;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.item.ItemMod;
import net.minecraft.world.item.*;

public class GelPickaxeItem extends PickaxeItem {

    private static Properties properties = new Item.Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new GelPickaxeItem(ItemMod.GEL_TIER, 50, 100,  properties)
            .setRegistryName(BaseMod.MODID, "gelpickaxe");

    public GelPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
