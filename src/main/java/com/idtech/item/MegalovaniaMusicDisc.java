package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.SoundHandler;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class MegalovaniaMusicDisc extends RecordItem {
    public static RecordItem INSTANCE = (RecordItem) new RecordItem(4, SoundHandler.megalovaniaSound, new Properties().tab(ModTab.INSTANCE).stacksTo(1))
            .setRegistryName(BaseMod.MODID,"megalovania_music_disc");

    public MegalovaniaMusicDisc(int comparatorValue, Supplier<SoundEvent> soundSupplier, Properties builder) {
        super(comparatorValue, soundSupplier, builder);
    }
}
