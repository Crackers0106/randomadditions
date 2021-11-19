package net.crackers0106.randomadditions.block;

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
import net.crackers0106.randomadditions.RandomAdditions;

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
	public static final Block MOSSY_DEEPSLATE_BRICKS;
    public static final Block BANANA_LEAVES;
	public static final Block ROSE;
	public static final Block POTTED_ROSE;

    static {

	// RIP readability, at least it's compact

    	POLISHED_NETHERRACK = register("polished_netherrack", new Block(FabricBlockSettings.of(Material.STONE)
					.breakByTool(FabricToolTags.PICKAXES, 1)
					.requiresTool()
					.strength(0.4F)
					.sounds(BlockSoundGroup.NETHERRACK)),
				new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    	SLATED_NETHERRACK = register("slated_netherrack", new Block(FabricBlockSettings.of(Material.STONE)
					.breakByTool(FabricToolTags.PICKAXES, 1)
					.requiresTool().strength(0.6F)
					.sounds(BlockSoundGroup.NETHERRACK)),
				new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        CUT_STONE = register("cut_stone", new Block(FabricBlockSettings.of(Material.STONE)
					.strength(0.6F, 1.5F)
					.breakByTool(FabricToolTags.PICKAXES, 1)
					.requiresTool()),
				new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        POLISHED_STONE = register("polished_stone", new Block(FabricBlockSettings.of(Material.STONE)
					.strength(0.6F, 1.5F)
					.breakByTool(FabricToolTags.PICKAXES, 1)
					.requiresTool()),
				new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        MINI_STONE_BRICKS = register("mini_stone_bricks", new Block(FabricBlockSettings.of(Material.STONE)
					.strength(0.6F, 1.5F)
					.breakByTool(FabricToolTags.PICKAXES, 1)
					.requiresTool()),
				new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

		MOSSY_COBBLED_DEEPSLATE = register("mossy_cobbled_deepslate", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE)
					.strength(3.5F, 6.0F)),
				new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

		MOSSY_DEEPSLATE_BRICKS = register("mossy_deepslate_bricks", new Block(FabricBlockSettings.copyOf(MOSSY_COBBLED_DEEPSLATE)
					.sounds(BlockSoundGroup.DEEPSLATE_BRICKS)),
				new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	// Plants

        BANANA_LEAVES = register("banana_leaves", createLeavesBlock(BlockSoundGroup.GRASS), new Item.Settings().group(ItemGroup.DECORATIONS));

		ROSE = register("rose", new FlowerBlock(StatusEffects.NIGHT_VISION, 5, FabricBlockSettings.of(Material.PLANT)
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

		POLISHED_NETHERRACK_STAIRS = register("polished_netherrack_stairs", createStairsBlock(POLISHED_NETHERRACK), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
		CUT_STONE_STAIRS = register("cut_stone_stairs", createStairsBlock(CUT_STONE), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
		POLISHED_STONE_STAIRS = register("polished_stone_stairs", createStairsBlock(POLISHED_STONE), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
		MINI_STONE_BRICK_STAIRS = register("mini_stone_brick_stairs", createStairsBlock(MINI_STONE_BRICKS), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	}

	// static hell

	private static Block register(String id, Block block, Item.Settings settings) {
		return register(id, block, true, settings);
	}

	private static Block register(String id, Block block, boolean registerAsBlockItem, Item.Settings settings) {
    	Identifier trueId = RandomAdditions.locate(id);
    	Registry.register(Registry.BLOCK, trueId, block);
    	if (registerAsBlockItem) Registry.register(Registry.ITEM, trueId, new BlockItem(block, settings));
    	return block;
	}

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
