package net.crackers0106.randomadditions.gen.configuredfeatures;

import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.gen.tree.foliageplacer.PalmFoliagePlacer;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class RATreeConfiguredFeatures {

    public static final ConfiguredFeature<TreeFeatureConfig, ?> BANANA = ConfiguredFeatures.register(
            "banana",
       Feature.TREE
           .configure(
              (new TreeFeatureConfig.Builder(
                      BlockStateProvider.of(Blocks.STRIPPED_JUNGLE_LOG),
                      new StraightTrunkPlacer(5, 3, 0),
                      BlockStateProvider.of(RABlocks.BANANA_LEAVES),
                      new PalmFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(4), ConstantIntProvider.create(3)),
                      new TwoLayersFeatureSize(1, 0, 1)
                   ))
                   .build()
           )
    );

    public static final ConfiguredFeature<?, ?> HUGE_GLOWSHROOM = ConfiguredFeatures.register(
            "huge_glowshroom",
            Feature.HUGE_RED_MUSHROOM
                    .configure(
                            new HugeMushroomFeatureConfig(
                                    BlockStateProvider.of(RABlocks.GLOWSHROOM_BLOCK.getDefaultState().with(MushroomBlock.DOWN, Boolean.FALSE)),
                                    BlockStateProvider.of(
                                            RABlocks.GLOWSHROOM_STEM.getDefaultState().with(MushroomBlock.UP, Boolean.FALSE).with(MushroomBlock.DOWN, Boolean.FALSE)
                                    ),
                                    2
                            )
                    )
    );
}
