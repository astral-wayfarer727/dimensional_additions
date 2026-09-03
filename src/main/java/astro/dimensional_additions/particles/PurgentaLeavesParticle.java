package astro.dimensional_additions.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.LeavesParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;

@Environment(EnvType.CLIENT)
public class PurgentaLeavesParticle extends LeavesParticle {

    public PurgentaLeavesParticle(ClientWorld world, double x, double y, double z, Sprite sprite, float gravity, float f, boolean bl, boolean bl2, float size,
                                  float initialYVelocity) {
        super(world, x, y, z, sprite, gravity, f, bl, bl2, size, initialYVelocity);
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(
                SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i, Random random
        ) {
            return new PurgentaLeavesParticle(clientWorld, d, e + 1.0F, f, this.spriteProvider.getSprite(random), -0.07F, 10.0F, true, false, 2.0F, -0.021F);
        }
    }
}
