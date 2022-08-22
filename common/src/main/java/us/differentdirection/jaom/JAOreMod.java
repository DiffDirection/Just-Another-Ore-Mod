package us.differentdirection.jaom;

import us.differentdirection.jaom.manager.OreMananger;
import us.differentdirection.jaom.registry.JARegistry;

public class JAOreMod {
    public static final String MOD_ID = "jaom";
    
    public static void init() {
        OreMananger.addOres();
        JARegistry.init();
    }
}
