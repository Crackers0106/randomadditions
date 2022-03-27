package net.crackers0106.randomadditions.datagen;


import com.google.gson.JsonObject;
import net.crackers0106.randomadditions.RandomAdditions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModelBuilder {
    private final JsonObject json = new JsonObject();
    private JsonObject textures;

    public ModelBuilder(Identifier parent) {
        this.json.addProperty("parent", parent.toString());
    }

    public ModelBuilder texture(String name, Identifier id) {
        if (this.textures == null) {
            this.json.add("textures", this.textures = new JsonObject());
        }

        this.textures.addProperty(name, id.toString());

        return this;
    }

    public JsonObject toJson() {
        return this.json;
    }

    public Identifier register(Block block) {
        var id = Registry.BLOCK.getId(block);
        return this.register(new Identifier(id.getNamespace(), "block/" + id.getPath()));
    }

    public Identifier register(Item block) {
        var id = Registry.ITEM.getId(block);
        return this.register(new Identifier(id.getNamespace(), "item/" + id.getPath()));
    }

    public Identifier register(Identifier id) {
        RandomAdditions.RESOURCE_PACK.putJson(ResourceType.CLIENT_RESOURCES,
                new Identifier(id.getNamespace(), "models/" + id.getPath()),
                this.toJson());
        return id;
    }
}
