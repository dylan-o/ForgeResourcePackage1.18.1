package com.idtech.entity.custom_trader;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.npc.WanderingTrader;


public class CustomTraderRenderFactory implements EntityRendererProvider<WanderingTrader> {

    public static CustomTraderRenderFactory INSTANCE = new CustomTraderRenderFactory();

    @Override
    public EntityRenderer<WanderingTrader> create(Context manager) {
        return new CustomTraderRenderer(manager);
    }
}
