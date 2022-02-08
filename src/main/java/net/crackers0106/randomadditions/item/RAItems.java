package net.crackers0106.randomadditions.item;

import net.crackers0106.randomadditions.RandomAdditions;
import net.crackers0106.randomadditions.item.armor.materials.CopperArmorMaterial;
import net.crackers0106.randomadditions.item.tools.RAAxe;
import net.crackers0106.randomadditions.item.tools.RAHoe;
import net.crackers0106.randomadditions.item.tools.RAPickaxe;
import net.crackers0106.randomadditions.item.tools.materials.AmethystToolMaterial;
import net.crackers0106.randomadditions.item.tools.materials.CopperToolMaterial;
import net.crackers0106.randomadditions.item.tools.materials.DeathHoeMaterial;
import net.crackers0106.randomadditions.util.RASoundEvents;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;

public class RAItems {

    public static final BananaItem BANANA;
    public static final Item PEELED_BANANA;
    public static final AbstractDiscItem CALM4_DISC;

    public static final RAPickaxe COPPER_PICKAXE;
    public static final RAAxe COPPER_AXE;
    public static final RAHoe COPPER_HOE;
    public static final RAHoe DEATH_HOE;
    public static final ShovelItem COPPER_SHOVEL;
    public static final SwordItem COPPER_SWORD;

    public static final RAPickaxe AMETHYST_PICKAXE;
    public static final ArmorMaterial COPPER_ARMOR_MATERIAL = new CopperArmorMaterial();

    public static final Item COPPER_HELMET;
    public static final Item COPPER_CHESTPLATE;
    public static final Item COPPER_LEGGINGS;
    public static final Item COPPER_BOOTS;

    static {

        BANANA = register("banana", new BananaItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)));
        PEELED_BANANA = register("peeled_banana", new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().nutrition(5).saturationMod(2.5F).build())));

        CALM4_DISC = register("music_disc_calm4", new AbstractDiscItem(14, RASoundEvents.MUSIC_DISC_CALM4, new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

    // Pickaxes

        COPPER_PICKAXE = register("copper_pickaxe", new RAPickaxe(CopperToolMaterial.INSTANCE, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
        AMETHYST_PICKAXE = register("amethyst_pickaxe", new RAPickaxe(AmethystToolMaterial.INSTANCE, 1, -2.8F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
        // Shovels

        COPPER_SHOVEL = register("copper_shovel", new ShovelItem(CopperToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    // Swords

        COPPER_SWORD = register("copper_sword", new SwordItem(CopperToolMaterial.INSTANCE, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    // Axes

        COPPER_AXE = register("copper_axe", new RAAxe(CopperToolMaterial.INSTANCE, 6.0F, -3.2F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    // Hoes

        COPPER_HOE = register("copper_hoe", new RAHoe(CopperToolMaterial.INSTANCE, -2, -1.0F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
        DEATH_HOE = register("hoe_of_destruction", new RAHoe(DeathHoeMaterial.INSTANCE, 19, -1.0F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    // Armor

        COPPER_HELMET = register("copper_helmet", new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
        COPPER_CHESTPLATE = register("copper_chestplate", new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
        COPPER_LEGGINGS = register("copper_leggings", new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
        COPPER_BOOTS = register("copper_boots", new ArmorItem(COPPER_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    }

    private static <T extends Item> T register(String id, T item) {
        return Registry.register(Registry.ITEM, RandomAdditions.locate(id), item);
    }

        public static void init() {

    	}
    }