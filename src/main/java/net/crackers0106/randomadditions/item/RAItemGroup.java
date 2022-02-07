package net.crackers0106.randomadditions.item;

import net.crackers0106.randomadditions.RandomAdditions;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class RAItemGroup {
    private static String Id = RandomAdditions.MOD_ID;

    public static final CreativeModeTab RANDOM_ADDITIONS = FabricItemGroupBuilder.build(
            new ResourceLocation(Id, "random_additions"),
            () -> new ItemStack(RAItems.BANANA));

    public static void init() {
    }
}
