package net.crackers0106.randomadditions.worldgen.configuredfeatures;

import net.crackers0106.randomadditions.block.RABlockTags;
import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.worldgen.placedfeatures.RACavePlacements;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class RACaveFeatures {
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> GLOWSHROOM = FeatureUtils.register(
            "glowshroom", Feature.SIMPLE_BLOCK, (
                    new SimpleBlockConfiguration(BlockStateProvider.simple(RABlocks.GLOWSHROOM.defaultBlockState()))
            ));

    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> GLOWCELIUM_PATCH = FeatureUtils.register(
            "glowcelium_patch",
            Feature.VEGETATION_PATCH,
            new VegetationPatchConfiguration(
                RABlockTags.GLOWCELIUM_REPLACEABLE,
                BlockStateProvider.simple(RABlocks.GLOWCELIUM),
                PlacementUtils.inlinePlaced(GLOWSHROOM),
                CaveSurface.FLOOR,
                ConstantInt.of(1),
                0.0F,
                5,
                0.5F,
                UniformInt.of(1, 2),
                0.75F)
            );

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_RUBY = FeatureUtils.register(
            "ore_ruby",
            Feature.ORE,
                new OreConfiguration(
                    List.of(
                        OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, RABlocks.RUBY_ORE.defaultBlockState()),
                        OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, RABlocks.DEEPSLATE_RUBY_ORE.defaultBlockState())), 3)
            );

    public static ResourceKey<PlacedFeature> getKey(PlacedFeature f) {
        return BuiltinRegistries.PLACED_FEATURE.getResourceKey(f).orElseThrow();
    }

    public static void generate() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_ORES, getKey(RACavePlacements.ORE_RUBY.value()));
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, getKey(RACavePlacements.GLOWCELIUM_VEGETATION.value()));
    }
}
