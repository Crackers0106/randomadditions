package net.crackers0106.randomadditions.block.behavior;

import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.gen.configuredfeatures.RAUndergroundConfiguredFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.lighting.LayerLightEngine;
import java.util.Random;

public class GlowceliumBlock extends NyliumBlock {
    public GlowceliumBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    private static boolean canBeNylium(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.above();
        BlockState blockState = world.getBlockState(blockPos);
        int i = LayerLightEngine.getLightBlockInto(world, state, pos, blockState, blockPos, Direction.UP, blockState.getLightBlock(world, blockPos));
        return i < world.getMaxLightLevel();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (!canBeNylium(state, world, pos)) {
            world.setBlockAndUpdate(pos, Blocks.DEEPSLATE.defaultBlockState());
        }

    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos);
        BlockPos blockPos = pos.above();
        ChunkGenerator chunkGenerator = world.getChunkSource().getGenerator();
        if (blockState.is(RABlocks.GLOWCELIUM)) {
            RAUndergroundConfiguredFeatures.GLOWSHROOM_VEGETATION.place(world, chunkGenerator, random, blockPos);
        }
    }
}