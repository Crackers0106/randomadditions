package net.crackers0106.randomadditions.gen.placedfeatures;

import net.crackers0106.randomadditions.gen.configuredfeatures.RAUndergroundConfiguredFeatures;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;

public class RAUndergroundPlacedFeatures {

    public static final PlacedFeature GLOWCELIUM_VEGETATION = PlacedFeatures.register(
            "glowcelium_vegetation",
            RAUndergroundConfiguredFeatures.GLOWCELIUM_PATCH
                    .withPlacement(
                            CountPlacementModifier.of(8),
                            SquarePlacementModifier.of(),
                            PlacedFeatures.BOTTOM_TO_120_RANGE,
                            EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
                            RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(1)),
                            BiomePlacementModifier.of())
    );
}
