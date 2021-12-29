package net.crackers0106.randomadditions.block;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

import static net.crackers0106.randomadditions.RandomAdditions.locate;

public final class RABlockTags {

    public static final Tag<Block> SPIKE_PASSABLE = TagFactory.BLOCK.create(locate("spike_passable"));

    public static void init() {
    }
}
