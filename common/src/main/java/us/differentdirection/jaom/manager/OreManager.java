package us.differentdirection.jaom.manager;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;
import us.differentdirection.jaom.registry.MiningLevel;
import us.differentdirection.jaom.registry.OreObject;
import us.differentdirection.jaom.registry.OreObjectBuilder;

import java.util.ArrayList;
import java.util.List;

public class OreManager {

    public static List<OreObject> ores = new ArrayList<>();
    public static RegistrySupplier<Item> TAB_ICON;

    public static void addOres() {
        OreObject aluminum = new OreObjectBuilder().setName("aluminum").setMiningLevel(MiningLevel.STONE).build();
        TAB_ICON = aluminum.INGOT;
        ores.add(aluminum);

        ores.add(new OreObjectBuilder().setName("cobalt").setMiningLevel(MiningLevel.DIAMOND).build());
        ores.add(new OreObjectBuilder().setName("platinum").setMiningLevel(MiningLevel.DIAMOND).build());
        ores.add(new OreObjectBuilder().setName("thorium").setMiningLevel(MiningLevel.DIAMOND).build());

        ores.add(new OreObjectBuilder().setName("copper").setMiningLevel(MiningLevel.STONE).build());
        ores.add(new OreObjectBuilder().setName("nickle").setMiningLevel(MiningLevel.STONE).build());
        ores.add(new OreObjectBuilder().setName("sodium").setMiningLevel(MiningLevel.STONE).build());
        ores.add(new OreObjectBuilder().setName("tin").setMiningLevel(MiningLevel.STONE).build());
        ores.add(new OreObjectBuilder().setName("zinc").setMiningLevel(MiningLevel.STONE).build());

        ores.add(new OreObjectBuilder().setName("lithium").build());
        ores.add(new OreObjectBuilder().setName("magnesium").build());
        ores.add(new OreObjectBuilder().setName("mercury").build());
        ores.add(new OreObjectBuilder().setName("phosphorus").build());
        ores.add(new OreObjectBuilder().setName("plutonium").build());
        ores.add(new OreObjectBuilder().setName("silver").build());
        ores.add(new OreObjectBuilder().setName("titanium").build());
        ores.add(new OreObjectBuilder().setName("tungsten").build());
        ores.add(new OreObjectBuilder().setName("uranium").build());

        ores.add(new OreObjectBuilder().setName("ruby").setHasNugget(false).build());
        ores.add(new OreObjectBuilder().setName("sapphire").setHasNugget(false).build());
        ores.add(new OreObjectBuilder().setName("silicon").setHasNugget(false).build());
    }
}
