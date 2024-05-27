package net.htlgkr.luwoes.receptarioAPI.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String ingredientName;

  public Ingredient(String ingredientName) {
    this.ingredientName = ingredientName;
  }
}
