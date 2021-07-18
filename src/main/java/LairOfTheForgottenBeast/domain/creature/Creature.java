package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

public abstract class Creature
{
   long id;

   String shortDescription;
   String longDescription;
   String properties;

   /**
    * The current room the creature is in.
    */
   RoomDynamic currentRoom;
   /**
    * The creature's name.
    */
   String name;
   /**
    * The inventory attached to a creature
    */
   Inventory inventory;
   /**
    * The max number of items that can be in a creatures inventory
    */
   Integer creatureInventorySize = 50;

   /**
    * The weapon the creature currently wields.
    */
   Item weapon;
   /**
    * The hit points the creature currently has.
    */
   Integer currentHitPoints;
   /**
    * The maximum hit points a creature has.
    */
   Integer maxHitPoints;
   /**
    * The damage the creature currently does.
    */
   Integer attackDamage;
  
   public abstract long getId();
   public abstract String getName();
   public abstract String getShortDescription();
   public abstract String getLongDescription();
   public abstract String toString();
   public abstract Item getWeapon();
   public abstract int getCurrentHitPoints();
   public abstract int getMaxHitPoints();
   public abstract int getAttackDamage();
   public abstract void setName(String name);
   public abstract void setShortDescription(String shortDescription);
   public abstract void setLongDescription(String longDescription);
   public abstract void setWeapon(Item weapon);
   public abstract void setCurrentHitPoints(int currentHitPoints);
   public abstract void setMaxHitPoints(int maxHitPoints);
   public abstract void setAttackDamage(int attackDamage);
   public abstract RoomDynamic getCurrentRoom();
   public abstract void setCurrentRoom(RoomDynamic currentRoom);
   public abstract Inventory getInventory();
   public abstract void setInventory(Inventory inventory);
   public abstract int getCreatureInventorySize();
   public abstract void setCreatureInventorySize(int creatureInventorySize);
   
}
