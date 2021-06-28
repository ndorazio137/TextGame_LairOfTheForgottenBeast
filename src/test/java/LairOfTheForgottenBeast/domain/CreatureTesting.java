package LairOfTheForgottenBeast.domain;

import LairOfTheForgottenBeast.domain.creature.Beast;
import LairOfTheForgottenBeast.domain.creature.Construct;
import LairOfTheForgottenBeast.domain.creature.Hobgoblin;
import LairOfTheForgottenBeast.domain.creature.Human;
import LairOfTheForgottenBeast.domain.creature.Undead;

public class CreatureTesting
{
   public Human mockHuman()
   {
      return new Human();
   }
   
   public Beast mockBeast()
   {
      return new Beast();
   }
   
   public Construct mockConstruct()
   {
      return new Construct();
   }
   
   public Hobgoblin mockHobgoblin()
   {
      return new Hobgoblin();
   }
   
   public Undead mockUndead()
   {
      return new Undead();
   }  
}