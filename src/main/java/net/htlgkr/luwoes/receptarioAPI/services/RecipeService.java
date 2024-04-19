package net.htlgkr.luwoes.receptarioAPI.services;

import net.htlgkr.luwoes.receptarioAPI.dtos.RecipeDTO;
import net.htlgkr.luwoes.receptarioAPI.models.Recipe;
import net.htlgkr.luwoes.receptarioAPI.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
  
  @Autowired
  RecipeRepository recipeRepository;
  
  public List<RecipeDTO> getRecipes() {
    return recipeRepository.findAll().stream().map(Recipe::toDTO).toList();
  }
}
