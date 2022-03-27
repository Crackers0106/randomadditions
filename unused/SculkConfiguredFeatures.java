package net.crackers0106.randomadditions.worldgen.configuredfeatures;

import net.crackers0106.randomadditions.block.RABlockTags;
import net.crackers0106.randomadditions.block.RASculkBlocks;
import net.crackers0106.randomadditions.worldgen.RAFeatures;
import net.crackers0106.randomadditions.worldgen.features.SculkPatchFeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.GlowLichenFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

import static net.crackers0106.randomadditions.worldgen.configuredfeatures.SculkConfiguredFeatures.States.*;

public class SculkConfiguredFeatures {

    public static final ConfiguredFeature<GlowLichenFeatureConfig, ?> SCULK_VEIN = ConfiguredFeatures.register(
            "sculk_vein",
            RAFeatures.SCULK_VEIN
                    .configure(
                            new GlowLichenFeatureConfig(
                                    20,
                                    true,
                                    true,
                                    true,
                                    0.8F,
                                    List.of(
                                            STONE, DRIPSTONE_BLOCK, DEEPSLATE
                                    )
                            )
                    )
    );

    public static final ConfiguredFeature<SculkPatchFeatureConfig, ?> SCULK_PATCH = ConfiguredFeatures.register(
            "sculk_patch",
            RAFeatures.SCULK_PATCH
                    .configure(
                            new SculkPatchFeatureConfig(
                                    BlockTags.MOSS_REPLACEABLE.getId(),
                                    RABlockTags.EXCLUDE_SCULK_VEIN_PLACEMENT.getId(),
                                    BlockStateProvider.of(SCULK),
                                    () -> SCULK_VEIN.withPlacement(),
                                    VerticalSurfaceType.FLOOR,
                                    ConstantIntProvider.create(1),
                                    5,
                                    0.005F,
                                    UniformIntProvider.create(1, 2)
                            )
                    )
    );

    public static class States {

        public static final BlockState SCULK = RASculkBlocks.SCULK.getDefaultState();
        public static final Block STONE = Blocks.STONE;
        public static final Block DRIPSTONE_BLOCK = Blocks.DRIPSTONE_BLOCK;
        public static final Block DEEPSLATE = Blocks.DEEPSLATE;
    }
}
