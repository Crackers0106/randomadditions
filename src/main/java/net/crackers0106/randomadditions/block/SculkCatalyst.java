// Modified from FoundationGames' Sculk Concept mod: https://github.com/FoundationGames/SculkConcept/blob/master/src/main/java/io/github/foundationgames/sculkconcept/block/SculkSourceBlock.java
package net.crackers0106.randomadditions.block;

import com.google.common.collect.Lists;
import net.crackers0106.randomadditions.block.RABlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Random;

public class SculkCatalyst extends Block {
      public static final BooleanProperty BLOOMING = BooleanProperty.of("blooming");
}
    public SculkCatalyst(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(BLOOMING, false));
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }
// TODO: Add Blooming block state
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        world.setBlockState(pos, state.with(BLOOMING, true));
      // TODO: Change to check for any type of natural stone block
        if(!world.getBlockState(pos.down()).isOf(Blocks.DEEPSLATE) && !world.getBlockState(pos.down()).isOf(RABlocks.SCULK) ) return;
        if(!world.getBlockState(pos.down()).isOf(RABlocks.SCULK)) {
            world.setBlockState(pos.down(), RABlocks.SCULK.getDefaultState());
            return world.setBlockState(pos, state.with(BLOOMING, false));
        }
        BlockPos.Mutable mpos = new BlockPos.Mutable();
        mpos.set(pos);
        mpos.set(mpos.add(random.nextInt(12) - 6, -1, random.nextInt(12) - 6));
        while(mpos.toImmutable().equals(pos.down())) {
            mpos.set(mpos.add(random.nextInt(12) - 6, -1, random.nextInt(12) - 6));
        }
        mpos.set(mpos.down(4));
        int i = 0;
        while(!world.getBlockState(mpos).isAir() && !world.getBlockState(mpos).isOf(RABlocks.SCULK_VEIN) && i < 8) {
            mpos.set(mpos.up());
            i++;
        }
        if(!world.getBlockState(mpos).isAir() && !world.getBlockState(mpos).isOf(RABlocks.SCULK_VEIN)) return;
        if(world.getBlockState(mpos).isOf(RABlocks.SCULK_VEIN)) {
            mpos.set(mpos.down());
            world.setBlockState(mpos, RABlocks.SCULK.getDefaultState());
            world.setBlockState(mpos.up(), Blocks.AIR.getDefaultState());
            return;
        }
        if(world.getBlockState(mpos).isAir()) {
            mpos.set(mpos.down());
            if(
                world.getBlockState(mpos.north()).isOf(RABlocks.SCULK) ||
                world.getBlockState(mpos.south()).isOf(RABlocks.SCULK) ||
                world.getBlockState(mpos.east()).isOf(RABlocks.SCULK) ||
                world.getBlockState(mpos.west()).isOf(RABlocks.SCULK)
            ) {
                if(world.getBlockState(mpos).isOf(RABlocks.SCULK)) return;
                world.setBlockState(mpos.up(), RABlocks.SCULK_VEIN.getDefaultState());
            }
        }
    }
}
