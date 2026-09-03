package astro.dimensional_additions.datagen;

import astro.dimensional_additions.blocks.ModBlocks;
import astro.dimensional_additions.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class DALootTableProvider extends FabricBlockLootTableProvider {RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
    protected DALootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //Purgenta Woodset
        addDrop(ModBlocks.PURGENTA_LOG);
        addDrop(ModBlocks.STRIPPED_PURGENTA_LOG);
        addDrop(ModBlocks.PURGENTA_WOOD);
        addDrop(ModBlocks.STRIPPED_PURGENTA_WOOD);
        addDrop(ModBlocks.PURGENTA_SAPLING);
        addDrop(ModBlocks.POTTED_PURGENTA_SAPLING, pottedPlantDrops(ModBlocks.PURGENTA_SAPLING));
        addDrop(ModBlocks.PURGENTA_PLANKS);
        addDrop(ModBlocks.PURGENTA_STAIRS);
        addDrop(ModBlocks.PURGENTA_SLAB, slabDrops(ModBlocks.PURGENTA_SLAB));
        addDrop(ModBlocks.PURGENTA_FENCE);
        addDrop(ModBlocks.PURGENTA_FENCE_GATE);
        addDrop(ModBlocks.PURGENTA_DOOR, doorDrops(ModBlocks.PURGENTA_DOOR));
        addDrop(ModBlocks.PURGENTA_TRAPDOOR);
        addDrop(ModBlocks.PURGENTA_PRESSURE_PLATE);
        addDrop(ModBlocks.PURGENTA_BUTTON);
        
        //Endurtica Woodset
        addDrop(ModBlocks.ENDURTICA_LOG);
        addDrop(ModBlocks.STRIPPED_ENDURTICA_LOG);
        addDrop(ModBlocks.ENDURTICA_WOOD);
        addDrop(ModBlocks.STRIPPED_ENDURTICA_WOOD);
        addDrop(ModBlocks.ENDURTICA_SAPLING);
        addDrop(ModBlocks.POTTED_ENDURTICA_SAPLING, pottedPlantDrops(ModBlocks.ENDURTICA_SAPLING));
        addDrop(ModBlocks.ENDURTICA_PLANKS);
        addDrop(ModBlocks.ENDURTICA_STAIRS);
        addDrop(ModBlocks.ENDURTICA_SLAB, slabDrops(ModBlocks.ENDURTICA_SLAB));
        addDrop(ModBlocks.ENDURTICA_FENCE);
        addDrop(ModBlocks.ENDURTICA_FENCE_GATE);
        addDrop(ModBlocks.ENDURTICA_DOOR, doorDrops(ModBlocks.ENDURTICA_DOOR));
        addDrop(ModBlocks.ENDURTICA_TRAPDOOR);
        addDrop(ModBlocks.ENDURTICA_PRESSURE_PLATE);
        addDrop(ModBlocks.ENDURTICA_BUTTON);

        //End Regolith
        addDrop(ModBlocks.SMOOTH_END_STONE_STAIRS);
        addDrop(ModBlocks.SMOOTH_END_STONE_SLAB, slabDrops(ModBlocks.SMOOTH_END_STONE_SLAB));
        addDrop(ModBlocks.SMOOTH_END_STONE_WALL);

        addDrop(ModBlocks.COBBLED_END_STONE_STAIRS);
        addDrop(ModBlocks.COBBLED_END_STONE_SLAB, slabDrops(ModBlocks.COBBLED_END_STONE_SLAB));
        addDrop(ModBlocks.COBBLED_END_STONE_WALL);

        //Shale Blocksets
        addDrop(ModBlocks.CERULEAN_SHALE);
        addDrop(ModBlocks.CERULEAN_SHALE_STAIRS);
        addDrop(ModBlocks.CERULEAN_SHALE_SLAB, slabDrops(ModBlocks.CERULEAN_SHALE_SLAB));
        addDrop(ModBlocks.CERULEAN_SHALE_WALL);
        addDrop(ModBlocks.CERULEAN_SHALE_BRICKS);
        addDrop(ModBlocks.CERULEAN_SHALE_BRICK_STAIRS);
        addDrop(ModBlocks.CERULEAN_SHALE_BRICK_SLAB, slabDrops(ModBlocks.CERULEAN_SHALE_BRICK_SLAB));
        addDrop(ModBlocks.CERULEAN_SHALE_BRICK_WALL);
        addDrop(ModBlocks.CERULEAN_SHALE_TILES);
        addDrop(ModBlocks.CERULEAN_SHALE_TILE_STAIRS);
        addDrop(ModBlocks.CERULEAN_SHALE_TILE_SLAB, slabDrops(ModBlocks.CERULEAN_SHALE_TILE_SLAB));
        addDrop(ModBlocks.CERULEAN_SHALE_TILE_WALL);
        addDrop(ModBlocks.POLISHED_CERULEAN_SHALE);
        addDrop(ModBlocks.POLISHED_CERULEAN_SHALE_STAIRS);
        addDrop(ModBlocks.POLISHED_CERULEAN_SHALE_SLAB, slabDrops(ModBlocks.POLISHED_CERULEAN_SHALE_SLAB));
        addDrop(ModBlocks.POLISHED_CERULEAN_SHALE_WALL);

        addDrop(ModBlocks.NAVY_SHALE);
        addDrop(ModBlocks.NAVY_SHALE_STAIRS);
        addDrop(ModBlocks.NAVY_SHALE_SLAB, slabDrops(ModBlocks.NAVY_SHALE_SLAB));
        addDrop(ModBlocks.NAVY_SHALE_WALL);
        addDrop(ModBlocks.NAVY_SHALE_BRICKS);
        addDrop(ModBlocks.NAVY_SHALE_BRICK_STAIRS);
        addDrop(ModBlocks.NAVY_SHALE_BRICK_SLAB, slabDrops(ModBlocks.NAVY_SHALE_BRICK_SLAB));
        addDrop(ModBlocks.NAVY_SHALE_BRICK_WALL);
        addDrop(ModBlocks.NAVY_SHALE_TILES);
        addDrop(ModBlocks.NAVY_SHALE_TILE_STAIRS);
        addDrop(ModBlocks.NAVY_SHALE_TILE_SLAB, slabDrops(ModBlocks.NAVY_SHALE_TILE_SLAB));
        addDrop(ModBlocks.NAVY_SHALE_TILE_WALL);
        addDrop(ModBlocks.POLISHED_NAVY_SHALE);
        addDrop(ModBlocks.POLISHED_NAVY_SHALE_STAIRS);
        addDrop(ModBlocks.POLISHED_NAVY_SHALE_SLAB, slabDrops(ModBlocks.POLISHED_NAVY_SHALE_SLAB));
        addDrop(ModBlocks.POLISHED_NAVY_SHALE_WALL);

        //Onyx Blockset
        addDrop(ModBlocks.ONYX_BLOCK);
        addDrop(ModBlocks.ONYX_STAIRS);
        addDrop(ModBlocks.ONYX_SLAB, slabDrops(ModBlocks.ONYX_SLAB));
        addDrop(ModBlocks.SMOOTH_ONYX_BLOCK);
        addDrop(ModBlocks.SMOOTH_ONYX_STAIRS);
        addDrop(ModBlocks.SMOOTH_ONYX_SLAB, slabDrops(ModBlocks.SMOOTH_ONYX_SLAB));
        addDrop(ModBlocks.ONYX_BRICKS);
        addDrop(ModBlocks.ONYX_BRICK_STAIRS);
        addDrop(ModBlocks.ONYX_BRICK_SLAB, slabDrops(ModBlocks.ONYX_BRICK_SLAB));
        addDrop(ModBlocks.ONYX_BRICK_WALL);
        addDrop(ModBlocks.CHISELED_ONYX_BLOCK);
        addDrop(ModBlocks.ONYX_PILLAR);

        //Vegetation
        addDrop(ModBlocks.ROSE_SHOOT, dropsWithShears(ModBlocks.ROSE_SHOOT));
        addDrop(ModBlocks.TALL_ROSE_SHOOT, dropsWithShears(ModBlocks.TALL_ROSE_SHOOT));
        addDropWithSilkTouch(ModBlocks.ENDURTICA_ROOTS);

        addDrop(ModBlocks.VERDANT_SHOOT, dropsWithShears(ModBlocks.VERDANT_SHOOT));
        addDrop(ModBlocks.TALL_VERDANT_SHOOT, dropsWithShears(ModBlocks.TALL_VERDANT_SHOOT));
        addDrop(ModBlocks.VERDANT_SHOOT_BLOOM);

        addDrop(ModBlocks.PYGMY_CHORUS, dropsWithShears(ModBlocks.PYGMY_CHORUS));
        addDrop(ModBlocks.POTTED_PYGMY_CHORUS, pottedPlantDrops(ModBlocks.PYGMY_CHORUS));
        addDrop(ModBlocks.SEDUM);
        addDrop(ModBlocks.POTTED_SEDUM, pottedPlantDrops(ModBlocks.SEDUM));

        addDrop(ModBlocks.DRIFT_BERRY_BUSH, block -> this.applyExplosionDecay(block,
            LootTable.builder().pool(LootPool.builder().conditionally(
                BlockStatePropertyLootCondition.builder(ModBlocks.DRIFT_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(SweetBerryBushBlock.AGE, 2)))
                .with(ItemEntry.builder(ModItems.DRIFT_BERRY))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
            )
        ));

        //Vanilla Block Expansion
        addDrop(ModBlocks.SMOOTH_PURPUR_STAIRS);
        addDrop(ModBlocks.SMOOTH_PURPUR_SLAB, slabDrops(ModBlocks.SMOOTH_PURPUR_SLAB));
        addDrop(ModBlocks.SMOOTH_PURPUR_WALL);
        addDrop(ModBlocks.PURPUR_BRICK_WALL);

        addDrop(ModBlocks.CALCITE_PILLAR);
        addDrop(ModBlocks.POLISHED_CALCITE_PILLAR);

        addDropWithSilkTouch(ModBlocks.VOLATILE_OBSIDIAN);
    }
}
