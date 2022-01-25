package net.crackers0106.randomadditions.item;

import net.crackers0106.randomadditions.RandomAdditions;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class RAItemGroup {
    private static String Id = RandomAdditions.MOD_ID;

    public static final ItemGroup RANDOM_ADDITIONS = FabricItemGroupBuilder.build(
            new Identifier(Id, "random_additions"),
            () -> new ItemStack(RAItems.BANANA));

    public static void init() {
    }
}
