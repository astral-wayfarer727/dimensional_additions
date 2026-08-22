package astro.dimensional_additions.datagen;

import astro.dimensional_additions.blocks.ModBlocks;
import astro.dimensional_additions.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
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

        //Vegetation
        addDrop(ModBlocks.ROSE_SHOOT, dropsWithShears(ModBlocks.ROSE_SHOOT));
        addDrop(ModBlocks.TALL_ROSE_SHOOT, dropsWithShears(ModBlocks.TALL_ROSE_SHOOT));
        addDropWithSilkTouch(ModBlocks.ENDURTICA_ROOTS);

        addDrop(ModBlocks.VERDANT_SHOOT, dropsWithShears(ModBlocks.VERDANT_SHOOT));
        addDrop(ModBlocks.TALL_VERDANT_SHOOT, dropsWithShears(ModBlocks.TALL_VERDANT_SHOOT));
        addDrop(ModBlocks.VERDANT_SHOOT_BLOOM);

        addDrop(ModBlocks.DRIFT_BERRY_BUSH, block -> this.applyExplosionDecay(block,
            LootTable.builder().pool(LootPool.builder().conditionally(
                BlockStatePropertyLootCondition.builder(ModBlocks.DRIFT_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(SweetBerryBushBlock.AGE, 2)))
                .with(ItemEntry.builder(ModItems.DRIFT_BERRY))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
            )
        ));
    }
}
