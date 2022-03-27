package net.crackers0106.randomadditions.datagen;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.crackers0106.randomadditions.RandomAdditions;
import net.fabricmc.fabric.api.resource.ModResourcePack;
import net.fabricmc.fabric.impl.resource.loader.ModResourcePackUtil;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.resource.AbstractFileResourcePack;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.resource.metadata.ResourceMetadataReader;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RAResourcePack implements ModResourcePack {
    private static final Logger LOGGER = LogManager.getLogger();

    private final Set<String> namespaces = new HashSet<>();
    private final Map<String, byte[]> resources = new Object2ObjectOpenHashMap<>();
    private final ResourceType type;

    private boolean hasRegisteredOneTimeResources = false;

    public RAResourcePack(ResourceType type) {
        this.type = type;
    }


    public RAResourcePack rebuild(ResourceType type, @Nullable ResourceManager resourceManager) {
        return type == ResourceType.CLIENT_RESOURCES ? this.rebuildClient(resourceManager) : this.rebuildData();
    }

    public RAResourcePack rebuildClient(ResourceManager resourceManager) {
        this.namespaces.add("randomadditions");

        return this;
    }

    public RAResourcePack rebuildData() {
        this.resources.clear();
        this.namespaces.clear();

        if (!this.hasRegisteredOneTimeResources) {
            this.hasRegisteredOneTimeResources = true;
        }

        LOGGER.info("Registered " + this.resources.size() + " resources.");

        return this;
    }

    private void registerTag(String[] types, Identifier id, Stream<Identifier> entries) {
        var root = new JsonObject();
        root.addProperty("replace", false);
        var values = new JsonArray();

        entries.forEach(value -> values.add(value.toString()));

        root.add("values", values);

        for (var type : types) {
            this.putJson("data/" + id.getNamespace() + "/tags/" + type + "/" + id.getPath() + ".json",
                    root);
        }
    }

    public void putResource(String resource, byte[] data) {
        this.resources.put(resource, data);

        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            try {
                var path = Paths.get("debug", "randomadditions").resolve(resource);
                Files.createDirectories(path.getParent());
                Files.write(path, data, StandardOpenOption.CREATE, StandardOpenOption.WRITE,
                        StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void putJsonText(ResourceType type, Identifier id, String json) {
        this.namespaces.add(id.getNamespace());

        String path = Datagen.toPath(id, type) + ".json";
        this.putText(path, json);
    }

    public void putText(String resource, String text) {
        this.putResource(resource, text.getBytes(StandardCharsets.UTF_8));
    }

    public void putJson(ResourceType type, Identifier id, JsonObject json) {
        this.namespaces.add(id.getNamespace());

        String path = Datagen.toPath(id, type) + ".json";
        this.putJson(path, json);
    }

    public void putJson(String resource, JsonObject json) {
        var stringWriter = new StringWriter();
        var jsonWriter = new JsonWriter(stringWriter);
        jsonWriter.setLenient(true);
        jsonWriter.setIndent("  ");
        try {
            Streams.write(json, jsonWriter);
        } catch (IOException e) {
            LOGGER.error("Failed to write JSON at {}.", resource, e);
        }
        this.putText(resource, stringWriter.toString());
    }

    @Override
    public ModMetadata getFabricModMetadata() {
        return FabricLoader.getInstance().getModContainer(RandomAdditions.MOD_ID).get().getMetadata();
    }

    @Override
    public @Nullable InputStream openRoot(String fileName) throws IOException {
        if (ModResourcePackUtil.containsDefault(this.getFabricModMetadata(), fileName)) {
            return ModResourcePackUtil.openDefault(this.getFabricModMetadata(),
                    this.type,
                    fileName);
        }

        byte[] data;
        if ((data = this.resources.get(fileName)) != null) {
            return new ByteArrayInputStream(data);
        }
        throw new IOException("Generated resources pack has no data or alias for " + fileName);
    }

    @Override
    public InputStream open(ResourceType type, Identifier id) throws IOException {
        if (type != this.type)
            throw new IOException("Reading data from the wrong resource pack.");
        return this.openRoot(type.getDirectory() + "/" + id.getNamespace() + "/" + id.getPath());
    }

    @Override
    public Collection<Identifier> findResources(ResourceType type, String namespace, String prefix, int maxDepth,
                                                Predicate<String> pathFilter) {
        if (type != this.type) return Collections.emptyList();
        var start = type.getDirectory() + "/" + namespace + "/" + prefix;
        return this.resources.keySet().stream()
                .filter(s -> s.startsWith(start) && pathFilter.test(s))
                .map(RAResourcePack::fromPath)
                .collect(Collectors.toList());
    }

    @Override
    public boolean contains(ResourceType type, Identifier id) {
        var path = type.getDirectory() + "/" + id.getNamespace() + "/" + id.getPath();
        return this.resources.containsKey(path);
    }

    @Override
    public Set<String> getNamespaces(ResourceType type) {
        return this.namespaces;
    }

    @Nullable
    @Override
    public <T> T parseMetadata(ResourceMetadataReader<T> metaReader) throws IOException {
        InputStream inputStream = this.openRoot("pack.mcmeta");
        Throwable error = null;

        T metadata;
        try {
            metadata = AbstractFileResourcePack.parseMetadata(metaReader, inputStream);
        } catch (Throwable e) {
            error = e;
            throw e;
        } finally {
            if (inputStream != null) {
                if (error != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        error.addSuppressed(e);
                    }
                } else {
                    inputStream.close();
                }
            }
        }

        return metadata;
    }

    @Override
    public String getName() {
        return "Random Additions Resources";
    }

    @Override
    public void close() {
        if (this.type == ResourceType.CLIENT_RESOURCES) {
            this.resources.clear();
            this.namespaces.clear();
        }
    }

    private static Identifier fromPath(String path) {
        String[] split = path.replaceAll("((assets)|(data))/", "").split("/", 2);

        return new Identifier(split[0], split[1]);
    }
}
