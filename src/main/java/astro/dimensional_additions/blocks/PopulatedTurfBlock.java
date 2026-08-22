package astro.dimensional_additions.blocks;

import astro.dimensional_additions.world.DAConfiguredFeatures;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.NetherConfiguredFeatures;

public class PopulatedTurfBlock extends Block implements Fertilizable {
    public static final MapCodec<PopulatedTurfBlock> CODEC = createCodec(PopulatedTurfBlock::new);

    @Override
    public MapCodec<PopulatedTurfBlock> getCodec() {
        return CODEC;
    }

    public PopulatedTurfBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    private static boolean stayAlive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        int i = ChunkLightProvider.getRealisticOpacity(state, blockState, Direction.UP, blockState.getOpacity());
        return i < 15;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!stayAlive(state, world, pos)) {
            world.setBlockState(pos, ModBlocks.ASTRAL_TURF.getDefaultState());
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return world.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos);
        BlockPos blockPos = pos.up();
        ChunkGenerator chunkGenerator = world.getChunkManager().getChunkGenerator();
        Registry<ConfiguredFeature<?, ?>> registry = world.getRegistryManager().getOrThrow(RegistryKeys.CONFIGURED_FEATURE);
        if (blockState.isOf(ModBlocks.VERDANT_TURF)) {
            this.generate(registry, DAConfiguredFeatures.PURGENTA_FOREST_VEGETATION_BONEMEAL, world, chunkGenerator, random, blockPos);
        } else if (blockState.isOf(ModBlocks.ROSE_TURF)) {
            this.generate(registry, DAConfiguredFeatures.ENDURTICA_FOREST_VEGETATION_BONEMEAL, world, chunkGenerator, random, blockPos);
        }
    }

    private void generate(
            Registry<ConfiguredFeature<?, ?>> registry,
            RegistryKey<ConfiguredFeature<?, ?>> key,
            ServerWorld world,
            ChunkGenerator chunkGenerator,
            Random random,
            BlockPos pos
    ) {
        registry.getOptional(key).ifPresent(entry -> ((ConfiguredFeature)entry.value()).generate(world, chunkGenerator, random, pos));
    }

    @Override
    public Fertilizable.FertilizableType getFertilizableType() {
        return Fertilizable.FertilizableType.NEIGHBOR_SPREADER;
    }
}
