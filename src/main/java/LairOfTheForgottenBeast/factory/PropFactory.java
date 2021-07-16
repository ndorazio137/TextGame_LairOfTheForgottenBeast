package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.prop.Decoration;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.Prop;

public class PropFactory implements AbstractPropFactory<Prop>
{
   @Override
   public Prop create(String propType)
   {
      if ("Item".equalsIgnoreCase(propType))
      {
         return new Item("item", "a misc item", "some sort of item"); 
      }
      if ("Decoration".equalsIgnoreCase(propType))
      {
         return new Decoration(); // human-created decorations like room styles
      }
      return null;
   }

   @Override
   public Prop create(String propType, String name, String shortDesc,
      String longDesc)
   {
      if ("Item".equalsIgnoreCase(propType))
      {
         return new Item(name, shortDesc, longDesc); 
      } 
      else if ("Decoration".equalsIgnoreCase(propType))
      {
         return new Decoration(); // human-created decorations like room styles
      } 
      return null;
   }

   @Override
   public Item createWeapon(String name, int attackDamage, String shortDesc, String longDesc)
   {
      return new Item(name, attackDamage, shortDesc, longDesc);                                               
   }
   
}
