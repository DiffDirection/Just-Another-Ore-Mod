package us.differentdirection.jaom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import us.differentdirection.jaom.manager.OreManager;
import us.differentdirection.jaom.registry.JARegistry;

public class JAOreMod {
    public static final String MOD_ID = "jaom";

    public static final Logger LOGGER = LogManager.getLogger("JAOreMod");

    public static void init() {
        OreManager.addOres();
        JARegistry.init();
    }
}
