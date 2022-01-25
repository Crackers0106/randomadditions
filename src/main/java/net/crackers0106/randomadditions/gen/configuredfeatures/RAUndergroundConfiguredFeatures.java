package net.crackers0106.randomadditions.gen.configuredfeatures;

import net.crackers0106.randomadditions.block.RABlockTags;
import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.gen.placedfeatures.RAUndergroundPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.BlockState;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class RAUndergroundConfiguredFeatures {

    public static final ConfiguredFeature<SimpleBlockFeatureConfig, ?> GLOWSHROOM_VEGETATION = ConfiguredFeatures.register(
            "glowshroom_vegetation",
            Feature.SIMPLE_BLOCK
                    .configure(
                            new SimpleBlockFeatureConfig(
                                    new WeightedBlockStateProvider(
                                            DataPool.<BlockState>builder()
                                                    .add(RABlocks.GLOWSHROOM.getDefaultState(), 50)
                                    )
                            )
                    )
    );

    public static final ConfiguredFeature<VegetationPatchFeatureConfig, ?> GLOWCELIUM_PATCH = ConfiguredFeatures.register(
            "glowcelium_patch",
            Feature.VEGETATION_PATCH
                    .configure(
                            new VegetationPatchFeatureConfig(
                                    RABlockTags.GLOWCELIUM_REPLACEABLE.getId(),
                                    BlockStateProvider.of(RABlocks.GLOWCELIUM),
                                    GLOWSHROOM_VEGETATION::withPlacement,
                                    VerticalSurfaceType.FLOOR,
                                    ConstantIntProvider.create(1),
                                    0.0F,
                                    5,
                                    0.6F,
                                    UniformIntProvider.create(1, 2),
                                    0.75F
                            )
                    )
    );

    public static RegistryKey<PlacedFeature> getKey(PlacedFeature f) {
        return BuiltinRegistries.PLACED_FEATURE.getKey(f).orElseThrow();
    }

    public static void generate() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, getKey(RAUndergroundPlacedFeatures.GLOWCELIUM_VEGETATION));
    }
}
