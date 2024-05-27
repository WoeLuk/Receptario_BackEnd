package net.htlgkr.luwoes.receptarioAPI.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientDTO {
  private String ingredientName;

  public IngredientDTO(String ingredientName) {
    this.ingredientName = ingredientName;
  }

}
