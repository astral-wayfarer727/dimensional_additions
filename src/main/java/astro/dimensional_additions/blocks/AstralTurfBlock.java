package astro.dimensional_additions.blocks;

import astro.dimensional_additions.tags.DATags;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class AstralTurfBlock extends Block implements Fertilizable {
    public static final MapCodec<AstralTurfBlock> CODEC = createCodec(AstralTurfBlock::new);

    @Override
    public MapCodec<AstralTurfBlock> getCodec() {
        return CODEC;
    }

    public AstralTurfBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        if (!world.getBlockState(pos.up()).isTransparent()) {
            return false;
        } else {
            for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
                if (world.getBlockState(blockPos).isIn(DATags.Blocks.TURF)) {
                    return true;
                }
            }

            return false;
        }
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        boolean bl = false;
        boolean bl2 = false;

        for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(ModBlocks.VERDANT_TURF)) {
                bl2 = true;
            }

            if (blockState.isOf(ModBlocks.ROSE_TURF)) {
                bl = true;
            }

            if (bl2 && bl) {
                break;
            }
        }

        if (bl2 && bl) {
            world.setBlockState(pos, random.nextBoolean() ? ModBlocks.VERDANT_TURF.getDefaultState() : ModBlocks.ROSE_TURF.getDefaultState(), Block.NOTIFY_ALL);
        } else if (bl2) {
            world.setBlockState(pos, ModBlocks.VERDANT_TURF.getDefaultState(), Block.NOTIFY_ALL);
        } else if (bl) {
            world.setBlockState(pos, ModBlocks.ROSE_TURF.getDefaultState(), Block.NOTIFY_ALL);
        }
    }

    @Override
    public Fertilizable.FertilizableType getFertilizableType() {
        return Fertilizable.FertilizableType.NEIGHBOR_SPREADER;
    }
}
