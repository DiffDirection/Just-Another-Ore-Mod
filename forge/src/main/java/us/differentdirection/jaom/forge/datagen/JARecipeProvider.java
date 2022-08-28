package us.differentdirection.jaom.forge.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreManager;

import java.util.function.Consumer;

public class JARecipeProvider extends RecipeProvider {
    public JARecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        registerShapedRecipes(consumer);
        registerShapelessRecipes(consumer);
        registerSmeltingRecipes(consumer);
    }

    private void registerShapedRecipes(Consumer<FinishedRecipe> consumer) {
        OreManager.ores.forEach(oreObject -> {
            // oreObject.INGOT -> oreObject.STORAGE.get()
            ShapedRecipeBuilder.shaped(oreObject.STORAGE.get())
                    .define('I', oreObject.INGOT.get())
                    .pattern("III")
                    .pattern("III")
                    .pattern("III")
                    .unlockedBy("has_" + oreObject.NAME + "_ingot", has(oreObject.INGOT.get()))
                    .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_ingot_to_storage"));
            if (oreObject.hasNugget) {
                // oreObject.NUGGET -> oreObject.INGOT
                ShapedRecipeBuilder.shaped(oreObject.INGOT.get())
                        .define('I', oreObject.NUGGET.get())
                        .pattern("III")
                        .pattern("III")
                        .pattern("III")
                        .unlockedBy("has_" + oreObject.NAME + "_nugget", has(oreObject.NUGGET.get()))
                        .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_nuggets_to_iron"));
            }
        });
    }

    private void registerShapelessRecipes(Consumer<FinishedRecipe> consumer) {
        OreManager.ores.forEach(oreObject -> {
            if (oreObject.hasNugget) {
                // oreObject.INGOT -> oreObject.NUGGET
                ShapelessRecipeBuilder.shapeless(oreObject.NUGGET.get(), 9)
                        .requires(oreObject.INGOT.get())
                        .unlockedBy("has_" + oreObject.NAME + "_ingot", has(oreObject.INGOT.get()))
                        .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_ingot_to_nugget"));
            }
            // oreObject.STORAGE.get() -> oreObject.INGOT
            ShapelessRecipeBuilder.shapeless(oreObject.INGOT.get(), 9)
                    .requires(oreObject.STORAGE.get())
                    .unlockedBy("has_" + oreObject.NAME + "_block", has(oreObject.STORAGE.get()))
                    .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_storage_to_ingot"));
        });
    }

    private void registerSmeltingRecipes(Consumer<FinishedRecipe> consumer) {
        OreManager.ores.forEach(oreObject -> {
            // oreObject.RAW -> oreObject.INGOT
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(oreObject.RAW.get()), oreObject.INGOT.get(), 2f, 100)
                    .unlockedBy("has_raw_" + oreObject.NAME, has(oreObject.RAW.get()))
                    .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_ore_smelting"));
        });
    }

}
