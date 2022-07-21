package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class GelPickaxeItem extends PickaxeItem {
    private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);
    public static Tier tier = new ForgeTier(4, 1561, 8.0F, 10.0F, 3, null, ()->{return Ingredient.of(ItemMod.STRUCTURE_GEL);});
    public static Item INSTANCE = new GelPickaxeItem(tier, 50, 100,  properties).setRegistryName(BaseMod.MODID, "gelpickaxe");
    public GelPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
