package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.creature.Beast;
import LairOfTheForgottenBeast.domain.creature.Construct;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.creature.Humanoid;
import LairOfTheForgottenBeast.domain.prop.Item;

public class CreatureFactory implements AbstractCreatureFactory<Creature>
{
   @Override
   public Creature create(String creatureType)
   {
      if ("Human".equalsIgnoreCase(creatureType)) 
      {
         Humanoid human = new Humanoid();
         human.setName("Frank");
         human.setShortDescription("Hi, I'm Frank");
         human.setLongDescription("Frank is a soldier.");
         Item weapon = new Item("iron sword", 60, "an iron longsword", "a longsword, forged from iron"); // specifc themed weapon
         human.setWeapon(weapon);
         human.setAttackDamage(65);
         human.setCurrentHitPoints(50);
         human.setMaxHitPoints(50);    
         return human;          
      } 
      else if ("Hobgoblin".equalsIgnoreCase(creatureType)) 
      {
         Humanoid hobgoblin = new Humanoid();
         hobgoblin.setName("Burbar");
         hobgoblin.setShortDescription("some hobgoblin");
         hobgoblin.setLongDescription("Burbar appears to be a hobgoblin.");
         Item weapon = new Item("bronze sword", 50, "a bronze longsword", "a longsword, forged from bronze"); // specific themed weapon 
         hobgoblin.setWeapon(weapon);
         hobgoblin.setAttackDamage(55);
         hobgoblin.setCurrentHitPoints(50);
         hobgoblin.setMaxHitPoints(50);    
         return hobgoblin;
      }
      else if ("Statue".equalsIgnoreCase(creatureType)) 
      {
         Construct construct = new Construct();
         construct.setName("Statue");
         construct.setShortDescription("a stone statue");
         construct.setLongDescription("this is a stone statue of a human soldier.");
         Item weapon = new Item("stone sword", 50, "a stone longsword", "a longsword, carved from stone");  // specific themed weapon
         construct.setWeapon(weapon);
         construct.setAttackDamage(55);
         construct.setCurrentHitPoints(50);
         construct.setMaxHitPoints(50);    
         return construct; 
      }
//      else if ("Beast".equalsIgnoreCase(creatureType)) 
//      {
//         Beast beast = new Beast();
//         beast.setName(name);
//         beast.setShortDescription(shortDesc);
//         beast.setLongDescription(longDesc);
//         Weapon weapon = new Weapon("claws", 50); // specific themed weapon
//         beast.setWeapon(weapon);
//         beast.setAttackDamage(1);
//         beast.setCurrentHitPoints(5);
//         beast.setMaxHitPoints(5);         
//         return beast;
//      }
//      else if ("Undead".equalsIgnoreCase(creatureType)) 
//      {
//         Undead undead = new Undead();
//         undead.setName(name);
//         undead.setShortDescription(shortDesc);
//         undead.setLongDescription(longDesc);
//         Weapon weapon = new Weapon("teeth", 50); // specific themed weapon
//         undead.setWeapon(weapon);
//         undead.setAttackDamage(1);
//         undead.setCurrentHitPoints(5);
//         undead.setMaxHitPoints(5);         
//         return undead; 
//      }
      return null;

   }
   
