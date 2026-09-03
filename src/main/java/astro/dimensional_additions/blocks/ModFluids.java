package astro.dimensional_additions.blocks;

import astro.dimensional_additions.DimensionalAdditions;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid NITROGEN_FLOWING = register("flowing_nitrogen", new NitrogenFluid.Flowing());
    public static final FlowableFluid NITROGEN_STILL = register("nitrogen", new NitrogenFluid.Still());

    private static FlowableFluid register(String name, FlowableFluid fluid) {
        return Registry.register(Registries.FLUID, Identifier.of(DimensionalAdditions.MOD_ID, name), fluid);
    }

    public static void registerFluids() {
        DimensionalAdditions.LOGGER.info("Registering Fluids for " + DimensionalAdditions.MOD_ID);
    }
}
