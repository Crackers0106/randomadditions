package net.crackers0106.randomadditions.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.GlowLichenBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.crackers0106.randomadditions.RandomAdditions;

public class RASlabs {

	
    public static final Block POLISHED_NETHERRACK_SLAB;
    public static final Block CUT_STONE_SLAB;
    public static final Block POLISHED_STONE_SLAB;
    public static final Block MINI_STONE_BRICK_SLAB;

    static {
    	
    	POLISHED_NETHERRACK_SLAB = register("polished_netherrack_slab", new Block(FabricBlockSettings.of(Material.STONE)
    			.breakByTool(FabricToolTags.PICKAXES, 1)
    			.requiresTool()
    			.strength(0.4F)
    			.sounds(BlockSoundGroup.NETHERRACK)), 
    			buildingBlock());    	    	  	
        
        CUT_STONE_SLAB = register("cut_stone_slab", new Block(FabricBlockSettings.of(Material.STONE)
        		.strength(0.6F, 1.5F)
        		.breakByTool(FabricToolTags.PICKAXES, 1)
        		.requiresTool()), 
        		buildingBlock());
        
        POLISHED_STONE_SLAB = register("polished_stone_slab", new Block(FabricBlockSettings.of(Material.STONE)
        		.strength(0.6F, 1.5F)
        		.breakByTool(FabricToolTags.PICKAXES, 1)
        		.requiresTool()), 
        		buildingBlock());
        
        MINI_STONE_BRICK_SLAB = register("mini_stone_brick_slab", new Block(FabricBlockSettings.of(Material.STONE)
        		.strength(0.6F, 1.5F)
        		.breakByTool(FabricToolTags.PICKAXES, 1)
        		.requiresTool()), 
        		buildingBlock());
    	
    }

private static Item.Settings buildingBlock() {
    return new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS);
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
