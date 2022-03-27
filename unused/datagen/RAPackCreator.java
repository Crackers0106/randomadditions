package net.crackers0106.randomadditions.datagen;

import net.crackers0106.randomadditions.RandomAdditions;
import net.minecraft.resource.ResourcePackProfile;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.resource.ResourcePackSource;
import net.minecraft.resource.ResourceType;

import java.util.function.Consumer;

public class RAPackCreator implements ResourcePackProvider {
    @Override
    public void register(Consumer<ResourcePackProfile> consumer, ResourcePackProfile.Factory factory) {
        consumer.accept(ResourcePackProfile.of("randomadditions:pack/runtime",
                true,
                () -> RandomAdditions.RESOURCE_PACK.rebuild(ResourceType.SERVER_DATA, null),
                factory, ResourcePackProfile.InsertionPosition.TOP, ResourcePackSource.onlyName()));
    }
}