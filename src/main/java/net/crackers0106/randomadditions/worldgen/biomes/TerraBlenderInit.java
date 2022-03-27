package net.crackers0106.randomadditions.worldgen.biomes;

import net.minecraft.resources.ResourceLocation;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

import static net.crackers0106.randomadditions.RandomAdditions.MOD_ID;

public class TerraBlenderInit implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized()
    {
        // Register our biome provider.
        Regions.register(new BiomeProvider());
    }

    public static class BiomeProvider extends Region {
        public BiomeProvider() {
            // Given we only add two biomes, we should keep our weight relatively low.
            super(new ResourceLocation(MOD_ID, "biome_provider"), RegionType.OVERWORLD, 2);
        }
    }
}
