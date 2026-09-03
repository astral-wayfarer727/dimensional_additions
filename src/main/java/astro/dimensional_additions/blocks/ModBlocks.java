package astro.dimensional_additions.blocks;

import astro.dimensional_additions.DimensionalAdditions;
import astro.dimensional_additions.particles.DAParticles;
import astro.dimensional_additions.world.tree.DASaplingGenerator;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.TintedParticleEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.spongepowered.include.com.google.common.base.Function;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {

    private static Block register(String name, Function<AbstractBlock.Settings, Block> factory,AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(DimensionalAdditions.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }
    //Ores
    public static Block NETHER_IRON_ORE = register("nether_iron_ore",
            settings -> new ExperienceDroppingBlock(ConstantIntProvider.create(0), settings), AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool().strength(3.0F, 6.0F));
    public static Block END_DIAMOND_ORE = register("end_diamond_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings), AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool().strength(4.0F, 9.0F));
    public static Block END_ONYX_ORE = register("end_onyx_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), settings),
            AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool().strength(3.5F, 9.0F));
    public static Block END_COAL_ORE = register("end_coal_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(0, 2), settings), AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool().strength(3.0F, 9.0F));

    //End Regolith
    public static final Block SMOOTH_END_STONE = register("smooth_end_stone",
            Block::new, AbstractBlock.Settings.copy(Blocks.END_STONE).strength(2.5F, 9.0F));
    public static Block SMOOTH_END_STONE_STAIRS = register("smooth_end_stone_stairs",
            settings -> new StairsBlock(SMOOTH_END_STONE.getDefaultState(), settings),
            Block.Settings.copy(SMOOTH_END_STONE));
    public static SlabBlock SMOOTH_END_STONE_SLAB = (SlabBlock) register("smooth_end_stone_slab",
            SlabBlock::new, Block.Settings.copy(SMOOTH_END_STONE));
    public static WallBlock SMOOTH_END_STONE_WALL = (WallBlock) register("smooth_end_stone_wall",
            WallBlock::new, Block.Settings.copy(SMOOTH_END_STONE));

    public static Block ASTRAL_TURF = register("astral_turf",
            AstralTurfBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.7F).sounds(BlockSoundGroup.NYLIUM));
    public static Block VERDANT_TURF = register("verdant_turf",
            PopulatedTurfBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).strength(0.8F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly());
    public static Block ROSE_TURF = register("rose_turf",
            PopulatedTurfBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).strength(0.8F).sounds(BlockSoundGroup.NYLIUM).ticksRandomly());

    //Shale Blocksets
    public static final Block CERULEAN_SHALE = register("cerulean_shale",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F));
    public static Block CERULEAN_SHALE_STAIRS = register("cerulean_shale_stairs",
            settings -> new StairsBlock(CERULEAN_SHALE.getDefaultState(), settings),
            Block.Settings.copy(CERULEAN_SHALE));
    public static SlabBlock CERULEAN_SHALE_SLAB = (SlabBlock) register("cerulean_shale_slab",
            SlabBlock::new, Block.Settings.copy(CERULEAN_SHALE));
    public static WallBlock CERULEAN_SHALE_WALL = (WallBlock) register("cerulean_shale_wall",
            WallBlock::new, Block.Settings.copy(CERULEAN_SHALE));

    public static final Block CERULEAN_SHALE_BRICKS = register("cerulean_shale_bricks",
            Block::new, AbstractBlock.Settings.copy(CERULEAN_SHALE));
    public static Block CERULEAN_SHALE_BRICK_STAIRS = register("cerulean_shale_brick_stairs",
            settings -> new StairsBlock(CERULEAN_SHALE_BRICKS.getDefaultState(), settings),
            Block.Settings.copy(CERULEAN_SHALE_BRICKS));
    public static SlabBlock CERULEAN_SHALE_BRICK_SLAB = (SlabBlock) register("cerulean_shale_brick_slab",
            SlabBlock::new, Block.Settings.copy(CERULEAN_SHALE_BRICKS));
    public static WallBlock CERULEAN_SHALE_BRICK_WALL = (WallBlock) register("cerulean_shale_brick_wall",
            WallBlock::new, Block.Settings.copy(CERULEAN_SHALE_BRICKS));

    public static final Block CERULEAN_SHALE_TILES = register("cerulean_shale_tiles",
            Block::new, AbstractBlock.Settings.copy(CERULEAN_SHALE));
    public static Block CERULEAN_SHALE_TILE_STAIRS = register("cerulean_shale_tile_stairs",
            settings -> new StairsBlock(CERULEAN_SHALE_TILES.getDefaultState(), settings),
            Block.Settings.copy(CERULEAN_SHALE_TILES));
    public static SlabBlock CERULEAN_SHALE_TILE_SLAB = (SlabBlock) register("cerulean_shale_tile_slab",
            SlabBlock::new, Block.Settings.copy(CERULEAN_SHALE_TILES));
    public static WallBlock CERULEAN_SHALE_TILE_WALL = (WallBlock) register("cerulean_shale_tile_wall",
            WallBlock::new, Block.Settings.copy(CERULEAN_SHALE_TILES));

    public static final Block POLISHED_CERULEAN_SHALE = register("polished_cerulean_shale",
            Block::new, AbstractBlock.Settings.copy(CERULEAN_SHALE));
    public static Block POLISHED_CERULEAN_SHALE_STAIRS = register("polished_cerulean_shale_stairs",
            settings -> new StairsBlock(POLISHED_CERULEAN_SHALE.getDefaultState(), settings),
            Block.Settings.copy(POLISHED_CERULEAN_SHALE));
    public static SlabBlock POLISHED_CERULEAN_SHALE_SLAB = (SlabBlock) register("polished_cerulean_shale_slab",
            SlabBlock::new, Block.Settings.copy(POLISHED_CERULEAN_SHALE));
    public static WallBlock POLISHED_CERULEAN_SHALE_WALL = (WallBlock) register("polished_cerulean_shale_wall",
            WallBlock::new, Block.Settings.copy(POLISHED_CERULEAN_SHALE));

    public static final Block NAVY_SHALE = register("navy_shale",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(1.5F, 6.0F));
    public static Block NAVY_SHALE_STAIRS = register("navy_shale_stairs",
            settings -> new StairsBlock(NAVY_SHALE.getDefaultState(), settings),
            Block.Settings.copy(NAVY_SHALE));
    public static SlabBlock NAVY_SHALE_SLAB = (SlabBlock) register("navy_shale_slab",
            SlabBlock::new, Block.Settings.copy(NAVY_SHALE));
    public static WallBlock NAVY_SHALE_WALL = (WallBlock) register("navy_shale_wall",
            WallBlock::new, Block.Settings.copy(NAVY_SHALE));

    public static final Block NAVY_SHALE_BRICKS = register("navy_shale_bricks",
            Block::new, AbstractBlock.Settings.copy(NAVY_SHALE));
    public static Block NAVY_SHALE_BRICK_STAIRS = register("navy_shale_brick_stairs",
            settings -> new StairsBlock(NAVY_SHALE_BRICKS.getDefaultState(), settings),
            Block.Settings.copy(NAVY_SHALE_BRICKS));
    public static SlabBlock NAVY_SHALE_BRICK_SLAB = (SlabBlock) register("navy_shale_brick_slab",
            SlabBlock::new, Block.Settings.copy(NAVY_SHALE_BRICKS));
    public static WallBlock NAVY_SHALE_BRICK_WALL = (WallBlock) register("navy_shale_brick_wall",
            WallBlock::new, Block.Settings.copy(NAVY_SHALE_BRICKS));

    public static final Block NAVY_SHALE_TILES = register("navy_shale_tiles",
            Block::new, AbstractBlock.Settings.copy(NAVY_SHALE));
    public static Block NAVY_SHALE_TILE_STAIRS = register("navy_shale_tile_stairs",
            settings -> new StairsBlock(NAVY_SHALE_TILES.getDefaultState(), settings),
            Block.Settings.copy(NAVY_SHALE_TILES));
    public static SlabBlock NAVY_SHALE_TILE_SLAB = (SlabBlock) register("navy_shale_tile_slab",
            SlabBlock::new, Block.Settings.copy(NAVY_SHALE_TILES));
    public static WallBlock NAVY_SHALE_TILE_WALL = (WallBlock) register("navy_shale_tile_wall",
            WallBlock::new, Block.Settings.copy(NAVY_SHALE_TILES));

    public static final Block POLISHED_NAVY_SHALE = register("polished_navy_shale",
            Block::new, AbstractBlock.Settings.copy(NAVY_SHALE));
    public static Block POLISHED_NAVY_SHALE_STAIRS = register("polished_navy_shale_stairs",
            settings -> new StairsBlock(POLISHED_NAVY_SHALE.getDefaultState(), settings),
            Block.Settings.copy(POLISHED_NAVY_SHALE));
    public static SlabBlock POLISHED_NAVY_SHALE_SLAB = (SlabBlock) register("polished_navy_shale_slab",
            SlabBlock::new, Block.Settings.copy(POLISHED_NAVY_SHALE));
    public static WallBlock POLISHED_NAVY_SHALE_WALL = (WallBlock) register("polished_navy_shale_wall",
            WallBlock::new, Block.Settings.copy(POLISHED_NAVY_SHALE));

    //Onyx Blockset
    public static final Block ONYX_BLOCK = register("onyx_block",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.8F));
    public static Block ONYX_STAIRS = register("onyx_stairs",
            settings -> new StairsBlock(ONYX_BLOCK.getDefaultState(), settings),
            Block.Settings.copy(ONYX_BLOCK));
    public static SlabBlock ONYX_SLAB = (SlabBlock) register("onyx_slab",
            SlabBlock::new, Block.Settings.copy(ONYX_BLOCK));

    public static final Block SMOOTH_ONYX_BLOCK = register("smooth_onyx_block",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.8F));
    public static Block SMOOTH_ONYX_STAIRS = register("smooth_onyx_stairs",
            settings -> new StairsBlock(SMOOTH_ONYX_BLOCK.getDefaultState(), settings),
            Block.Settings.copy(SMOOTH_ONYX_BLOCK));
    public static SlabBlock SMOOTH_ONYX_SLAB = (SlabBlock) register("smooth_onyx_slab",
            SlabBlock::new, Block.Settings.copy(SMOOTH_ONYX_BLOCK));

    public static final Block ONYX_BRICKS = register("onyx_bricks",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(0.8F));
    public static Block ONYX_BRICK_STAIRS = register("onyx_brick_stairs",
            settings -> new StairsBlock(ONYX_BRICKS.getDefaultState(), settings),
            Block.Settings.copy(ONYX_BRICKS));
    public static SlabBlock ONYX_BRICK_SLAB = (SlabBlock) register("onyx_brick_slab",
            SlabBlock::new, Block.Settings.copy(ONYX_BRICKS));
    public static WallBlock ONYX_BRICK_WALL = (WallBlock) register("onyx_brick_wall",
            WallBlock::new, Block.Settings.copy(ONYX_BRICKS));

    public static final Block CHISELED_ONYX_BLOCK = register("chiseled_onyx_block",
            Block::new, AbstractBlock.Settings.copy(ONYX_BLOCK));
    public static final Block ONYX_PILLAR = register("onyx_pillar",
            PillarBlock::new, AbstractBlock.Settings.copy(ONYX_BLOCK));


    //Vanilla Block Expansion
    public static Block COBBLED_END_STONE_STAIRS = register("cobbled_end_stone_stairs",
            settings -> new StairsBlock(END_STONE.getDefaultState(), settings),
            Block.Settings.copy(END_STONE));
    public static SlabBlock COBBLED_END_STONE_SLAB = (SlabBlock) register("cobbled_end_stone_slab",
            SlabBlock::new, Block.Settings.copy(END_STONE));
    public static WallBlock COBBLED_END_STONE_WALL = (WallBlock) register("cobbled_end_stone_wall",
            WallBlock::new, Block.Settings.copy(END_STONE));

    public static Block VOLATILE_OBSIDIAN = register("volatile_obsidian",
            VolatileObsidianBlock::new, AbstractBlock.Settings.copy(Blocks.OBSIDIAN).luminance(state -> 15));

    public static final Block SMOOTH_PURPUR = register("smooth_purpur",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(1.0F, 5.0F));
    public static Block SMOOTH_PURPUR_STAIRS = register("smooth_purpur_stairs",
            settings -> new StairsBlock(SMOOTH_PURPUR.getDefaultState(), settings),
            Block.Settings.copy(END_STONE));
    public static SlabBlock SMOOTH_PURPUR_SLAB = (SlabBlock) register("smooth_purpur_slab",
            SlabBlock::new, Block.Settings.copy(SMOOTH_PURPUR));
    public static WallBlock SMOOTH_PURPUR_WALL = (WallBlock) register("smooth_purpur_wall",
            WallBlock::new, Block.Settings.copy(SMOOTH_PURPUR));
    public static WallBlock PURPUR_BRICK_WALL = (WallBlock) register("purpur_brick_wall",
            WallBlock::new, Block.Settings.copy(PURPUR_BLOCK));

    public static Block CALCITE_PILLAR = register("calcite_pillar",
            PillarBlock::new, AbstractBlock.Settings.copy(CALCITE));
    public static Block POLISHED_CALCITE_PILLAR = register("polished_calcite_pillar",
            PillarBlock::new, AbstractBlock.Settings.copy(CALCITE));

    //Vegetation
    public static Block VERDANT_SHOOT = register("verdant_shoot",
            VerdantShootBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GREEN).replaceable().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.ROOTS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static Block TALL_VERDANT_SHOOT = register("tall_verdant_shoot",
            TallVerdantShootBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GREEN).replaceable().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.ROOTS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static Block VERDANT_SHOOT_BLOOM = register("verdant_shoot_bloom",
            VerdantShootBloomBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GREEN).replaceable().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.ROOTS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY).luminance(state -> 14));

    public static Block ROSE_SHOOT = register("rose_shoot",
            RoseShootBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GREEN).replaceable().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.ROOTS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static Block TALL_ROSE_SHOOT = register("tall_rose_shoot",
            TallRoseShootBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_GREEN).replaceable().noCollision().breakInstantly()
                    .sounds(BlockSoundGroup.ROOTS).offset(AbstractBlock.OffsetType.XYZ).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static Block ENDURTICA_ROOTS = register("endurtica_roots",
            EndurticaRootsBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.RED).noCollision().strength(1.0F).sounds(BlockSoundGroup.WOOD).burnable().pistonBehavior(PistonBehavior.DESTROY));

    public static final Block DRIFT_BERRY_BUSH = register("drift_berry_bush",
            DriftBerryBushBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_YELLOW).ticksRandomly().noCollision().sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY));

    public static Block PYGMY_CHORUS = register("pygmy_chorus",
            settings -> new EndFlowerBlock(StatusEffects.SLOWNESS, 7.0F, settings),
            AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PURPLE).noCollision().breakInstantly().sounds(BlockSoundGroup.ROOTS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY));
    public static Block POTTED_PYGMY_CHORUS = register("potted_pygmy_chorus", settings -> new FlowerPotBlock(PYGMY_CHORUS, settings), createFlowerPotSettings());

    public static Block SEDUM = register("sedum",
            settings -> new EndFlowerBlock(StatusEffects.RESISTANCE, 7.0F, settings),
            AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY));
    public static Block POTTED_SEDUM = register("potted_sedum", settings -> new FlowerPotBlock(SEDUM, settings), createFlowerPotSettings());

    //Purgenta Woodset
    public static Block PURGENTA_LOG = register("purgenta_log",
            PillarBlock::new, createLogSettings(MapColor.TERRACOTTA_PURPLE, MapColor.PURPLE, BlockSoundGroup.NETHER_STEM));
    public static Block PURGENTA_WOOD = register("purgenta_wood",
            PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.TERRACOTTA_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM).burnable());
    public static Block STRIPPED_PURGENTA_LOG = register("stripped_purgenta_log",
            PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM).burnable());
    public static Block STRIPPED_PURGENTA_WOOD = register("stripped_purgenta_wood",
            PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM).burnable());

    public static Block PURGENTA_PLANKS = register("purgenta_planks",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD).burnable());
    public static Block PURGENTA_STAIRS = register("purgenta_stairs",
            settings -> new StairsBlock(PURGENTA_PLANKS.getDefaultState(), settings),
            Block.Settings.copy(PURGENTA_PLANKS));
    public static SlabBlock PURGENTA_SLAB = (SlabBlock) register("purgenta_slab",
            SlabBlock::new, Block.Settings.copy(PURGENTA_PLANKS));
    public static FenceBlock PURGENTA_FENCE = (FenceBlock) register("purgenta_fence",
            FenceBlock::new, AbstractBlock.Settings.create().mapColor(PURGENTA_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD).burnable());
    public static FenceGateBlock PURGENTA_FENCE_GATE = (FenceGateBlock) register("purgenta_fence_gate",
            settings -> new FenceGateBlock(WoodType.CRIMSON, settings), AbstractBlock.Settings.create().mapColor(PURGENTA_PLANKS.getDefaultMapColor()).solid()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD).burnable());
    public static DoorBlock PURGENTA_DOOR = (DoorBlock) register("purgenta_door",
            settings -> new DoorBlock(BlockSetType.CRIMSON, settings), AbstractBlock.Settings.create().mapColor(PURGENTA_PLANKS.getDefaultMapColor())
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static TrapdoorBlock PURGENTA_TRAPDOOR = (TrapdoorBlock) register("purgenta_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.CRIMSON, settings), AbstractBlock.Settings.create().mapColor(PURGENTA_PLANKS.getDefaultMapColor())
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable());
    public static PressurePlateBlock PURGENTA_PRESSURE_PLATE = (PressurePlateBlock) register("purgenta_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.CRIMSON, settings), AbstractBlock.Settings.create().mapColor(PURGENTA_PLANKS.getDefaultMapColor()).solid()
                    .instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static Block PURGENTA_BUTTON = register("purgenta_button", settings -> new ButtonBlock(BlockSetType.CRIMSON, 30, settings), createButtonSettings());

    public static Block PURGENTA_LEAVES = register("purgenta_leaves",
            settings -> new UntintedParticleLeavesBlock(0.01F, DAParticles.PURGENTA_LEAVES, settings),
            AbstractBlock.Settings.create().ticksRandomly().mapColor(MapColor.PALE_YELLOW).strength(1.0F).sounds(BlockSoundGroup.GRASS).nonOpaque());

    public static Block PURGENTA_SAPLING = register("purgenta_sapling",
            settings -> new EndSaplingBlock(DASaplingGenerator.PURGENTA, settings),
            AbstractBlock.Settings.create().mapColor(MapColor.GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY));
    public static Block POTTED_PURGENTA_SAPLING = register("potted_purgenta_sapling", settings -> new FlowerPotBlock(PURGENTA_SAPLING, settings), createFlowerPotSettings());


    //Endurtica Woodset
    public static Block ENDURTICA_LOG = register("endurtica_log",
            PillarBlock::new, createLogSettings(MapColor.LIGHT_GRAY, MapColor.BLACK, BlockSoundGroup.NETHER_STEM));
    public static Block ENDURTICA_WOOD = register("endurtica_wood",
            PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM).burnable());
    public static Block STRIPPED_ENDURTICA_LOG = register("stripped_endurtica_log",
            PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM).burnable());
    public static Block STRIPPED_ENDURTICA_WOOD = register("stripped_endurtica_wood",
            PillarBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM).burnable());

    public static Block ENDURTICA_PLANKS = register("endurtica_planks",
            Block::new, AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD).burnable());
    public static Block ENDURTICA_STAIRS = register("endurtica_stairs",
            settings -> new StairsBlock(ENDURTICA_PLANKS.getDefaultState(), settings),
            Block.Settings.copy(ENDURTICA_PLANKS));
    public static SlabBlock ENDURTICA_SLAB = (SlabBlock) register("endurtica_slab",
            SlabBlock::new, Block.Settings.copy(ENDURTICA_PLANKS));
    public static FenceBlock ENDURTICA_FENCE = (FenceBlock) register("endurtica_fence",
            FenceBlock::new, AbstractBlock.Settings.create().mapColor(ENDURTICA_PLANKS.getDefaultMapColor()).solid().instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD).burnable());
    public static FenceGateBlock ENDURTICA_FENCE_GATE = (FenceGateBlock) register("endurtica_fence_gate",
            settings -> new FenceGateBlock(WoodType.WARPED, settings), AbstractBlock.Settings.create().mapColor(ENDURTICA_PLANKS.getDefaultMapColor()).solid()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.NETHER_WOOD).burnable());
    public static DoorBlock ENDURTICA_DOOR = (DoorBlock) register("endurtica_door",
            settings -> new DoorBlock(BlockSetType.WARPED, settings), AbstractBlock.Settings.create().mapColor(ENDURTICA_PLANKS.getDefaultMapColor())
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static TrapdoorBlock ENDURTICA_TRAPDOOR = (TrapdoorBlock) register("endurtica_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.WARPED, settings), AbstractBlock.Settings.create().mapColor(ENDURTICA_PLANKS.getDefaultMapColor())
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable());
    public static PressurePlateBlock ENDURTICA_PRESSURE_PLATE = (PressurePlateBlock) register("endurtica_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.WARPED, settings), AbstractBlock.Settings.create().mapColor(ENDURTICA_PLANKS.getDefaultMapColor()).solid()
                    .instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY));
    public static Block ENDURTICA_BUTTON = register("endurtica_button", settings -> new ButtonBlock(BlockSetType.WARPED, 30, settings), createButtonSettings());

    public static Block ENDURTICA_LEAVES = register("endurtica_leaves",
            settings -> new UntintedParticleLeavesBlock(0.0F, TintedParticleEffect.create(ParticleTypes.TINTED_LEAVES, 1743149), settings),
            AbstractBlock.Settings.create().ticksRandomly().mapColor(MapColor.DARK_GREEN).strength(1.0F).sounds(BlockSoundGroup.GRASS).nonOpaque());
    public static Block FLOWERING_ENDURTICA_LEAVES = register("flowering_endurtica_leaves",
            settings -> new UntintedParticleLeavesBlock(0.1F, DAParticles.ENDURTICA_ROSE, settings),
            AbstractBlock.Settings.copy(ModBlocks.ENDURTICA_LEAVES));

    public static Block ENDURTICA_SAPLING = register("endurtica_sapling",
            settings -> new EndSaplingBlock(DASaplingGenerator.ENDURTICA, settings),
            AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY));
    public static Block POTTED_ENDURTICA_SAPLING = register("potted_endurtica_sapling", settings -> new FlowerPotBlock(ENDURTICA_SAPLING, settings), createFlowerPotSettings());

    //Nitrogen
    public static Block NITROGEN = register("nitrogen",
            settings -> new FluidBlock(ModFluids.NITROGEN_STILL, settings),
            AbstractBlock.Settings.create().mapColor(MapColor.WHITE).replaceable().noCollision().strength(100.0F).pistonBehavior(PistonBehavior.DESTROY).dropsNothing().liquid().sounds(BlockSoundGroup.INTENTIONALLY_EMPTY));

    public static void registerBlocks() {
        DimensionalAdditions.LOGGER.info("Registering Blocks for " + DimensionalAdditions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Blocks.NETHER_QUARTZ_ORE, ModBlocks.NETHER_IRON_ORE);
            entries.addAfter(ModBlocks.NETHER_IRON_ORE, ModBlocks.END_COAL_ORE);
            entries.addAfter(ModBlocks.END_COAL_ORE, ModBlocks.END_ONYX_ORE);
            entries.addAfter(ModBlocks.END_ONYX_ORE, ModBlocks.END_DIAMOND_ORE);

            entries.addAfter(Blocks.WARPED_STEM, ModBlocks.PURGENTA_LOG);
            entries.addAfter(ModBlocks.PURGENTA_LOG, ModBlocks.ENDURTICA_LOG);
            entries.addAfter(Blocks.FLOWERING_AZALEA_LEAVES, ModBlocks.PURGENTA_LEAVES);
            entries.addAfter(ModBlocks.PURGENTA_LEAVES, ModBlocks.ENDURTICA_LEAVES);
            entries.addAfter(ModBlocks.ENDURTICA_LEAVES, ModBlocks.FLOWERING_ENDURTICA_LEAVES);
            entries.addAfter(Blocks.WARPED_FUNGUS, ModBlocks.PURGENTA_SAPLING);
            entries.addAfter(ModBlocks.PURGENTA_SAPLING, ModBlocks.ENDURTICA_SAPLING);

            entries.addBefore(Blocks.END_STONE, ModBlocks.SMOOTH_END_STONE_WALL);
            entries.addBefore(ModBlocks.SMOOTH_END_STONE_WALL, ModBlocks.SMOOTH_END_STONE_SLAB);
            entries.addBefore(ModBlocks.SMOOTH_END_STONE_SLAB, ModBlocks.SMOOTH_END_STONE_STAIRS);
            entries.addBefore(ModBlocks.SMOOTH_END_STONE_STAIRS, ModBlocks.SMOOTH_END_STONE);

            entries.addAfter(Blocks.END_STONE, ModBlocks.COBBLED_END_STONE_STAIRS);
            entries.addAfter(ModBlocks.COBBLED_END_STONE_STAIRS, ModBlocks.COBBLED_END_STONE_SLAB);
            entries.addAfter(ModBlocks.COBBLED_END_STONE_SLAB, ModBlocks.COBBLED_END_STONE_WALL);
            entries.addAfter(ModBlocks.COBBLED_END_STONE_WALL, ModBlocks.ASTRAL_TURF);
            entries.addAfter(ModBlocks.ASTRAL_TURF, ModBlocks.VERDANT_TURF);
            entries.addAfter(ModBlocks.VERDANT_TURF, ModBlocks.ROSE_TURF);

            entries.addAfter(ModBlocks.COBBLED_END_STONE_WALL, ModBlocks.CERULEAN_SHALE);
            entries.addAfter(ModBlocks.CERULEAN_SHALE, ModBlocks.CERULEAN_SHALE_STAIRS);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_STAIRS, ModBlocks.CERULEAN_SHALE_SLAB);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_SLAB, ModBlocks.CERULEAN_SHALE_WALL);

            entries.addAfter(ModBlocks.CERULEAN_SHALE_WALL, ModBlocks.NAVY_SHALE);
            entries.addAfter(ModBlocks.NAVY_SHALE, ModBlocks.NAVY_SHALE_STAIRS);
            entries.addAfter(ModBlocks.NAVY_SHALE_STAIRS, ModBlocks.NAVY_SHALE_SLAB);
            entries.addAfter(ModBlocks.NAVY_SHALE_SLAB, ModBlocks.NAVY_SHALE_WALL);

            entries.addAfter(Blocks.TWISTING_VINES, ModBlocks.PYGMY_CHORUS);
            entries.addAfter(ModBlocks.PYGMY_CHORUS, ModBlocks.VERDANT_SHOOT);
            entries.addAfter(ModBlocks.VERDANT_SHOOT, ModBlocks.TALL_VERDANT_SHOOT);
            entries.addAfter(ModBlocks.TALL_VERDANT_SHOOT, ModBlocks.VERDANT_SHOOT_BLOOM);
            entries.addAfter(ModBlocks.VERDANT_SHOOT_BLOOM, ModBlocks.ROSE_SHOOT);
            entries.addAfter(ModBlocks.ROSE_SHOOT, ModBlocks.TALL_ROSE_SHOOT);
            entries.addAfter(ModBlocks.TALL_ROSE_SHOOT, ModBlocks.ENDURTICA_ROOTS);
            entries.addAfter(Blocks.WITHER_ROSE, ModBlocks.SEDUM);

            entries.addAfter(ModBlocks.COBBLED_END_STONE_WALL, ModBlocks.SMOOTH_PURPUR);
            entries.addAfter(ModBlocks.SMOOTH_PURPUR, ModBlocks.SMOOTH_PURPUR_STAIRS);
            entries.addAfter(ModBlocks.SMOOTH_PURPUR_STAIRS, ModBlocks.SMOOTH_PURPUR_SLAB);
            entries.addAfter(ModBlocks.SMOOTH_PURPUR_SLAB, ModBlocks.SMOOTH_PURPUR_WALL);

            entries.addAfter(Blocks.CALCITE, ModBlocks.CALCITE_PILLAR);

            entries.addAfter(Blocks.CRYING_OBSIDIAN, ModBlocks.VOLATILE_OBSIDIAN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addBefore(Blocks.END_STONE, ModBlocks.SMOOTH_END_STONE_WALL);
            entries.addBefore(ModBlocks.SMOOTH_END_STONE_WALL, ModBlocks.SMOOTH_END_STONE_SLAB);
            entries.addBefore(ModBlocks.SMOOTH_END_STONE_SLAB, ModBlocks.SMOOTH_END_STONE_STAIRS);
            entries.addBefore(ModBlocks.SMOOTH_END_STONE_STAIRS, ModBlocks.SMOOTH_END_STONE);
            entries.addAfter(Blocks.END_STONE, ModBlocks.COBBLED_END_STONE_STAIRS);
            entries.addAfter(ModBlocks.COBBLED_END_STONE_STAIRS, ModBlocks.COBBLED_END_STONE_SLAB);
            entries.addAfter(ModBlocks.COBBLED_END_STONE_SLAB, ModBlocks.COBBLED_END_STONE_WALL);

            entries.addBefore(Blocks.BASALT, Blocks.CALCITE);
            entries.addAfter(Blocks.CALCITE, ModBlocks.CALCITE_PILLAR);
            entries.addAfter(ModBlocks.CALCITE_PILLAR, ModBlocks.POLISHED_CALCITE_PILLAR);

            entries.addBefore(Blocks.PURPUR_BLOCK, ModBlocks.SMOOTH_PURPUR_WALL);
            entries.addBefore(ModBlocks.SMOOTH_PURPUR_WALL, ModBlocks.SMOOTH_PURPUR_SLAB);
            entries.addBefore(ModBlocks.SMOOTH_PURPUR_SLAB, ModBlocks.SMOOTH_PURPUR_STAIRS);
            entries.addBefore(ModBlocks.SMOOTH_PURPUR_STAIRS, ModBlocks.SMOOTH_PURPUR);
            entries.addAfter(Blocks.PURPUR_SLAB, ModBlocks.PURPUR_BRICK_WALL);

            entries.addAfter(ModBlocks.PURPUR_BRICK_WALL, ModBlocks.CERULEAN_SHALE);
            entries.addAfter(ModBlocks.CERULEAN_SHALE, ModBlocks.CERULEAN_SHALE_STAIRS);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_STAIRS, ModBlocks.CERULEAN_SHALE_SLAB);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_SLAB, ModBlocks.CERULEAN_SHALE_WALL);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_WALL, ModBlocks.CERULEAN_SHALE_BRICKS);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_BRICKS, ModBlocks.CERULEAN_SHALE_BRICK_STAIRS);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_BRICK_STAIRS, ModBlocks.CERULEAN_SHALE_BRICK_SLAB);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_BRICK_SLAB, ModBlocks.CERULEAN_SHALE_BRICK_WALL);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_BRICK_WALL, ModBlocks.CERULEAN_SHALE_TILES);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_TILES, ModBlocks.CERULEAN_SHALE_TILE_STAIRS);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_TILE_STAIRS, ModBlocks.CERULEAN_SHALE_TILE_SLAB);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_TILE_SLAB, ModBlocks.CERULEAN_SHALE_TILE_WALL);
            entries.addAfter(ModBlocks.CERULEAN_SHALE_TILE_WALL, ModBlocks.POLISHED_CERULEAN_SHALE);
            entries.addAfter(ModBlocks.POLISHED_CERULEAN_SHALE, ModBlocks.POLISHED_CERULEAN_SHALE_STAIRS);
            entries.addAfter(ModBlocks.POLISHED_CERULEAN_SHALE_STAIRS, ModBlocks.POLISHED_CERULEAN_SHALE_SLAB);
            entries.addAfter(ModBlocks.POLISHED_CERULEAN_SHALE_SLAB, ModBlocks.POLISHED_CERULEAN_SHALE_WALL);

            entries.addAfter(ModBlocks.POLISHED_CERULEAN_SHALE_WALL, ModBlocks.NAVY_SHALE);
            entries.addAfter(ModBlocks.NAVY_SHALE, ModBlocks.NAVY_SHALE_STAIRS);
            entries.addAfter(ModBlocks.NAVY_SHALE_STAIRS, ModBlocks.NAVY_SHALE_SLAB);
            entries.addAfter(ModBlocks.NAVY_SHALE_SLAB, ModBlocks.NAVY_SHALE_WALL);
            entries.addAfter(ModBlocks.NAVY_SHALE_WALL, ModBlocks.NAVY_SHALE_BRICKS);
            entries.addAfter(ModBlocks.NAVY_SHALE_BRICKS, ModBlocks.NAVY_SHALE_BRICK_STAIRS);
            entries.addAfter(ModBlocks.NAVY_SHALE_BRICK_STAIRS, ModBlocks.NAVY_SHALE_BRICK_SLAB);
            entries.addAfter(ModBlocks.NAVY_SHALE_BRICK_SLAB, ModBlocks.NAVY_SHALE_BRICK_WALL);
            entries.addAfter(ModBlocks.NAVY_SHALE_BRICK_WALL, ModBlocks.NAVY_SHALE_TILES);
            entries.addAfter(ModBlocks.NAVY_SHALE_TILES, ModBlocks.NAVY_SHALE_TILE_STAIRS);
            entries.addAfter(ModBlocks.NAVY_SHALE_TILE_STAIRS, ModBlocks.NAVY_SHALE_TILE_SLAB);
            entries.addAfter(ModBlocks.NAVY_SHALE_TILE_SLAB, ModBlocks.NAVY_SHALE_TILE_WALL);
            entries.addAfter(ModBlocks.NAVY_SHALE_TILE_WALL, ModBlocks.POLISHED_NAVY_SHALE);
            entries.addAfter(ModBlocks.POLISHED_NAVY_SHALE, ModBlocks.POLISHED_NAVY_SHALE_STAIRS);
            entries.addAfter(ModBlocks.POLISHED_NAVY_SHALE_STAIRS, ModBlocks.POLISHED_NAVY_SHALE_SLAB);
            entries.addAfter(ModBlocks.POLISHED_NAVY_SHALE_SLAB, ModBlocks.POLISHED_NAVY_SHALE_WALL);

            entries.addAfter(Blocks.SMOOTH_QUARTZ_SLAB, ModBlocks.ONYX_BLOCK);
            entries.addAfter(ModBlocks.ONYX_BLOCK, ModBlocks.ONYX_STAIRS);
            entries.addAfter(ModBlocks.ONYX_STAIRS, ModBlocks.ONYX_SLAB);
            entries.addAfter(ModBlocks.ONYX_SLAB, ModBlocks.CHISELED_ONYX_BLOCK);
            entries.addAfter(ModBlocks.CHISELED_ONYX_BLOCK, ModBlocks.ONYX_BRICKS);
            entries.addAfter(ModBlocks.ONYX_BRICKS, ModBlocks.ONYX_BRICK_STAIRS);
            entries.addAfter(ModBlocks.ONYX_BRICK_STAIRS, ModBlocks.ONYX_BRICK_SLAB);
            entries.addAfter(ModBlocks.ONYX_BRICK_SLAB, ModBlocks.ONYX_BRICK_WALL);
            entries.addAfter(ModBlocks.ONYX_BRICK_WALL, ModBlocks.ONYX_PILLAR);
            entries.addAfter(ModBlocks.ONYX_PILLAR, ModBlocks.SMOOTH_ONYX_BLOCK);
            entries.addAfter(ModBlocks.SMOOTH_ONYX_BLOCK, ModBlocks.SMOOTH_ONYX_STAIRS);
            entries.addAfter(ModBlocks.SMOOTH_ONYX_STAIRS, ModBlocks.SMOOTH_ONYX_SLAB);

            entries.addAfter(Blocks.WARPED_BUTTON, ModBlocks.PURGENTA_LOG);
            entries.addAfter(ModBlocks.PURGENTA_LOG, ModBlocks.PURGENTA_WOOD);
            entries.addAfter(ModBlocks.PURGENTA_WOOD, ModBlocks.STRIPPED_PURGENTA_LOG);
            entries.addAfter(ModBlocks.STRIPPED_PURGENTA_LOG, ModBlocks.STRIPPED_PURGENTA_WOOD);
            entries.addAfter(ModBlocks.STRIPPED_PURGENTA_WOOD, ModBlocks.PURGENTA_PLANKS);
            entries.addAfter(ModBlocks.PURGENTA_PLANKS, ModBlocks.PURGENTA_STAIRS);
            entries.addAfter(ModBlocks.PURGENTA_STAIRS, ModBlocks.PURGENTA_SLAB);
            entries.addAfter(ModBlocks.PURGENTA_SLAB, ModBlocks.PURGENTA_FENCE);
            entries.addAfter(ModBlocks.PURGENTA_FENCE, ModBlocks.PURGENTA_FENCE_GATE);
            entries.addAfter(ModBlocks.PURGENTA_FENCE_GATE, ModBlocks.PURGENTA_DOOR);
            entries.addAfter(ModBlocks.PURGENTA_DOOR, ModBlocks.PURGENTA_TRAPDOOR);
            entries.addAfter(ModBlocks.PURGENTA_TRAPDOOR, ModBlocks.PURGENTA_PRESSURE_PLATE);
            entries.addAfter(ModBlocks.PURGENTA_PRESSURE_PLATE, ModBlocks.PURGENTA_BUTTON);

            entries.addAfter(ModBlocks.PURGENTA_BUTTON, ModBlocks.ENDURTICA_LOG);
            entries.addAfter(ModBlocks.ENDURTICA_LOG, ModBlocks.ENDURTICA_WOOD);
            entries.addAfter(ModBlocks.ENDURTICA_WOOD, ModBlocks.STRIPPED_ENDURTICA_LOG);
            entries.addAfter(ModBlocks.STRIPPED_ENDURTICA_LOG, ModBlocks.STRIPPED_ENDURTICA_WOOD);
            entries.addAfter(ModBlocks.STRIPPED_ENDURTICA_WOOD, ModBlocks.ENDURTICA_PLANKS);
            entries.addAfter(ModBlocks.ENDURTICA_PLANKS, ModBlocks.ENDURTICA_STAIRS);
            entries.addAfter(ModBlocks.ENDURTICA_STAIRS, ModBlocks.ENDURTICA_SLAB);
            entries.addAfter(ModBlocks.ENDURTICA_SLAB, ModBlocks.ENDURTICA_FENCE);
            entries.addAfter(ModBlocks.ENDURTICA_FENCE, ModBlocks.ENDURTICA_FENCE_GATE);
            entries.addAfter(ModBlocks.ENDURTICA_FENCE_GATE, ModBlocks.ENDURTICA_DOOR);
            entries.addAfter(ModBlocks.ENDURTICA_DOOR, ModBlocks.ENDURTICA_TRAPDOOR);
            entries.addAfter(ModBlocks.ENDURTICA_TRAPDOOR, ModBlocks.ENDURTICA_PRESSURE_PLATE);
            entries.addAfter(ModBlocks.ENDURTICA_PRESSURE_PLATE, ModBlocks.ENDURTICA_BUTTON);
        });
    }
}
