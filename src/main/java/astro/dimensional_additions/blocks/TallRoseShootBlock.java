package astro.dimensional_additions.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TallRoseShootBlock extends PlantBlock implements Fertilizable {
    protected TallRoseShootBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE = Block.createColumnShape(12.0, 0.0, 12.0);

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return Fertilizable.canSpread(world, pos, ModBlocks.ROSE_SHOOT.getDefaultState());
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        Fertilizable.findPosToSpreadTo(world, pos, ModBlocks.ROSE_SHOOT.getDefaultState())
                .ifPresent(posx -> world.setBlockState(posx, ModBlocks.ROSE_SHOOT.getDefaultState()));
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl) {
        if (entity instanceof LivingEntity) {
            entity.slowMovement(state, new Vec3d(0.6F, 0.5, 0.6F));
        }
    }
}

