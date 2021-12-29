package net.crackers0106.randomadditions.block;

import net.crackers0106.randomadditions.util.RADamageSource;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RASpike extends Block {
    public static final BooleanProperty EXTENDED = BooleanProperty.of("extended");

    public RASpike(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(EXTENDED, false));
    }

    @Override @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(EXTENDED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (!world.isClient) {

            if (extended(state) != (powered(world, pos) && isPassable(world, pos))) {
                world.playSound(null, pos, SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 1.9F, 1.5F);
                world.setBlockState(pos, state.cycle(EXTENDED), 2);

            } else if (extended(state) && !powered(world, pos)) {
                world.playSound(null, pos, SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 1.9F, 1.5F);
                world.setBlockState(pos, state.with(EXTENDED, Boolean.FALSE));
            }
        }
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (state.get(EXTENDED) && entity instanceof LivingEntity) {
            entity.damage(RADamageSource.SPIKES, 2.0F);
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    public Boolean extended(BlockState state) {
        return state.get(EXTENDED);
    }

    public Boolean isPassable(World world, BlockPos pos) {
        return world.getBlockState(pos.up()).isIn(RABlockTags.SPIKE_PASSABLE);
    }

    public Boolean powered(World world, BlockPos pos) {
        return world.isReceivingRedstonePower(pos);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(EXTENDED);
    }
};