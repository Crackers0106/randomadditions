package net.crackers0106.randomadditions.util;

import net.minecraft.entity.damage.DamageSource;

public class RADamageSource extends DamageSource {

    public static final DamageSource SPIKES = (new RADamageSource("spikes")).setBypassesArmor();

    protected RADamageSource(String name) {
        super(name);
    }
}