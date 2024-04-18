package net.htlgkr.luwoes.receptarioAPI.services;

import net.htlgkr.luwoes.receptarioAPI.dtos.User;
import net.htlgkr.luwoes.receptarioAPI.dtos.UserDTO;
import net.htlgkr.luwoes.receptarioAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public boolean checkUserLogin(UserDTO userDTO) {
    boolean validInfo = false;

    int users = (int) userRepository.findAll().stream().filter(user -> {
      if (user.getUsername().equalsIgnoreCase(userDTO.getUsername()) && user.getPassword().equalsIgnoreCase(userDTO.getPassword())) {
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

  public UserDTO addUser(UserDTO userDTO) throws ResponseStatusException {
    User newUser = new User(userDTO.getUsername(), userDTO.getPassword());
    User userNameTaken = userRepository.findUserByUsername(newUser.getUsername());

    if (userNameTaken == null) {
      userRepository.save(newUser);
      return userDTO;
    } else {
      throw new ResponseStatusException(HttpStatus.CONFLICT);
    }
  }
}
