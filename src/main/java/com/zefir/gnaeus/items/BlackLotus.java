package com.zefir.gnaeus.init.items;

import com.zefir.gnaeus.GnaeusMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.logging.log4j.Logger;

public class BlackLotus extends Item
{
    private final Logger LOGGER = NewMod.LOGGER;

    public BlackLotus(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        playerIn.addItemStackToInventory(new ItemStack(Items.DIAMOND, 3));
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        itemstack.shrink(1);
        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }
}
