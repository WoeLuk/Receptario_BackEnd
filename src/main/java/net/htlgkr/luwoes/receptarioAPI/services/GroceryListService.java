package net.htlgkr.luwoes.receptarioAPI.services;

import net.htlgkr.luwoes.receptarioAPI.models.GroceryList;
import net.htlgkr.luwoes.receptarioAPI.models.Ingredient;
import net.htlgkr.luwoes.receptarioAPI.repositories.GroceriesRepository;
import net.htlgkr.luwoes.receptarioAPI.repositories.GroceryListRepository;
import net.htlgkr.luwoes.receptarioAPI.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GroceryListService {

  @Autowired
  GroceryListRepository groceryListRepository;

  @Autowired
  GroceriesRepository groceriesRepository;

  public void addList(GroceryList list) {
    if (groceryListRepository.findAll().stream().filter(grList -> list.getUsername().equals(grList.getUsername())).count() > 0) {
      System.out.println("Username: '" + list.getUsername() + "' already has an existing grocery list");
      GroceryList pastList = null;
      try {
        pastList = groceryListRepository.findAll().stream().filter(grList -> grList.getUsername().equals(list.getUsername())).findFirst().get();
      } catch (NoSuchElementException e) {
        System.out.println("No grocery list for this username yet");
      }

      if (pastList != null) {

        for (Ingredient i : pastList.getGroceryList()) {
          groceriesRepository.delete(i);
        }
        groceryListRepository.delete(pastList);
      }
    }
      groceriesRepository.saveAll(list.getGroceryList());
      groceryListRepository.save(list);
  }

  public GroceryList getListWithUsername(String username) {
    try {
      return groceryListRepository.findAll().stream().filter(grList -> grList.getUsername().equals(username)).findFirst().get();
    } catch (NoSuchElementException e) {
      System.out.println("No grocery list for this username yet");
    }
    return null;
  }
}
