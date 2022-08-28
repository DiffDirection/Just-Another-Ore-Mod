package us.differentdirection.jaom.forge.datagen.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreManager;

public class JABlockTags extends BlockTagsProvider {
    public JABlockTags(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, JAOreMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        OreManager.ores.forEach(oreObject -> {
            tag(Tags.Blocks.ORES).add(oreObject.ORE.get());
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(oreObject.ORE.get());
            tag(BlockTags.create(new ResourceLocation("forge:ores/" + oreObject.NAME))).add(oreObject.ORE.get());
            tag(Tags.Blocks.STORAGE_BLOCKS).add(oreObject.STORAGE.get());
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(oreObject.STORAGE.get());
            tag(BlockTags.create(new ResourceLocation("forge:storage_blocks/" + oreObject.NAME))).add(oreObject.STORAGE.get());

            if (oreObject.getMiningLevel() != null) {
                switch (oreObject.getMiningLevel()) {
                    case IRON -> {
                        tag(BlockTags.NEEDS_IRON_TOOL).add(oreObject.ORE.get());
                        tag(BlockTags.NEEDS_IRON_TOOL).add(oreObject.STORAGE.get());
                    }
                    case DIAMOND -> {
                        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(oreObject.ORE.get());
                        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(oreObject.STORAGE.get());
                    }
                    case STONE -> {
                        tag(BlockTags.NEEDS_STONE_TOOL).add(oreObject.ORE.get());
                        tag(BlockTags.NEEDS_STONE_TOOL).add(oreObject.STORAGE.get());
                    }
                }
            }
        });

        tag(BlockTags.COPPER_ORES).add(OreManager.ores.stream().filter(oreObject -> oreObject.NAME.equals("copper")).findFirst().get().ORE.get());
    }
}
