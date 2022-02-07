package net.crackers0106.randomadditions.item.tools.materials;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class DeathHoeMaterial implements Tier {

    public static final DeathHoeMaterial INSTANCE = new DeathHoeMaterial();

    @Override
    public int getUses() {
        return 2048;
    }

    @Override
    public float getSpeed() {
        return 9.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0.0F;
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public int getEnchantmentValue() {
        return 22;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.COPPER_INGOT);
    }


}
