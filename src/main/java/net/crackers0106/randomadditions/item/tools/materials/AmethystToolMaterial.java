package net.crackers0106.randomadditions.item.tools.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AmethystToolMaterial implements ToolMaterial {

    public static final AmethystToolMaterial INSTANCE = new AmethystToolMaterial();

    @Override
    public int getDurability() {
        return 550;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.5F;
    }

    @Override
    public float getAttackDamage() {
        return 2.5F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }

}