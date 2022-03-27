package net.crackers0106.randomadditions.item;

import net.crackers0106.randomadditions.RandomAdditions;
import net.crackers0106.randomadditions.item.armor.materials.CopperArmorMaterial;
import net.crackers0106.randomadditions.item.tools.RAAxe;
import net.crackers0106.randomadditions.item.tools.RAHoe;
import net.crackers0106.randomadditions.item.tools.RAPickaxe;
import net.crackers0106.randomadditions.item.tools.RAToolMaterials;
import net.crackers0106.randomadditions.util.RASoundEvents;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

public class RAItems {

    public static final BananaItem BANANA;
    public static final Item PEELED_BANANA;
    public static final AbstractDiscItem CALM4_DISC;

    public static final ArmorMaterial COPPER_ARMOR_MATERIAL = new CopperArmorMaterial();

    public static final RAPickaxe COPPER_PICKAXE;
    public static final RAAxe COPPER_AXE;
    public static final RAHoe COPPER_HOE;
    public static final ShovelItem COPPER_SHOVEL;
    public static final SwordItem COPPER_SWORD;

    public static final RAPickaxe AMETHYST_PICKAXE;
    public static final RAHoe HOE_OF_DESTRUCTION;
    public static final Item UNMAKER;

    public static final Item COPPER_HELMET;
    public static final Item COPPER_CHESTPLATE;
    public static final Item COPPER_LEGGINGS;
    public static final Item COPPER_BOOTS;
    public static final Item RUBY;

    static {

        BANANA = register("banana", new BananaItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));
        PEELED_BANANA = register("peeled_banana", new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().nutrition(5).saturationMod(2.5F).build())));
        RUBY = register("ruby", new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

        CALM4_DISC = register("music_disc_calm4", new AbstractDiscItem(14, RASoundEvents.MUSIC_DISC_CALM4, new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

        // Copper

        COPPER_PICKAXE = register("copper_pickaxe", new RAPickaxe(RAToolMaterials.COPPER, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
        COPPER_SHOVEL = register("copper_shovel", new ShovelItem(RAToolMaterials.COPPER, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
        COPPER_SWORD = register("copper_sword", new SwordItem(RAToolMaterials.COPPER, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
        COPPER_AXE = register("copper_axe", new RAAxe(RAToolMaterials.COPPER, 6.0F, -3.2F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
        COPPER_HOE = register("copper_hoe", new RAHoe(RAToolMaterials.COPPER, -2, -1.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

        // Special tools

        AMETHYST_PICKAXE = register("amethyst_pickaxe", new RAPickaxe(RAToolMaterials.AMETHYST, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
        HOE_OF_DESTRUCTION = register("hoe_of_destruction", new RAHoe(RAToolMaterials.HOE_OF_DESTRUCTION, 19, -1.0F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
        UNMAKER = register("unmaker", new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

        // Armor

        COPPER_HELMET = register("copper_helmet", new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
        COPPER_CHESTPLATE = register("copper_chestplate", new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
        COPPER_LEGGINGS = register("copper_leggings", new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
        COPPER_BOOTS = register("copper_boots", new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    }

    private static <T extends Item> T register(String id, T item) {
        return Registry.register(Registry.ITEM, RandomAdditions.locate(id), item);
    }

    public static void init() {}
}