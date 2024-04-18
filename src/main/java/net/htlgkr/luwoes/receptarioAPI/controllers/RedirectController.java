package net.htlgkr.luwoes.receptarioAPI.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping
public class RedirectController {

  @RequestMapping()
  public void redirect(HttpServletResponse response) {
    try {
      response.sendRedirect("/swagger-ui/index.html");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
