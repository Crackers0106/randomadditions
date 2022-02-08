package net.crackers0106.randomadditions.util;

import net.crackers0106.randomadditions.block.RABlocks;
import net.crackers0106.randomadditions.block.RAWools;
import net.crackers0106.randomadditions.item.RAItems;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.client.renderer.RenderType;

public class Instance {

    public static void init() {

        // Flammable blocks

            // Wools
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.BRIGHT_RED, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.BRIGHT_ORANGE, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.BRIGHT_YELLOW, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.CHARTREUSE, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.BRIGHT_LIME, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.SPRING_GREEN, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.BRIGHT_CYAN, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.CAPRI, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.ULTRAMARINE, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.VIOLET, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.BRIGHT_PURPLE, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.MAGENTA, 30, 60);
            FlammableBlockRegistry.getDefaultInstance().add(RAWools.ROSE, 30, 60);

            // Plants
            FlammableBlockRegistry.getDefaultInstance().add(RABlocks.ROSE, 60, 100);
            FlammableBlockRegistry.getDefaultInstance().add(RABlocks.BANANA_SAPLING, 60, 100);

        // Block render layers
            BlockRenderLayerMap.INSTANCE.putBlock(RABlocks.ROSE, RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(RABlocks.POTTED_ROSE, RenderType.cutout());

            BlockRenderLayerMap.INSTANCE.putBlock(RABlocks.BANANA_SAPLING, RenderType.cutout());
            BlockRenderLayerMap.INSTANCE.putBlock(RABlocks.GLOWSHROOM, RenderType.cutout());

            BlockRenderLayerMap.INSTANCE.putBlock(RABlocks.SPIKE, RenderType.cutout());

        // Compostable
            CompostingChanceRegistry.INSTANCE.add(RABlocks.ROSE, 0.65f);
            CompostingChanceRegistry.INSTANCE.add(RAItems.BANANA, 0.65f);
            CompostingChanceRegistry.INSTANCE.add(RAItems.PEELED_BANANA, 0.65f);

    }
}
