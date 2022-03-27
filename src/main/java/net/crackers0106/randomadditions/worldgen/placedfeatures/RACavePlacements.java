package net.crackers0106.randomadditions.worldgen.placedfeatures;

import net.crackers0106.randomadditions.worldgen.configuredfeatures.RACaveFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class RACavePlacements {
    public static final Holder<PlacedFeature> GLOWCELIUM_VEGETATION = PlacementUtils.register(
    "glowcelium_vegetation",
        RACaveFeatures.GLOWCELIUM_PATCH,
            CountPlacement.of(8),
            InSquarePlacement.spread(),
            PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
            EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12),
            RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> PATCH_GLOWSHROOM_BONEMEAL = PlacementUtils.register(
            "patch_glowshroom_bonemeal", RACaveFeatures.GLOWSHROOM,
            PlacementUtils.isEmpty());

    public static final Holder<PlacedFeature> ORE_RUBY = PlacementUtils.register(
            "ore_ruby",
            RACaveFeatures.ORE_RUBY, (commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(4), VerticalAnchor.absolute(32))))
    );

    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier2) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(i), placementModifier);
    }
}
