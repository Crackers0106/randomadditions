package net.crackers0106.randomadditions.gen.biome;

import net.crackers0106.randomadditions.gen.RAFeatures;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;

public class BiomeRainforest {

    private static final Biome RAINFOREST = createRainforest();

    private static Biome createRainforest () {
        // We specify what entities spawn and what features generate in the biome.
        // Aside from some structures, trees, rocks, plants and
        //   custom entities, these are mostly the same for each biome.
        // Vanilla configured features for biomes are defined in DefaultBiomeFeatures.

        GenerationSettings.Builder builder = new GenerationSettings.Builder();
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(ConfiguredSurfaceBuilders.GRASS);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addDefaultLakes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);

        BiomeRainforest.addFeatures(generationSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NONE)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(0.9F)
                .downfall(1.0F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x050533)
                        .fogColor(0xc0d8ff)
                        .skyColor(0x77adff)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();

    }

    public static final RegistryKey<Biome> RAINFOREST_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("randomadditions", "rainforest"));

    public static void addFeatures(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_MELON);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, RAFeatures.TREES_RAINFOREST);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, RAFeatures.PATCH_GRASS_SHRUBLAND);
    }

    public static void init() {
        Registry.register(BuiltinRegistries.BIOME, RAINFOREST_KEY.getValue(), RAINFOREST);

        OverworldBiomes.addContinentalBiome(RAINFOREST_KEY, OverworldClimate.TEMPERATE, 2D);
    }
}