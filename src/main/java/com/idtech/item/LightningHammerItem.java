package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LightningHammerItem extends Item {

    private static Properties properties = new Properties().tab(ModTab.INSTANCE);

    public static Item INSTANCE = new LightningHammerItem(properties).setRegistryName(BaseMod.MODID, "lightninghammer");

    public LightningHammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

        ItemStack itemstack = playerIn.getItemInHand(handIn);
        BlockPos location = Utils.getBlockAtCursor(playerIn, 100.0d, true);

        if(location != null){
            Utils.createExplosion(level, location, 10f);
            Utils.strikeLightning(level, location);
        }
        return InteractionResultHolder.pass(itemstack);
    }










}
