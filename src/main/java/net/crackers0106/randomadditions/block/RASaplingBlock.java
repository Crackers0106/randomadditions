package net.crackers0106.randomadditions.block;

import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class RASaplingBlock extends SaplingBlock {

    public RASaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
        super.grow(world, random, pos, state);
    }
}
