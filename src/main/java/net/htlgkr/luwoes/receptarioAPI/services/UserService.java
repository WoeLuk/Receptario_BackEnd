package net.htlgkr.luwoes.receptarioAPI.services;

import net.htlgkr.luwoes.receptarioAPI.dtos.UserDTO;
import net.htlgkr.luwoes.receptarioAPI.models.ReceptarioUser;
import net.htlgkr.luwoes.receptarioAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public boolean checkUserLogin(String username, String password) {
    boolean validInfo = false;

    int users = (int) userRepository.findAll().stream().filter(user -> {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        return true;
      } else {
        return false;
      }
    }).count();

    if (users > 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean addUser(String username, String password) {
    ReceptarioUser newUser = new ReceptarioUser(username, password);
    ReceptarioUser userNameTaken = userRepository.findUserByUsername(newUser.getUsername());

    if (userNameTaken == null) {
      userRepository.save(newUser);
      return true;
    } else {
      return false;
    }
  }
}
