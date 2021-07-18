package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.creature.Beast;
import LairOfTheForgottenBeast.domain.creature.Construct;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.creature.Humanoid;
import LairOfTheForgottenBeast.domain.creature.Undead;
import LairOfTheForgottenBeast.domain.prop.Item;

public class CreatureFactory implements AbstractCreatureFactory<Creature>
{
   
   // Create method for only a creature type parameter. Non-unique creatures
   @Override
   public Creature create(String creatureType)
   {
      if ("Human".equalsIgnoreCase(creatureType)) 
      {
         Humanoid human = new Humanoid();
         human.setName("Generic Human");
         human.setShortDescription("Hi, I'm "+ human.getName());
         human.setLongDescription("Frank is a soldier.");
         Item weapon = new Item("iron sword", "an iron longsword", "a longsword, forged from iron", 60); // specifc themed weapon
         human.setWeapon(weapon);
         human.setAttackDamage(65);
         human.setCurrentHitPoints(50);
         human.setMaxHitPoints(50);    
         return human;          
      } 
      else if ("Hobgoblin".equalsIgnoreCase(creatureType)) 
      {
         Humanoid hobgoblin = new Humanoid();
         hobgoblin.setName("Generic Hobgoblin");
         hobgoblin.setShortDescription("some hobgoblin");
         hobgoblin.setLongDescription("Burbar appears to be a hobgoblin.");
         Item weapon = new Item("bronze sword", 50, "a bronze longsword", "a longsword, forged from bronze", 50); // specific themed weapon 
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
         Item weapon = new Item("stone sword", "a stone longsword", "a longsword, carved from stone", 50);  // specific themed weapon
         construct.setWeapon(weapon);
         construct.setAttackDamage(55);
         construct.setCurrentHitPoints(50);
         construct.setMaxHitPoints(50);    
         return construct; 
      }
      else if ("Beast".equalsIgnoreCase(creatureType)) 
      {
         Beast beast = new Beast();
         beast.setName("Generic Beast");
         beast.setShortDescription("short description default beast");
         beast.setLongDescription("long description default beast");
         beast.setAttackDamage(1);
         beast.setCurrentHitPoints(5);
         beast.setMaxHitPoints(5);         
         return beast;
      }
      else if ("Undead".equalsIgnoreCase(creatureType)) 
      {
         Undead undead = new Undead();
         undead.setName("Generic Undead");
         undead.setShortDescription("short description generic undead");
         undead.setLongDescription("long description generic undead");
         Item weapon = new Item("rusty iron sword", "a rusty iron longsword", "an old longsword, forged from iron but rusty.", 60); // specifc themed weapon
         undead..setWeapon(weapon);
         undead.setAttackDamage(1);
         undead.setCurrentHitPoints(5);
         undead.setMaxHitPoints(5);         
         return undead; 
      }
      return null;

   }
   
   // Create method that includes all parameters except the weapons
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
         hobgoblin.setAttackDamage(attackDamage);
         hobgoblin.setCurrentHitPoints(currentHitPoints);
         hobgoblin.setMaxHitPoints(maxHitPoints);
         return hobgoblin;
      }
      else if ("Construct".equalsIgnoreCase(creatureType)) 
      {
         Construct construct = new Construct();
         construct.setName(name);
         construct.setShortDescription(shortDesc);
         construct.setLongDescription(longDesc);
         construct.setAttackDamage(attackDamage);
         construct.setCurrentHitPoints(currentHitPoints);
         construct.setMaxHitPoints(maxHitPoints);     
         return construct; 
      }
      else if ("Beast".equalsIgnoreCase(creatureType)) 
      {
         Beast beast = new Beast();
         beast.setName(name);
         beast.setShortDescription(shortDesc);
         beast.setLongDescription(longDesc);
         beast.setAttackDamage(attackDamage);
         beast.setCurrentHitPoints(currentHitPoints);
         beast.setMaxHitPoints(maxHitPoints);        
         return beast;
      }
      else if ("Undead".equalsIgnoreCase(creatureType)) 
      {
         Undead undead = new Undead();
         undead.setName(name);
         undead.setShortDescription(shortDesc);
         undead.setLongDescription(longDesc);
         undead.setAttackDamage(attackDamage);
         undead.setCurrentHitPoints(currentHitPoints);
         undead.setMaxHitPoints(maxHitPoints);          
         return undead; 
      }
      return null;
   }
   
   // Create method using all the parameters including weapons
   @Override
   public Creature create(String creatureType, String name, String shortDesc, 
      String longDesc, Item weapon, Integer attackDamage, Integer currentHitPoints, Integer maxHitPoints) 
   {
      if ("Human".equalsIgnoreCase(creatureType)) 
      {
         Humanoid human = new Humanoid();
         human.setName(name);
         human.setShortDescription(shortDesc);
         human.setLongDescription(longDesc);
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
         hobgoblin.setWeapon(weapon);
         hobgoblin.setAttackDamage(attackDamage);
         hobgoblin.setCurrentHitPoints(currentHitPoints);
         hobgoblin.setMaxHitPoints(maxHitPoints);      
         return hobgoblin;
      }
      else if ("Construct".equalsIgnoreCase(creatureType)) 
      {
         Construct construct = new Construct();
         construct.setName(name);
         construct.setShortDescription(shortDesc);
         construct.setLongDescription(longDesc);
         construct.setWeapon(weapon);
         construct.setAttackDamage(attackDamage);
         construct.setCurrentHitPoints(currentHitPoints);
         construct.setMaxHitPoints(maxHitPoints);     
         return construct; 
      }
      else if ("Beast".equalsIgnoreCase(creatureType)) 
      {
         Beast beast = new Beast();
         beast.setName(name);
         beast.setShortDescription(shortDesc);
         beast.setLongDescription(longDesc);
         beast.setWeapon(weapon);
         beast.setAttackDamage(attackDamage);
         beast.setCurrentHitPoints(currentHitPoints);
         beast.setMaxHitPoints(maxHitPoints);        
         return beast;
      }
      else if ("Undead".equalsIgnoreCase(creatureType)) 
      {
         Undead undead = new Undead();
         undead.setName(name);
         undead.setShortDescription(shortDesc);
         undead.setLongDescription(longDesc);
         undead.setWeapon(weapon);
         undead.setAttackDamage(attackDamage);
         undead.setCurrentHitPoints(currentHitPoints);
         undead.setMaxHitPoints(maxHitPoints);          
         return undead; 
      }
      return null;
   }
}