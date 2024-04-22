package net.htlgkr.luwoes.receptarioAPI.repositories;

import net.htlgkr.luwoes.receptarioAPI.models.CookingStep;
import org.springframework.data.repository.ListCrudRepository;

public interface CookingStepsRepository extends ListCrudRepository<CookingStep, Integer> {
}
