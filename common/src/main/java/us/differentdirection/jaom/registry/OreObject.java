package us.differentdirection.jaom.registry;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OreObject {
    private final MiningLevel miningLevel;
    public String NAME;
    public RegistrySupplier<Item> INGOT;
    public RegistrySupplier<Item> NUGGET;
    public RegistrySupplier<Item> RAW;
    public RegistrySupplier<Block> ORE;
    public RegistrySupplier<Block> STORAGE;
    public Boolean hasNugget;

    public OreObject(String name, BlockBehaviour.Properties blockProperties, Item.Properties itemProperties, Boolean hasNugget, MiningLevel miningLevel) {
        this.NAME = name;
        this.hasNugget = hasNugget;
        this.INGOT = JARegistry.ITEMS.register(this.NAME + "_ingot", () -> new Item(itemProperties));
        if (hasNugget)
            this.NUGGET = JARegistry.ITEMS.register(this.NAME + "_nugget", () -> new Item(itemProperties));
        this.RAW = JARegistry.ITEMS.register("raw_" + this.NAME, () -> new Item(itemProperties));
        this.ORE = JARegistry.BLOCKS.register(this.NAME + "_ore", () -> new Block(blockProperties.sound(SoundType.STONE)));
        JARegistry.ITEMS.register(this.NAME + "_ore", () -> new BlockItem(this.ORE.get(), itemProperties));
        this.STORAGE = JARegistry.BLOCKS.register(this.NAME + "_block", () -> new Block(blockProperties.sound(SoundType.METAL)));
        JARegistry.ITEMS.register(this.NAME + "_block", () -> new BlockItem(this.STORAGE.get(), itemProperties));

        this.miningLevel = miningLevel;
    }

    public MiningLevel getMiningLevel() {
        return miningLevel;
    }

}
