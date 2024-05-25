package net.htlgkr.luwoes.receptarioAPI.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

  @PostMapping
  public void addGroceryList(@RequestBody GroceryListDTO groceryListDTO) {

  }
}
