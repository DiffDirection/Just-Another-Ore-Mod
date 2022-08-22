package us.differentdirection.jaom.fabric;

import us.differentdirection.jaom.JAOreMod;
import net.fabricmc.api.ModInitializer;
import us.differentdirection.jaom.registry.JARegistry;

public class JAOreModFabric implements ModInitializer {
    @Override
    public void onInitialize()
    {
        JAOreMod.init();
        JARegistry.init();
    }
}
