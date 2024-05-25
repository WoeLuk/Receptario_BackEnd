package net.htlgkr.luwoes.receptarioAPI.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDTO {
  private String ingredientName;

  public IngredientDTO(String ingredientName) {
    this.ingredientName = ingredientName;
  }

}
