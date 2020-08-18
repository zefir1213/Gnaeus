package com.zefir.gnaeus.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Freeze extends SpriteTexturedParticle
{
    protected Freeze(ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(world, x, y, z, xSpeed, ySpeed, zSpeed);
    }

    @Override
    public IParticleRenderType getRenderType()
    {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Factory implements IParticleFactory<BasicParticleType>
    {
        protected final IAnimatedSprite spriteSet;
        public Factory(IAnimatedSprite sprite)
        {
            this.spriteSet = sprite;
        }

        @Nullable
        @Override
        public Particle makeParticle(BasicParticleType basicParticleType, ClientWorld clientWorld, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            SpriteTexturedParticle freeze = new Freeze(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);
            freeze.selectSpriteRandomly(spriteSet);
            return freeze ;
        }
    }
}
