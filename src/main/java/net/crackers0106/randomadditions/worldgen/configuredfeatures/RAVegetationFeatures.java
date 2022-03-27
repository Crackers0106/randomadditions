package net.crackers0106.randomadditions.worldgen.configuredfeatures;

import net.crackers0106.randomadditions.worldgen.placedfeatures.RATreePlacements;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;

import java.util.List;

public class RAVegetationFeatures {
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BUSHES_SHRUBLAND = FeatureUtils.register(
        "bushes_shrubland", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(
            List.of(new WeightedPlacedFeature(RATreePlacements.SHRUBLAND_BUSH, 0.3F)),
            RATreePlacements.SHRUBLAND_BUSH))
    );

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_RAINFOREST = FeatureUtils.register(
            "trees_rainforest", Feature.RANDOM_SELECTOR, (new RandomFeatureConfiguration(
            List.of(new WeightedPlacedFeature(TreePlacements.FANCY_OAK_CHECKED, 0.666F),
                    new WeightedPlacedFeature(RATreePlacements.BANANA_CHECKED, 0.1F)),
            TreePlacements.JUNGLE_TREE_CHECKED))
    );
}
