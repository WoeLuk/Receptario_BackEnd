package net.htlgkr.luwoes.receptarioAPI.dtos;

public class UserDTO {
  private String username;
  private String password;

  public UserDTO(String password, String username) {
    this.password = password;
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
