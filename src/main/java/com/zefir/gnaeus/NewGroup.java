package com.zefir.gnaeus;

import com.zefir.gnaeus.init.ItemsInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class NewGroup extends ItemGroup
{
    public static final NewGroup instance = new NewGroup(ItemGroup.GROUPS.length, "gnaeus");

    public NewGroup(int index, String label)
    {
        super(index, label);
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(ItemsInit.ASE);
    }
}
