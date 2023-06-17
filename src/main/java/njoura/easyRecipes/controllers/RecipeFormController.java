package njoura.easyRecipes.controllers;

import njoura.easyRecipes.Model.Category;
import njoura.easyRecipes.Model.Ingredient;
import njoura.easyRecipes.Model.Recipe;
import njoura.easyRecipes.Model.Tag;
import njoura.easyRecipes.repository.CategoryRepository;
import njoura.easyRecipes.repository.IngredientRepository;
import njoura.easyRecipes.repository.RecipeRepository;
import njoura.easyRecipes.repository.TagRepository;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/recipe-form")
public class RecipeFormController {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;

    @Autowired
    public RecipeFormController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository,
                                CategoryRepository categoryRepository, TagRepository tagRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }

    @GetMapping
    public ResponseEntity<Recipe> showRecipeForm() {
        Recipe recipe = new Recipe();
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/tags")
    public List<Tag> getTags() {
        return tagRepository.findAll();
    }

    @PostMapping
    public Recipe submitRecipeForm(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
