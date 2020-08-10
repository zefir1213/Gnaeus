package com.zefir.gnaeus.potions;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class Frostbite extends Effect
{
    protected Frostbite()
    {
        super(EffectType.HARMFUL, 0x0048ba);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
    }
}