package com.idtech.entity.ghost;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;


public class GhostRenderFactory implements EntityRendererProvider<GhostEntity> {

    public static GhostRenderFactory INSTANCE = new GhostRenderFactory();

    @Override
    public EntityRenderer<GhostEntity> create(Context manager) {
        return new GhostRenderer(manager);
    }
}