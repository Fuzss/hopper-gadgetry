package fuzs.hoppergadgetry.common.data;

import fuzs.hoppergadgetry.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v3.recipes.AbstractRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;

public class ModRecipeProvider extends AbstractRecipeProvider {

    public ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    @Override
    public void buildRecipes() {
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.REDSTONE, ModRegistry.GRATED_HOPPER_ITEM.value())
                .define('#', Items.IRON_BARS)
                .define('X', Items.HOPPER)
                .pattern("#")
                .pattern("X")
                .group(getItemName(ModRegistry.GRATED_HOPPER_ITEM.value()))
                .unlockedBy(getHasName(Items.HOPPER), this.has(Items.HOPPER))
                .save(this.output,
                        getItemName(ModRegistry.GRATED_HOPPER_ITEM.value()) + "_from_" + getItemName(Items.HOPPER));
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.REDSTONE, ModRegistry.GRATED_HOPPER_ITEM.value())
                .define('#', Items.IRON_BARS)
                .define('I', Items.IRON_INGOT)
                .define('C', Items.CHEST)
                .pattern("I#I")
                .pattern("ICI")
                .pattern(" I ")
                .group(getItemName(ModRegistry.GRATED_HOPPER_ITEM.value()))
                .unlockedBy(getHasName(Items.CHEST), this.has(Items.CHEST))
                .save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.REDSTONE, ModRegistry.DUCT_ITEM.value())
                .define('#', ItemTags.PLANKS)
                .define('I', Items.IRON_INGOT)
                .pattern("#I#")
                .unlockedBy(getHasName(Items.IRON_INGOT), this.has(Items.IRON_INGOT))
                .save(this.output);
        ShapedRecipeBuilder.shaped(this.items, RecipeCategory.REDSTONE, ModRegistry.CHUTE_ITEM.value())
                .define('#', ItemTags.PLANKS)
                .define('X', ItemTags.LOGS)
                .pattern("# #")
                .pattern("#X#")
                .pattern(" # ")
                .unlockedBy(getHasName(Items.CHEST), this.has(Items.CHEST))
                .save(this.output);
        ShapelessRecipeBuilder.shapeless(this.items,
                        RecipeCategory.TRANSPORTATION,
                        ModRegistry.GRATED_HOPPER_MINECART_ITEM.value())
                .requires(ModRegistry.GRATED_HOPPER_ITEM.value())
                .requires(Items.MINECART)
                .unlockedBy(getHasName(Items.MINECART), this.has(Items.MINECART))
                .save(this.output);
        ShapelessRecipeBuilder.shapeless(this.items,
                        RecipeCategory.TRANSPORTATION,
                        ModRegistry.CHUTE_MINECART_ITEM.value())
                .requires(ModRegistry.CHUTE_ITEM.value())
                .requires(Items.MINECART)
                .unlockedBy(getHasName(Items.MINECART), this.has(Items.MINECART))
                .save(this.output);
    }
}
