package net.crackers0106.randomadditions.gen.configuredfeatures;

import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.gen.tree.foliageplacer.PalmFoliagePlacer;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class RATreeConfiguredFeatures {

    public static final ConfiguredFeature<TreeConfiguration, ?> BANANA = FeatureUtils.register(
            "banana",
       Feature.TREE
           .configured(
              (new TreeConfiguration.TreeConfigurationBuilder(
                      BlockStateProvider.simple(Blocks.STRIPPED_JUNGLE_LOG),
                      new StraightTrunkPlacer(5, 3, 0),
                      BlockStateProvider.simple(RABlocks.BANANA_LEAVES),
                      new PalmFoliagePlacer(ConstantInt.of(5), ConstantInt.of(4), ConstantInt.of(3)),
                      new TwoLayersFeatureSize(1, 0, 1)
                   ))
                   .build()
           )
    );

    public static final ConfiguredFeature<?, ?> HUGE_GLOWSHROOM = FeatureUtils.register(
            "huge_glowshroom",
            Feature.HUGE_RED_MUSHROOM
                    .configured(
                            new HugeMushroomFeatureConfiguration(
                                    BlockStateProvider.simple(RABlocks.GLOWSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                                    BlockStateProvider.simple(
                                            RABlocks.GLOWSHROOM_STEM.defaultBlockState().setValue(HugeMushroomBlock.UP, Boolean.FALSE).setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)
                                    ),
                                    2
                            )
                    )
    );
}
