package us.differentdirection.jaom.forge.datagen.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreManager;

public class JAItemTags extends ItemTagsProvider {
    public JAItemTags(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, JAOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        OreManager.ores.forEach(oreObject -> {
            copy(BlockTags.create(new ResourceLocation("forge:ore/" + oreObject.NAME)), ItemTags.create(new ResourceLocation("forge:ore/" + oreObject.NAME)));
            tag(ItemTags.create(new ResourceLocation("forge:ingots/" + oreObject.NAME))).add(oreObject.INGOT.get());
            if (oreObject.hasNugget) tag(ItemTags.create(new ResourceLocation("forge:nuggets/" + oreObject.NAME))).add(oreObject.NUGGET.get());
        });
    }
}
