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
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import static net.minecraft.block.Blocks.*;

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

		SLATED_NETHERRACK = registerWithItem("slated_netherrack", new Block(FabricBlockSettings.copyOf(NETHERRACK).requiresTool().strength(0.6F)), buildingBlock());

		POLISHED_NETHERRACK = registerWithItem("polished_netherrack", new Block(FabricBlockSettings.copyOf(NETHERRACK)), buildingBlock());
		POLISHED_NETHERRACK_STAIRS = registerWithItem("polished_netherrack_stairs", new RAStairs(NETHERRACK.getDefaultState(), Block.Settings.copy(NETHERRACK)), buildingBlock());
		POLISHED_NETHERRACK_SLAB = registerWithItem("polished_netherrack_slab", new RASlabs(NETHERRACK.getDefaultState(), Block.Settings.copy(NETHERRACK)), buildingBlock());
		POLISHED_NETHERRACK_WALL = registerWithItem("polished_netherrack_wall", new RAWalls(NETHERRACK.getDefaultState(), Block.Settings.copy(NETHERRACK)), buildingBlock());

		CUT_STONE = registerWithItem("cut_stone", new Block(FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		CUT_STONE_STAIRS = registerWithItem("cut_stone_stairs", new RAStairs(STONE_BRICKS.getDefaultState(), Block.Settings.copy(STONE_BRICKS)), buildingBlock());
		CUT_STONE_SLAB = registerWithItem("cut_stone_slab", new RASlabs(COBBLED_DEEPSLATE.getDefaultState(), Block.Settings.copy(COBBLED_DEEPSLATE)), buildingBlock());
		CUT_STONE_WALL = registerWithItem("cut_stone_wall", new RAWalls(COBBLED_DEEPSLATE.getDefaultState(), Block.Settings.copy(COBBLED_DEEPSLATE)), buildingBlock());

        POLISHED_STONE = registerWithItem("polished_stone", new Block(FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		POLISHED_STONE_STAIRS = registerWithItem("polished_stone_stairs", new RAStairs(STONE_BRICKS.getDefaultState(), Block.Settings.copy(STONE_BRICKS)), buildingBlock());
		POLISHED_STONE_SLAB = registerWithItem("polished_stone_slab", new RASlabs(STONE_BRICKS.getDefaultState(), Block.Settings.copy(STONE_BRICKS)), buildingBlock());
		POLISHED_STONE_WALL = registerWithItem("polished_stone_wall", new RAWalls(STONE_BRICKS.getDefaultState(), Block.Settings.copy(STONE_BRICKS)), buildingBlock());

		MINI_STONE_BRICKS = registerWithItem("mini_stone_bricks", new Block(FabricBlockSettings.copyOf(STONE_BRICKS)), buildingBlock());
		MINI_STONE_BRICK_STAIRS = registerWithItem("mini_stone_brick_stairs", new RAStairs(STONE_BRICKS.getDefaultState(), Block.Settings.copy(STONE_BRICKS)), buildingBlock());
		MINI_STONE_BRICK_SLAB = registerWithItem("mini_stone_brick_slab", new RASlabs(STONE_BRICKS.getDefaultState(), Block.Settings.copy(STONE_BRICKS)), buildingBlock());
		MINI_STONE_BRICK_WALL = registerWithItem("mini_stone_brick_wall", new RAWalls(STONE_BRICKS.getDefaultState(), Block.Settings.copy(STONE_BRICKS)), buildingBlock());

		MOSSY_COBBLED_DEEPSLATE = registerWithItem("mossy_cobbled_deepslate", new Block(Block.Settings.copy(COBBLED_DEEPSLATE)), buildingBlock());
		MOSSY_COBBLED_DEEPSLATE_STAIRS = registerWithItem("mossy_cobbled_deepslate_stairs", new RAStairs(COBBLED_DEEPSLATE.getDefaultState(), Block.Settings.copy(COBBLED_DEEPSLATE)), buildingBlock());
		MOSSY_COBBLED_DEEPSLATE_SLAB = registerWithItem("mossy_cobbled_deepslate_slab", new RASlabs(COBBLED_DEEPSLATE.getDefaultState(), Block.Settings.copy(COBBLED_DEEPSLATE)), buildingBlock());
		MOSSY_COBBLED_DEEPSLATE_WALL = registerWithItem("mossy_cobbled_deepslate_wall", new RAWalls(COBBLED_DEEPSLATE.getDefaultState(), Block.Settings.copy(COBBLED_DEEPSLATE)), buildingBlock());

		MOSSY_DEEPSLATE_BRICKS = registerWithItem("mossy_deepslate_bricks", new Block(FabricBlockSettings.copyOf(DEEPSLATE_BRICKS)), buildingBlock());
		MOSSY_DEEPSLATE_BRICK_STAIRS = registerWithItem("mossy_deepslate_brick_stairs", new RAStairs(DEEPSLATE_BRICKS.getDefaultState(), Block.Settings.copy(DEEPSLATE_BRICKS)), buildingBlock());
		MOSSY_DEEPSLATE_BRICK_SLAB = registerWithItem("mossy_deepslate_brick_slab", new RASlabs(DEEPSLATE_BRICKS.getDefaultState(), Block.Settings.copy(DEEPSLATE_BRICKS)), buildingBlock());
		MOSSY_DEEPSLATE_BRICK_WALL = registerWithItem("mossy_deepslate_brick_wall", new RAWalls(DEEPSLATE_BRICKS.getDefaultState(), Block.Settings.copy(DEEPSLATE_BRICKS)), buildingBlock());

		SPIKE = registerWithItem("spike", new RASpike(FabricBlockSettings.of(Material.STONE)
				.strength(0.6F, 1.5F)
				.requiresTool()),
				buildingBlock());

		GLOWSHROOM = registerWithItem("glowshroom", new MushroomPlantBlock(FabricBlockSettings.of(Material.PLANT)
					.noCollision()
					.ticksRandomly()
					.breakInstantly()
					.sounds(BlockSoundGroup.GRASS)
					.luminance(state -> 7)
					.emissiveLighting(RABlocks::always)
					.postProcess(RABlocks::always),
				() -> RATreeConfiguredFeatures.HUGE_GLOWSHROOM),
				buildingBlock());

		GLOWCELIUM = registerWithItem("glowcelium", new GlowceliumBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC)
				.ticksRandomly()
				.strength(3.0F, 6.0F)
				.sounds(RABlockSoundGroup.GLOWCELIUM)
				.luminance(state -> 4)
				.requiresTool()),
				buildingBlock());

		GLOWSHROOM_BLOCK = registerWithItem("glowshroom_block", new MushroomBlock(FabricBlockSettings.of(Material.WOOD)
				.strength(0.2F)
				.sounds(BlockSoundGroup.WOOD)
				.luminance(state -> 4)
				.emissiveLighting(RABlocks::always)
				.postProcess(RABlocks::always)),
				buildingBlock());

		GLOWSHROOM_STEM = registerWithItem("glowshroom_stem", new MushroomBlock(FabricBlockSettings.copyOf(GLOWSHROOM_BLOCK)
				.emissiveLighting(RABlocks::always)
				.postProcess(RABlocks::always)),
				buildingBlock());

	// Plants

        BANANA_LEAVES = registerWithItem("banana_leaves", createLeavesBlock(), buildingBlock());
		BANANA_SAPLING = registerWithItem("banana_sapling", new RASaplingBlock(new BananaSaplingGenerator(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), buildingBlock());
		POTTED_BANANA_SAPLING = register("potted_banana_sapling", createPottedBlock(BANANA_SAPLING));

		ROSE = registerWithItem("rose", new FlowerBlock(StatusEffects.NIGHT_VISION, 5, AbstractBlock.Settings.of(Material.PLANT)
				.noCollision()
				.breakInstantly()
				.sounds(BlockSoundGroup.GRASS)),
				buildingBlock());

		POTTED_ROSE = register("potted_rose", createPottedBlock(ROSE));
	}

	private static Item.Settings buildingBlock() {
		return new FabricItemSettings().group(RAItemGroup.RANDOM_ADDITIONS);
	}

	private static Block register(String id, Block block) {
		return Registry.register(Registry.BLOCK, RandomAdditions.locate(id), block);
	}

	private static Block registerWithItem(String id, Block block, Item.Settings settings) {
    	Identifier trueId = RandomAdditions.locate(id);
    	Registry.register(Registry.ITEM, trueId, new BlockItem(block, settings));
    	return Registry.register(Registry.BLOCK, trueId, block);
	}

	private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}

	private static LeavesBlock createLeavesBlock() {
		return new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(RABlocks::canSpawnOnLeaves).suffocates(RABlocks::never).blockVision(RABlocks::never));
	}

	private static FlowerPotBlock createPottedBlock(Block sourceBlock) {
		return new FlowerPotBlock(sourceBlock, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque());
	}

	public static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos) {
    	return false;
	}
		public static boolean always(BlockState blockState, BlockView blockView, BlockPos blockPos) {
			return true;
	}

public static void init() {

	}
}
