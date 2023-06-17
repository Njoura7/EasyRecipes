package njoura.easyRecipes.service;

import njoura.easyRecipes.Model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> findAllRecipes();
    Recipe findRecipeById(Long id);
    Recipe saveRecipe(Recipe recipe);
    void deleteRecipe(Long id);
}