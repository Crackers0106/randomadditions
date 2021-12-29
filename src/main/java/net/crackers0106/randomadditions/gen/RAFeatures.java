package net.crackers0106.randomadditions.gen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.crackers0106.randomadditions.RandomAdditions;
import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.block.SculkBlocks;
import net.crackers0106.randomadditions.gen.tree.foliageplacer.PalmFoliagePlacer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class RAFeatures extends ConfiguredFeatures{

    public static final ConfiguredFeature<?, ?> PATCH_SCULK_VEIN = register(
            "sculk_vein_patch",
            Feature.RANDOM_PATCH
                    .configure(Configs.SCULK_VEIN_CONFIG)
    );

    public static final ConfiguredFeature<VegetationPatchFeatureConfig, ?> SCULK_PATCH = register(
            "sculk_patch",
            Feature.VEGETATION_PATCH
                    .configure(
                            new VegetationPatchFeatureConfig(
                                    BlockTags.MOSS_REPLACEABLE.getId(),
                                    new SimpleBlockStateProvider(States.SCULK),
                                    () -> ConfiguredFeatures.MOSS_VEGETATION,
                                    VerticalSurfaceType.FLOOR,
                                    ConstantIntProvider.create(1),
                                    0.0F,
                                    5,
                                    0.6F,
                                    UniformIntProvider.create(1, 2),
                                    0.75F
                            )
                    )
    );

    public static final ConfiguredFeature<?, ?> PATCH_GRASS_SHRUBLAND = register(
            "shrubland_grass",
            Feature.RANDOM_PATCH
                    .configure(Configs.SHRUBLAND_GRASS_CONFIG)
                    .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE)
                    .repeat(20)
    );

    public static ConfiguredFeature<?, ?> BUSH_DECORATOR = register(
            "bush_decorator",
            Feature.RANDOM_SELECTOR
                    .configure(Configs.BUSH_DECORATOR_CONFIG)
                    .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
                    .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1F, 1)))
    );

    public static final ConfiguredFeature<TreeFeatureConfig, ?> BANANA_TREE = register(
            "banana_tree",
            Feature.TREE
                    .configure(Configs.BANANA_CONFIG)
    );

    public static ConfiguredFeature<?, ?> TREES_RAINFOREST = register(
            "trees_rainforest",
            Feature.RANDOM_SELECTOR
                    .configure(new RandomFeatureConfig(ImmutableList.of(ConfiguredFeatures.FANCY_OAK.withChance(0.666F), BANANA_TREE.withChance(0.1F)), ConfiguredFeatures.JUNGLE_TREE))
                    .decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
                    .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(3, 0.1F, 1)))
    );

    public static class Configs {

        public static final TreeFeatureConfig BANANA_CONFIG = (new TreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(States.STRIPPED_JUNGLE_LOG),
            new StraightTrunkPlacer(5, 3, 0),
            new SimpleBlockStateProvider(States.BANANA_LEAVES),
            new SimpleBlockStateProvider(States.BANANA_SAPLING),
            new PalmFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(4), ConstantIntProvider.create(3)),
            new TwoLayersFeatureSize(1, 0, 1)
    ))
            .build();
        
        public static final TreeFeatureConfig SHRUBLAND_BUSH = (new TreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(States.OAK_LOG),
                new StraightTrunkPlacer(1, 0, 0),
                new SimpleBlockStateProvider(States.OAK_LEAVES),
                new SimpleBlockStateProvider(States.OAK_SAPLING),
                new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(0, 0, 0)
        ))
                .build();

        public static final RandomFeatureConfig BUSH_DECORATOR_CONFIG = new RandomFeatureConfig(
                ImmutableList.of(Feature.TREE.configure(SHRUBLAND_BUSH).withChance(0.3F)),
                Feature.TREE.configure(SHRUBLAND_BUSH)
        );
        
        public static final RandomPatchFeatureConfig SHRUBLAND_GRASS_CONFIG = (new RandomPatchFeatureConfig.Builder(
                new WeightedBlockStateProvider(pool().add(States.GRASS, 3).add(States.FERN, 1)),
                SimpleBlockPlacer.INSTANCE
            ))
            .tries(32)
            .build();

        public static final RandomPatchFeatureConfig SCULK_VEIN_CONFIG = (new RandomPatchFeatureConfig.Builder(
                new SimpleBlockStateProvider(States.SCULK_VEIN),
                SimpleBlockPlacer.INSTANCE
            ))
            .blacklist(ImmutableSet.of(States.SCULK))
            .tries(64)
            .build();

    }

    public static class States {

        public static final BlockState GRASS = Blocks.GRASS.getDefaultState();
        public static final BlockState FERN = Blocks.FERN.getDefaultState();
        public static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
        public static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
        public static final BlockState OAK_SAPLING = Blocks.OAK_SAPLING.getDefaultState();
        public static final BlockState STRIPPED_JUNGLE_LOG = Blocks.STRIPPED_JUNGLE_LOG.getDefaultState();
        public static final BlockState BANANA_LEAVES = RABlocks.BANANA_LEAVES.getDefaultState();
        public static final BlockState BANANA_SAPLING = RABlocks.BANANA_SAPLING.getDefaultState();
        public static final BlockState SCULK_SENSOR = Blocks.SCULK_SENSOR.getDefaultState();
        public static final BlockState SCULK_VEIN = SculkBlocks.SCULK_VEIN.getDefaultState();
        public static final BlockState SCULK = SculkBlocks.SCULK.getDefaultState();
    }

    public static void registerFeatures() {
    }

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, RandomAdditions.locate(id), configuredFeature);
    }

    static DataPool.Builder<BlockState> pool() {
        return DataPool.builder();
    }
    //        RAINFOREST_TREES = register("rainforest_trees", Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(ConfiguredFeatures.FANCY_OAK.withChance(0.666F)), ConfiguredFeatures.JUNGLE_TREE)).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(8, 0.1F, 1))));
}