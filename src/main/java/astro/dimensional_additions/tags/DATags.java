package astro.dimensional_additions.tags;

import astro.dimensional_additions.DimensionalAdditions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class DATags {
    public static class Blocks {
        public static final TagKey<Block> TURF = createTag("turf");
        public static final TagKey<Block> VALID_DRIFT_BERRY_BLOCKS = createTag("valid_drift_berry_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(DimensionalAdditions.MOD_ID, name));
        }
    }

    public static class Items {
        //public static final TagKey<Item> ENDANIUM_TOOL_MATERIALS = createTag("endanium_tool_materials");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(DimensionalAdditions.MOD_ID, name));
        }
    }
}
