package net.crackers0106.randomadditions.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class RASaplingBlock extends SaplingBlock {

    public RASaplingBlock(AbstractTreeGrower generator, Properties settings) {
        super(generator, settings);
    }

    @Override
    public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
        world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        super.performBonemeal(world, random, pos, state);
    }
}
