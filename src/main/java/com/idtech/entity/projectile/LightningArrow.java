package com.idtech.entity.projectile;

import com.idtech.Utils;
import com.idtech.item.BombArrowItem;
import com.idtech.item.LightningArrowItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class LightningArrow extends AbstractArrow
{
    public LightningArrow(Level levelIn, LivingEntity entityIn)
    {
        super(EntityType.ARROW, entityIn, levelIn);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(LightningArrowItem.INSTANCE);
    }

    int count = 0;

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        Vec3 loc = result.getLocation();
        if(count < 1) {
            Utils.strikeLightning(level, new BlockPos(loc));
            count++;
        }
    }
}