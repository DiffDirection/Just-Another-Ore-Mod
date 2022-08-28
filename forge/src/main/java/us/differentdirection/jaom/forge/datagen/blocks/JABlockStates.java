package us.differentdirection.jaom.forge.datagen.blocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreManager;

public class JABlockStates extends BlockStateProvider {
    public JABlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, JAOreMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        OreManager.ores.forEach(oreObject -> {
            simpleBlock(oreObject.ORE.get(), models().getExistingFile(modLoc(oreObject.NAME + "_ore")));
            simpleBlock(oreObject.STORAGE.get(), models().getExistingFile(modLoc(oreObject.NAME + "_block")));
        });
    }
}
