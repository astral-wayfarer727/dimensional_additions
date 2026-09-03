package astro.dimensional_additions.blocks;

import astro.dimensional_additions.tags.DATags;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TallVerdantShootBlock extends EndPlantBlock implements Fertilizable {
    protected TallVerdantShootBlock(Settings settings) {
        super(settings);
    }
    private static final VoxelShape SHAPE = Block.createColumnShape(12.0, 0.0, 12.0);
    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, ModBlocks.VERDANT_SHOOT_BLOOM.getDefaultState());
    }
}
