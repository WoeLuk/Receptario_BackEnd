package net.htlgkr.luwoes.receptarioAPI.controllers;

import net.htlgkr.luwoes.receptarioAPI.dtos.GroceryListDTO;
import net.htlgkr.luwoes.receptarioAPI.dtos.IngredientDTO;
import net.htlgkr.luwoes.receptarioAPI.models.GroceryList;
import net.htlgkr.luwoes.receptarioAPI.models.Ingredient;
import net.htlgkr.luwoes.receptarioAPI.services.GroceryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/grocery")
public class GroceryController {

  @Autowired
  GroceryListService service;

  @PostMapping("/add")
  public void addGroceryList(@RequestBody GroceryListDTO groceryListDTO) {
    System.out.println("Adding grocery list");
    List<IngredientDTO> _ingredients = groceryListDTO.getGroceryList();
    List<Ingredient> ingredients = new ArrayList<>();
    for (IngredientDTO ingDTO : _ingredients) {
      ingredients.add(new Ingredient(ingDTO.getIngredientName()));
    }
    service.addList(new GroceryList(ingredients, groceryListDTO.getUsername()));
  }

  @GetMapping
  public GroceryListDTO getGroceryListWithUsername(@RequestParam String username) {
    System.out.println("Loading grocery list");
    GroceryList list = service.getListWithUsername(username);
    List<Ingredient> ingredients = list.getGroceryList();
    List<IngredientDTO> ingDTOs = new ArrayList<>();

    for (Ingredient i : ingredients) {
      ingDTOs.add(new IngredientDTO(i.getIngredientName()));
    }
    return new GroceryListDTO(ingDTOs, list.getUsername());
  }
}
