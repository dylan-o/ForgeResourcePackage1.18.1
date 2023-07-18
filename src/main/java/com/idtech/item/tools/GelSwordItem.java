package com.idtech.item.tools;

import com.idtech.BaseMod;
import com.idtech.item.ItemMod;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelSwordItem extends SwordItem {
    private static Properties properties = new Properties().tab(CreativeModeTab.TAB_TOOLS);
    public static Tier tier = new ForgeTier(4, 1561, 8.0F, 10.0F, 3, null, ()->{return Ingredient.of(ItemMod.GEL);});
    public static Item INSTANCE = new GelSwordItem(tier, 50, 100,  properties).setRegistryName(BaseMod.MODID, "gelsword");
    public GelSwordItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
