package com.idtech.block;


import com.idtech.ModTab;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BlockMod {

    //Basic Block
    public static final Block CASTLE_WALL = BlockUtils.createBasicBlock("castlewall", Material.STONE, 0.3f);
    public static final Item CASTLE_WALL_ITEM = BlockUtils.createBlockItem(CASTLE_WALL, ModTab.INSTANCE);
    public static final Block GEL_ORE = BlockUtils.createBasicBlock("gel_ore", Material.STONE, 0.5f);
    public static final Item GEL_ORE_ITEM = BlockUtils.createBlockItem(GEL_ORE, ModTab.INSTANCE);
    public static final Block EMBER_BLOCK = BlockUtils.createBasicBlock("ember_block", Material.STONE, 0.8f);
    public static final Item EMBER_BLOCK_ITEM = BlockUtils.createBlockItem(EMBER_BLOCK, ModTab.INSTANCE);
    public static final Block ENDSTONE_ORE = BlockUtils.createBasicBlock("endstone_ore", Material.STONE, 1.0f);
    public static final Item ENDSTONE_ORE_ITEM = BlockUtils.createBlockItem(ENDSTONE_ORE, ModTab.INSTANCE);


    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {

        event.getRegistry().register(CASTLE_WALL_ITEM);
        event.getRegistry().register(GEL_ORE_ITEM);
        event.getRegistry().register(EMBER_BLOCK_ITEM);
        event.getRegistry().register(ENDSTONE_ORE_ITEM);
        event.getRegistry().register(GelBlock.ITEM);
        event.getRegistry().register(CreeperSurpriseBlock.ITEM);
        //event.getRegistry().register(TNTCannonBlock.ITEM);

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().register(CASTLE_WALL);
        event.getRegistry().register(GEL_ORE);
        event.getRegistry().register(EMBER_BLOCK);
        event.getRegistry().register(ENDSTONE_ORE);
        event.getRegistry().register(GelBlock.INSTANCE);
        event.getRegistry().register(CreeperSurpriseBlock.INSTANCE);
        //event.getRegistry().register(TNTCannonBlock.INSTANCE);

    }
}





