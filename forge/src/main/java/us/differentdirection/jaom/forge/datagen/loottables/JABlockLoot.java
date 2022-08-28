package us.differentdirection.jaom.forge.datagen.loottables;

import com.google.common.collect.Streams;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import us.differentdirection.jaom.manager.OreManager;

import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JABlockLoot extends BlockLoot {

    @Override
    protected void addTables() {
        OreManager.ores.forEach(oreObject -> {
            dropSelf(oreObject.STORAGE.get());
            this.add(oreObject.ORE.get(), createOreDrop(oreObject.ORE.get(), oreObject.RAW.get()));
        });
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return Streams.concat(
                OreManager.ores.stream().map(ore -> ore.STORAGE).filter(RegistrySupplier::isPresent),
                OreManager.ores.stream().map(ore -> ore.ORE).filter(RegistrySupplier::isPresent)
        ).map(Supplier::get).collect(Collectors.toList());
    }

}
