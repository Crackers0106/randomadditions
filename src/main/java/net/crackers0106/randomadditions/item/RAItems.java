package net.crackers0106.randomadditions.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RAItems {
	
    // an instance of our new item
    public static final Item BANANA = new BananaItem(new Item.Settings().group(ItemGroup.FOOD));
    public static final Item PEELED_BANANA = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(2.5F).build()));
    
        public static void init() {
            Registry.register(Registry.ITEM, new Identifier("randomadditions", "banana"), BANANA);
            Registry.register(Registry.ITEM, new Identifier("randomadditions", "peeled_banana"), PEELED_BANANA);
    	}
    }