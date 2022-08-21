package us.differentdirection.jaom.fabric;

import us.differentdirection.jaom.JAOMExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class JAOMExpectPlatformImpl {
    /**
     * This is our actual method to {@link JAOMExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
