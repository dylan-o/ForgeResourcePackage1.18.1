package com.idtech.world;

import com.idtech.BaseMod;
import com.idtech.block.BlockMod;
import com.idtech.entity.ghost.GhostEntity;
import com.idtech.entity.jungle_bat.JungleBatEntity;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnSettingsBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

// Use this class for natural ore generation and mob spawning
@Mod.EventBusSubscriber(modid = BaseMod.MODID)
public class WorldMod {

    // Needed to create "replaceables" for end ore feature.
    public static final RuleTest ENDSTONE = new BlockMatchTest(Blocks.END_STONE);

    // Testing Ore Generation (https://fabricmc.net/wiki/tutorial:ores)
    // last int is vein size, not sure if its maximum or average
    public static ConfiguredFeature<?, ?> CASTLE_WALL_TEST_FEATURE = new ConfiguredFeature(
            Feature.ORE, new OreConfiguration(
            OreFeatures.STONE_ORE_REPLACEABLES,
            BlockMod.CASTLE_WALL.defaultBlockState(),
            12));

    // natural ore generation
    // CountPlacement.of(veinsPerChunk)
    public static PlacedFeature CASTLE_WALL_TEST_PLACED_FEATURE = CASTLE_WALL_TEST_FEATURE.placed(
            List.of(
                    CountPlacement.of(150),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80)),
                    BiomeFilter.biome()
            ));

    // For some reason you need to create this resource key to register biomes idk
    //private static ResourceKey<Biome> BASIC_TESTER = ResourceKey.create(Registry.BIOME_REGISTRY, CustomBiomes.BASIC_TESTER.getRegistryName());
    //private static ResourceKey<Biome> STORMFIELD_PLAINS = ResourceKey.create(Registry.BIOME_REGISTRY, StormfieldPlainsBiome.INSTANCE.getRegistryName());

    public static void registerBiomes(final RegistryEvent.Register<Biome> event){
        //register the biome itself
        //event.getRegistry().register(CustomBiomes.BASIC_TESTER);
        //event.getRegistry().register(StormfieldPlainsBiome.INSTANCE);
    }


    public static void setupBiomes()
    {
        //BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(STORMFIELD_PLAINS, 9999));
    }



    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void addFeatures(BiomeLoadingEvent event) {
        Biome.BiomeCategory biomeCategory = event.getCategory();
        BiomeGenerationSettingsBuilder biomeGen = event.getGeneration();
        MobSpawnSettingsBuilder builder = event.getSpawns();

        // natural ore generation
        FeatureUtils.register("castlewallfeature", CASTLE_WALL_TEST_FEATURE);
        PlacementUtils.register("castlewallfeature", CASTLE_WALL_TEST_PLACED_FEATURE);

        // natural ore generation
        if(event.getCategory() == Biome.BiomeCategory.MOUNTAIN)
        {
            biomeGen.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CASTLE_WALL_TEST_PLACED_FEATURE);
        }

        // MOB SPAWNING:
        // works for custom mobs and mobs already in the game

        if(event.getCategory() == Biome.BiomeCategory.JUNGLE){
            // the 3 int parameters when calling SpawnerData are:
            // Spawn weight (increase to have them spawn more often)
            // Minimum group size
            // Maximum group size
            event.getSpawns().addSpawn(MobCategory.AMBIENT,
                    new MobSpawnSettings.SpawnerData(JungleBatEntity.TYPE, 1, 2, 8));
        }

        // example of spawning for a normal minecraft mob
        if(event.getCategory() == Biome.BiomeCategory.PLAINS){
            event.getSpawns().addSpawn(MobCategory.CREATURE,
                    new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 5, 1, 3));
        }

        if(event.getCategory() == Biome.BiomeCategory.MESA)
        {
            event.getSpawns().addSpawn(MobCategory.MONSTER,
                    new MobSpawnSettings.SpawnerData(GhostEntity.TYPE, 5, 1, 1));
        }

        if(event.getCategory() == Biome.BiomeCategory.THEEND){
            event.getSpawns().addSpawn(MobCategory.MONSTER,
                    new MobSpawnSettings.SpawnerData(GhostEntity.TYPE, 2, 1, 1));
        }
    }
}