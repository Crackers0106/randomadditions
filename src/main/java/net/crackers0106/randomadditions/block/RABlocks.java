package net.crackers0106.randomadditions.block;

import net.crackers0106.randomadditions.RandomAdditions;
import net.crackers0106.randomadditions.gen.tree.sapling.BananaSaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.feature.ConfiguredFeatures;

public class RABlocks {

	
    public static final Block POLISHED_NETHERRACK;
	public static final Block POLISHED_NETHERRACK_STAIRS;
    public static final Block SLATED_NETHERRACK;
    public static final Block CUT_STONE;
	public static final Block CUT_STONE_STAIRS;
    public static final Block POLISHED_STONE;
	public static final Block POLISHED_STONE_STAIRS;
    public static final Block MINI_STONE_BRICKS;
	public static final Block MINI_STONE_BRICK_STAIRS;
	public static final Block MOSSY_COBBLED_DEEPSLATE;
	public static final Block MOSSY_COBBLED_DEEPSLATE_STAIRS;
	public static final Block MOSSY_DEEPSLATE_BRICKS;
	public static final Block MOSSY_DEEPSLATE_BRICK_STAIRS;
	public static final Block SPIKE;
    public static final Block BANANA_LEAVES;
	public static final Block BANANA_SAPLING;
	public static final Block ROSE;
	public static final Block POTTED_ROSE;
	public static final Block GLOWSHROOM;
	public static final Block GLOWCELIUM;

