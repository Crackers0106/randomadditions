package net.crackers0106.randomadditions.block;

import net.crackers0106.randomadditions.RandomAdditions;
import net.crackers0106.randomadditions.block.behavior.GlowceliumBlock;
import net.crackers0106.randomadditions.block.behavior.RASpike;
import net.crackers0106.randomadditions.block.decorative.RASlabs;
import net.crackers0106.randomadditions.block.decorative.RAStairs;
import net.crackers0106.randomadditions.block.decorative.RAWalls;
import net.crackers0106.randomadditions.gen.configuredfeatures.RATreeConfiguredFeatures;
import net.crackers0106.randomadditions.gen.tree.sapling.BananaSaplingGenerator;
import net.crackers0106.randomadditions.item.RAItemGroup;
import net.crackers0106.randomadditions.util.RABlockSoundGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import static net.minecraft.world.level.block.Blocks.*;

public class RABlocks {

	public static final Block SLATED_NETHERRACK;
    public static final Block POLISHED_NETHERRACK;
	public static final Block POLISHED_NETHERRACK_STAIRS;
	public static final Block POLISHED_NETHERRACK_SLAB;
	public static final Block POLISHED_NETHERRACK_WALL;
    public static final Block CUT_STONE;
	public static final Block CUT_STONE_STAIRS;
	public static final Block CUT_STONE_SLAB;
	public static final Block CUT_STONE_WALL;
    public static final Block POLISHED_STONE;
	public static final Block POLISHED_STONE_STAIRS;
	public static final Block POLISHED_STONE_SLAB;
	public static final Block POLISHED_STONE_WALL;
    public static final Block MINI_STONE_BRICKS;
	public static final Block MINI_STONE_BRICK_STAIRS;
	public static final Block MINI_STONE_BRICK_SLAB;
	public static final Block MINI_STONE_BRICK_WALL;
	public static final Block MOSSY_COBBLED_DEEPSLATE;
	public static final Block MOSSY_COBBLED_DEEPSLATE_STAIRS;
	public static final Block MOSSY_COBBLED_DEEPSLATE_SLAB;
	public static final Block MOSSY_COBBLED_DEEPSLATE_WALL;
	public static final Block MOSSY_DEEPSLATE_BRICKS;
	public static final Block MOSSY_DEEPSLATE_BRICK_STAIRS;
	public static final Block MOSSY_DEEPSLATE_BRICK_SLAB;
	public static final Block MOSSY_DEEPSLATE_BRICK_WALL;
	public static final Block SPIKE;
    public static final Block BANANA_LEAVES;
	public static final Block BANANA_SAPLING;
	public static final Block POTTED_BANANA_SAPLING;
	public static final Block ROSE;
	public static final Block POTTED_ROSE;
	public static final Block GLOWSHROOM;
	public static final Block GLOWCELIUM;
	public static final Block GLOWSHROOM_BLOCK;
	public static final Block GLOWSHROOM_STEM;

