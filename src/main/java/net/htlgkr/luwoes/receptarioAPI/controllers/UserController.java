package net.htlgkr.luwoes.receptarioAPI.controllers;

import net.htlgkr.luwoes.receptarioAPI.dtos.User;
import net.htlgkr.luwoes.receptarioAPI.dtos.UserDTO;
import net.htlgkr.luwoes.receptarioAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("/checkLogin")
  public boolean checkLoginInformation(@RequestBody UserDTO userDTO) {
    return userService.checkUserLogin(userDTO);
  }

//  @PostMapping("/add")
//  public UserDTO addUser(@RequestBody UserDTO userDTO) {
//    return userService.addUser(userDTO);
//  }
}
