package us.differentdirection.jaom.forge.datagen.tags;

import net.minecraft.resources.ResourceLocation;
import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreMananger;
import us.differentdirection.jaom.registry.OreObjectBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class JABlockTags extends BlockTagsProvider {
    public JABlockTags(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, JAOreMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        OreMananger.ores.forEach(oreObject -> {
            tag(Tags.Blocks.ORES).add(oreObject.ORE);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(oreObject.ORE);
            tag(BlockTags.create(new ResourceLocation("forge:ores/" + oreObject.NAME))).add(oreObject.ORE);
            tag(Tags.Blocks.STORAGE_BLOCKS).add(oreObject.STORAGE);
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(oreObject.STORAGE);
            tag(BlockTags.create(new ResourceLocation("forge:storage_blocks/" + oreObject.NAME))).add(oreObject.STORAGE);

            if (oreObject.getMiningLevel() != null) {
                switch (oreObject.getMiningLevel()) {
                    case IRON -> {
                        tag(BlockTags.NEEDS_IRON_TOOL).add(oreObject.ORE);
                        tag(BlockTags.NEEDS_IRON_TOOL).add(oreObject.STORAGE);
                    }
                    case DIAMOND -> {
                        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(oreObject.ORE);
                        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(oreObject.STORAGE);
                    }
                    case STONE -> {
                        tag(BlockTags.NEEDS_STONE_TOOL).add(oreObject.ORE);
                        tag(BlockTags.NEEDS_STONE_TOOL).add(oreObject.STORAGE);
                    }
                }
            }
        });

        tag(BlockTags.COPPER_ORES).add(new OreObjectBuilder().setName("copper").build().ORE);
    }
}
