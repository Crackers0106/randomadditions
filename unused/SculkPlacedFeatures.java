package net.crackers0106.randomadditions.worldgen.placedfeatures;

import net.crackers0106.randomadditions.worldgen.configuredfeatures.SculkConfiguredFeatures;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;

public class SculkPlacedFeatures {

    public static final PlacedFeature SCULK_VEIN_CLUSTER = PlacedFeatures.register(
            "sculk_vein_cluster",
            SculkConfiguredFeatures.SCULK_VEIN
                    .withPlacement(
                            CountPlacementModifier.of(10),
                            RarityFilterPlacementModifier.of(50),
                            EnvironmentScanPlacementModifier.of(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
                            RandomOffsetPlacementModifier.of(UniformIntProvider.create(0,5), UniformIntProvider.create(0,5)),
                            BiomePlacementModifier.of())
    );
}
