package com.idtech.item;

import com.idtech.BaseMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class CustomArmorItem extends ArmorItem {

    //armor material creation!
    private static ArmorMaterial customMaterial = ItemUtils.buildArmorMaterial("gelore", 22, new int[]{10,10,10,10} ,5,
            SoundEvents.ARMOR_EQUIP_CHAIN, 4.0f, 0.3f,"examplemod:gelore");

    //properties
    private static Item.Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_COMBAT);

    //static instances for registering
    public static Item HELM = new CustomArmorItem(customMaterial, EquipmentSlot.HEAD, properties).setRegistryName(BaseMod.MODID,"custom_helm");
    public static Item CHEST = new CustomArmorItem(customMaterial, EquipmentSlot.CHEST, properties).setRegistryName(BaseMod.MODID,"custom_chest");
    public static Item LEGS = new CustomArmorItem(customMaterial, EquipmentSlot.LEGS, properties).setRegistryName(BaseMod.MODID,"custom_legs");
    public static Item BOOTS = new CustomArmorItem(customMaterial, EquipmentSlot.FEET, properties).setRegistryName(BaseMod.MODID,"custom_boots");

    //constructor
    public CustomArmorItem(ArmorMaterial material, EquipmentSlot type, Item.Properties properties) {
        super(material, type, properties);
    }

    // custom armor item gives player an effect when worn
    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {

            if(player.getInventory().getArmor(3).getItem() != Items.AIR){
                ArmorItem helmet = (ArmorItem) player.getInventory().getArmor(3).getItem();
                if(helmet.getMaterial() == customMaterial){
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 21, 1));
                }
            }

            if(player.getInventory().getArmor(2).getItem() != Items.AIR){
                ArmorItem chestplate = (ArmorItem) player.getInventory().getArmor(2).getItem();
                if(chestplate.getMaterial() == customMaterial){
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 21, 1));
                }
            }

            if(player.getInventory().getArmor(1).getItem() != Items.AIR){
                ArmorItem leggings = (ArmorItem) player.getInventory().getArmor(1).getItem();
                if(leggings.getMaterial() == customMaterial){
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 21, 1));
                }
            }

            if(player.getInventory().getArmor(0).getItem() != Items.AIR){
                ArmorItem boots = (ArmorItem) player.getInventory().getArmor(0).getItem();
                if(boots.getMaterial() == customMaterial){
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 21, 1));
                }
            }
            super.onArmorTick(stack, world, player);
        }
    }

    //texture management!
    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if(slot == EquipmentSlot.LEGS){
            return "examplemod:textures/models/armor/custom_armor_layer_2.png";
        }else{
            return "examplemod:textures/models/armor/custom_armor_layer_1.png";
        }
    }
}