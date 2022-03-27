package net.crackers0106.randomadditions.worldgen.biomes;

import net.crackers0106.randomadditions.RandomAdditions;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class RABiomes {
    public static final ResourceKey<Biome> SHRUBLAND = register("shrubland");
    public static final ResourceKey<Biome> RAINFOREST = register("rainforest");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(RandomAdditions.MOD_ID, name));
    }
}