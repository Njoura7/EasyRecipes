package njoura.easyRecipes.controllers;

import njoura.easyRecipes.service.RecipeService;
import njoura.easyRecipes.model.Recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String getAllRecipes(Model model) {
        List<Recipe> recipes = recipeService.findAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    // Add more methods for creating, updating, and deleting recipes
}
