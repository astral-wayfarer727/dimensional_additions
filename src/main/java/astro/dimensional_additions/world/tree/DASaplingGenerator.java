package astro.dimensional_additions.world.tree;

import astro.dimensional_additions.DimensionalAdditions;
import astro.dimensional_additions.world.DAConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class DASaplingGenerator {
    public static final SaplingGenerator ENDURTICA = new SaplingGenerator(
            DimensionalAdditions.MOD_ID + ":endurtica",
            0.1F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(DAConfiguredFeatures.ENDURTICA_KEY),
            Optional.of(DAConfiguredFeatures.ENDURTICA_RARE_KEY),
            Optional.empty(),
            Optional.empty()
    );
    public static final SaplingGenerator PURGENTA = new SaplingGenerator(
            DimensionalAdditions.MOD_ID + ":purgenta",
            0.1F,
            Optional.of(DAConfiguredFeatures.PURGENTA_KEY),
            Optional.of(DAConfiguredFeatures.PURGENTA_RARE_KEY),
            Optional.empty(),
            Optional.empty(),
            Optional.empty(),
            Optional.empty()
    );
}
