package astro.dimensional_additions.blocks;

import astro.dimensional_additions.tags.DATags;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class EndFlowerBlock extends FlowerBlock {

    public EndFlowerBlock(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, Settings settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState2 = world.getBlockState(pos.down());
        return (blockState2.isIn(DATags.Blocks.TURF) || blockState2.isIn(DATags.Blocks.VALID_FLOWER_BLOCKS) && !blockState2.isIn(BlockTags.AIR) && !blockState2.isOf(this));
    }
}
