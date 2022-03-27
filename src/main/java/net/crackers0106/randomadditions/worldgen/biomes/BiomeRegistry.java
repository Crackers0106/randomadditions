package net.crackers0106.randomadditions.worldgen.biomes;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeRegistry {
    public static void registerBiomes() {
        register(RABiomes.SHRUBLAND, RAOverworldBiomes.shrubland());
        register(RABiomes.RAINFOREST, RAOverworldBiomes.rainforest());
    }

    private static void register(ResourceKey<Biome> key, Biome biome) {
        BuiltinRegistries.register(BuiltinRegistries.BIOME, key, biome);
    }
}
