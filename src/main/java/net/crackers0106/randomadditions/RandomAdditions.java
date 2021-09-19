package net.crackers0106.randomadditions;

import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.item.RAItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class RandomAdditions implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		RABlocks.init();
		RAItems.init();
		System.out.println("Hello Fabric world!");
	}
    public static final String MOD_ID = "randomadditions";	
	
	    public static Identifier locate(String location) {
	        return new Identifier(MOD_ID, location);
	}
}