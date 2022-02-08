package net.crackers0106.randomadditions.item.tools;

import net.crackers0106.randomadditions.item.RAItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class RAPickaxe extends PickaxeItem {
    public RAPickaxe(Tier material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        float original = super.getDestroySpeed(stack, state);
        if (getDefaultInstance().is(RAItems.AMETHYST_PICKAXE) && state.is(Blocks.DEEPSLATE)) return original + 6.5F;
        return original;
    }
}