package astro.dimensional_additions.datagen;

import astro.dimensional_additions.blocks.DriftBerryBushBlock;
import astro.dimensional_additions.blocks.ModBlocks;
import astro.dimensional_additions.items.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
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

        //Shale Blocksets
        BlockStateModelGenerator.BlockTexturePool ceruleanShalePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CERULEAN_SHALE);
        ceruleanShalePool.stairs(ModBlocks.CERULEAN_SHALE_STAIRS);
        ceruleanShalePool.slab(ModBlocks.CERULEAN_SHALE_SLAB);
        ceruleanShalePool.wall(ModBlocks.CERULEAN_SHALE_WALL);
        BlockStateModelGenerator.BlockTexturePool ceruleanShaleBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CERULEAN_SHALE_BRICKS);
        ceruleanShaleBrickPool.stairs(ModBlocks.CERULEAN_SHALE_BRICK_STAIRS);
        ceruleanShaleBrickPool.slab(ModBlocks.CERULEAN_SHALE_BRICK_SLAB);
        ceruleanShaleBrickPool.wall(ModBlocks.CERULEAN_SHALE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool ceruleanShaleTilePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CERULEAN_SHALE_TILES);
        ceruleanShaleTilePool.stairs(ModBlocks.CERULEAN_SHALE_TILE_STAIRS);
        ceruleanShaleTilePool.slab(ModBlocks.CERULEAN_SHALE_TILE_SLAB);
        ceruleanShaleTilePool.wall(ModBlocks.CERULEAN_SHALE_TILE_WALL);
        BlockStateModelGenerator.BlockTexturePool polishedCeruleanShalePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_CERULEAN_SHALE);
        polishedCeruleanShalePool.stairs(ModBlocks.POLISHED_CERULEAN_SHALE_STAIRS);
        polishedCeruleanShalePool.slab(ModBlocks.POLISHED_CERULEAN_SHALE_SLAB);
        polishedCeruleanShalePool.wall(ModBlocks.POLISHED_CERULEAN_SHALE_WALL);

        BlockStateModelGenerator.BlockTexturePool navyShalePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.NAVY_SHALE);
        navyShalePool.stairs(ModBlocks.NAVY_SHALE_STAIRS);
        navyShalePool.slab(ModBlocks.NAVY_SHALE_SLAB);
        navyShalePool.wall(ModBlocks.NAVY_SHALE_WALL);
        BlockStateModelGenerator.BlockTexturePool navyShaleBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.NAVY_SHALE_BRICKS);
        navyShaleBrickPool.stairs(ModBlocks.NAVY_SHALE_BRICK_STAIRS);
        navyShaleBrickPool.slab(ModBlocks.NAVY_SHALE_BRICK_SLAB);
        navyShaleBrickPool.wall(ModBlocks.NAVY_SHALE_BRICK_WALL);
        BlockStateModelGenerator.BlockTexturePool navyShaleTilePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.NAVY_SHALE_TILES);
        navyShaleTilePool.stairs(ModBlocks.NAVY_SHALE_TILE_STAIRS);
        navyShaleTilePool.slab(ModBlocks.NAVY_SHALE_TILE_SLAB);
        navyShaleTilePool.wall(ModBlocks.NAVY_SHALE_TILE_WALL);
        BlockStateModelGenerator.BlockTexturePool polishedNavyShalePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_NAVY_SHALE);
        polishedNavyShalePool.stairs(ModBlocks.POLISHED_NAVY_SHALE_STAIRS);
        polishedNavyShalePool.slab(ModBlocks.POLISHED_NAVY_SHALE_SLAB);
        polishedNavyShalePool.wall(ModBlocks.POLISHED_NAVY_SHALE_WALL);

        //Onyx Blockset
        BlockStateModelGenerator.BlockTexturePool onyxPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ONYX_BLOCK);
        onyxPool.stairs(ModBlocks.ONYX_STAIRS);
        onyxPool.slab(ModBlocks.ONYX_SLAB);
        BlockStateModelGenerator.BlockTexturePool smoothOnyxPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_ONYX_BLOCK);
        smoothOnyxPool.stairs(ModBlocks.SMOOTH_ONYX_STAIRS);
        smoothOnyxPool.slab(ModBlocks.SMOOTH_ONYX_SLAB);
        BlockStateModelGenerator.BlockTexturePool onyxBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ONYX_BRICKS);
        onyxBrickPool.stairs(ModBlocks.ONYX_BRICK_STAIRS);
        onyxBrickPool.slab(ModBlocks.ONYX_BRICK_SLAB);
        onyxBrickPool.wall(ModBlocks.ONYX_BRICK_WALL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.ONYX_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);

        //Vegetation
        blockStateModelGenerator.registerTintableCross(ModBlocks.ROSE_SHOOT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TALL_ROSE_SHOOT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ENDURTICA_ROOTS, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(ModBlocks.VERDANT_SHOOT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.TALL_VERDANT_SHOOT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.VERDANT_SHOOT_BLOOM, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCross(ModBlocks.SEDUM, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.PYGMY_CHORUS, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.DRIFT_BERRY_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED,
                DriftBerryBushBlock.AGE, 0, 1, 2);

        //Vanilla Block Expansion
        blockStateModelGenerator.registerAxisRotated(ModBlocks.CALCITE_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.POLISHED_CALCITE_PILLAR, TexturedModel.END_FOR_TOP_CUBE_COLUMN, TexturedModel.END_FOR_TOP_CUBE_COLUMN_HORIZONTAL);
        BlockStateModelGenerator.BlockTexturePool smoothPurpurPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SMOOTH_PURPUR);
        smoothPurpurPool.stairs(ModBlocks.SMOOTH_PURPUR_STAIRS);
        smoothPurpurPool.slab(ModBlocks.SMOOTH_PURPUR_SLAB);
        smoothPurpurPool.wall(ModBlocks.SMOOTH_PURPUR_WALL);

        BlockStateModelGenerator.BlockTexturePool purpurPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PURPUR_BLOCK);
        purpurPool.wall(ModBlocks.PURPUR_BRICK_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOLATILE_OBSIDIAN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.NITROGEN_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONYX, Models.GENERATED);
    }
}
