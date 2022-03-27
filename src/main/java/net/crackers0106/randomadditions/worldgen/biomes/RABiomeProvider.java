package net.crackers0106.randomadditions.worldgen.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

import static net.minecraft.world.level.biome.Climate.Parameter;

public class RABiomeProvider extends Region {
    public RABiomeProvider(ResourceLocation name, RegionType type, int overworldWeight) {
        super(name, type, overworldWeight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addBiome(
                mapper,
                Parameter.span(0.5F, 0.97F),    // temperature
                Parameter.span(-0.35F, -0.1F),    // humidity
                Parameter.span(0.03F, 1.0F),    // continentialness
                Parameter.span(-1.0F, -0.78F),    // erosion
                Parameter.span(-0.26666668F, -0.05F),   // weirdness
                Parameter.point(0.0F),    // depth
                0.1F,    // offset
                RABiomes.SHRUBLAND);

        this.addBiome(
                mapper,
                Parameter.span(0.97F, 1.0F),    // temperature
                Parameter.span(0.9F, 1.0F),    // humidity
                Parameter.span(0.03F, 1.0F),    // continentialness
                Parameter.span(0.05F, 0.45F),    //erosion
                Parameter.span(-0.4F, -0.26666668F),   //weirdness
                Parameter.point(0.0F),    //depth
                0.1F,    // offset
                RABiomes.RAINFOREST);
    }
}