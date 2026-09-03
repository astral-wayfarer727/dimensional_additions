package astro.dimensional_additions.blocks;

import astro.dimensional_additions.items.ModItems;
import astro.dimensional_additions.particles.DAParticles;
import astro.dimensional_additions.tags.DATags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.CollisionEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.*;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.rule.GameRules;

import java.util.Optional;

public abstract class NitrogenFluid extends FlowableFluid {

    @Override
    public Fluid getFlowing() {
        return ModFluids.NITROGEN_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.NITROGEN_STILL;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.NITROGEN_BUCKET;
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        BlockPos blockPos = pos.up();
        if (!state.isStill() && !(Boolean)state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                world.playSoundClient(
                        pos.getX() + 0.5,
                        pos.getY() + 0.5,
                        pos.getZ() + 0.5,
                        SoundEvents.BLOCK_WATER_AMBIENT,
                        SoundCategory.AMBIENT,
                        random.nextFloat() * 0.25F + 0.75F,
                        random.nextFloat() + 0.5F,
                        false
                );
            }
        }
        if (world.getBlockState(blockPos).isAir() && !world.getBlockState(blockPos).isOpaqueFullCube()) {
            if (random.nextInt(20) == 0) {
                double d = pos.getX() + random.nextDouble();
                double e = pos.getY() + 0.75;
                double f = pos.getZ() + random.nextDouble();
                world.addParticleClient(DAParticles.FROST_CLOUD, d, e, f, 0.0, 0.0, 0.0);
                world.playSoundClient(
                        d, e, f, SoundEvents.BLOCK_POWDER_SNOW_FALL, SoundCategory.AMBIENT, 0.125F + random.nextFloat() * 0.125F, 0.9F + random.nextFloat() * 0.15F, false
                );
            }
        }
    }

    @Override
    protected boolean isInfinite(ServerWorld world) {
        return world.getGameRules().getValue(GameRules.WATER_SOURCE_CONVERSION);
    }

    private void playExtinguishEvent(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
    }

    @Override
    protected void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState) {
        if (direction == Direction.DOWN) {
            FluidState fluidState2 = world.getFluidState(pos);
            if (this.isIn(DATags.Fluids.NITROGEN) && fluidState2.isIn(FluidTags.WATER)) {
                if (state.getBlock() instanceof FluidBlock) {
                    world.setBlockState(pos, ModBlocks.CERULEAN_SHALE.getDefaultState(), Block.NOTIFY_ALL);
                }

                this.playExtinguishEvent(world, pos);
                return;
            }
        }
        super.flow(world, pos, state, direction, fluidState);
    }

    @Override
    protected void onEntityCollision(World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        if (world.isClient()) {
            Random random = world.getRandom();
            boolean bl2 = entity.lastRenderX != entity.getX() || entity.lastRenderZ != entity.getZ();
            if (bl2 && random.nextBoolean()) {
                world.addParticleClient(
                        ParticleTypes.SNOWFLAKE,
                        entity.getX(),
                        pos.getY() + 1,
                        entity.getZ(),
                        MathHelper.nextBetween(random, -1.0F, 1.0F) * 0.083333336F,
                        0.05F,
                        MathHelper.nextBetween(random, -1.0F, 1.0F) * 0.083333336F
                );
            }
        }
        handler.addEvent(CollisionEvent.EXTINGUISH);
        handler.addEvent(CollisionEvent.FREEZE);
        if (entity.canFreeze()) {
            entity.setFrozenTicks(Math.min(entity.getMinFreezeDamageTicks() + 20, entity.getFrozenTicks() + 1));
            BlockState state = null;
            entity.slowMovement(null, new Vec3d(0.9F, 1.5, 0.9F));
        }
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    public int getMaxFlowDistance(WorldView world) {
        return 4;
    }

    @Override
    public int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }


    @Override
    public boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return fluid.isIn(FluidTags.WATER) || fluid.isIn(FluidTags.LAVA);
    }

    @Override
    public int getTickRate(WorldView world) {
        return 4;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }

    @Override
    public BlockState toBlockState(FluidState state) {
        return ModBlocks.NITROGEN.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == ModFluids.NITROGEN_STILL || fluid == ModFluids.NITROGEN_FLOWING;
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL);
    }

    public static class Flowing extends NitrogenFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState state) {
            return (Integer)state.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }
    }

    public static class Still extends NitrogenFluid {
        @Override
        public int getLevel(FluidState state) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }
    }
}
