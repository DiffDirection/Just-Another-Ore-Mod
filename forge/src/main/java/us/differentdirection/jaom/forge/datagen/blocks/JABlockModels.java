package us.differentdirection.jaom.forge.datagen.blocks;

import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreMananger;
import net.minecraft.data.DataGenerator;


public class JABlockModels extends BlockModelProvider {
    public JABlockModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, JAOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        OreMananger.ores.forEach(oreObject -> {
            cubeAll(oreObject.NAME + "_ore", modLoc("block/ore/" + oreObject.NAME + "_ore"));
            cubeAll(oreObject.NAME + "_block", modLoc("block/storage/" + oreObject.NAME + "_block"));
        });
    }
}
