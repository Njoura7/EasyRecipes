package njoura.easyRecipes.controllers;

import njoura.easyRecipes.model.Recipe;
import njoura.easyRecipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

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

    @PostMapping("/recipes/update/{id}")
    public String updateRecipe(@PathVariable Long id, @ModelAttribute Recipe recipe) {
        recipe.setId(id);
        recipeService.update(recipe);
        return "redirect:/view-recipes";
    }


    @PostMapping("/recipes/delete/{id}")
    public String deleteRecipe(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        recipeService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Recipe deleted successfully");
        return "redirect:/view-recipes";
    }

}
