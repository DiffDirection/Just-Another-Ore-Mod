package us.differentdirection.jaom.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class OreObjectBuilder {
    private String name;
    private BlockBehaviour.Properties blockProperties = BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).requiresCorrectToolForDrops();
    private Item.Properties itemProperties = new Item.Properties();//.tab(JARegistry.JAOM_TAB);
    private Boolean hasNugget = true;
    private MiningLevel miningLevel = MiningLevel.IRON;

    public OreObjectBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public OreObjectBuilder setBlockProperties(BlockBehaviour.Properties blockProperties) {
        this.blockProperties = blockProperties;
        return this;
    }

    public OreObjectBuilder setItemProperties(Item.Properties itemProperties) {
        this.itemProperties = itemProperties;
        return this;
    }

    public OreObjectBuilder setHasNugget(Boolean hasNugget) {
        this.hasNugget = hasNugget;
        return this;
    }

    public OreObjectBuilder setMiningLevel(MiningLevel miningLevel) {
        this.miningLevel = miningLevel;
        return this;
    }

    public OreObject build() {
        return new OreObject(name, blockProperties, itemProperties, hasNugget, miningLevel);
    }
}