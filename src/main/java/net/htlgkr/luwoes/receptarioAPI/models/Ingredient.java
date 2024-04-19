package net.htlgkr.luwoes.receptarioAPI.models;

import lombok.Getter;
import lombok.Setter;


public class Ingredient {
  public String ingredientName;
  public String ingredientDescription;

  public Ingredient(String ingredientName, String ingredientDescription) {
    this.ingredientName = ingredientName;
    this.ingredientDescription = ingredientDescription;
  }
}
