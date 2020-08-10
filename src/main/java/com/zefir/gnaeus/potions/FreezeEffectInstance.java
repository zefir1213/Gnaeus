package com.zefir.gnaeus.potions;

import com.zefir.gnaeus.GnaeusMod;
import com.zefir.gnaeus.particle.Freeze;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;


import static com.zefir.gnaeus.particle.ModParticles.FREEZE;
import static com.zefir.gnaeus.potions.Effects.FROZEN;
import static net.minecraft.particles.ParticleTypes.CRIT;

public class FreezeEffectInstance extends EffectInstance
{
    private boolean FirstTick = true;
    private double x, y, z;
    private float pitch;
    private float yaw;

    public FreezeEffectInstance(int durationIn) {
        super(FROZEN, durationIn, 0, false, false);

    }

    @Override
    public boolean tick(LivingEntity entityIn)
    {
        performEffect(entityIn);
        return super.tick(entityIn);
    }

    @Override
    public void performEffect(LivingEntity entityIn)
    {
        if(FirstTick)
        {
            Random random = new Random();
            World world = entityIn.world;
            /*for (int i = 0; i<10; i++)world.addParticle(FREEZE.get(),  entityIn.posX + (double)(random.nextFloat() * entityIn.getWidth() * 2.0F) - (double)entityIn.getWidth(), entityIn.posY + 0.5D + (double)(random.nextFloat() * entityIn.getHeight()),
                    entityIn.posZ + (double)(random.nextFloat() * entityIn.getWidth() * 2.0F) - (double)entityIn.getWidth(),
                    0.0D, 0.3D, 0.0D);*/
            for (int i = 0; i<10; i++)
                Minecraft.getInstance().particles.addParticle(FREEZE, entityIn.posX + (double)(random.nextFloat() * entityIn.getWidth() * 2.0F) - (double)entityIn.getWidth(), entityIn.posY + 0.5D + (double)(random.nextFloat() * entityIn.getHeight()),
                        entityIn.posZ + (double)(random.nextFloat() * entityIn.getWidth() * 2.0F) - (double)entityIn.getWidth(),
                        0.0D, 0.3D, 0.0D);
            x = entityIn.posX;
            z = entityIn.posZ;
            pitch = entityIn.rotationPitch;
            yaw = entityIn.rotationYaw;
            FirstTick = false;
        }

        entityIn.setPositionAndRotation(x, entityIn.posY ,z , yaw, pitch);

        super.performEffect(entityIn);
    }
}