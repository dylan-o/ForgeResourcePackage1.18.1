package com.idtech.item.tools;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.item.ItemMod;
import net.minecraft.world.item.*;

public class EnderPickaxeItem extends PickaxeItem {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static Item INSTANCE = new EnderPickaxeItem(ItemMod.ENDER_TIER, 50, 100, properties)
            .setRegistryName(BaseMod.MODID, "enderpickaxe");

    public EnderPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
