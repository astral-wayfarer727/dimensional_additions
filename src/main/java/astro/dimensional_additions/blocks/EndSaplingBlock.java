package astro.dimensional_additions.blocks;

import astro.dimensional_additions.tags.DATags;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class EndSaplingBlock extends SaplingBlock {
    public EndSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState2 = world.getBlockState(pos.down());
        return (blockState2.isIn(DATags.Blocks.TURF) || blockState2.isIn(BlockTags.DIRT) && !blockState2.isIn(BlockTags.AIR) && !blockState2.isOf(this));
    }
}
