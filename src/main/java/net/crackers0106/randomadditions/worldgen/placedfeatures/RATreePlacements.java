package net.crackers0106.randomadditions.worldgen.placedfeatures;

import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.worldgen.configuredfeatures.RATreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class RATreePlacements {

    public static final Holder<PlacedFeature> BANANA_CHECKED = PlacementUtils.register(
        "banana_checked", RATreeFeatures.BANANA, PlacementUtils.filteredByBlockSurvival(RABlocks.BANANA_SAPLING));

    public static final Holder<PlacedFeature> SHRUBLAND_BUSH = PlacementUtils.register(
        "shrubland_bush", RATreeFeatures.SHRUBLAND_BUSH, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
}
