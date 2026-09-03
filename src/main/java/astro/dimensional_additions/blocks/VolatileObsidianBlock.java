package astro.dimensional_additions.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class VolatileObsidianBlock extends Block {
    public static final MapCodec<VolatileObsidianBlock> CODEC = createCodec(VolatileObsidianBlock::new);

    @Override
    public MapCodec<VolatileObsidianBlock> getCodec() {
        return CODEC;
    }

    public VolatileObsidianBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(Items.GLASS)) {
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_RESPAWN_ANCHOR_DEPLETE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (stack.isEmpty()) {
                player.setStackInHand(hand, new ItemStack(Items.END_CRYSTAL));
            } else if (!player.getInventory().insertStack(new ItemStack(Items.END_CRYSTAL))) {
                player.dropItem(new ItemStack(Items.END_CRYSTAL), false);
            }
            world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
        } else {
            return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        ServerWorld serverWorld = (ServerWorld) world;
        var silkTouchEntry = serverWorld.getRegistryManager()
                .getOrThrow(RegistryKeys.ENCHANTMENT)
                .getOptional(Enchantments.SILK_TOUCH);
        if (silkTouchEntry.isEmpty() || EnchantmentHelper.getLevel(silkTouchEntry.get(), tool) == 0) {
            if (!world.isClient() && !player.getAbilities().creativeMode) {
                world.removeBlock(pos, false);
                serverWorld.createExplosion(
                        null,
                        pos.getX() + 0.5D,
                        pos.getY() + 0.5D,
                        pos.getZ() + 0.5D,
                        5.0F,
                        true,
                        ServerWorld.ExplosionSourceType.BLOCK
                );
            }
        }
        super.afterBreak(world, player, pos, state, blockEntity, tool);
    }
}
