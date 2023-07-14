package com.idtech.entity;

import com.idtech.entity.custom_trader.CustomTraderEntity;
import com.idtech.entity.custom_trader.CustomTraderRenderFactory;
import com.idtech.entity.ghost.GhostEntity;
import com.idtech.entity.ghost.GhostModel;
import com.idtech.entity.ghost.GhostRenderFactory;
import com.idtech.entity.jungle_bat.JungleBatEntity;
import com.idtech.entity.jungle_bat.JungleBatRenderFactory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityMod {

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
        event.getRegistry().register(GhostEntity.TYPE);
        event.getRegistry().register(JungleBatEntity.TYPE);
        event.getRegistry().register(CustomTraderEntity.TYPE);
    }
    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(GhostEntity.EGG);
        event.getRegistry().register(JungleBatEntity.EGG);
        event.getRegistry().register(CustomTraderEntity.EGG);
    }
    @SubscribeEvent
    public static void entityRenderers(final EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(GhostEntity.TYPE, GhostRenderFactory.INSTANCE);
        event.registerEntityRenderer(JungleBatEntity.TYPE, JungleBatRenderFactory.INSTANCE);
        event.registerEntityRenderer(CustomTraderEntity.TYPE, CustomTraderRenderFactory.INSTANCE);
    }
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        //This line is necessary even if the createAttributes method wasn't overridden
        event.put(GhostEntity.TYPE, GhostEntity.createAttributes().build());
        event.put(JungleBatEntity.TYPE, JungleBatEntity.createAttributes().build());
        event.put(CustomTraderEntity.TYPE, CustomTraderEntity.createAttributes().build());
    }
    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {

        //LayerDefinition ghostBodyLayer = GhostModel.createBodyLayer();
        //ImmutableMap.Builder<ModelLayerLocation, LayerDefinition> builder = ImmutableMap.builder();

        //register LayerDefinitions (only needed for mobs with custom models)
        event.registerLayerDefinition(GhostModel.LAYER_LOCATION,  GhostModel::createBodyLayer);
    }

}
