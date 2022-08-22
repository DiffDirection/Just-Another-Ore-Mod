package us.differentdirection.jaom.registry;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static us.differentdirection.jaom.JAOreMod.MOD_ID;

public class OreObject
{
    private final MiningLevel miningLevel;
    public String NAME;
    public RegistrySupplier<Item> INGOT;

    public RegistrySupplier<Item> NUGGET;

    public RegistrySupplier<Item> RAW;

    public Block ORE;
    public Block STORAGE;
    public Boolean hasNugget;

    public OreObject(String name, BlockBehaviour.Properties blockProperties, Item.Properties itemProperties, Boolean hasNugget, MiningLevel miningLevel)
    {
        this.NAME = name;
        this.hasNugget = hasNugget;
        this.INGOT = JARegistry.ITEMS.register(new ResourceLocation(MOD_ID, this.NAME+"_ingot"), () -> new Item(itemProperties.tab(JARegistry.JAOM_TAB)));
        if(hasNugget)
            this.NUGGET = JARegistry.ITEMS.register(new ResourceLocation(MOD_ID, this.NAME+"_nugget"), () -> new Item(itemProperties.tab(JARegistry.JAOM_TAB)));
        this.RAW = JARegistry.ITEMS.register(new ResourceLocation(MOD_ID, "raw_" + this.NAME), () -> new Item(itemProperties.tab(JARegistry.JAOM_TAB)));
        this.ORE = null; //new Block();
        this.STORAGE = null; //new Block(new Block.Properties());

        this.miningLevel = miningLevel;
    }

    public MiningLevel getMiningLevel() {
        return miningLevel;
    }

}
