package us.differentdirection.jaom.registry;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import us.differentdirection.jaom.manager.OreMananger;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;

import static us.differentdirection.jaom.JAOreMod.MOD_ID;

public class JARegistry {
    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MOD_ID));

    public static final CreativeModeTab JAOM_TAB = CreativeTabRegistry.create(new ResourceLocation(MOD_ID, "jaom_tab"), () ->
            new ItemStack(OreMananger.TAB_ICON));

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_REGISTRY);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_REGISTRY);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(MOD_ID, Registry.MENU_REGISTRY);

    public static void init() {
        BLOCKS.register();
        ITEMS.register();
        BLOCK_ENTITY_TYPES.register();
        MENU_TYPES.register();

        registerOres();
    }

    private static void registerOres() {
        OreMananger.ores.forEach(oreObject -> {
            JARegistry.ITEMS.register(oreObject.NAME + "_ingot", () -> oreObject.INGOT);
            if (oreObject.hasNugget) JARegistry.ITEMS.register(oreObject.NAME + "_nugget", () -> oreObject.NUGGET);
            JARegistry.ITEMS.register("raw_" + oreObject.NAME, () -> oreObject.RAW);
            JARegistry.BLOCKS.register(oreObject.NAME + "_ore", () -> oreObject.ORE);
            JARegistry.ITEMS.register(oreObject.NAME + "_ore", () -> new BlockItem(oreObject.ORE, new Item.Properties().tab(JARegistry.JAOM_TAB)));
            JARegistry.BLOCKS.register(oreObject.NAME + "_block", () -> oreObject.STORAGE);
            JARegistry.ITEMS.register(oreObject.NAME + "_block", () -> new BlockItem(oreObject.STORAGE, new Item.Properties().tab(JARegistry.JAOM_TAB)));
        });
    }
}
