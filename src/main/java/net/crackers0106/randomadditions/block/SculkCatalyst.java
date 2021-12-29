package net.crackers0106.randomadditions.block;

import net.crackers0106.randomadditions.gen.RAFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SculkCatalyst extends Block {
	   public static final BooleanProperty BLOOMING = BooleanProperty.of("blooming");

	   public SculkCatalyst(Settings settings) {
	      super(settings);
	      setDefaultState(getStateManager().getDefaultState().with(BLOOMING, false));
	   }
	   
	   @Override @Nullable
	   public BlockState getPlacementState(ItemPlacementContext ctx) {
	      return this.getDefaultState().with(BLOOMING, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
	   }

	   @Override
	   public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
	      if (!world.isClient) {
	         boolean bl = state.get(BLOOMING);
	         if (bl != world.isReceivingRedstonePower(pos)) {
	            if (bl) {
	               world.getBlockTickScheduler().schedule(pos, this, 20);
	            } else {
	               world.setBlockState(pos, state.cycle(BLOOMING), 2);

	            }
	         }

	      }
	   }
	   
	   @Override
	   public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
	      if (state.get(BLOOMING) && !world.isReceivingRedstonePower(pos)) {
	         world.setBlockState(pos, state.cycle(BLOOMING), 2);
			  Feature.VEGETATION_PATCH
				.generate(new FeatureContext<>(world, world.getChunkManager().getChunkGenerator(), random, pos.up(), RAFeatures.SCULK_PATCH.getConfig()));
	      }
	   }
	   
	   @Override
	    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
	        stateManager.add(BLOOMING);
	    }
}