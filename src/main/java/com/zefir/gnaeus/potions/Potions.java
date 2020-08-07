package com.zefir.gnaeus.potions;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@net.minecraftforge.registries.ObjectHolder("gnaeus")
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class Potions
{
    public static Potion FREEZE_POTION = register("freeze", new Potion(new EffectInstance(Effects.FREEZE, 60)));

    private static Potion register(String key, Potion potion)
    {
        potion.setRegistryName(key);
        ForgeRegistries.POTION_TYPES.register(potion);
        return potion;
    }
}
