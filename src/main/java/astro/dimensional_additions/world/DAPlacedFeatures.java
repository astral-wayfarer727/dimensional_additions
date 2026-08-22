package astro.dimensional_additions.world;

import astro.dimensional_additions.DimensionalAdditions;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class DAPlacedFeatures {

    //Ores
    public static final RegistryKey<PlacedFeature> NETHER_IRON_ORE_PLACED_KEY = registerKey("nether_iron_ore_placed");
    public static final RegistryKey<PlacedFeature> END_COAL_ORE_PLACED_KEY = registerKey("end_coal_ore_placed");
    public static final RegistryKey<PlacedFeature> END_DIAMOND_ORE_PLACED_KEY = registerKey("end_diamond_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, NETHER_IRON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(DAConfiguredFeatures.NETHER_IRON_ORE_KEY),
                modifiersWithCount(40, HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.belowTop(6))));

        register(context, END_COAL_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(DAConfiguredFeatures.END_COAL_ORE_KEY),
                modifiersWithCount(8, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-26), YOffset.fixed(36))));

        register(context, END_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(DAConfiguredFeatures.END_DIAMOND_ORE_KEY),
                modifiersWithCount(6, HeightRangePlacementModifier.uniform(YOffset.fixed(2), YOffset.fixed(16))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(DimensionalAdditions.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
}
