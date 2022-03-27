package net.crackers0106.randomadditions.worldgen.features;

import com.mojang.serialization.Codec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

public class SculkPatchFeature extends Feature<SculkPatchFeatureConfig> {
    public SculkPatchFeature(Codec<SculkPatchFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<SculkPatchFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        SculkPatchFeatureConfig sculkPatchFeatureConfig = context.getConfig();
        Random random = context.getRandom();
        BlockPos blockPos = context.getOrigin();
        Predicate<BlockState> predicate = getReplaceablePredicate(sculkPatchFeatureConfig);
        int i = sculkPatchFeatureConfig.horizontalRadius.get(random) + 1;
        int j = sculkPatchFeatureConfig.horizontalRadius.get(random) + 1;
        Set<BlockPos> set = this.placeGroundAndGetPositions(structureWorldAccess, sculkPatchFeatureConfig, random, blockPos, predicate, i, j);
        this.generateVeins(context, structureWorldAccess, sculkPatchFeatureConfig, random, set, i, j);
        return !set.isEmpty();
    }

    protected Set<BlockPos> placeGroundAndGetPositions(
            StructureWorldAccess world,
            SculkPatchFeatureConfig config,
            Random random,
            BlockPos pos,
            Predicate<BlockState> replaceable,
            int radiusX,
            int radiusZ
    ) {
        BlockPos.Mutable mutable = pos.mutableCopy();
        BlockPos.Mutable mutable2 = mutable.mutableCopy();
        Direction direction = config.surface.getDirection();
        Direction direction2 = direction.getOpposite();
        Set<BlockPos> set = new HashSet();

        for(int i = -radiusX; i <= radiusX; ++i) {
            boolean bl = i == -radiusX || i == radiusX;

            for(int j = -radiusZ; j <= radiusZ; ++j) {
                boolean bl2 = j == -radiusZ || j == radiusZ;
                boolean bl3 = bl || bl2;
                boolean bl4 = bl && bl2;
                boolean bl5 = bl3 && !bl4;
                if (!bl4 && (!bl5 || config.growthChance != 0.0F && !(random.nextFloat() > config.growthChance))) {
                    mutable.set(pos, i, 0, j);

                    for(int k = 0; world.testBlockState(mutable, AbstractBlock.AbstractBlockState::isAir) && k < config.verticalRange; ++k) {
                        mutable.move(direction);
                    }

                    for(int var25 = 0; world.testBlockState(mutable, state -> !state.isAir()) && var25 < config.verticalRange; ++var25) {
                        mutable.move(direction2);
                    }

                    mutable2.set(mutable, config.surface.getDirection());
                    BlockState blockState = world.getBlockState(mutable2);
                    if (world.isAir(mutable) && blockState.isSideSolidFullSquare(world, mutable2, config.surface.getDirection().getOpposite())) {
                        int l = config.depth.get(random)
                                + (config.growthChance > 0.0F && random.nextFloat() < config.growthChance ? 1 : 0);
                        BlockPos blockPos = mutable2.toImmutable();
                        boolean bl6 = this.placeGround(world, config, replaceable, random, mutable2, l);
                        if (bl6) {
                            set.add(blockPos);
                        }
                    }
                }
            }
        }

        return set;
    }

    protected void generateVeins(
            FeatureContext<SculkPatchFeatureConfig> context,
            StructureWorldAccess world,
            SculkPatchFeatureConfig config,
            Random random,
            Set<BlockPos> positions,
            int radiusX,
            int radiusZ
    ) {
        for(BlockPos blockPos : positions) {
            if (config.growthChance > 0.0F && random.nextFloat() < config.growthChance) {
                this.generateVeinsFeature(world, config, context.getGenerator(), random, blockPos);
            }
        }
    }

    protected boolean generateVeinsFeature(
            StructureWorldAccess world, SculkPatchFeatureConfig config, ChunkGenerator generator, Random random, BlockPos pos
    ) {
        return ((PlacedFeature)config.sculkVeinFeature.get())
                .generate(world, generator, random, pos.offset(config.surface.getDirection().getOpposite()));
    }

    protected boolean placeGround(
            StructureWorldAccess world, SculkPatchFeatureConfig config, Predicate<BlockState> replaceable, Random random, BlockPos.Mutable pos, int depth
    ) {
        for(int i = 0; i < depth; ++i) {
            BlockState blockState = config.groundState.getBlockState(random, pos);
            BlockState blockState2 = world.getBlockState(pos);
            if (!blockState.isOf(blockState2.getBlock())) {
                if (!replaceable.test(blockState2)) {
                    return i != 0;
                }

                world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
                pos.move(config.surface.getDirection());
            }
        }

        return true;
    }

    private static Predicate<BlockState> getReplaceablePredicate(SculkPatchFeatureConfig config) {
        Tag<Block> tag = BlockTags.getTagGroup().getTag(config.replaceable);
        return tag == null ? state -> true : state -> state.isIn(tag);
    }
}
