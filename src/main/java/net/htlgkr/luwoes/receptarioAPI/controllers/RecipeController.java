package net.htlgkr.luwoes.receptarioAPI.controllers;


import net.htlgkr.luwoes.receptarioAPI.dtos.RecipeDTO;
import net.htlgkr.luwoes.receptarioAPI.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

  @Autowired
  RecipeService recipeService;

  @GetMapping
  public List<RecipeDTO> getRecipes() {
    return recipeService.getRecipes();
  }

  @PostMapping("/add")
  public RecipeDTO addRecipe(@RequestBody RecipeDTO recipeDTO) {
    System.out.println("Adding recipe...");
    System.out.println(recipeDTO.toString());
    if (recipeService.addRecipe(recipeDTO)) {
      System.out.println("Recipe added successfully");
      return recipeDTO;
    } else {
      System.out.println("Recipe added failed");
      return null;
    }
  }

  @GetMapping("{username}")
  public List<RecipeDTO> getRecipesWithUsername(@PathVariable String username) {
    System.out.println("Loading recipes with username");
    return recipeService.getRecipesWithUsername(username);
  }

  @GetMapping("/search")
  public List<RecipeDTO> getRecipesWithSearchTypeAndTerm(@RequestParam String type, @RequestParam String term) {
    System.out.println("Searching recipe after " + type + " with term: " + term);
    return recipeService.searchRecipes(type, term);
  }
}
