package us.differentdirection.jaom.forge.datagen.loottables;

import us.differentdirection.jaom.manager.OreMananger;
import us.differentdirection.jaom.registry.JARegistry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JABlockLoot extends BlockLoot {

    @Override
    protected void addTables() {
        OreMananger.ores.forEach(oreObject -> {
            dropSelf(oreObject.STORAGE);
            this.add(oreObject.ORE, createOreDrop(oreObject.ORE, oreObject.RAW));
        });

    }

//    @Override
//    protected @NotNull Iterable<Block> getKnownBlocks() {
//        return JARegistry.BLOCKS.getRegistries().;
//    }

}
