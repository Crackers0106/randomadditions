package net.crackers0106.randomadditions.worldgen.features;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.function.Supplier;

public class SculkPatchFeatureConfig implements FeatureConfig {
    public static final Codec<SculkPatchFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Identifier.CODEC.fieldOf("replaceable").forGetter(sculkPatchFeatureConfig -> sculkPatchFeatureConfig.replaceable),
                            Identifier.CODEC.fieldOf("cantPlaceSculkVein").forGetter(sculkPatchFeatureConfig -> sculkPatchFeatureConfig.cantPlaceSculkVein),
                            BlockStateProvider.TYPE_CODEC.fieldOf("ground_state").forGetter(sculkPatchFeatureConfig -> sculkPatchFeatureConfig.groundState),
                            PlacedFeature.REGISTRY_CODEC
                                    .fieldOf("sculk_vein_feature")
                                    .forGetter(sculkPatchFeatureConfig -> sculkPatchFeatureConfig.sculkVeinFeature),
                            VerticalSurfaceType.CODEC.fieldOf("surface").forGetter(sculkPatchFeatureConfig -> sculkPatchFeatureConfig.surface),
                            IntProvider.createValidatingCodec(1, 128).fieldOf("depth").forGetter(vegetationPatchFeatureConfig -> vegetationPatchFeatureConfig.depth),
                            Codec.intRange(1, 256).fieldOf("vertical_range").forGetter(sculkPatchFeatureConfig -> sculkPatchFeatureConfig.verticalRange),
                            Codec.floatRange(0.0F, 1.0F)
                                    .fieldOf("growth_chance")
                                    .forGetter(vegetationPatchFeatureConfig -> vegetationPatchFeatureConfig.growthChance),
                            IntProvider.VALUE_CODEC.fieldOf("xz_radius").forGetter(sculkPatchFeatureConfig -> sculkPatchFeatureConfig.horizontalRadius)
            )
                    .apply(instance, SculkPatchFeatureConfig::new)
        );

    public final Identifier replaceable;
    public final Identifier cantPlaceSculkVein;
    public final BlockStateProvider groundState;
    public final Supplier<PlacedFeature> sculkVeinFeature;
    public final VerticalSurfaceType surface;
    public final IntProvider depth;
    public final int verticalRange;
    public final float growthChance;
    public final IntProvider horizontalRadius;
    public SculkPatchFeatureConfig(
            Identifier replaceable,
            Identifier cantPlaceSculkVein,
            BlockStateProvider groundState,
            Supplier<PlacedFeature> sculkVeinFeature,
            VerticalSurfaceType surface,
            IntProvider depth,
            int verticalRange,
            float growthChance,
            IntProvider horizontalRadius

    ) {
        this.replaceable = replaceable;
        this.cantPlaceSculkVein = cantPlaceSculkVein;
        this.groundState = groundState;
        this.sculkVeinFeature = sculkVeinFeature;
        this.surface = surface;
        this.depth = depth;
        this.verticalRange = verticalRange;
        this.growthChance = growthChance;
        this.horizontalRadius = horizontalRadius;
    }
}
