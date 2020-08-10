package com.zefir.gnaeus.potions;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
@net.minecraftforge.registries.ObjectHolder("gnaeus")
public class Effects
{
    public static Effect FREEZE = register("freeze", new Frostbite());
    public static Effect FROZEN = register("frozen", new Frozen(EffectType.HARMFUL, 0x0048ba));

    private static Effect register(String key, Effect effect)
    {
        effect.setRegistryName(key);
        ForgeRegistries.POTIONS.register(effect);
        return effect;
    }
}
