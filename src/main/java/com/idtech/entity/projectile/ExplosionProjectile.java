package com.idtech.entity.projectile;

import com.idtech.BaseMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class ExplosionProjectile extends ThrowableItemProjectile implements ItemSupplier {

    public static EntityType<? extends ThrowableItemProjectile> TYPE = (EntityType<ExplosionProjectile>)
            EntityType.Builder.<ExplosionProjectile>of(ExplosionProjectile::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F).build("explosionprojectile")
                    .setRegistryName(BaseMod.MODID, "explosionprojectile");

    public ExplosionProjectile(Level level, LivingEntity entity) {
        super(TYPE, entity, level);
    }

    public ExplosionProjectile(EntityType<ExplosionProjectile> type, Level level) {
        super(type, level);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.FIRE_CHARGE;
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if(!this.level.isClientSide) {
            Vec3 pos = hitResult.getLocation();
            level.explode(null, pos.x(), pos.y(), pos.z(), 10, Explosion.BlockInteraction.DESTROY);
        }
        this.remove(RemovalReason.DISCARDED);
    }

}
