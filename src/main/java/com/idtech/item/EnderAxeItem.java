package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class EnderAxeItem extends AxeItem {

    private static Properties properties = new Item.Properties().tab(ModTab.INSTANCE);

    public static Tier tier = new ForgeTier(4, 1561, 8.0F, 10.0F, 10, null, ()->{return Ingredient.of(ItemMod.STRUCTURE_GEL);});

    public static Item INSTANCE = new EnderAxeItem(tier, 100, 100, new Properties().tab(CreativeModeTab.TAB_MISC)).setRegistryName(BaseMod.MODID,"enderaxe");

    public EnderAxeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties properties){
        super(tier, attackDamageIn, attackSpeedIn, properties);

    }






}
