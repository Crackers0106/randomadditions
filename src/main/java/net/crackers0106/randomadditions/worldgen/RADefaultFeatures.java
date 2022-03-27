package net.crackers0106.randomadditions.worldgen;

import net.crackers0106.randomadditions.worldgen.placedfeatures.RACavePlacements;
import net.crackers0106.randomadditions.worldgen.placedfeatures.RAVegetationPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class RADefaultFeatures {

    public static void addShrublandVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RAVegetationPlacements.BUSHES_SHRUBLAND);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_JUNGLE);
    }

    public static void addRainforestVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RAVegetationPlacements.TREES_RAINFOREST);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_JUNGLE);
    }

    public static void addGlowshrooms(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RACavePlacements.GLOWCELIUM_VEGETATION);
    }

    public static void addRubies(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RACavePlacements.ORE_RUBY);
    }
}
