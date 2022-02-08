package net.crackers0106.randomadditions.item.tools.materials;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class AmethystToolMaterial implements Tier {

    public static final AmethystToolMaterial INSTANCE = new AmethystToolMaterial();

    @Override
    public int getUses() {
        return 550;
    }

    @Override
    public float getSpeed() {
        return 6.5F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 2.5F;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.COPPER_INGOT);
    }

}