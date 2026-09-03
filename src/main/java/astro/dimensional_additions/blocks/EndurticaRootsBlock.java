package astro.dimensional_additions.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class EndurticaRootsBlock extends PlantBlock implements Fertilizable {
    protected EndurticaRootsBlock(Settings settings) {
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
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        Fertilizable.findPosToSpreadTo(world, pos, ModBlocks.ENDURTICA_ROOTS.getDefaultState())
                .ifPresent(posx -> world.setBlockState(posx, ModBlocks.ENDURTICA_ROOTS.getDefaultState()));
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
            entity.handleFallDamage(fallDistance + 2.5, 2.0F, world.getDamageSources().cactus());
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl) {
        if (entity instanceof LivingEntity) {
            entity.serverDamage(world.getDamageSources().cactus(), 1.0F);
        }
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState2 = world.getBlockState(pos.down());
        return (!blockState2.isIn(BlockTags.AIR) && !blockState2.isOf(this));
    }
}

