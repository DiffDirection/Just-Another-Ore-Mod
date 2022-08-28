package us.differentdirection.jaom.forge.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import us.differentdirection.jaom.manager.OreManager;

import static us.differentdirection.jaom.JAOreMod.MOD_ID;

public class JALang extends LanguageProvider {

    public JALang(DataGenerator generator) {
        super(generator, MOD_ID, "en_us");
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.jaom.jaom_tab", "Just Another Ore Mod");
        OreManager.ores.forEach(oreObject -> {
            add("block.jaom." + oreObject.NAME + "_ore", capitalize(oreObject.NAME) + " Ore");
            add("block.jaom." + oreObject.NAME + "_block", capitalize(oreObject.NAME) + " Block");
            add("item.jaom." + oreObject.NAME + "_ingot", capitalize(oreObject.NAME) + " Ingot");
            if (oreObject.hasNugget)
                add("item.jaom." + oreObject.NAME + "_nugget", capitalize(oreObject.NAME) + " Nugget");
            add("item.jaom." + "raw_" + oreObject.NAME, "Raw " + capitalize(oreObject.NAME));
        });
    }
}
