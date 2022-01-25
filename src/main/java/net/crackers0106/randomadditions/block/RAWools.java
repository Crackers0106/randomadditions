package net.crackers0106.randomadditions.block;

import net.crackers0106.randomadditions.RandomAdditions;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RAWools {


    public static final Block BRIGHT_RED;
    public static final Block BRIGHT_ORANGE;
    public static final Block BRIGHT_YELLOW;
    public static final Block CHARTREUSE;
    public static final Block BRIGHT_LIME;
    public static final Block SPRING_GREEN;
    public static final Block BRIGHT_CYAN;
    public static final Block CAPRI;
    public static final Block ULTRAMARINE;
    public static final Block VIOLET;
    public static final Block BRIGHT_PURPLE;
    public static final Block MAGENTA;
    public static final Block ROSE;

    static {

        BRIGHT_RED = register("bright_red_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        BRIGHT_ORANGE = register("bright_orange_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        BRIGHT_YELLOW = register("bright_yellow_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        CHARTREUSE = register("chartreuse_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        BRIGHT_LIME = register("bright_lime_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        SPRING_GREEN = register("spring_green_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        BRIGHT_CYAN = register("bright_cyan_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        CAPRI = register("capri_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        ULTRAMARINE = register("ultramarine_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        VIOLET = register("violet_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        BRIGHT_PURPLE = register("bright_purple_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        MAGENTA = register("magenta_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

        ROSE = register("rose_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sounds(BlockSoundGroup.WOOL)),
                new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    }

    private static Block register(String id, Block block, Item.Settings settings) {
        return register(id, block, true, settings);
    }

    private static Block register(String id, Block block, boolean registerAsBlockItem, Item.Settings settings) {
        Identifier trueId = RandomAdditions.locate(id);
        Registry.register(Registry.BLOCK, trueId, block);
        if (registerAsBlockItem) Registry.register(Registry.ITEM, trueId, new BlockItem(block, settings));
        return block;
    }

    public static void init() {

    }
}
