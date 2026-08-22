package astro.dimensional_additions.world;

import astro.dimensional_additions.DimensionalAdditions;
import astro.dimensional_additions.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class DAConfiguredFeatures {
    //Ores
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_IRON_ORE_KEY = registerKey("nether_iron_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_COAL_ORE_KEY = registerKey("end_coal_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_DIAMOND_ORE_KEY = registerKey("end_diamond_ore");

    //Trees
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDURTICA_KEY = registerKey("endurtica");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDURTICA_RARE_KEY = registerKey("endurtica_rare");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURGENTA_KEY = registerKey("purgenta");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURGENTA_RARE_KEY = registerKey("purgenta_rare");

    //Vegetation
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDURTICA_FOREST_VEGETATION_BONEMEAL = registerKey("endurtica_forest_vegetation_bonemeal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURGENTA_FOREST_VEGETATION_BONEMEAL = registerKey("purgenta_forest_vegetation_bonemeal");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest netherReplaceable = new BlockMatchRuleTest(Blocks.BLACKSTONE);
        RuleTest endReplaceable = new BlockMatchRuleTest(ModBlocks.SMOOTH_END_STONE);
        RuleTest endCoalBonus = new BlockMatchRuleTest(ModBlocks.END_COAL_ORE);

        List<OreFeatureConfig.Target> netherIronOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceable, ModBlocks.NETHER_IRON_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endDiamondOres =
                List.of(OreFeatureConfig.createTarget(endCoalBonus, ModBlocks.END_DIAMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endCoalOres =
                List.of(OreFeatureConfig.createTarget(endReplaceable, ModBlocks.END_COAL_ORE.getDefaultState()));

        register(context, NETHER_IRON_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherIronOres, 16));
        register(context, END_COAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(endCoalOres, 22));
        register(context, END_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(endDiamondOres, 10));
    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(DimensionalAdditions.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key,new ConfiguredFeature<>(feature, configuration));
    }
}
