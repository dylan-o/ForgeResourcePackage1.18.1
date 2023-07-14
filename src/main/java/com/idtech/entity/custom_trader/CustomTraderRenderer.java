package com.idtech.entity.custom_trader;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WanderingTraderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.WanderingTrader;

public class CustomTraderRenderer extends WanderingTraderRenderer{

    public CustomTraderRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }

    @Override
    public ResourceLocation getTextureLocation(WanderingTrader entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/customtrader.png");
    }



}