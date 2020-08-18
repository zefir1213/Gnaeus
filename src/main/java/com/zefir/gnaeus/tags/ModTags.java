package com.zefir.gnaeus.tags;


import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tags.TagRegistry;
import net.minecraft.tags.TagRegistryManager;
import net.minecraft.util.ResourceLocation;

public class ModTags
{
    protected static final TagRegistry<Item> collection = TagRegistryManager.func_242196_a(new ResourceLocation("gnaeus","item"), ITagCollectionSupplier::func_241836_b);

    public static final ITag.INamedTag<Item> ICE = makeWrapperTag("ice");

    public static ITag.INamedTag<Item> makeWrapperTag(String name) {
        return collection.func_232937_a_(name);
    }
}
