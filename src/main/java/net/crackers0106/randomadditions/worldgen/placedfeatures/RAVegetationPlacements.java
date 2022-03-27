package net.crackers0106.randomadditions.worldgen.placedfeatures;

import net.crackers0106.randomadditions.worldgen.configuredfeatures.RAVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class RAVegetationPlacements {

    public static final Holder<PlacedFeature> BUSHES_SHRUBLAND = PlacementUtils.register(
            "bushes_shrubland",
            RAVegetationFeatures.BUSHES_SHRUBLAND, (treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)))
    );

    public static final Holder<PlacedFeature> TREES_RAINFOREST = PlacementUtils.register(
            "trees_rainforest",
            RAVegetationFeatures.TREES_RAINFOREST, (treePlacement(PlacementUtils.countExtra(3, 0.1F, 1)))
    );
}
