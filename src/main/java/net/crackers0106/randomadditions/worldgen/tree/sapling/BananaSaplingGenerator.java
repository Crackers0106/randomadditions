package net.crackers0106.randomadditions.worldgen.tree.sapling;

import net.crackers0106.randomadditions.worldgen.configuredfeatures.RATreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Random;

public class BananaSaplingGenerator extends AbstractTreeGrower {

    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean bees) {
        return RATreeFeatures.BANANA;
    }
}