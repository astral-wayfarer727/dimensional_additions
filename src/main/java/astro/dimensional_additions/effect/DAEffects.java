package astro.dimensional_additions.effect;

import astro.dimensional_additions.DimensionalAdditions;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class DAEffects {
    private static RegistryEntry<StatusEffect> register(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(DimensionalAdditions.MOD_ID, name), statusEffect);
    }

    // The only way I could currently figure out how to have the two levels of the potion have their own values since I didn't like how the default Operators where scaling the
    // effect otherwise, as I couldn't get Low Grav 1 to actually be useful without Low Grav 2 reversing gravity completely... I will definitely clean this up in the future once
    // I figure out how but for now, it's gonna be this ugly lol

    // Which btw, the whole idea behind the Low Grav effect was that with the increased amounts of the Small End Island Features, it would open up some platforming level design
    // for the player to have another way to get between the islands, so that's why I wanted the first level to still be pretty strong so that the Berries would give a useful
    // level right there and then without having to brew the potions, but idk I'm just rambling at this point

    public static final RegistryEntry<StatusEffect> LOW_GRAVITY_1 = register("low_gravity_1", new LowGravityEffect()
            .addAttributeModifier(EntityAttributes.GRAVITY, Identifier.ofVanilla("effect.gravity"), -0.875, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .addAttributeModifier(EntityAttributes.SAFE_FALL_DISTANCE, Identifier.ofVanilla("effect.fall_damage_multiplier"), 0.875,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final RegistryEntry<StatusEffect> LOW_GRAVITY_2 = register("low_gravity_2", new LowGravityEffect()
            .addAttributeModifier(EntityAttributes.GRAVITY, Identifier.ofVanilla("effect.gravity"), -0.95, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .addAttributeModifier(EntityAttributes.SAFE_FALL_DISTANCE, Identifier.ofVanilla("effect.fall_damage_multiplier"), 0.95,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final RegistryEntry<StatusEffect> HIGH_GRAVITY = register("high_gravity", new HighGravityEffect()
            .addAttributeModifier(EntityAttributes.GRAVITY, Identifier.ofVanilla("effect.gravity"), 0.55, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .addAttributeModifier(EntityAttributes.SAFE_FALL_DISTANCE, Identifier.ofVanilla("effect.fall_damage_multiplier"), -1.0,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );
}
