package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.creature.Beast;
import LairOfTheForgottenBeast.domain.creature.Construct;
import LairOfTheForgottenBeast.domain.creature.Humanoid;
import LairOfTheForgottenBeast.domain.creature.Undead;

public class CreatureTesting {
  public Humanoid createHuman() {
    return new Humanoid();
  }

  public Beast createBeast() {
    return new Beast();
  }

  public Construct createConstruct() {
    return new Construct();
  }

  public Undead createUndead() {
    return new Undead();
  }
}
