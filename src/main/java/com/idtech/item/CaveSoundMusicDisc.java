package com.idtech.item;

import com.idtech.BaseMod;
import com.idtech.ModTab;
import com.idtech.SoundHandler;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class CaveSoundMusicDisc extends RecordItem {
    public static RecordItem INSTANCE = (RecordItem) new RecordItem(4, SoundEvents.AMBIENT_CAVE, new Properties().tab(ModTab.INSTANCE).stacksTo(1))
            .setRegistryName(BaseMod.MODID,"cave_sound_music_disc");

    public CaveSoundMusicDisc(int comparatorValue, Supplier<SoundEvent> soundSupplier, Properties builder) {
        super(comparatorValue, soundSupplier, builder);
    }
}