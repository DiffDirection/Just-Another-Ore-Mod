package us.differentdirection.jaom.forge;

import us.differentdirection.jaom.JAOMExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class JAOMExpectPlatformImpl {
    /**
     * This is our actual method to {@link JAOMExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
