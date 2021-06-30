package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.creature.Beast;
import LairOfTheForgottenBeast.domain.creature.Construct;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.creature.Humanoid;
import LairOfTheForgottenBeast.domain.creature.Undead;

public class CreatureFactory implements AbstractCreatureFactory<Creature>
{
   @Override
   public Creature create(String creatureType)
   {
      if ("Human".equalsIgnoreCase(creatureType)) 
      {
         return new Humanoid(); 
      } 
      else if ("Hobgoblin".equalsIgnoreCase(creatureType)) 
      {
         Humanoid hobgoblin = new Humanoid();
         hobgoblin.setName("Hobgoblin");
         return hobgoblin; 
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