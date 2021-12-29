package net.crackers0106.randomadditions.block;

import net.crackers0106.randomadditions.RandomAdditions;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.GlowLichenBlock;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class SculkBlocks {

    public static final Block SCULK;
    public static final Block SCULK_VEIN;
    public static final Block SCULK_CATALYST;

    static {

            SCULK = register("sculk", new OreBlock(FabricBlockSettings.of(Material.SCULK)
                            .breakByTool(FabricToolTags.HOES, 1)
                            .breakByHand(true)
                            .strength(1.5F)
                            .sounds(BlockSoundGroup.SCULK_SENSOR)),
                    new Item.Settings().group(ItemGroup.REDSTONE));

           SCULK_VEIN = register("sculk_vein", new GlowLichenBlock(FabricBlockSettings.of(Material.SCULK)
                            .breakByTool(FabricToolTags.HOES, 1)
                            .breakByHand(true)
                            .strength(0.5F)
                            .noCollision()
                            .nonOpaque()
                            .sounds(BlockSoundGroup.SCULK_SENSOR)),
                    new Item.Settings().group(ItemGroup.REDSTONE));

            SCULK_CATALYST = register("sculk_catalyst", new SculkCatalyst(FabricBlockSettings.of(Material.SCULK)
                            .breakByTool(FabricToolTags.HOES, 1)
                            .breakByHand(true)
                            .strength(1.5F)
                            .sounds(BlockSoundGroup.BONE)),
                   new Item.Settings().group(ItemGroup.REDSTONE)); UniformIntProvider.create(1, 1);
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
