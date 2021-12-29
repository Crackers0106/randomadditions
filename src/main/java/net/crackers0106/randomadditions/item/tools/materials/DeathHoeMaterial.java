package net.crackers0106.randomadditions.item.tools.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class DeathHoeMaterial implements ToolMaterial {

    public static final DeathHoeMaterial INSTANCE = new DeathHoeMaterial();

    @Override
    public int getDurability() {
        return 2048;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0F;
    }

    @Override
    public float getAttackDamage() {
        return 0.0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }


}
