package net.htlgkr.luwoes.receptarioAPI.dtos;

import net.htlgkr.luwoes.receptarioAPI.enums.Category;
import net.htlgkr.luwoes.receptarioAPI.enums.Difficulty;

public class RecipeDTO {
  private String name;
  private Category category;
  private Difficulty difficulty;
  private String duration;

  //Strings hier müssen noch geändert werden!
  private String ingredients;
  private String cookingSteps;

  public RecipeDTO(String name, Category category, Difficulty difficulty, String duration, String ingredients, String cookingSteps) {
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

  public String getIngredients() {
    return ingredients;
  }

  public String getCookingSteps() {
    return cookingSteps;
  }
}
