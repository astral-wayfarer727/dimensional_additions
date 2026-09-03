package astro.dimensional_additions.particles;

import astro.dimensional_additions.DimensionalAdditions;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class DAParticles {

    public static final SimpleParticleType FROST_CLOUD = registerParticle("frost_cloud", FabricParticleTypes.simple());
    public static final SimpleParticleType ENDURTICA_ROSE = registerParticle("endurtica_rose", FabricParticleTypes.simple());
    public static final SimpleParticleType PURGENTA_LEAVES = registerParticle("purgenta_leaves", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(DimensionalAdditions.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        DimensionalAdditions.LOGGER.info("Registering Particles for " + DimensionalAdditions.MOD_ID);
    }
}
