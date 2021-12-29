package net.crackers0106.randomadditions;

import net.crackers0106.randomadditions.block.RABlockTags;
import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.block.RAWools;
import net.crackers0106.randomadditions.gen.RAFeatures;
import net.crackers0106.randomadditions.gen.biome.BiomeRainforest;
import net.crackers0106.randomadditions.gen.biome.BiomeShrubland;
import net.crackers0106.randomadditions.gen.tree.foliageplacer.RAFoliagePlacers;
import net.crackers0106.randomadditions.item.RAItems;
import net.crackers0106.randomadditions.util.Instance;
import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RandomAdditions implements ModInitializer {

//	public static final Logger LOGGER = LogManager.getLogger();
	public static final Identifier CALM4 = new Identifier("randomadditions:calm4");
	public static SoundEvent CALM4_SOUND_EVENT = new SoundEvent(CALM4);

		@Override
		public void onInitialize () {
			// This code runs as soon as Minecraft is in a mod-load-ready state.
			// However, some things (like resources) may still be uninitialized.
			// Proceed with mild caution.

			Instance.init();
			RAFeatures.registerFeatures();
			RAFoliagePlacers.init();
			BiomeRainforest.init();
			BiomeShrubland.init();
			RABlockTags.init();
			RABlocks.init();
			RAWools.init();
			RAItems.init();
			Registry.register(Registry.SOUND_EVENT, RandomAdditions.CALM4, CALM4_SOUND_EVENT);
			System.out.println("Initialized Random Additions...");
		}

	public static final String MOD_ID = "randomadditions";

	public static Identifier locate(String location) {
		return new Identifier(MOD_ID, location);
	}
}
