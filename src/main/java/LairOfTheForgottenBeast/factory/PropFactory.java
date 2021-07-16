package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Weapon;
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
         return new Item("item", "a misc item", "some sort of item"); // weapons,
                                                                      // spellbooks,
                                                                      // potions,
                                                                      // coins,
                                                                      // containers
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
         return new Item(name, shortDesc, longDesc); // weapons, spellbooks,
                                                     // potions, coins,
                                                     // containers
      } else if ("Weapon".equalsIgnoreCase(propType))
      {
         return new Weapon();
      } else if ("Decoration".equalsIgnoreCase(propType))
      {
         return new Decoration(); // human-created decorations like room styles
      } 
      return null;
   }

   @Override
   public Weapon createWeapon(String name, Integer attackDamage)
   {
      return new Weapon(name, attackDamage);                                               
   }
   
}
