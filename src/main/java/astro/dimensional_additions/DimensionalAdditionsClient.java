package astro.dimensional_additions;

import astro.dimensional_additions.blocks.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;

public class DimensionalAdditionsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.ENDURTICA_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.PURGENTA_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_ENDURTICA_SAPLING, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_PURGENTA_SAPLING, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.ENDURTICA_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ENDURTICA_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.PURGENTA_DOOR, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.ENDURTICA_LEAVES, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.PURGENTA_LEAVES, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.ROSE_SHOOT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.TALL_ROSE_SHOOT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.ENDURTICA_ROOTS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VERDANT_SHOOT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.TALL_VERDANT_SHOOT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VERDANT_SHOOT_BLOOM, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.DRIFT_BERRY_BUSH, BlockRenderLayer.CUTOUT);
    }
}
