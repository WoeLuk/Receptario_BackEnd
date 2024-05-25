package net.htlgkr.luwoes.receptarioAPI.dtos;

import net.htlgkr.luwoes.receptarioAPI.models.Ingredient;

import java.util.List;

public class GroceryListDTO {
  private List<IngredientDTO> groceryList;
  private String username;

  public GroceryListDTO(List<IngredientDTO> groceryList, String username) {
    this.groceryList = groceryList;
    this.username = username;
  }

  public List<IngredientDTO> getGroceryList() {
    return groceryList;
  }

  public String getUsername() {
    return username;
  }
}
