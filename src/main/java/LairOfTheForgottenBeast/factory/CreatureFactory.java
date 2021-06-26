package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.Beast;
import LairOfTheForgottenBeast.domain.Construct;
import LairOfTheForgottenBeast.domain.Creature;
import LairOfTheForgottenBeast.domain.Hobgoblin;
import LairOfTheForgottenBeast.domain.Human;
import LairOfTheForgottenBeast.domain.Undead;

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