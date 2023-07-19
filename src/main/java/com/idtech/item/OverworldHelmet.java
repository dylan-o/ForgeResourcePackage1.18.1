package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class OverworldHelmet extends ArmorItem {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);
    public static ArmorMaterial materials = ItemUtils.buildArmorMaterial("guardianspikes", 1,
           new int[]{10,10,10,10}, 22, SoundEvents.ARMOR_EQUIP_NETHERITE, 1,
           2, "minecraft:netherite_ingot");
    public static Item INSTANCE = new OverworldHelmet(materials, EquipmentSlot.HEAD, properties)
            .setRegistryName(BaseMod.MODID, "overworldhelmet");

    public OverworldHelmet(ArmorMaterial material, EquipmentSlot slot, Properties properties) {

        super(material, slot, properties);
    }

    // give effects to player when wearing helmet
    @Override
    public void onArmorTick(ItemStack itemStack, Level level, Player player) {
        boolean equipped = player.hasItemInSlot(EquipmentSlot.HEAD);
        if (equipped) {
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 21,3));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 21,1));
        }
        super.onArmorTick(itemStack, level, player);
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "examplemod:textures/models/armor/overworld_helmet.png";
    }

//    @Override
//    public void onCraftedBy(ItemStack stack, Level level, Player playerin) {
//        stack.enchant(Enchantment.byId(8), 20);
//        stack.enchant(Enchantment.byId(5), 127);
//        stack.enchant(Enchantment.byId(6), 1);
//    }
}
