package com.idtech.entity.ghost;

import com.idtech.BaseMod;
import com.idtech.entity.EntityUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.Random;

public class GhostEntity extends Ghast {
    public static final ResourceLocation LOOT_TABLE = new ResourceLocation(BaseMod.MODID, "entities/ghost");
    public static EntityType<GhostEntity> TYPE = (EntityType<GhostEntity>)
            EntityType.Builder.of(GhostEntity::new, MobCategory.MONSTER)
                    .build("ghost")
                    .setRegistryName(BaseMod.MODID, "ghost");
    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xff3399, 0x1a000d);
    public GhostEntity(EntityType<? extends Ghast> type, Level level) {
        super(type, level);
    }
    public static AttributeSupplier.Builder createAttributes() {

        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 1f).add(Attributes.MAX_HEALTH, 30).add(Attributes.FLYING_SPEED, 1f).add(Attributes.FOLLOW_RANGE, 1000f);
    }
    public boolean isOnFire() {
        return false;
    }
    @Override
    public void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(2, new GhostShootFireballGoal(this));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(50, new RandomFloatAroundGoal(this));
    }

    //copied from Ghast.java so that it can be accessed and edited
    static class GhostShootFireballGoal extends Goal {
        private final Ghast ghast;
        public int chargeTime;

        public GhostShootFireballGoal(Ghast p_32776_) {
            this.ghast = p_32776_;
        }

        public boolean canUse() {
            return this.ghast.getTarget() != null;
        }

        public void start() {
            this.chargeTime = 0;
        }

        public void stop() {
            this.ghast.setCharging(false);
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            LivingEntity livingentity = this.ghast.getTarget();
            if (livingentity != null) {
                double d0 = 64.0D;
                if (livingentity.distanceToSqr(this.ghast) < 4096.0D && this.ghast.hasLineOfSight(livingentity)) {
                    Level level = this.ghast.level;
                    ++this.chargeTime;
                    if (this.chargeTime == 10 && !this.ghast.isSilent()) {
                        level.levelEvent((Player)null, 1015, this.ghast.blockPosition(), 0);
                    }

                    if (this.chargeTime == 20) {
                        double d1 = 4.0D;
                        Vec3 vec3 = this.ghast.getViewVector(1.0F);
                        double d2 = livingentity.getX() - (this.ghast.getX() + vec3.x * 4.0D);
                        double d3 = livingentity.getY(0.5D) - (0.5D + this.ghast.getY(0.5D));
                        double d4 = livingentity.getZ() - (this.ghast.getZ() + vec3.z * 4.0D);
                        if (!this.ghast.isSilent()) {
                            level.levelEvent((Player)null, 1016, this.ghast.blockPosition(), 0);
                        }

                        LargeFireball largefireball = new LargeFireball(level, this.ghast, d2, d3, d4, this.ghast.getExplosionPower());
                        largefireball.setPos(this.ghast.getX() + vec3.x * 4.0D, this.ghast.getY(0.5D) + 0.5D, largefireball.getZ() + vec3.z * 4.0D);
                        level.addFreshEntity(largefireball);
                        this.chargeTime = -40;
                    }
                } else if (this.chargeTime > 0) {
                    --this.chargeTime;
                }

                this.ghast.setCharging(this.chargeTime > 10);
            }
        }
    }

    //copied from Ghast.java so that it can be accessed and edited
    static class RandomFloatAroundGoal extends Goal {
        private final Ghast ghast;

        public RandomFloatAroundGoal(Ghast p_32783_) {
            this.ghast = p_32783_;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            MoveControl movecontrol = this.ghast.getMoveControl();
            if (!movecontrol.hasWanted()) {
                return true;
            } else {
                double d0 = movecontrol.getWantedX() - this.ghast.getX();
                double d1 = movecontrol.getWantedY() - this.ghast.getY();
                double d2 = movecontrol.getWantedZ() - this.ghast.getZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        public boolean canContinueToUse() {
            return false;
        }

        public void start() {
            Random random = this.ghast.getRandom();
            double d0 = this.ghast.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 4.0F);
            double d1 = this.ghast.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 4.0F);
            double d2 = this.ghast.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 4.0F);
            this.ghast.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
        }
    }

    @Override
    public ResourceLocation getDefaultLootTable(){
        return LOOT_TABLE;
    }
}
