package net.crackers0106.randomadditions.gen;

import com.google.common.collect.ImmutableList;
import net.crackers0106.randomadditions.RandomAdditions;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.NoSuchElementException;

public class RAFeatures {

    public static ConfiguredFeature<TreeFeatureConfig, ?> SHRUBLAND_BUSH;
    public static ConfiguredFeature<?, ?> BUSH_DECORATOR;
    public static ConfiguredFeature<?, ?> SHRUBLAND_GRASS;

    public static void registerFeatures() {

        SHRUBLAND_BUSH = register("shrubland_bush", Feature.TREE.configure(Configs.BUSH_CONFIG));
        SHRUBLAND_GRASS = register("shrubland_grass", Feature.RANDOM_PATCH.configure(Configs.SHRUBLAND_GRASS_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(20));
        BUSH_DECORATOR = register("bush_decorator", Feature.RANDOM_SELECTOR.configure(Configs.BUSH_DECORATOR_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.1F, 1))));
    }

    public static class Configs {

        public static final TreeFeatureConfig BUSH_CONFIG = (new net.minecraft.world.gen.feature.TreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new StraightTrunkPlacer(1, 0, 0), new SimpleBlockStateProvider(States.OAK_LEAVES), new SimpleBlockStateProvider(States.OAK_SAPLING), new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2), new TwoLayersFeatureSize(0, 0, 0))).build();
        public static final RandomPatchFeatureConfig SHRUBLAND_GRASS_CONFIG = (new net.minecraft.world.gen.feature.RandomPatchFeatureConfig.Builder(new WeightedBlockStateProvider(RAFeatures.pool().add(States.GRASS, 3).add(States.FERN, 1)), SimpleBlockPlacer.INSTANCE)).tries(32).build();

        public static final RandomFeatureConfig BUSH_DECORATOR_CONFIG = new RandomFeatureConfig(
                ImmutableList.of(
                        Feature.TREE.configure(BUSH_CONFIG).withChance(0.3F)
                ),
                Feature.TREE.configure(Configs.BUSH_CONFIG)
        );
    }

    public static class States {

        public static final BlockState GRASS = Blocks.GRASS.getDefaultState();
        public static final BlockState FERN = Blocks.FERN.getDefaultState();
        public static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
        public static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
        public static final BlockState OAK_SAPLING = Blocks.OAK_SAPLING.getDefaultState();
    }

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, RandomAdditions.locate(id), configuredFeature);
    }

    static DataPool.Builder<BlockState> pool() {
        return DataPool.builder();
    }
}