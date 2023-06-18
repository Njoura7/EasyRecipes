package njoura.easyRecipes.controllers;

import njoura.easyRecipes.model.Recipe;
import njoura.easyRecipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add-recipe")
    public String addRecipe() {
        return "add-recipe";
    }

    @GetMapping("/view-recipes")
    public String recipes(Model model) {
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "recipes";
    }
}
