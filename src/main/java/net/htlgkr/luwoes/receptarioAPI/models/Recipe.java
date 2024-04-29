package net.htlgkr.luwoes.receptarioAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.htlgkr.luwoes.receptarioAPI.dtos.RecipeDTO;
import net.htlgkr.luwoes.receptarioAPI.enums.Category;
import net.htlgkr.luwoes.receptarioAPI.enums.Difficulty;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Recipe {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String uploaded_username;
  private Category category;
  private Difficulty difficulty;
  private String duration;

  @OneToMany
  private List<Ingredient> ingredients;

  @OneToMany
  private List<CookingStep> cookingSteps;

  public Recipe(String name, Category category, Difficulty difficulty, String duration, List<Ingredient> ingredients, List<CookingStep> cookingSteps, String uploaded_username) {
    this.name = name;
    this.category = category;
    this.difficulty = difficulty;
    this.duration = duration;
    this.ingredients = ingredients;
    this.cookingSteps = cookingSteps;
    this.uploaded_username = uploaded_username;
  }

  public RecipeDTO toDTO() {
    return new RecipeDTO(name, category, difficulty, duration, ingredients, cookingSteps, uploaded_username);
  }
}
