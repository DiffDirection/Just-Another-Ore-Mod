package us.differentdirection.jaom.forge.datagen.blocks;

import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreMananger;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class JABlockStates extends BlockStateProvider {
    public JABlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, JAOreMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        OreMananger.ores.forEach(oreObject -> {
            simpleBlock(oreObject.ORE, models().getExistingFile(modLoc(oreObject.NAME + "_ore")));
            simpleBlock(oreObject.STORAGE, models().getExistingFile(modLoc(oreObject.NAME + "_block")));
        });
    }
}
