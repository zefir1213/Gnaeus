package com.zefir.gnaeus.potions;

import com.zefir.gnaeus.particle.Freeze;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import static com.zefir.gnaeus.particle.ModParticles.FREEZE;
import static com.zefir.gnaeus.potions.Effects.FROZEN;

import java.util.Random;

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
            /*for (int i = 0; i<10; i++)
                Minecraft.getInstance().particles.addParticle(FREEZE, entityIn.posX + (double)(random.nextFloat() * entityIn.getWidth() * 2.0F) - (double)entityIn.getWidth(), entityIn.posY + 0.5D + (double)(random.nextFloat() * entityIn.getHeight()),
                        entityIn.posZ + (double)(random.nextFloat() * entityIn.getWidth() * 2.0F) - (double)entityIn.getWidth(),
                        0.0D, 0.3D, 0.0D);*/
            for (int i = 0; i<10; i++)
                    Minecraft.getInstance().particles.addParticle(FREEZE,
                    entityIn.getPosXRandom(1D), entityIn.getPosYRandom(), entityIn.getPosZRandom(1D),
                    0.0D, 0.3D, 0.0D);
            x = entityIn.getPosX();
            z = entityIn.getPosZ();
            pitch = entityIn.rotationPitch;
            yaw = entityIn.rotationYaw;
            FirstTick = false;
        }

        entityIn.setPositionAndRotation(x, entityIn.getPosY() ,z , yaw, pitch);

        super.performEffect(entityIn);
    }
}