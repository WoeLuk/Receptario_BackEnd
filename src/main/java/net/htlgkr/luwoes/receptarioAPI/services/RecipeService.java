package net.htlgkr.luwoes.receptarioAPI.services;

import jakarta.servlet.http.HttpServletResponse;
import net.htlgkr.luwoes.receptarioAPI.dtos.RecipeDTO;
import net.htlgkr.luwoes.receptarioAPI.models.CookingStep;
import net.htlgkr.luwoes.receptarioAPI.models.Ingredient;
import net.htlgkr.luwoes.receptarioAPI.models.Recipe;
import net.htlgkr.luwoes.receptarioAPI.repositories.CookingStepsRepository;
import net.htlgkr.luwoes.receptarioAPI.repositories.IngredientsRepository;
import net.htlgkr.luwoes.receptarioAPI.repositories.RecipeRepository;
import net.htlgkr.luwoes.receptarioAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
public class RecipeService {
  
  @Autowired
  RecipeRepository recipeRepository;

  @Autowired
  UserRepository userRepository;

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

    String username = recipeDTO.getUploaded_username();

    Recipe recipe = new Recipe(recipeDTO.getName(), recipeDTO.getCategory(), recipeDTO.getDifficulty(), recipeDTO.getDuration(), ingredients, cookingSteps, recipeDTO.getUploaded_username());
    recipeRepository.save(recipe);
    return true;
  }

  public List<RecipeDTO> getRecipesWithUsername(String username) {
    List<RecipeDTO> recipeDTOS =  recipeRepository.findAll().stream().filter(recipe -> recipe.getUploaded_username().equals(username)).map(Recipe::toDTO).toList();
    return recipeDTOS;
  }

  public List<RecipeDTO> searchRecipes(String type, String term) {
    if (type.equals("Name")) {
      return recipeRepository.findAll().stream().filter(recipe -> recipe.getName().toLowerCase().contains(term.toLowerCase())).map(Recipe::toDTO).toList();
    } else if (type.equals("Category")) {
      return recipeRepository.findAll().stream().filter(recipe -> recipe.getCategory().toString().toLowerCase().contains(term.toLowerCase())).map(Recipe::toDTO).toList();
    } else if (type.equals("Difficulty")) {
      return recipeRepository.findAll().stream().filter(recipe -> recipe.getDifficulty().toString().toLowerCase().contains(term.toLowerCase())).map(Recipe::toDTO).toList();
    }
    return null;
  }
}
