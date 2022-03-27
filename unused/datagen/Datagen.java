package net.crackers0106.randomadditions.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.crackers0106.randomadditions.RandomAdditions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.crackers0106.randomadditions.util.JsonUtils.jsonArray;

public final class Datagen {
    public static final Logger LOGGER = LogManager.getLogger("randomadditions:datagen");

    private static final Direction[] DIRECTIONS = Direction.values();

    private Datagen() {
        throw new UnsupportedOperationException("Someone tried to instantiate a static-only class. How?");
    }

    private static JsonObject generateBlockLootTableSimplePool(Identifier id, boolean copyName) {
        var pool = new JsonObject();
        pool.addProperty("rolls", 1.0);
        pool.addProperty("bonus_rolls", 0.0);

        var entries = new JsonArray();

        var entry = new JsonObject();
        entry.addProperty("type", "minecraft:item");
        entry.addProperty("name", id.toString());

        if (copyName) {
            var function = new JsonObject();
            function.addProperty("function", "minecraft:copy_name");
            function.addProperty("source", "block_entity");
            entry.add("functions", jsonArray(function));
        }

        entries.add(entry);

        pool.add("entries", entries);

        var survivesExplosion = new JsonObject();
        survivesExplosion.addProperty("condition", "minecraft:survives_explosion");
        pool.add("conditions", jsonArray(survivesExplosion));

        return pool;
    }

    public static JsonObject simpleBlockLootTable(Identifier id, boolean copyName) {
        var root = new JsonObject();
        root.addProperty("type", "minecraft:block");
        var pools = new JsonArray();
        pools.add(generateBlockLootTableSimplePool(id, copyName));

        root.add("pools", pools);

        return root;
    }

    private static JsonObject doubleBlockLootTable(Identifier id) {
        var root = new JsonObject();
        root.addProperty("type", "minecraft:block");
        var pools = new JsonArray();
        pools.add(generateBlockLootTableSimplePool(id, true));

        {
            var pool = generateBlockLootTableSimplePool(id, true);
            pools.add(pool);

            var conditions = pool.getAsJsonArray("conditions");
            var condition = new JsonObject();
            conditions.add(condition);
            condition.addProperty("condition", "minecraft:block_state_property");
            condition.addProperty("block", id.toString());
            {
                var properties = new JsonObject();
                properties.addProperty("type", "double");
                condition.add("properties", properties);
            }
        }

        root.add("pools", pools);

        return root;
    }

    public static void registerDoubleBlockLootTable(Block block) {
        var id = Registry.BLOCK.getId(block);
        RandomAdditions.RESOURCE_PACK.putJson(
                ResourceType.SERVER_DATA,
                new Identifier(id.getNamespace(), "loot_tables/blocks/" + id.getPath()),
                doubleBlockLootTable(id)
        );
    }

    public static void dropsSelf(Block block) {
        registerSimpleBlockLootTable(Registry.BLOCK.getId(block), Registry.ITEM.getId(block.asItem()),
                block instanceof BlockWithEntity);
    }

    public static void registerSimpleBlockLootTable(Identifier blockId, Identifier itemId, boolean copyName) {
        RandomAdditions.RESOURCE_PACK.putJson(
                ResourceType.SERVER_DATA,
                new Identifier(blockId.getNamespace(), "loot_tables/blocks/" + blockId.getPath()),
                simpleBlockLootTable(itemId, copyName)
        );
    }

    private static void generateSimpleItemModel(Item item) {
        var itemId = Registry.ITEM.getId(item);
        generateSimpleItemModel(new Identifier(itemId.getNamespace(), "item/" + itemId.getPath()));
    }

    private static void generateSimpleItemModel(Identifier id) {
        modelBuilder(new Identifier("item/generated"))
                .texture("layer0", id)
                .register(id);
    }

    public static String toPath(Identifier id, ResourceType type) {
        return toPath(id, type, "");
    }

    public static String toPath(Identifier id, ResourceType type, String prefix) {
        return type.getDirectory() + '/' + id.getNamespace() + '/' + prefix + id.getPath();
    }

 //   public static BlockStateBuilder blockStateBuilder(Block block) {
 //       return new BlockStateBuilder(block);
 //   }

 //   public static MultipartBlockStateBuilder multipartBlockStateBuilder(Block block) {
 //       return new MultipartBlockStateBuilder(block);
 //   }

    public static ModelBuilder modelBuilder(Identifier parent) {
        return new ModelBuilder(parent);
    }
}