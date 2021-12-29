package net.crackers0106.randomadditions.gen.tree.sapling;

import net.crackers0106.randomadditions.gen.RAFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BananaSaplingGenerator extends SaplingGenerator {

    @Override
    protected @Nullable ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return RAFeatures.BANANA_TREE;
    }
}