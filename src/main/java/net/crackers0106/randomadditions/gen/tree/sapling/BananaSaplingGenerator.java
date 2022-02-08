package net.crackers0106.randomadditions.gen.tree.sapling;

import net.crackers0106.randomadditions.gen.configuredfeatures.RATreeConfiguredFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BananaSaplingGenerator extends AbstractTreeGrower {

    @Override
    protected @Nullable ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean bees) {
        return RATreeConfiguredFeatures.BANANA;
    }
}