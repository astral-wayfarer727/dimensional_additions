package astro.dimensional_additions;

import astro.dimensional_additions.blocks.ModBlocks;
import astro.dimensional_additions.items.ModItems;
import astro.dimensional_additions.potion.DAPotions;
import astro.dimensional_additions.world.DAFeatureGeneration;
import astro.dimensional_additions.world.gen.DAWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DimensionalAdditions implements ModInitializer {
	public static final String MOD_ID = "dimensional_additions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		DAPotions.registerPotions();
		DAFeatureGeneration.generateOres();
		DAWorldGeneration.generateDAWorldGen();

		StrippableBlockRegistry.register(ModBlocks.PURGENTA_LOG, ModBlocks.STRIPPED_PURGENTA_LOG);
		StrippableBlockRegistry.register(ModBlocks.PURGENTA_WOOD, ModBlocks.STRIPPED_PURGENTA_WOOD);
		StrippableBlockRegistry.register(ModBlocks.ENDURTICA_LOG, ModBlocks.STRIPPED_ENDURTICA_LOG);
		StrippableBlockRegistry.register(ModBlocks.ENDURTICA_WOOD, ModBlocks.STRIPPED_ENDURTICA_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ENDURTICA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ENDURTICA_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ENDURTICA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ENDURTICA_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ENDURTICA_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ENDURTICA_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ENDURTICA_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ENDURTICA_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ENDURTICA_FENCE_GATE, 5, 20);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ENDURTICA_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.FLOWERING_ENDURTICA_LEAVES, 30, 60);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURGENTA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURGENTA_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PURGENTA_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_PURGENTA_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURGENTA_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURGENTA_STAIRS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURGENTA_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURGENTA_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURGENTA_FENCE_GATE, 5, 20);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.PURGENTA_LEAVES, 30, 60);

		CompostingChanceRegistry.INSTANCE.add(ModItems.DRIFT_BERRY, 0.25F);

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.DRIFT_BERRY, DAPotions.LOW_GRAVITY);
			builder.registerPotionRecipe(DAPotions.LOW_GRAVITY, Items.REDSTONE, DAPotions.LONG_LOW_GRAVITY);
			builder.registerPotionRecipe(DAPotions.LOW_GRAVITY, Items.GLOWSTONE_DUST, DAPotions.STRONG_LOW_GRAVITY);

			builder.registerPotionRecipe(DAPotions.LOW_GRAVITY, Items.FERMENTED_SPIDER_EYE, DAPotions.HIGH_GRAVITY);
			builder.registerPotionRecipe(DAPotions.LONG_LOW_GRAVITY, Items.FERMENTED_SPIDER_EYE, DAPotions.LONG_HIGH_GRAVITY);
			builder.registerPotionRecipe(DAPotions.STRONG_LOW_GRAVITY, Items.FERMENTED_SPIDER_EYE, DAPotions.STRONG_HIGH_GRAVITY);
		});
	}
}