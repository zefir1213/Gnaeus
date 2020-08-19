package com.zefir.gnaeus.blocks;

import com.zefir.gnaeus.blocks.Card;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@net.minecraftforge.registries.ObjectHolder("gnaeus")
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks
{
    public static Block MY_BLOCK = register("my_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2, 10)));
    public static Block CARD = register("card", new Card());


    static private Block register(String name, Block block)
    {
        block.setRegistryName(name);
        ForgeRegistries.BLOCKS.register(block);
        return block;
    }
}