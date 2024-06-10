package net.htlgkr.luwoes.receptarioAPI.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GroceryList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long groceryID;

  @OneToMany
  private List<Ingredient> groceryList;
  private String username;

  public GroceryList(List<Ingredient> groceryList, String username) {
    this.groceryList = groceryList;
    this.username = username;
  }
}
