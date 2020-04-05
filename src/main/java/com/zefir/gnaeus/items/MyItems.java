package com.zefir.gnaeus.items;

import com.zefir.gnaeus.NewGroup;
import com.zefir.gnaeus.GnaeusMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraftforge.fml.common.Mod;
import com.zefir.gnaeus.blocks.MyBlocks;
import net.minecraftforge.registries.ForgeRegistries;

import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@net.minecraftforge.registries.ObjectHolder("gnaeus")
public class MyItems
{
    public static final Item MY_BLOCK = register("my_block", MyBlocks.MY_BLOCK);
    public static final Item ASE= register("ase", new Item(new Item.Properties().group(NewGroup.instance)));
    public static final Item QUEEN = register("queen", new Item(new Item.Properties().group(NewGroup.instance)));
    public static final Item BLACK_LOTUS = register("black_lotus", new BlackLotus(new Item.Properties().group(NewGroup.instance)));

    private static Item register(String name, Block block)
    {
        return register(name, new BlockItem(block, new Item.Properties().group(NewGroup.instance)));
    }
    private static Item register(String name, Item item)
    {
        item.setRegistryName(name);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}