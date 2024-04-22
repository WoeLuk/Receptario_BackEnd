package net.htlgkr.luwoes.receptarioAPI.repositories;

import net.htlgkr.luwoes.receptarioAPI.models.Ingredient;
import org.springframework.data.repository.ListCrudRepository;

public interface IngredientsRepository extends ListCrudRepository<Ingredient, Ingredient> {
}
