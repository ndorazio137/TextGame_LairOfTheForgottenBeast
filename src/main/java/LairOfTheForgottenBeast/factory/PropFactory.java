package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.NatureProp;
import LairOfTheForgottenBeast.domain.Decoration;
import LairOfTheForgottenBeast.domain.Item;
import LairOfTheForgottenBeast.domain.Prop;
import LairOfTheForgottenBeast.domain.Puzzle;
import LairOfTheForgottenBeast.domain.Trap;

public class PropFactory implements AbstractFactory<Prop>
{

   @Override
   public Prop create(String propType)
   {
      if ("Item".equalsIgnoreCase(propType)) 
      {
         return new Item(); // weapons, spellbooks, potions, coins, containers
      } 
      else if ("Decoration".equalsIgnoreCase(propType)) 
      {
         return new Decoration(); // human-created decorations like room styles
      }
      else if ("NatureProp".equalsIgnoreCase(propType)) 
      {
         return new NatureProp(); // Boulders, trees, water, all natural
      }
      else if ("Trap".equalsIgnoreCase(propType)) 
      {
         return new Trap(); // pits, trip wires, loose tiles, etc. 
      }
      else if ("Puzzle".equalsIgnoreCase(propType)) 
      {
         return new Puzzle(); // puzzles 
      }
      return null;
   }
}
