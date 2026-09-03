package astro.dimensional_additions;

import astro.dimensional_additions.blocks.ModBlocks;
import astro.dimensional_additions.blocks.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

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
        BlockRenderLayerMap.putBlock(ModBlocks.SEDUM, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_SEDUM, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.PYGMY_CHORUS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.POTTED_PYGMY_CHORUS, BlockRenderLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(ModBlocks.NITROGEN, BlockRenderLayer.TRANSLUCENT);
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.NITROGEN_STILL, ModFluids.NITROGEN_FLOWING,
                new SimpleFluidRenderHandler(
                        Identifier.of("dimensional_additions:block/nitrogen"),
                        Identifier.of("dimensional_additions:block/flowing_nitrogen")
                ));
        BlockRenderLayerMap.putFluids(BlockRenderLayer.TRANSLUCENT,
                ModFluids.NITROGEN_STILL, ModFluids.NITROGEN_FLOWING);
    }
}
