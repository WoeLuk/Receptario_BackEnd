package net.htlgkr.luwoes.receptarioAPI.repositories;

import net.htlgkr.luwoes.receptarioAPI.dtos.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, Integer> {
  public User findUserByUsername(String username);
}
