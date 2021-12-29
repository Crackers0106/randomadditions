package net.crackers0106.randomadditions.item.tools.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CopperToolMaterial implements ToolMaterial {

    public static final CopperToolMaterial INSTANCE = new CopperToolMaterial();

    @Override
    public int getDurability() {
        return 191;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1.0F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }


}
