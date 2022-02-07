package net.crackers0106.randomadditions.gen.tree.foliageplacer;

import net.crackers0106.randomadditions.mixin.world.features.FoliagePlacerTypeInvoker;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

// This is pretty barren for now, but will grow later on if we ever need to add more foliage placers
public class RAFoliagePlacers {
    public static final FoliagePlacerType<PalmFoliagePlacer> PALM_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister("palm_foliage_placer", PalmFoliagePlacer.CODEC);

    public static void init() {
    }
}
