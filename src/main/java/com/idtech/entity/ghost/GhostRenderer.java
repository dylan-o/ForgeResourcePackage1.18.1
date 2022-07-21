package com.idtech.entity.ghost;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GhostRenderer extends MobRenderer<GhostEntity, GhostModel<GhostEntity>>{
    public GhostRenderer(EntityRendererProvider.Context provider) {
        super(provider, new GhostModel<>(provider.bakeLayer(GhostModel.LAYER_LOCATION)), 1f);
    }
    @Override
    public ResourceLocation getTextureLocation(GhostEntity entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/ghost.png");
    }

}
