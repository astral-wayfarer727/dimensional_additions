package astro.dimensional_additions.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;
import org.jspecify.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class FrostCloudParticle extends BillboardParticle {
    private final SpriteProvider spriteProvider;

    public FrostCloudParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider) {

        super(world, x, y, z, spriteProvider.getFirst());
        this.gravityStrength = -0.05F;
        this.velocityY = 0.01F;
        this.spriteProvider = spriteProvider;
        this.scale = 0.66F * (this.random.nextFloat() * 0.25F + 0.75F);
        this.maxAge = (int)(40.0 * (this.random.nextFloat() * 1.1 + 0.9));
        this.updateSprite(spriteProvider);
    }

    @Override
    protected BillboardParticle.RenderType getRenderType() {
        return BillboardParticle.RenderType.PARTICLE_ATLAS_OPAQUE;
    }

    @Override
    public void tick() {
        super.tick();
        this.updateSprite(this.spriteProvider);
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double d, double e, double f, double g, double h, double i, Random random) {
            return new FrostCloudParticle(world, d, e, f, this.spriteProvider);
        }
    }
}
