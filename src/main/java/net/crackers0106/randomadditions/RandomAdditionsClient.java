package net.crackers0106.randomadditions;

import net.crackers0106.randomadditions.block.RABlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class RandomAdditionsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		BlockRenderLayerMap.INSTANCE.putBlock(RABlocks.SCULK_VEIN, RenderLayer.getCutout());
	}
	
}