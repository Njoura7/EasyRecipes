package njoura.easyRecipes.controllers;

import njoura.easyRecipes.model.Category;
import njoura.easyRecipes.model.Ingredient;
import njoura.easyRecipes.model.Recipe;
import njoura.easyRecipes.model.Tag;
import njoura.easyRecipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "index";
    }

    @PostMapping("/addRecipe")
    public String addRecipe(@ModelAttribute("recipe") Recipe recipe,
                            @RequestParam("category") String category,
                            @RequestParam("description") String description,
                            @RequestParam("ingredientNames") List<String> ingredientNames,
                            @RequestParam("ingredientQuantities") List<Integer> ingredientQuantities,
                            @RequestParam("tags") List<String> tags) {
        Category recipeCategory = new Category();
        recipeCategory.setName(category);
        recipe.setCategory(recipeCategory);
        recipe.setDescription(description);

        for (int i = 0; i < ingredientNames.size(); i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientNames.get(i));
            ingredient.setQuantity(ingredientQuantities.get(i));
            recipe.addIngredient(ingredient);
        }

        for (String tagTitle : tags) {
            Tag tag = new Tag();
            tag.setTitle(tagTitle);
            recipe.addTag(tag);
        }

        recipeService.addRecipe(recipe);

        return "redirect:/viewRecipes";
    }

    @GetMapping("/viewRecipes")
    public String viewRecipes(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
}
