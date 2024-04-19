package net.htlgkr.luwoes.receptarioAPI.controllers;


import net.htlgkr.luwoes.receptarioAPI.dtos.RecipeDTO;
import net.htlgkr.luwoes.receptarioAPI.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
