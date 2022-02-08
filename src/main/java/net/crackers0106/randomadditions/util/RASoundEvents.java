package net.crackers0106.randomadditions.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class RASoundEvents {

    public static final SoundEvent MUSIC_DISC_CALM4 = register("randomadditions:calm4");

    public static final SoundEvent BLOCK_GLOWCELIUM_BREAK = register("randomadditions:block.glowcelium.break");
    public static final SoundEvent BLOCK_GLOWCELIUM_STEP = register("randomadditions:block.glowcelium.step");
    public static final SoundEvent BLOCK_GLOWCELIUM_PLACE = register("randomadditions:block.glowcelium.place");
    public static final SoundEvent BLOCK_GLOWCELIUM_HIT = register("randomadditions:block.glowcelium.hit");
    public static final SoundEvent BLOCK_GLOWCELIUM_FALL = register("randomadditions:block.glowcelium.fall");

    public static final SoundEvent BLOCK_SPIKE_EXTEND = register("randomadditions:block.spike.extend");
    public static final SoundEvent BLOCK_SPIKE_RETRACT = register("randomadditions:block.spike.retract");

    private static SoundEvent register(String id) {
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(new ResourceLocation(id)));
    }

    public static void init() {
    }
}
