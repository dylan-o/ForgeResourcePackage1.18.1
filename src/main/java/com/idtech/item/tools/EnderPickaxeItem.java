package com.idtech.item.tools;

import com.idtech.BaseMod;
import com.idtech.item.ItemMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class EnderPickaxeItem extends PickaxeItem {
    private static Properties properties = new Properties().tab(CreativeModeTab.TAB_TOOLS);
    public static Tier tier = new ForgeTier(4, 1561, 8.0F, 10.0F, 3, null, ()->{return Ingredient.of(ItemMod.GEL);});
    public static Item INSTANCE = new EnderPickaxeItem(tier, 50, 100,  properties).setRegistryName(BaseMod.MODID, "enderpickaxe");
    public EnderPickaxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);
    }
}
