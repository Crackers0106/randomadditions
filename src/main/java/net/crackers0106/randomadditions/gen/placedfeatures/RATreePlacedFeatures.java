package net.crackers0106.randomadditions.gen.placedfeatures;

import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.gen.configuredfeatures.RATreeConfiguredFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class RATreePlacedFeatures {

    public static final PlacedFeature BANANA_CHECKED = PlacementUtils.register(
            "banana_checked", RATreeConfiguredFeatures.BANANA.filteredByBlockSurvival(RABlocks.BANANA_SAPLING)
    );
}
