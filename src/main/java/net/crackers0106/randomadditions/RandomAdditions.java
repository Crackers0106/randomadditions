package net.crackers0106.randomadditions;

import net.crackers0106.randomadditions.block.RABlockTags;
import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.block.RAWools;
import net.crackers0106.randomadditions.item.RAItems;
import net.crackers0106.randomadditions.util.Instance;
import net.crackers0106.randomadditions.util.RASoundEvents;
import net.crackers0106.randomadditions.worldgen.biomes.BiomeRegistry;
import net.crackers0106.randomadditions.worldgen.configuredfeatures.RACaveFeatures;
import net.crackers0106.randomadditions.worldgen.tree.foliageplacer.RAFoliagePlacers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.TerraBlenderApi;

public class RandomAdditions implements ModInitializer, TerraBlenderApi {
    public static final Logger LOGGER = LoggerFactory.getLogger("Random Additions");
    public static final String MOD_ID = "randomadditions";

    public static ResourceLocation locate(String location) {
        return new ResourceLocation(MOD_ID, location);
    }

    // Create a Creative Mode tab for our mod's items
    public static final CreativeModeTab ITEM_GROUP = FabricItemGroupBuilder.build(
            new ResourceLocation(MOD_ID, "random_additions"),
            () -> new ItemStack(RAItems.BANANA));

    @Override
    public void onInitialize() {
        // This codebase is a fucking disaster

        Instance.init();
        RACaveFeatures.generate();
        RAFoliagePlacers.init();
        BiomeRegistry.registerBiomes();
        RABlockTags.init();
        RABlocks.init();
        RAWools.init();
        RAItems.init();
        RASoundEvents.init();
        LOGGER.info("Initialized Random Additions...");
    }
}
