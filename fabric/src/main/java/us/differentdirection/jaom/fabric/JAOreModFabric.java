package us.differentdirection.jaom.fabric;

import net.fabricmc.api.ModInitializer;
import us.differentdirection.jaom.JAOreMod;

public class JAOreModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        JAOreMod.init();
    }
}
