package com.idtech.entity.jungle_bat;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.BatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ambient.Bat;

public class JungleBatRenderer extends BatRenderer {

    public JungleBatRenderer(EntityRendererProvider.Context provider) {
        super(provider);
    }

    @Override
    public ResourceLocation getTextureLocation(Bat entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/jungle_bat.png");
    }

}