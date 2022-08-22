package us.differentdirection.jaom.forge.datagen;

import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreMananger;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class JAItemModels extends ItemModelProvider {
    public JAItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, JAOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        OreMananger.ores.forEach(oreObject -> {
            singleTexture(oreObject.NAME + "_ingot", mcLoc("item/generated"), "layer0", modLoc("item/ingot/" + oreObject.NAME + "_ingot"));
            if (oreObject.hasNugget)
                singleTexture(oreObject.NAME + "_nugget", mcLoc("item/generated"), "layer0", modLoc("item/nugget/" + oreObject.NAME + "_nugget"));
            singleTexture("raw_" + oreObject.NAME, mcLoc("item/generated"), "layer0", modLoc("item/raw/raw_" + oreObject.NAME));
            withExistingParent(oreObject.NAME + "_block", modLoc("block/" + oreObject.NAME + "_block"));
            withExistingParent(oreObject.NAME + "_ore", modLoc("block/" + oreObject.NAME + "_ore"));
        });
    }
}
