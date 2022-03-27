package net.crackers0106.randomadditions.worldgen.features;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.crackers0106.randomadditions.block.RASculkBlocks;
import net.crackers0106.randomadditions.block.behavior.sculk.SculkVein;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.GlowLichenFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SculkVeinFeature extends Feature<GlowLichenFeatureConfig> {
    public SculkVeinFeature(Codec<GlowLichenFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<GlowLichenFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        GlowLichenFeatureConfig sculkVeinFeatureConfig = context.getConfig();
        if (!isAirOrWater(structureWorldAccess.getBlockState(blockPos))) {
            return false;
        } else {
            List<Direction> list = shuffleDirections(sculkVeinFeatureConfig, random);
            if (generate(structureWorldAccess, blockPos, structureWorldAccess.getBlockState(blockPos), sculkVeinFeatureConfig, random, list)) {
                return true;
            } else {
                BlockPos.Mutable mutable = blockPos.mutableCopy();

                for(Direction direction : list) {
                    mutable.set(blockPos);
                    List<Direction> list2 = shuffleDirections(sculkVeinFeatureConfig, random, direction.getOpposite());

                    for(int i = 0; i < sculkVeinFeatureConfig.searchRange; ++i) {
                        mutable.set(blockPos, direction);
                        BlockState blockState = structureWorldAccess.getBlockState(mutable);
                        if (!isAirOrWater(blockState) && !blockState.isOf(RASculkBlocks.SCULK_VEIN)) {
                            break;
                        }

                        if (generate(structureWorldAccess, mutable, blockState, sculkVeinFeatureConfig, random, list2)) {
                            return true;
                        }
                    }
                }

                return false;
            }
        }
    }

    public static boolean generate(
            StructureWorldAccess world, BlockPos pos, BlockState state, GlowLichenFeatureConfig config, Random random, List<Direction> directions
    ) {
        BlockPos.Mutable mutable = pos.mutableCopy();

        for(Direction direction : directions) {
            BlockState blockState = world.getBlockState(mutable.set(pos, direction));
            if (config.canPlaceOn.contains(blockState.getBlock())) {
                SculkVein sculkVein = (SculkVein) RASculkBlocks.SCULK_VEIN;
                BlockState blockState2 = sculkVein.withDirection(state, world, pos, direction);
                if (blockState2 == null) {
                    return false;
                }

                world.setBlockState(pos, blockState2, Block.NOTIFY_ALL);
                world.getChunk(pos).markBlockForPostProcessing(pos);
                if (random.nextFloat() < config.spreadChance) {
                    sculkVein.trySpreadRandomly(blockState2, world, pos, direction, random, true);
                }

                return true;
            }
        }

        return false;
    }

    public static List<Direction> shuffleDirections(GlowLichenFeatureConfig config, Random random) {
        List<Direction> list = Lists.<Direction>newArrayList(config.directions);
        Collections.shuffle(list, random);
        return list;
    }

    public static List<Direction> shuffleDirections(GlowLichenFeatureConfig config, Random random, Direction excluded) {
        List<Direction> list = (List)config.directions.stream().filter(direction -> direction != excluded).collect(Collectors.toList());
        Collections.shuffle(list, random);
        return list;
    }

    private static boolean isAirOrWater(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER);
    }
}
