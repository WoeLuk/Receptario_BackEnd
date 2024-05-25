package net.htlgkr.luwoes.receptarioAPI.repositories;

import net.htlgkr.luwoes.receptarioAPI.models.GroceryList;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryListRepository extends ListCrudRepository<GroceryList, Integer> {
}
