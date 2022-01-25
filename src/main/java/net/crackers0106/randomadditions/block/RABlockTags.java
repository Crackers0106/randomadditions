package net.crackers0106.randomadditions.block;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

import static net.crackers0106.randomadditions.RandomAdditions.locate;

public final class RABlockTags {

    public static final Tag<Block> SPIKE_PASSABLE = TagFactory.BLOCK.create(locate("spike_passable"));
    public static final Tag.Identified<Block> GLOWCELIUM_REPLACEABLE = TagFactory.BLOCK.create(locate("glowcelium_replaceable"));
    public static final Tag.Identified<Block> EXCLUDE_SCULK_VEIN_PLACEMENT = TagFactory.BLOCK.create(locate("exclude_sculk_vein_placement"));

    public static void init() {
    }
}
