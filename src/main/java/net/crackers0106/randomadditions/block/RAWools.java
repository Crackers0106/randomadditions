package net.crackers0106.randomadditions.block;

import net.crackers0106.randomadditions.RandomAdditions;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

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
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        BRIGHT_ORANGE = register("bright_orange_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        BRIGHT_YELLOW = register("bright_yellow_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        CHARTREUSE = register("chartreuse_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        BRIGHT_LIME = register("bright_lime_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        SPRING_GREEN = register("spring_green_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        BRIGHT_CYAN = register("bright_cyan_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        CAPRI = register("capri_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        ULTRAMARINE = register("ultramarine_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        VIOLET = register("violet_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        BRIGHT_PURPLE = register("bright_purple_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        MAGENTA = register("magenta_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

        ROSE = register("rose_wool", new Block(FabricBlockSettings.of(Material.WOOL)
                        .strength(0.8F)
                        .sound(SoundType.WOOL)),
                new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));

    }

    private static Block register(String id, Block block, Item.Properties settings) {
        return register(id, block, true, settings);
    }

    private static Block register(String id, Block block, boolean registerAsBlockItem, Item.Properties settings) {
        ResourceLocation trueId = RandomAdditions.locate(id);
        Registry.register(Registry.BLOCK, trueId, block);
        if (registerAsBlockItem) Registry.register(Registry.ITEM, trueId, new BlockItem(block, settings));
        return block;
    }

    public static void init() {

    }
}
