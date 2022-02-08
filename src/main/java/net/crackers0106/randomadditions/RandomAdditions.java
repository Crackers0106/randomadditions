package net.crackers0106.randomadditions;

import net.crackers0106.randomadditions.block.RABlockTags;
import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.block.RAWools;
import net.crackers0106.randomadditions.gen.configuredfeatures.RAUndergroundConfiguredFeatures;
import net.crackers0106.randomadditions.gen.tree.foliageplacer.RAFoliagePlacers;
import net.crackers0106.randomadditions.item.RAItemGroup;
import net.crackers0106.randomadditions.item.RAItems;
import net.crackers0106.randomadditions.util.Instance;
import net.crackers0106.randomadditions.util.RASoundEvents;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.TerraBlenderApi;

public class RandomAdditions implements ModInitializer, TerraBlenderApi {
	public static final Logger LOGGER = LogManager.getLogger();

		@Override
		public void onInitialize () {
			// This codebase is a fucking disaster

			Instance.init();
			RAUndergroundConfiguredFeatures.generate();
			RAFoliagePlacers.init();
//			BiomeRegistry.registerBiomes();
			RAItemGroup.init();
			RABlockTags.init();
			RABlocks.init();
//			RASculkBlocks.init();
			RAWools.init();
			RAItems.init();
			RASoundEvents.init();
			System.out.println("Initialized Random Additions...");
		}

	public static final String MOD_ID = "randomadditions";

//	@Override
//	public void onTerraBlenderInitialized()
//	{
//		// Given we only add two biomes, we should keep our weight relatively low.
//		BiomeProviders.register(new RABiomeProvider(new Identifier(MOD_ID, "biome_provider"), 0));
//	}

	public static ResourceLocation locate(String location) {
		return new ResourceLocation(MOD_ID, location);
	}
}
