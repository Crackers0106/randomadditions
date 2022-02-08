package net.crackers0106.randomadditions.gen.configuredfeatures;

import net.crackers0106.randomadditions.block.RABlockTags;
import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.gen.placedfeatures.RAUndergroundPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class RAUndergroundConfiguredFeatures {

    public static final ConfiguredFeature<SimpleBlockConfiguration, ?> GLOWSHROOM_VEGETATION = FeatureUtils.register(
            "glowshroom_vegetation",
            Feature.SIMPLE_BLOCK
                    .configured(
                            new SimpleBlockConfiguration(
                                    new WeightedStateProvider(
                                            SimpleWeightedRandomList.<BlockState>builder()
                                                    .add(RABlocks.GLOWSHROOM.defaultBlockState(), 50)
                                    )
                            )
                    )
    );

    public static final ConfiguredFeature<VegetationPatchConfiguration, ?> GLOWCELIUM_PATCH = FeatureUtils.register(
            "glowcelium_patch",
            Feature.VEGETATION_PATCH
                    .configured(
                            new VegetationPatchConfiguration(
                                    RABlockTags.GLOWCELIUM_REPLACEABLE.getName(),
                                    BlockStateProvider.simple(RABlocks.GLOWCELIUM),
                                    GLOWSHROOM_VEGETATION::placed,
                                    CaveSurface.FLOOR,
                                    ConstantInt.of(1),
                                    0.0F,
                                    5,
                                    0.6F,
                                    UniformInt.of(1, 2),
                                    0.75F
                            )
                    )
    );

    public static ResourceKey<PlacedFeature> getKey(PlacedFeature f) {
        return BuiltinRegistries.PLACED_FEATURE.getResourceKey(f).orElseThrow();
    }

    public static void generate() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES, getKey(RAUndergroundPlacedFeatures.GLOWCELIUM_VEGETATION));
    }
}
