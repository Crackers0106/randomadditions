package net.crackers0106.randomadditions.item;

import net.crackers0106.randomadditions.RandomAdditions;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.SculkSensorBlock;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class RAItems {
	
    // an instance of our new item
    public static final Item BANANA = new BananaItem(new Item.Settings().group(ItemGroup.FOOD));
    public static final Item PEELED_BANANA = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(5).saturationModifier(2.5F).build()));
//    public static final Item BANANA_PEEL = new BananaItem(new Item.Settings().group(ItemGroup.MISC));
    public static final Item CALM4_DISC = new AbstractDiscItem(14, RandomAdditions.CALM4_SOUND_EVENT, new Item.Settings().rarity(Rarity.RARE).maxCount(1).group(ItemGroup.MISC));
    public static final Item SCULK_SENSOR = new AliasedBlockItem(Blocks.SCULK_SENSOR, (new FabricItemSettings().group(ItemGroup.REDSTONE)));

        public static void init() {
            Registry.register(Registry.ITEM, new Identifier("randomadditions", "banana"), BANANA);
            Registry.register(Registry.ITEM, new Identifier("randomadditions", "peeled_banana"), PEELED_BANANA);
//            Registry.register(Registry.ITEM, new Identifier("randomadditions", "banana_peel"), BANANA_PEEL);
            Registry.register(Registry.ITEM, new Identifier("randomadditions", "music_disc_calm4"), CALM4_DISC);
            Registry.register(Registry.ITEM, new Identifier("randomadditions", "sculk_sensor_item"), SCULK_SENSOR);

    	}
    }