package us.differentdirection.jaom.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class OreObject {
    private final MiningLevel miningLevel;
    public String NAME;
    public Block ORE;
    public Block STORAGE;
    public Boolean hasNugget;

    public OreObject(String name, Boolean hasNugget, MiningLevel miningLevel) {
        this.NAME = name;
        this.hasNugget = hasNugget;
        this.ORE = null; //new Block();
        this.STORAGE = null; //new Block(new Block.Properties());

        this.miningLevel = miningLevel;
    }

    public MiningLevel getMiningLevel() {
        return miningLevel;
    }

}
