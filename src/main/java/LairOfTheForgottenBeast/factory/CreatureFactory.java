package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.creature.Beast;
import LairOfTheForgottenBeast.domain.creature.Construct;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.creature.Hobgoblin;
import LairOfTheForgottenBeast.domain.creature.Human;
import LairOfTheForgottenBeast.domain.creature.Undead;

public class CreatureFactory implements AbstractCreatureFactory<Creature>
{
   @Override
   public Creature create(String creatureType)
   {
      if ("Human".equalsIgnoreCase(creatureType)) 
      {
         return new Human(); 
      } 
      else if ("Hobgoblin".equalsIgnoreCase(creatureType)) 
      {
         return new Hobgoblin(); 
      }
      else if ("Beast".equalsIgnoreCase(creatureType)) 
      {
         return new Beast(); 
      }
      else if ("Undead".equalsIgnoreCase(creatureType)) 
      {
         return new Undead(); 
      }
      else if ("Construct".equalsIgnoreCase(creatureType)) 
      {
         return new Construct(); 
      }
      return null;
   }
}