package astro.dimensional_additions.datagen;

import astro.dimensional_additions.blocks.DriftBerryBushBlock;
import astro.dimensional_additions.blocks.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class DAModelProvider extends FabricModelProvider {
    public DAModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Ores
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_COAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_ONYX_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_DIAMOND_ORE);

        //Endurtica Woodset
        blockStateModelGenerator.createLogTexturePool(ModBlocks.ENDURTICA_LOG).log(ModBlocks.ENDURTICA_LOG).wood(ModBlocks.ENDURTICA_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_ENDURTICA_LOG).log(ModBlocks.STRIPPED_ENDURTICA_LOG).wood(ModBlocks.STRIPPED_ENDURTICA_WOOD);

        blockStateModelGenerator.registerSingleton(ModBlocks.ENDURTICA_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSingleton(ModBlocks.FLOWERING_ENDURTICA_LEAVES, TexturedModel.LEAVES);

        BlockStateModelGenerator.BlockTexturePool endurticaPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ENDURTICA_PLANKS);
        endurticaPlankPool.stairs(ModBlocks.ENDURTICA_STAIRS);
        endurticaPlankPool.slab(ModBlocks.ENDURTICA_SLAB);
        endurticaPlankPool.fence(ModBlocks.ENDURTICA_FENCE);
        endurticaPlankPool.fenceGate(ModBlocks.ENDURTICA_FENCE_GATE);
        endurticaPlankPool.pressurePlate(ModBlocks.ENDURTICA_PRESSURE_PLATE);
        endurticaPlankPool.button(ModBlocks.ENDURTICA_BUTTON);
        blockStateModelGenerator.registerDoor(ModBlocks.ENDURTICA_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.ENDURTICA_TRAPDOOR);

        //Purgenta Woodset
        blockStateModelGenerator.createLogTexturePool(ModBlocks.PURGENTA_LOG).log(ModBlocks.PURGENTA_LOG).wood(ModBlocks.PURGENTA_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_PURGENTA_LOG).log(ModBlocks.STRIPPED_PURGENTA_LOG).wood(ModBlocks.STRIPPED_PURGENTA_WOOD);

        blockStateModelGenerator.registerSingleton(ModBlocks.PURGENTA_LEAVES, TexturedModel.LEAVES);

        BlockStateModelGenerator.BlockTexturePool purgentaPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PURGENTA_PLANKS);
        purgentaPlankPool.stairs(ModBlocks.PURGENTA_STAIRS);
        purgentaPlankPool.slab(ModBlocks.PURGENTA_SLAB);
        purgentaPlankPool.fence(ModBlocks.PURGENTA_FENCE);
        purgentaPlankPool.fenceGate(ModBlocks.PURGENTA_FENCE_GATE);
        purgentaPlankPool.pressurePlate(ModBlocks.PURGENTA_PRESSURE_PLATE);
        purgentaPlankPool.button(ModBlocks.PURGENTA_BUTTON);
        blockStateModelGenerator.registerDoor(ModBlocks.PURGENTA_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.PURGENTA_TRAPDOOR);

        //End Regolith
        BlockStateModelGenerator.BlockTexturePool smoothEndStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_END_STONE);
        smoothEndStonePool.stairs(ModBlocks.SMOOTH_END_STONE_STAIRS);
        smoothEndStonePool.slab(ModBlocks.SMOOTH_END_STONE_SLAB);
        smoothEndStonePool.wall(ModBlocks.SMOOTH_END_STONE_WALL);

        BlockStateModelGenerator.BlockTexturePool endStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.END_STONE);
        endStonePool.stairs(ModBlocks.COBBLED_END_STONE_STAIRS);
        endStonePool.slab(ModBlocks.COBBLED_END_STONE_SLAB);
        endStonePool.wall(ModBlocks.COBBLED_END_STONE_WALL);

        //Vegetation
        blockStateModelGenerator.registerTintableCross(ModBlocks.ROSE_SHOOT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TALL_ROSE_SHOOT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ENDURTICA_ROOTS, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(ModBlocks.VERDANT_SHOOT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TALL_VERDANT_SHOOT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.VERDANT_SHOOT_BLOOM, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.DRIFT_BERRY_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED,
                DriftBerryBushBlock.AGE, 0, 1, 2);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
