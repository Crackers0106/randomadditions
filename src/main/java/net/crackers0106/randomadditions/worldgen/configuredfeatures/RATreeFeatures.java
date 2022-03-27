package net.crackers0106.randomadditions.worldgen.configuredfeatures;

import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.worldgen.tree.foliageplacer.PalmFoliagePlacer;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import static net.minecraft.util.valueproviders.ConstantInt.of;
import static java.lang.Boolean.*;

public class RATreeFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BANANA = FeatureUtils.register(
        "banana",
            Feature.TREE, (
                (new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Blocks.STRIPPED_JUNGLE_LOG), new StraightTrunkPlacer(5, 3, 0),
                    BlockStateProvider.simple(RABlocks.BANANA_LEAVES), new PalmFoliagePlacer(of(5), of(4), of(3)),
                    new TwoLayersFeatureSize(1, 0, 1)))
                    .build()));

    public static final Holder<ConfiguredFeature<HugeMushroomFeatureConfiguration, ?>> HUGE_GLOWSHROOM = FeatureUtils.register(
        "huge_glowshroom",
            Feature.HUGE_RED_MUSHROOM, (
                new HugeMushroomFeatureConfiguration(
                    BlockStateProvider.simple(RABlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, FALSE)),
                    BlockStateProvider.simple(RABlocks.GLOWSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, FALSE).setValue(HugeMushroomBlock.DOWN, false)),
                        2)));

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SHRUBLAND_BUSH = FeatureUtils.register(
        "shrubland_bush",
            Feature.TREE, (
                (new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(1, 0, 0),
                    BlockStateProvider.simple(Blocks.OAK_LEAVES), new BushFoliagePlacer(of(2), of(1), 2),
                    new TwoLayersFeatureSize(0, 0, 0)))
                    .build()));
}
