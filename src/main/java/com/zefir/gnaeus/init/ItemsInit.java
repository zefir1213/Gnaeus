package com.zefir.gnaeus.init;

import com.zefir.gnaeus.NewGroup;
import com.zefir.gnaeus.items.BlackLotus;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@net.minecraftforge.registries.ObjectHolder("gnaeus")
public class ItemsInit
{
    public static final Item MY_BLOCK = register("my_block", BlocksInit.MY_BLOCK);
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