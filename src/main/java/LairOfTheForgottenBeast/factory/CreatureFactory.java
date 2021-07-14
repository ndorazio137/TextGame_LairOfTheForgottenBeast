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
         Humanoid human = new Humanoid();
         human.setName("Human");
         return human; 
      } 
      else if ("Hobgoblin".equalsIgnoreCase(creatureType)) 
      {
         Humanoid hobgoblin = new Humanoid();
         hobgoblin.setName("Hobgoblin");
         return hobgoblin; 
      }
      else if ("Construct".equalsIgnoreCase(creatureType)) 
      {
         Construct construct = new Construct();
         construct.setName("Statue");
         return construct; 
      }
      else if ("Beast".equalsIgnoreCase(creatureType)) 
      {
         return new Beast(); 
      }
      else if ("Undead".equalsIgnoreCase(creatureType)) 
      {
         return new Undead(); 
      }

      return null;
   }
   
   @Override
   public Creature create(String creatureType, String name, String shortDesc, String longDesc) 
   {
      if ("Human".equalsIgnoreCase(creatureType)) 
      {
         Humanoid human = new Humanoid();
         human.setName(name);
         human.setShortDescription(shortDesc);
         human.setLongDescription(longDesc);
         return human; 
      } 
      else if ("Hobgoblin".equalsIgnoreCase(creatureType)) 
      {
         Humanoid hobgoblin = new Humanoid();
         hobgoblin.setName(name);
         return hobgoblin;
      }
      else if ("Construct".equalsIgnoreCase(creatureType)) 
      {
         Construct construct = new Construct();
         construct.setName(name);
         return construct; 
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