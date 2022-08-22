package us.differentdirection.jaom.forge;

import dev.architectury.platform.forge.EventBuses;
import us.differentdirection.jaom.JAOreMod;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import us.differentdirection.jaom.registry.JARegistry;

@Mod(JAOreMod.MOD_ID)
public class JAOreModForge {
    public JAOreModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(JAOreMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        JARegistry.init();
        JAOreMod.init();
    }
}
