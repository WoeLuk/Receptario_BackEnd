package net.htlgkr.luwoes.receptarioAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CookingStep {
  @Id
  @GeneratedValue
  private long id;
  private String stepDescription;

  public CookingStep(String stepDescription) {
    this.stepDescription = stepDescription;
  }
}
