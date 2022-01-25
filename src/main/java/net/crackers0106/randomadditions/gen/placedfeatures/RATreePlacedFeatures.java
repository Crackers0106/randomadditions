package net.crackers0106.randomadditions.gen.placedfeatures;

import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.gen.configuredfeatures.RATreeConfiguredFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;

public class RATreePlacedFeatures {

    public static final PlacedFeature BANANA_CHECKED = PlacedFeatures.register(
            "banana_checked", RATreeConfiguredFeatures.BANANA.withWouldSurviveFilter(RABlocks.BANANA_SAPLING)
    );
}
