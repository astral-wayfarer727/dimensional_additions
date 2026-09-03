package astro.dimensional_additions.blocks;

import astro.dimensional_additions.tags.DATags;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class EndPlantBlock extends PlantBlock {
    protected EndPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState2 = world.getBlockState(pos.down());
        return (blockState2.isIn(DATags.Blocks.TURF) || blockState2.isIn(BlockTags.DIRT) && !blockState2.isIn(BlockTags.AIR) && !blockState2.isOf(this));
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }
}
