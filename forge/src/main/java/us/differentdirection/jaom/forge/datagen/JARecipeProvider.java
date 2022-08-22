package us.differentdirection.jaom.forge.datagen;

import us.differentdirection.jaom.JAOreMod;
import us.differentdirection.jaom.manager.OreMananger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

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
        OreMananger.ores.forEach(oreObject -> {
            // oreObject.INGOT -> oreObject.STORAGE
            ShapedRecipeBuilder.shaped(oreObject.STORAGE)
                    .define('I', oreObject.INGOT)
                    .pattern("III")
                    .pattern("III")
                    .pattern("III")
                    .unlockedBy("has_" + oreObject.NAME + "_ingot", has(oreObject.INGOT))
                    .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_ingot_to_storage"));
            if (oreObject.hasNugget) {
                // oreObject.NUGGET -> oreObject.INGOT
                ShapedRecipeBuilder.shaped(oreObject.INGOT)
                        .define('I', oreObject.NUGGET)
                        .pattern("III")
                        .pattern("III")
                        .pattern("III")
                        .unlockedBy("has_" + oreObject.NAME + "_nugget", has(oreObject.NUGGET))
                        .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_nuggets_to_iron"));
            }
        });
    }

    private void registerShapelessRecipes(Consumer<FinishedRecipe> consumer) {
        OreMananger.ores.forEach(oreObject -> {
            if (oreObject.hasNugget) {
                // oreObject.INGOT -> oreObject.NUGGET
                ShapelessRecipeBuilder.shapeless(oreObject.NUGGET, 9)
                        .requires(oreObject.INGOT)
                        .unlockedBy("has_" + oreObject.NAME + "_ingot", has(oreObject.INGOT))
                        .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_ingot_to_nugget"));
            }
            // oreObject.STORAGE -> oreObject.INGOT
            ShapelessRecipeBuilder.shapeless(oreObject.INGOT, 9)
                    .requires(oreObject.STORAGE)
                    .unlockedBy("has_" + oreObject.NAME + "_block", has(oreObject.STORAGE))
                    .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_storage_to_ingot"));
        });
    }

    private void registerSmeltingRecipes(Consumer<FinishedRecipe> consumer) {
        OreMananger.ores.forEach(oreObject -> {
            // oreObject.RAW -> oreObject.INGOT
            SimpleCookingRecipeBuilder.smelting(Ingredient.of(oreObject.RAW), oreObject.INGOT, 2f, 100)
                    .unlockedBy("has_raw_" + oreObject.NAME, has(oreObject.RAW))
                    .save(consumer, new ResourceLocation(JAOreMod.MOD_ID, oreObject.NAME + "_ore_smelting"));
        });
    }

}
