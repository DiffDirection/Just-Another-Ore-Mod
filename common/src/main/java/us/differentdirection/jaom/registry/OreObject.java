package us.differentdirection.jaom.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OreObject {
    private final MiningLevel miningLevel;
    public String NAME;
    public Item INGOT;
    public Item NUGGET;
    public Item RAW;
    public Block ORE;
    public Block STORAGE;
    public Boolean hasNugget;

    public OreObject(String name, BlockBehaviour.Properties blockProperties, Item.Properties itemProperties, Boolean hasNugget, MiningLevel miningLevel) {
        this.NAME = name;
        this.hasNugget = hasNugget;
        this.INGOT = new Item(itemProperties);
        if (hasNugget)
            this.NUGGET = new Item(itemProperties);
        this.RAW = new Item(itemProperties);
        this.ORE = new Block(blockProperties.sound(SoundType.STONE));
        this.STORAGE = new Block(blockProperties.sound(SoundType.METAL));

        this.miningLevel = miningLevel;
    }

    public MiningLevel getMiningLevel() {
        return miningLevel;
    }

}
