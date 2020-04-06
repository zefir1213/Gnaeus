package com.zefir.gnaeus.init.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

@net.minecraftforge.registries.ObjectHolder("gnaeus")
public class BlocksInit
{
    public static Block MY_BLOCK=new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2, 10)).setRegistryName("my_block");
}