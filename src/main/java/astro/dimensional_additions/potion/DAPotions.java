package astro.dimensional_additions.potion;

import astro.dimensional_additions.DimensionalAdditions;
import astro.dimensional_additions.effect.DAEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class DAPotions {
    //Low Gravity Potions
    public static final RegistryEntry<Potion> LOW_GRAVITY = registerPotion(
            "low_gravity", new Potion("low_gravity", new StatusEffectInstance(DAEffects.LOW_GRAVITY, 1800))
    );
    public static final RegistryEntry<Potion> LONG_LOW_GRAVITY = registerPotion(
            "long_low_gravity", new Potion("low_gravity", new StatusEffectInstance(DAEffects.LOW_GRAVITY, 4800))
    );
    public static final RegistryEntry<Potion> STRONG_LOW_GRAVITY = registerPotion(
            "strong_low_gravity", new Potion("low_gravity", new StatusEffectInstance(DAEffects.LOW_GRAVITY, 900, 1))
    );

    //High Gravity Potions
    public static final RegistryEntry<Potion> HIGH_GRAVITY = registerPotion(
            "high_gravity", new Potion("high_gravity", new StatusEffectInstance(DAEffects.HIGH_GRAVITY, 900))
    );
    public static final RegistryEntry<Potion> LONG_HIGH_GRAVITY = registerPotion(
            "long_high_gravity", new Potion("high_gravity", new StatusEffectInstance(DAEffects.HIGH_GRAVITY, 2400))
    );
    public static final RegistryEntry<Potion> STRONG_HIGH_GRAVITY = registerPotion(
            "strong_high_gravity", new Potion("high_gravity", new StatusEffectInstance(DAEffects.HIGH_GRAVITY, 450, 1))
    );

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(DimensionalAdditions.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        DimensionalAdditions.LOGGER.info("Registering potions for " + DimensionalAdditions.MOD_ID);
    }
}
