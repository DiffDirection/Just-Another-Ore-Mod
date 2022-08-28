package us.differentdirection.jaom.forge.datagen.blocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreManager;


public class JABlockModels extends BlockModelProvider {
    public JABlockModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, JAOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        OreManager.ores.forEach(oreObject -> {
            cubeAll(oreObject.NAME + "_ore", modLoc("block/ore/" + oreObject.NAME + "_ore"));
            cubeAll(oreObject.NAME + "_block", modLoc("block/storage/" + oreObject.NAME + "_block"));
        });
    }
}
