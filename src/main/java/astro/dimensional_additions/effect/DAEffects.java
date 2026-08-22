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

    public static final RegistryEntry<StatusEffect> LOW_GRAVITY = register("low_gravity", new LowGravityEffect()
            .addAttributeModifier(EntityAttributes.GRAVITY, Identifier.ofVanilla("effect.gravity"), -0.4, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .addAttributeModifier(EntityAttributes.SAFE_FALL_DISTANCE, Identifier.ofVanilla("effect.fall_damage_multiplier"), 0.4, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final RegistryEntry<StatusEffect> HIGH_GRAVITY = register("high_gravity", new HighGravityEffect()
            .addAttributeModifier(EntityAttributes.GRAVITY, Identifier.ofVanilla("effect.gravity"), 0.4, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            .addAttributeModifier(EntityAttributes.SAFE_FALL_DISTANCE, Identifier.ofVanilla("effect.fall_damage_multiplier"), -0.4, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );
}