    static {

		SLATED_NETHERRACK = registerWithItem("slated_netherrack", new Block(FabricBlockSettings.copyOf(NETHERRACK).requiresCorrectToolForDrops().strength(0.6F)), buildingBlock());

		POLISHED_NETHERRACK = registerWithItem("polished_netherrack", new Block(FabricBlockSettings.copyOf(NETHERRACK)), buildingBlock());
		POLISHED_NETHERRACK_STAIRS = registerWithItem("polished_netherrack_stairs", new RAStairs(NETHERRACK.defaultBlockState(), FabricBlockSettings.copyOf(NETHERRACK)), buildingBlock());
		POLISHED_NETHERRACK_SLAB = registerWithItem("polished_netherrack_slab", new RASlabs(NETHERRACK.defaultBlockState(), FabricBlockSettings.copyOf(NETHERRACK)), buildingBlock());
		POLISHED_NETHERRACK_WALL = registerWithItem("polished_netherrack_wall", new RAWalls(NETHERRACK.defaultBlockState(), FabricBlockSettings.copyOf(NETHERRACK)), buildingBlock());

		CUT_STONE = registerWithItem("cut_stone", new Block(FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		CUT_STONE_STAIRS = registerWithItem("cut_stone_stairs", new RAStairs(STONE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		CUT_STONE_SLAB = registerWithItem("cut_stone_slab", new RASlabs(COBBLED_DEEPSLATE.defaultBlockState(), FabricBlockSettings.copyOf(COBBLED_DEEPSLATE)), buildingBlock());
		CUT_STONE_WALL = registerWithItem("cut_stone_wall", new RAWalls(COBBLED_DEEPSLATE.defaultBlockState(), FabricBlockSettings.copyOf(COBBLED_DEEPSLATE)), buildingBlock());

        POLISHED_STONE = registerWithItem("polished_stone", new Block(FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		POLISHED_STONE_STAIRS = registerWithItem("polished_stone_stairs", new RAStairs(STONE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		POLISHED_STONE_SLAB = registerWithItem("polished_stone_slab", new RASlabs(STONE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		POLISHED_STONE_WALL = registerWithItem("polished_stone_wall", new RAWalls(STONE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());

		MINI_STONE_BRICKS = registerWithItem("mini_stone_bricks", new Block(FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		MINI_STONE_BRICK_STAIRS = registerWithItem("mini_stone_brick_stairs", new RAStairs(STONE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		MINI_STONE_BRICK_SLAB = registerWithItem("mini_stone_brick_slab", new RASlabs(STONE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		MINI_STONE_BRICK_WALL = registerWithItem("mini_stone_brick_wall", new RAWalls(STONE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());

		MOSSY_COBBLED_DEEPSLATE = registerWithItem("mossy_cobbled_deepslate", new Block(FabricBlockSettings.copyOf(COBBLED_DEEPSLATE)), buildingBlock());
		MOSSY_COBBLED_DEEPSLATE_STAIRS = registerWithItem("mossy_cobbled_deepslate_stairs", new RAStairs(COBBLED_DEEPSLATE.defaultBlockState(), FabricBlockSettings.copyOf(COBBLED_DEEPSLATE)), buildingBlock());
		MOSSY_COBBLED_DEEPSLATE_SLAB = registerWithItem("mossy_cobbled_deepslate_slab", new RASlabs(COBBLED_DEEPSLATE.defaultBlockState(), FabricBlockSettings.copyOf(COBBLED_DEEPSLATE)), buildingBlock());
		MOSSY_COBBLED_DEEPSLATE_WALL = registerWithItem("mossy_cobbled_deepslate_wall", new RAWalls(COBBLED_DEEPSLATE.defaultBlockState(), FabricBlockSettings.copyOf(COBBLED_DEEPSLATE)), buildingBlock());

		MOSSY_DEEPSLATE_BRICKS = registerWithItem("mossy_deepslate_bricks", new Block(FabricBlockSettings.copyOf(DEEPSLATE_BRICKS)), buildingBlock());
		MOSSY_DEEPSLATE_BRICK_STAIRS = registerWithItem("mossy_deepslate_brick_stairs", new RAStairs(DEEPSLATE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(DEEPSLATE_BRICKS)), buildingBlock());
		MOSSY_DEEPSLATE_BRICK_SLAB = registerWithItem("mossy_deepslate_brick_slab", new RASlabs(DEEPSLATE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(DEEPSLATE_BRICKS)), buildingBlock());
		MOSSY_DEEPSLATE_BRICK_WALL = registerWithItem("mossy_deepslate_brick_wall", new RAWalls(DEEPSLATE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(DEEPSLATE_BRICKS)), buildingBlock());

		SPIKE = registerWithItem("spike", new RASpike(FabricBlockSettings.of(Material.STONE)
				.strength(0.6F, 1.5F)
				.requiresCorrectToolForDrops()),
				buildingBlock());

		GLOWSHROOM = registerWithItem("glowshroom", new MushroomBlock(FabricBlockSettings.of(Material.PLANT)
					.noCollission()
					.randomTicks()
					.instabreak()
					.sound(SoundType.GRASS)
					.lightLevel(state -> 7)
					.emissiveRendering(RABlocks::always)
					.hasPostProcess(RABlocks::always),
				() -> RATreeConfiguredFeatures.HUGE_GLOWSHROOM),
				buildingBlock());

		GLOWCELIUM = registerWithItem("glowcelium", new GlowceliumBlock(FabricBlockSettings.of(Material.GRASS)
				.randomTicks()
				.strength(3.0F, 6.0F)
				.sound(RABlockSoundGroup.GLOWCELIUM)
				.lightLevel(state -> 4)
				.requiresCorrectToolForDrops()),
				buildingBlock());

		GLOWSHROOM_BLOCK = registerWithItem("glowshroom_block", new HugeMushroomBlock(FabricBlockSettings.of(Material.WOOD)
				.strength(0.2F)
				.sound(SoundType.WOOD)
				.lightLevel(state -> 4)
				.emissiveRendering(RABlocks::always)
				.hasPostProcess(RABlocks::always)),
				buildingBlock());

		GLOWSHROOM_STEM = registerWithItem("glowshroom_stem", new HugeMushroomBlock(FabricBlockSettings.copyOf(GLOWSHROOM_BLOCK)
				.emissiveRendering(RABlocks::always)
				.hasPostProcess(RABlocks::always)),
				buildingBlock());

	// Plants

        BANANA_LEAVES = registerWithItem("banana_leaves", createLeavesBlock(), buildingBlock());
		BANANA_SAPLING = registerWithItem("banana_sapling", new RASaplingBlock(new BananaSaplingGenerator(), BlockBehaviour.Properties.copy(OAK_SAPLING)), buildingBlock());
		POTTED_BANANA_SAPLING = register("potted_banana_sapling", createPottedBlock(BANANA_SAPLING));

		ROSE = registerWithItem("rose", new FlowerBlock(MobEffects.NIGHT_VISION, 5, BlockBehaviour.Properties.of(Material.PLANT)
				.noCollission()
				.instabreak()
				.sound(SoundType.GRASS)),
				buildingBlock());

		POTTED_ROSE = register("potted_rose", createPottedBlock(ROSE));
	}

	private static Item.Properties buildingBlock() {
		return new FabricItemSettings().tab(RAItemGroup.RANDOM_ADDITIONS);
	}

	private static Block register(String id, Block block) {
		return Registry.register(Registry.BLOCK, RandomAdditions.locate(id), block);
	}

	private static Block registerWithItem(String id, Block block, Item.Properties settings) {
    	ResourceLocation trueId = RandomAdditions.locate(id);
    	Registry.register(Registry.ITEM, trueId, new BlockItem(block, settings));
    	return Registry.register(Registry.BLOCK, trueId, block);
	}

	private static Boolean canSpawnOnLeaves(BlockState state, BlockGetter world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}

	private static LeavesBlock createLeavesBlock() {
		return new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(RABlocks::canSpawnOnLeaves).isSuffocating(RABlocks::never).isViewBlocking(RABlocks::never));
	}

	private static FlowerPotBlock createPottedBlock(Block sourceBlock) {
		return new FlowerPotBlock(sourceBlock, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion());
	}

	public static boolean never(BlockState blockState, BlockGetter blockView, BlockPos blockPos) {
    	return false;
	}
		public static boolean always(BlockState blockState, BlockGetter blockView, BlockPos blockPos) {
			return true;
	}

public static void init() {

	}
}
