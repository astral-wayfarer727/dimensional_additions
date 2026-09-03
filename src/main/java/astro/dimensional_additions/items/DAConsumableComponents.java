package astro.dimensional_additions.items;

import astro.dimensional_additions.effect.DAEffects;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.food;

public class DAConsumableComponents {
    public static final ConsumableComponent DRIFT_BERRY = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(DAEffects.LOW_GRAVITY_1, 600, 0))
                    )
            )
            .build();
}
