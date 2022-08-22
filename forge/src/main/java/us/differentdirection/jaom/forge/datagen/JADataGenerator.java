package us.differentdirection.jaom.forge.datagen;

import net.minecraftforge.data.event.GatherDataEvent;
import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.forge.datagen.blocks.JABlockModels;
import us.differentdirection.jaom.forge.datagen.blocks.JABlockStates;
import us.differentdirection.jaom.forge.datagen.loottables.JALootTableGenerator;
import us.differentdirection.jaom.forge.datagen.tags.JABlockTags;
import us.differentdirection.jaom.forge.datagen.tags.JAItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = JAOreMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class JADataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        if (event.includeServer()) registerServerProviders(event.getGenerator(), event);

        if (event.includeClient()) registerClientProviders(event.getGenerator(), event);

    }

    private static void registerServerProviders(DataGenerator generator, GatherDataEvent event) {
        generator.addProvider(true, new JARecipeProvider(generator));
    }

    private static void registerClientProviders(DataGenerator generator, GatherDataEvent event) {
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(true, new JABlockModels(generator, helper));
        generator.addProvider(true, new JAItemModels(generator, helper));
        generator.addProvider(true, new JABlockStates(generator, helper));
        generator.addProvider(true, new JALang(generator));

        JABlockTags blockTags = new JABlockTags(generator, helper);
        generator.addProvider(true, blockTags);
        generator.addProvider(true, new JAItemTags(generator, blockTags, helper));

        generator.addProvider(true, new JALootTableGenerator(generator));
    }
}
