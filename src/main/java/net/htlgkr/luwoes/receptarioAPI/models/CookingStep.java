package net.htlgkr.luwoes.receptarioAPI.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CookingStep {
  private String stepDescription;

  public CookingStep(String stepDescription) {
    this.stepDescription = stepDescription;
  }
}
