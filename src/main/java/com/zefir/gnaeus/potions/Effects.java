package com.zefir.gnaeus.potions;

import net.minecraft.potion.Effect;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@net.minecraftforge.registries.ObjectHolder("gnaeus")
public class Effects
{
    public static Effect FREEZE = register("freeze", new Freeze());

    private static Effect register(String key, Effect effect)
    {
        effect.setRegistryName(key);
        ForgeRegistries.POTIONS.register(effect);
        return effect;
    }
}
