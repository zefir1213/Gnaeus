package com.zefir.gnaeus.potions;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;

import static com.zefir.gnaeus.particle.ModParticles.FREEZE;
import static com.zefir.gnaeus.potions.Effects.FROZEN;

public class FreezeEffectInstance extends EffectInstance
{
    private boolean FirstTick = true;
    private double x, z;

    public FreezeEffectInstance(int durationIn) {
        super(FROZEN, durationIn, 0, false, false);

    }

    @Override
    public boolean tick(LivingEntity entityIn, Runnable p_76455_2_)
    {
        performEffect(entityIn);
        return super.tick(entityIn, p_76455_2_);
    }

    @Override
    public void performEffect(LivingEntity entityIn)
    {
        if(FirstTick)
        {
            Random random = new Random();

            for (int i = 0; i<100; i++)
            {
                double yaw = random.nextDouble()*Math.PI*2;
                double pitch = random.nextDouble()*Math.PI*2;
                Minecraft.getInstance().particles.addParticle(FREEZE,
                    entityIn.getPosX(), entityIn.getPosY(), entityIn.getPosZ(),
                    Math.sin(yaw)*Math.cos(pitch), Math.sin(pitch), Math.cos(yaw)*Math.cos(pitch));
            }
            x = entityIn.getPosX();
            z = entityIn.getPosZ();
            FirstTick = false;
        }

        entityIn.setPositionAndRotation(x, entityIn.getPosY() ,z , entityIn.rotationYaw, entityIn.rotationPitch);

        super.performEffect(entityIn);
    }
}