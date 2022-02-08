package net.crackers0106.randomadditions.util;

import net.minecraft.world.damagesource.DamageSource;

public class RADamageSource extends DamageSource {

    public static final DamageSource SPIKES = (new RADamageSource("spikes")).bypassArmor();

    protected RADamageSource(String name) {
        super(name);
    }
}