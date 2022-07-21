package com.idtech.entity.jungle_bat;

import com.idtech.BaseMod;
import com.idtech.entity.EntityUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class JungleBatEntity extends Bat {

    // I set its category to CREATURE so that it would spawn above ground
    //for it to spawn underground like a normal bat, switch category to AMBIENT
    public static EntityType<JungleBatEntity> TYPE = (EntityType<JungleBatEntity>)
            EntityType.Builder.of(JungleBatEntity::new, MobCategory.CREATURE)
                    .build("jungle_bat")
                    .setRegistryName(BaseMod.MODID, "jungle_bat");

    public static Item EGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0x4c3e30, 0xec616d);

    public JungleBatEntity(EntityType<? extends Bat> type, Level level) {
        super(type, level);
    }
}