    static {

    	POLISHED_NETHERRACK = registerWithItem("polished_netherrack", new Block(FabricBlockSettings.of(Material.STONE)
				.breakByTool(FabricToolTags.PICKAXES, 1)
				.requiresTool()
				.strength(0.4F)
				.sounds(BlockSoundGroup.NETHERRACK)),
			new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    	SLATED_NETHERRACK = registerWithItem("slated_netherrack", new Block(FabricBlockSettings.of(Material.STONE)
				.breakByTool(FabricToolTags.PICKAXES, 1)
				.requiresTool()
				.strength(0.6F)
				.sounds(BlockSoundGroup.NETHERRACK)),
			new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        CUT_STONE = registerWithItem("cut_stone", new Block(FabricBlockSettings.of(Material.STONE)
				.strength(0.6F, 1.5F)
				.breakByTool(FabricToolTags.PICKAXES, 1)
				.requiresTool()),
			new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        POLISHED_STONE = registerWithItem("polished_stone", new Block(FabricBlockSettings.of(Material.STONE)
				.strength(0.6F, 1.5F)
				.breakByTool(FabricToolTags.PICKAXES, 1)
				.requiresTool()),
			new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        MINI_STONE_BRICKS = registerWithItem("mini_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE)
				.strength(0.6F, 1.5F)
				.breakByTool(FabricToolTags.PICKAXES, 1)
				.requiresTool()),
			new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

		MOSSY_COBBLED_DEEPSLATE = registerWithItem("mossy_cobbled_deepslate", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
				.strength(3.5F, 6.0F)),
			new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

		MOSSY_DEEPSLATE_BRICKS = registerWithItem("mossy_deepslate_bricks", new Block(FabricBlockSettings.copyOf(MOSSY_COBBLED_DEEPSLATE)
				.sounds(BlockSoundGroup.DEEPSLATE_BRICKS)),
			new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

		SPIKE = registerWithItem("spike", new RASpike(FabricBlockSettings.of(Material.STONE)
				.strength(0.6F, 1.5F)
				.breakByTool(FabricToolTags.PICKAXES, 1)
				.requiresTool()),
			new Item.Settings().group(ItemGroup.REDSTONE));

		GLOWSHROOM = registerWithItem("glowshroom", new MushroomPlantBlock(FabricBlockSettings.of(Material.PLANT)
					.noCollision()
					.ticksRandomly()
					.breakInstantly()
					.sounds(BlockSoundGroup.GRASS)
					.luminance(state -> 7)
					.emissiveLighting(RABlocks::always)
					.postProcess(RABlocks::always),
				() -> ConfiguredFeatures.HUGE_BROWN_MUSHROOM),
			new Item.Settings().group(ItemGroup.DECORATIONS));

		GLOWCELIUM = registerWithItem("glowcelium", new MyceliumBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC)
				.ticksRandomly()
				.strength(3.0F, 6.0F)
				.sounds(BlockSoundGroup.NYLIUM)
//				.luminance(state -> 2)
				.requiresTool()),
			new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));



	// Plants

        BANANA_LEAVES = registerWithItem("banana_leaves", createLeavesBlock(BlockSoundGroup.GRASS), new Item.Settings().group(ItemGroup.DECORATIONS));

		BANANA_SAPLING = registerWithItem("banana_sapling", new RASaplingBlock(new BananaSaplingGenerator(), AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)), new Item.Settings().group(ItemGroup.DECORATIONS));

		ROSE = registerWithItem("rose", new FlowerBlock(StatusEffects.NIGHT_VISION, 5, FabricBlockSettings.of(Material.PLANT)
				.noCollision()
				.nonOpaque()
				.suffocates(RABlocks::never)
				.blockVision(RABlocks::never)
				.breakInstantly()
				.sounds(BlockSoundGroup.GRASS)),
			new Item.Settings().group(ItemGroup.DECORATIONS));

		POTTED_ROSE = register("potted_rose", new FlowerPotBlock(ROSE, FabricBlockSettings.of(Material.DECORATION)
				.breakInstantly()
				.nonOpaque()),
			new Item.Settings());

		// Stairs

		POLISHED_NETHERRACK_STAIRS = registerWithItem("polished_netherrack_stairs", createStairsBlock(POLISHED_NETHERRACK), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
		CUT_STONE_STAIRS = registerWithItem("cut_stone_stairs", createStairsBlock(CUT_STONE), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
		POLISHED_STONE_STAIRS = registerWithItem("polished_stone_stairs", createStairsBlock(POLISHED_STONE), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
		MINI_STONE_BRICK_STAIRS = registerWithItem("mini_stone_brick_stairs", createStairsBlock(MINI_STONE_BRICKS), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
		MOSSY_COBBLED_DEEPSLATE_STAIRS = registerWithItem("mossy_cobbled_deepslate_stairs", createStairsBlock(MOSSY_COBBLED_DEEPSLATE), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
		MOSSY_DEEPSLATE_BRICK_STAIRS = registerWithItem("mossy_deepslate_brick_stairs", createStairsBlock(MOSSY_DEEPSLATE_BRICKS), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	}

	// static hell

	private static Block register(String id, Block block, Item.Settings settings) {
		return registerWithItem(id, block, false, settings);
	}

	private static Block registerWithItem(String id, Block block, Item.Settings settings) {
		return registerWithItem(id, block, true, settings);
	}

	private static Block registerWithItem(String id, Block block, boolean registerAsBlockItem, Item.Settings settings) {
    	Identifier trueId = RandomAdditions.locate(id);
    	Registry.register(Registry.BLOCK, trueId, block);
    	if (registerAsBlockItem) Registry.register(Registry.ITEM, trueId, new BlockItem(block, settings));
    	return block;
	}

	// Why are both these methods named the same??
	public static Block createStairsBlock(String id, Block base) {
		return new RAStairs(base.getDefaultState(), FabricBlockSettings.copy(base));
	}

	public static Block createStairsBlock(Block base) {
		return createStairsBlock(Registry.BLOCK.getId(base).getPath(), base);
	}

	private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}

	private static LeavesBlock createLeavesBlock(BlockSoundGroup soundGroup) {
		return new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(soundGroup).nonOpaque().allowsSpawning(RABlocks::canSpawnOnLeaves).suffocates(RABlocks::never).blockVision(RABlocks::never));
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
