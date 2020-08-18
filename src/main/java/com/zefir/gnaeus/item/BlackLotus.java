package com.zefir.gnaeus.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class BlackLotus extends Item
{

    public BlackLotus(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        int r=random.nextInt(10)+5;
        for(int i=0; i<r; i++) playerIn.world.addParticle(ParticleTypes.HAPPY_VILLAGER, playerIn.getPosX() + (double)(random.nextFloat() * playerIn.getWidth() * 2.0F) - (double)playerIn.getWidth(), playerIn.getPosY() + 0.5D + (double)(random.nextFloat() * playerIn.getHeight()), playerIn.getPosY() + (double)(random.nextFloat() * playerIn.getWidth() * 2.0F) - (double)playerIn.getWidth(), 0.0D, 0.3D, 0.0D);
        playerIn.addItemStackToInventory(new ItemStack(Items.DIAMOND, 3));
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!playerIn.abilities.isCreativeMode) itemstack.shrink(1);
        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }

}
