package com.zefir.gnaeus.tags;


import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class ModTags
{
    public static final ITag.INamedTag<Item> ICE = GnaeusTag("ice");

    public static ITag.INamedTag<Item> GnaeusTag(String name)
    {
        return ItemTags.makeWrapperTag("gnaeus:"+name);
    }
}
