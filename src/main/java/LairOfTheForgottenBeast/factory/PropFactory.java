package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.prop.Decoration;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.NatureProp;
import LairOfTheForgottenBeast.domain.prop.Prop;
import LairOfTheForgottenBeast.domain.prop.Puzzle;
import LairOfTheForgottenBeast.domain.prop.Trap;

public class PropFactory implements AbstractPropFactory<Prop>
{
   @Override
   public Prop create(String propType)
   {
      if ("Item".equalsIgnoreCase(propType)) 
      {
         return new Item("item", "a misc item", "some sort of item"); // weapons, spellbooks, potions, coins, containers
      } 
      if ("Weapon".equalsIgnoreCase(propType)) 
      {
         Item weapon = new Item("weapon", "a misc weapon", "some sort of weapon"); // weapons, spellbooks, potions, coins, containers
//         TODO: set weapon-specific fields like weapon.setDamage(1.0);
      } 
      if ("Decoration".equalsIgnoreCase(propType)) 
      {
         return new Decoration(); // human-created decorations like room styles
      }
      if ("NatureProp".equalsIgnoreCase(propType)) 
      {
         return new NatureProp(); // Boulders, trees, water, all natural
      }
      if ("Trap".equalsIgnoreCase(propType)) 
      {
         return new Trap(); // pits, trip wires, loose tiles, etc. 
      }
      if ("Puzzle".equalsIgnoreCase(propType)) 
      {
         return new Puzzle(); // puzzles 
      }
      return null;
   }

   @Override
   public Prop create(String propType, String name, String shortDesc, String longDesc) {
      if ("Item".equalsIgnoreCase(propType)) 
      {
         return new Item(name, shortDesc, longDesc); // weapons, spellbooks, potions, coins, containers
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
