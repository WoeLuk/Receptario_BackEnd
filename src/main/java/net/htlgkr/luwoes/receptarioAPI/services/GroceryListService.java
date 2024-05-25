package net.htlgkr.luwoes.receptarioAPI.services;

import net.htlgkr.luwoes.receptarioAPI.models.GroceryList;
import net.htlgkr.luwoes.receptarioAPI.repositories.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroceryListService {

  @Autowired
  GroceryListRepository groceryListRepository;

  public void addList(GroceryList list) {
    if (groceryListRepository.findAll().stream().filter(grList -> list.getUsername().equals(grList.getUsername())).count() > 0) {
      groceryListRepository.findAll().stream().filter(grList -> list.getUsername().equals(grList.getUsername())).forEach(grList -> grList.setGroceryList(list.getGroceryList()));
    } else {
      groceryListRepository.save(list);
    }
  }

  public GroceryList getListWithUsername(String username) {
    return groceryListRepository.findAll().stream().filter(grList -> grList.getUsername().equals(username)).findFirst().get();
  }
}
