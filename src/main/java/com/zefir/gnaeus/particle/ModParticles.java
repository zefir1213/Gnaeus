package com.zefir.gnaeus.particle;

import com.zefir.gnaeus.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.*;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD)
//@net.minecraftforge.registries.ObjectHolder("gnaeus")
public class ModParticles
{
    private static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "gnaeus");
    //public static final RegistryObject<BasicParticleType> FREEZE = PARTICLES.register("freeze", () -> new BasicParticleType(false));

    public static final BasicParticleType FREEZE = register("gnaeus:freeze", false);

    private static BasicParticleType register(String key, boolean alwaysShow)
    {

        return (BasicParticleType)Registry.<ParticleType<? extends IParticleData>>register(Registry.PARTICLE_TYPE, key, new BasicParticleType(alwaysShow));
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerParticleFactories(ParticleFactoryRegisterEvent event)
    {
        ParticleManager particleManager = Minecraft.getInstance().particles;

        particleManager.registerFactory(ModParticles.FREEZE, Freeze.Factory::new);
    }
}