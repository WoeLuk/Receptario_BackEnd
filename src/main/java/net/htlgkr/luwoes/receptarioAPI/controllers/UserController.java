package net.htlgkr.luwoes.receptarioAPI.controllers;

import net.htlgkr.luwoes.receptarioAPI.dtos.UserDTO;
import net.htlgkr.luwoes.receptarioAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/checkLogin")
  public String checkLoginInformation(@RequestParam String username, @RequestParam String password) {
    System.out.println("Checking login...");
    if (userService.checkUserLogin(username, password)) {
      System.out.println("Logged in");
      return "true";
    } else {
      System.out.println("Not logged in");
      return "false";
    }
  }

  @PostMapping("/add")
  public String addUser(@RequestParam String username, @RequestParam String password) {
    System.out.println("Adding user...");
    if (userService.addUser(username, password)) {
      System.out.println("User added");
      return "true";
    } else {
      System.out.println("User not added");
      return "false";
    }
  }
}
