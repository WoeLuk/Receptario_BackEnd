package net.htlgkr.luwoes.receptarioAPI.dtos;

import net.htlgkr.luwoes.receptarioAPI.enums.Category;
import net.htlgkr.luwoes.receptarioAPI.enums.Difficulty;
import net.htlgkr.luwoes.receptarioAPI.models.CookingStep;
import net.htlgkr.luwoes.receptarioAPI.models.Ingredient;

import java.util.List;

public class RecipeDTO {
  private String name;
  private Category category;
  private Difficulty difficulty;
  private String duration;

  //Strings hier müssen noch geändert werden!
  private List<Ingredient> ingredients;
  private List<CookingStep> cookingSteps;

  public RecipeDTO(String name, Category category, Difficulty difficulty, String duration, List<Ingredient> ingredients, List<CookingStep> cookingSteps) {
    this.name = name;
    this.category = category;
    this.difficulty = difficulty;
    this.duration = duration;
    this.ingredients = ingredients;
    this.cookingSteps = cookingSteps;
  }

  public String getName() {
    return name;
  }

  public Category getCategory() {
    return category;
  }

  public Difficulty getDifficulty() {
    return difficulty;
  }

  public String getDuration() {
    return duration;
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public List<CookingStep> getCookingSteps() {
    return cookingSteps;
  }
}
