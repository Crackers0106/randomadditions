package net.crackers0106.randomadditions.block.behavior;

import net.crackers0106.randomadditions.block.RABlockTags;
import net.crackers0106.randomadditions.util.RADamageSource;
import net.crackers0106.randomadditions.util.RASoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
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
                world.playSound(null, pos, RASoundEvents.BLOCK_SPIKE_EXTEND, SoundCategory.BLOCKS, 0.5F, 1.0F);
                world.setBlockState(pos, state.cycle(EXTENDED), 2);
//                System.out.println("Spike Extended");

            } if (extended(state) && (!powered(world, pos) || !isPassable(world, pos))) {
                world.playSound(null, pos, RASoundEvents.BLOCK_SPIKE_RETRACT, SoundCategory.BLOCKS, 0.5F, 1.0F);
                world.setBlockState(pos, state.with(EXTENDED, Boolean.FALSE));
//                System.out.println("Spike Retracted");
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