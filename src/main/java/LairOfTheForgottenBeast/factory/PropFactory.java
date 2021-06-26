package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.NatureProp;
import LairOfTheForgottenBeast.domain.Decoration;
import LairOfTheForgottenBeast.domain.Item;
import LairOfTheForgottenBeast.domain.Prop;

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
      else if ("natureProp".equalsIgnoreCase(propType)) 
      {
         return new NatureProp(); // Boulders, trees, water, all natural
      }
      return null;
   }
}
