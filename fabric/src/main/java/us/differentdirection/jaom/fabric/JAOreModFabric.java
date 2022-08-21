package us.differentdirection.jaom.fabric;

import us.differentdirection.jaom.JAOreMod;
import net.fabricmc.api.ModInitializer;

public class JAOreModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        JAOreMod.init();
    }
}
