package com.zefir.gnaeus.particle;

import com.zefir.gnaeus.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID,bus=Mod.EventBusSubscriber.Bus.MOD)

public class ModParticles
{
    public static final BasicParticleType FREEZE = (BasicParticleType) GnaeusRegister("freeze", new BasicParticleType(false));

    private static ParticleType<?> GnaeusRegister(String name, ParticleType<?> particle)
    {
        particle.setRegistryName("gnaeus:" + name);
        ForgeRegistries.PARTICLE_TYPES.register(particle);
        return particle;
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void registerParticleFactories(ParticleFactoryRegisterEvent event)
    {
        ParticleManager particleManager = Minecraft.getInstance().particles;

        particleManager.registerFactory(ModParticles.FREEZE, Freeze.Factory::new);
    }
}