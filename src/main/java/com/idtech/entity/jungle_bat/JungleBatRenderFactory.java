package com.idtech.entity.jungle_bat;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.ambient.Bat;

public class JungleBatRenderFactory implements EntityRendererProvider<Bat> {

    public static JungleBatRenderFactory INSTANCE = new JungleBatRenderFactory();

    @Override
    public EntityRenderer<Bat> create(Context manager) {
        return new JungleBatRenderer(manager);
    }
}