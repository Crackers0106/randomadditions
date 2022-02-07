package net.crackers0106.randomadditions.gen.placedfeatures;

import net.crackers0106.randomadditions.gen.configuredfeatures.RAUndergroundConfiguredFeatures;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;

public class RAUndergroundPlacedFeatures {

    public static final PlacedFeature GLOWCELIUM_VEGETATION = PlacementUtils.register(
            "glowcelium_vegetation",
            RAUndergroundConfiguredFeatures.GLOWCELIUM_PATCH
                    .placed(
                            CountPlacement.of(8),
                            InSquarePlacement.spread(),
                            PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                            EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
                            RandomOffsetPlacement.vertical(ConstantInt.of(1)),
                            BiomeFilter.biome())
    );
}
