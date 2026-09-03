package astro.dimensional_additions.mixin;

import astro.dimensional_additions.blocks.ModBlocks;
import astro.dimensional_additions.blocks.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.pathing.LandPathNodeMaker;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LandPathNodeMaker.class)
public class LandPathNodeMakerMixin {
	@Inject(method = "getCommonNodeType", at = @At("HEAD"), cancellable = true)
	private static void hazardPathfinding(BlockView world, BlockPos pos, CallbackInfoReturnable<PathNodeType> cir) {
		BlockState blockState = world.getBlockState(pos);

		if (blockState.isOf(ModBlocks.ENDURTICA_ROOTS)) {
			cir.setReturnValue(PathNodeType.DAMAGE_OTHER);
		}
		if (blockState.isOf(ModBlocks.TALL_ROSE_SHOOT)) {
			cir.setReturnValue(PathNodeType.DAMAGE_CAUTIOUS);
		}
	}

	@Inject(method = "getCommonNodeType", at = @At("HEAD"), cancellable = true)
	private static void nitrogenPathfinding(BlockView world, BlockPos pos, CallbackInfoReturnable<PathNodeType> cir) {
		FluidState fluidState = world.getFluidState(pos);

		if (fluidState.isOf(ModFluids.NITROGEN_STILL) || fluidState.isOf(ModFluids.NITROGEN_FLOWING)) {
			cir.setReturnValue(PathNodeType.POWDER_SNOW);
		}
	}
}