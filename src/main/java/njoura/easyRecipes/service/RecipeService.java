package njoura.easyRecipes.service;

import njoura.easyRecipes.model.Recipe;
import njoura.easyRecipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
    public Recipe update(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
