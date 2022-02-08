package net.crackers0106.randomadditions.block.behavior;

import net.crackers0106.randomadditions.block.RABlockTags;
import net.crackers0106.randomadditions.util.RADamageSource;
import net.crackers0106.randomadditions.util.RASoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class RASpike extends Block {
    public static final BooleanProperty EXTENDED = BooleanProperty.create("extended");

    public RASpike(Properties settings) {
        super(settings);
        registerDefaultState(getStateDefinition().any().setValue(EXTENDED, false));
    }

    @Override @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(EXTENDED, ctx.getLevel().hasNeighborSignal(ctx.getClickedPos()));
    }

    @Override
    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (!world.isClientSide) {

            if (extended(state) != (powered(world, pos) && isPassable(world, pos))) {
                world.playSound(null, pos, RASoundEvents.BLOCK_SPIKE_EXTEND, SoundSource.BLOCKS, 0.5F, 1.0F);
                world.setBlock(pos, state.cycle(EXTENDED), 2);
//                System.out.println("Spike Extended");

            } if (extended(state) && (!powered(world, pos) || !isPassable(world, pos))) {
                world.playSound(null, pos, RASoundEvents.BLOCK_SPIKE_RETRACT, SoundSource.BLOCKS, 0.5F, 1.0F);
                world.setBlockAndUpdate(pos, state.setValue(EXTENDED, Boolean.FALSE));
//                System.out.println("Spike Retracted");
            }
        }
    }

    public void stepOn(Level world, BlockPos pos, BlockState state, Entity entity) {
        if (state.getValue(EXTENDED) && entity instanceof LivingEntity) {
            entity.hurt(RADamageSource.SPIKES, 2.0F);
        }

        super.entityInside(state, world, pos, entity);
    }

    public Boolean extended(BlockState state) {
        return state.getValue(EXTENDED);
    }

    public Boolean isPassable(Level world, BlockPos pos) {
        return world.getBlockState(pos.above()).is(RABlockTags.SPIKE_PASSABLE);
    }

    public Boolean powered(Level world, BlockPos pos) {
        return world.hasNeighborSignal(pos);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateManager) {
        stateManager.add(EXTENDED);
    }
};