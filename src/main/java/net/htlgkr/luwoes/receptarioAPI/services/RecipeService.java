package net.htlgkr.luwoes.receptarioAPI.services;

import net.htlgkr.luwoes.receptarioAPI.dtos.RecipeDTO;
import net.htlgkr.luwoes.receptarioAPI.models.CookingStep;
import net.htlgkr.luwoes.receptarioAPI.models.Ingredient;
import net.htlgkr.luwoes.receptarioAPI.models.Recipe;
import net.htlgkr.luwoes.receptarioAPI.repositories.CookingStepsRepository;
import net.htlgkr.luwoes.receptarioAPI.repositories.IngredientsRepository;
import net.htlgkr.luwoes.receptarioAPI.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
  
  @Autowired
  RecipeRepository recipeRepository;

  @Autowired
  IngredientsRepository ingredientsRepository;

  @Autowired
  CookingStepsRepository cookingStepsRepository;

  public List<RecipeDTO> getRecipes() {
    return recipeRepository.findAll().stream().map(Recipe::toDTO).toList();
  }

  public boolean addRecipe(RecipeDTO recipeDTO) {
    List<Ingredient> ingredients = recipeDTO.getIngredients();
    ingredientsRepository.saveAll(ingredients);

    List<CookingStep> cookingSteps = recipeDTO.getCookingSteps();
    cookingStepsRepository.saveAll(cookingSteps);

    Recipe recipe = new Recipe(recipeDTO.getName(), recipeDTO.getCategory(), recipeDTO.getDifficulty(), recipeDTO.getDuration(), ingredients, cookingSteps);
    recipeRepository.save(recipe);
    return true;
  }
}