   @Override
   public Creature create(String creatureType, String name, String shortDesc, 
      String longDesc, Integer attackDamage, Integer currentHitPoints, Integer maxHitPoints) 
   {
      if ("Human".equalsIgnoreCase(creatureType)) 
      {
         Humanoid human = new Humanoid();
         human.setName(name);
         human.setShortDescription(shortDesc);
         human.setLongDescription(longDesc);
         Item weapon = new Item("iron sword", 60, "an iron longsword", "a longsword, forged from iron"); // specifc themed weapon
         human.setWeapon(weapon);
         human.setAttackDamage(attackDamage);
         human.setCurrentHitPoints(currentHitPoints);
         human.setMaxHitPoints(maxHitPoints);    
         return human; 
      } 
      else if ("Hobgoblin".equalsIgnoreCase(creatureType)) 
      {
         Humanoid hobgoblin = new Humanoid();
         hobgoblin.setName(name);
         hobgoblin.setShortDescription(shortDesc);
         hobgoblin.setLongDescription(longDesc);
         Item weapon = new Item("bronze sword", 50, "a bronze longsword", "a longsword, forged from bronze"); // specific themed weapon 
         hobgoblin.setWeapon(weapon);
         hobgoblin.setAttackDamage(attackDamage);
         hobgoblin.setCurrentHitPoints(currentHitPoints);
         hobgoblin.setMaxHitPoints(maxHitPoints);
         return hobgoblin;
      }
//      else if ("Construct".equalsIgnoreCase(creatureType)) 
//      {
//         Construct construct = new Construct();
//         construct.setName(name);
//         construct.setShortDescription(shortDesc);
//         construct.setLongDescription(longDesc);
//         Weapon weapon = new Weapon("stone sword", 50); // specific themed weapon
//         construct.setWeapon(weapon);
//         construct.setAttackDamage(1);
//         construct.setCurrentHitPoints(5);
//         construct.setMaxHitPoints(5);    
//         return construct; 
//      }
//      else if ("Beast".equalsIgnoreCase(creatureType)) 
//      {
//         Beast beast = new Beast();
//         beast.setName(name);
//         beast.setShortDescription(shortDesc);
//         beast.setLongDescription(longDesc);
//         Weapon weapon = new Weapon("claws", 50); // specific themed weapon
//         beast.setWeapon(weapon);
//         beast.setAttackDamage(1);
//         beast.setCurrentHitPoints(5);
//         beast.setMaxHitPoints(5);         
//         return beast;
//      }
//      else if ("Undead".equalsIgnoreCase(creatureType)) 
//      {
//         Undead undead = new Undead();
//         undead.setName(name);
//         undead.setShortDescription(shortDesc);
//         undead.setLongDescription(longDesc);
//         Weapon weapon = new Weapon("teeth", 50); // specific themed weapon
//         undead.setWeapon(weapon);
//         undead.setAttackDamage(1);
//         undead.setCurrentHitPoints(5);
//         undead.setMaxHitPoints(5);         
//         return undead; 
//      }
      return null;
   }

   @Override
   public Creature create(String creatureType, String name)
   {
      if ("Human".equalsIgnoreCase(creatureType)) 
      {
         Humanoid human = new Humanoid();
         human.setName(name);
         human.setShortDescription("Hi, I'm " + name);
         human.setLongDescription(name + " is a human.");
         Item weapon = new Item("iron sword", 60, "an iron longsword", "a longsword, forged from iron"); // specifc themed weapon
         human.setWeapon(weapon);
         human.setAttackDamage(65);
         human.setCurrentHitPoints(50);
         human.setMaxHitPoints(50);    
         return human;          
      } 
      else if ("Hobgoblin".equalsIgnoreCase(creatureType)) 
      {
         Humanoid hobgoblin = new Humanoid();
         hobgoblin.setName(name);
         hobgoblin.setShortDescription("Hi, I'm " + name);
         hobgoblin.setLongDescription(name + " appears to be a hobgoblin.");
         Item weapon = new Item("bronze sword", 60, "a bronze longsword", "a longsword, forged from bronze"); // specific themed weapon 
         hobgoblin.setWeapon(weapon);
         hobgoblin.setAttackDamage(55);
         hobgoblin.setCurrentHitPoints(50);
         hobgoblin.setMaxHitPoints(50);    
         return hobgoblin;
      }
      else if ("Construct".equalsIgnoreCase(creatureType)) 
      {
         Construct construct = new Construct();
         construct.setName(name);
         construct.setShortDescription("a stone statue");
         construct.setLongDescription("this is a stone statue of a human soldier.");
         Item weapon = new Item("stone sword", 60, "a stone longsword", "a longsword, carved from stone"); // specific themed weapon
         construct.setWeapon(weapon);
         construct.setAttackDamage(55);
         construct.setCurrentHitPoints(50);
         construct.setMaxHitPoints(50);    
         return construct; 
      }
    else if ("Beast".equalsIgnoreCase(creatureType)) 
    {
       Beast beast = new Beast();
       beast.setName(name);
       beast.setShortDescription("a giant spider.");
       beast.setLongDescription("a giant spider that has webbed the entire room.");
       Item weapon = new Item("fangs", 60, "spider fangs", "spider fangs, sharp and probably venemous"); // specific themed weapon
       beast.setWeapon(weapon);
       beast.setAttackDamage(55);
       beast.setCurrentHitPoints(50);
       beast.setMaxHitPoints(50);         
       return beast;
    }
      
      return null;
   }

}