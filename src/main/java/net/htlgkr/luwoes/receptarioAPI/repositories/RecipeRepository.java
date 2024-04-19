package net.htlgkr.luwoes.receptarioAPI.repositories;

import net.htlgkr.luwoes.receptarioAPI.models.Recipe;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends ListCrudRepository<Recipe, Integer> {
}
