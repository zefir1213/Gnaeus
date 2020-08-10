package com.zefir.gnaeus.item;

import com.zefir.gnaeus.particle.Freeze;
import com.zefir.gnaeus.potions.Effects;
import com.zefir.gnaeus.potions.FreezeEffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;

public class IceDagger extends SwordItem
{

    public IceDagger()
    {
        super(ModItemTier.ICE, 6, -2F, (new Item.Properties()).group(ItemGroup.COMBAT));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        for (EffectInstance effect : target.getActivePotionEffects()) {
            if (effect.getPotion() == Effects.FROZEN) {
                attacker.addPotionEffect(new EffectInstance(net.minecraft.potion.Effects.SPEED, 99, 4));
            }
        }
        target.addPotionEffect(new FreezeEffectInstance(88));
        return super.hitEntity(stack, target, attacker);
    }


}
