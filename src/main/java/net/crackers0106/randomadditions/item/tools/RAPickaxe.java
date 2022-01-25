package net.crackers0106.randomadditions.item.tools;

import net.crackers0106.randomadditions.item.RAItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class RAPickaxe extends PickaxeItem {
    public RAPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        float original = super.getMiningSpeedMultiplier(stack, state);
        if (getDefaultStack().isOf(RAItems.AMETHYST_PICKAXE) && state.isOf(Blocks.DEEPSLATE)) return original + 6.5F;
        return original;
    }
}