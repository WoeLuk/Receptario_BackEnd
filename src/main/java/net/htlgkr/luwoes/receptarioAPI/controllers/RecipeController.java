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
  public String addRecipe(@RequestBody RecipeDTO recipeDTO) {
    System.out.println("Adding recipe...");
    System.out.println(recipeDTO.toString());
    if (recipeService.addRecipe(recipeDTO)) {
      return "true";
    } else {
      return "false";
    }
  }

  @GetMapping("{username}")
  public List<RecipeDTO> getRecipesWithUsername(@PathVariable String username) {
    return recipeService.getRecipesWithUsername(username);
  }
}
