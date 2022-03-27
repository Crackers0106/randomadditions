package net.crackers0106.randomadditions.block;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class RABlockTags {

    public static final TagKey<Block> SPIKE_PASSABLE = create("spike_passable");
    public static final TagKey<Block> DEEPSLATE = create("deepslate");
    public static final TagKey<Block> GLOWCELIUM_REPLACEABLE = create("glowcelium_replaceable");

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(name));
    }

    public static void init() {}
}
