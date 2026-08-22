package astro.dimensional_additions.items;

import astro.dimensional_additions.DimensionalAdditions;
import astro.dimensional_additions.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DimensionalAdditions.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }
    public static Item DRIFT_BERRY = register(
            "drift_berry", createBlockItemWithUniqueName(ModBlocks.DRIFT_BERRY_BUSH), new Item.Settings().food(DAFoodComponents.DRIFT_BERRY, DAConsumableComponents.DRIFT_BERRY));

    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }

    public static void registerItems() {
        DimensionalAdditions.LOGGER.info("Registering items for " + DimensionalAdditions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.addAfter(Items.GLOW_BERRIES, ModItems.DRIFT_BERRY);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.SWEET_BERRIES, ModItems.DRIFT_BERRY);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.GOLDEN_CARROT, ModItems.DRIFT_BERRY);
        });
    }
}
