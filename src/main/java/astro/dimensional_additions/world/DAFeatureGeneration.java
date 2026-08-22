package astro.dimensional_additions.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.CaveCarver;

public class DAFeatureGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BASALT_DELTAS), GenerationStep.Feature.UNDERGROUND_ORES,
                DAPlacedFeatures.NETHER_IRON_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_BARRENS, BiomeKeys.END_MIDLANDS, BiomeKeys.END_HIGHLANDS), GenerationStep.Feature.UNDERGROUND_ORES,
                DAPlacedFeatures.END_COAL_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                DAPlacedFeatures.END_DIAMOND_ORE_PLACED_KEY);
    }
}
