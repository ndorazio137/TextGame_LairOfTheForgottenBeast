package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.Weapon;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

public abstract class Creature
{
   Long id;

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

   /**
    * The inventory attached to a creature
    */

   public abstract Long getId();

   public abstract String getName();

   public abstract String getShortDescription();

   public abstract String getLongDescription();

   public abstract String getProperties();

   public abstract String toString();

   public abstract Item getWeapon();

   public abstract Integer getCurrentHitPoints();

   public abstract Integer getMaxHitPoints();

   public abstract Integer getAttackDamage();

   public void setName(String name)
   {
      this.name = name;
   }

   public void setShortDescription(String shortDescription)
   {
      this.shortDescription = shortDescription;
   }

   public void setLongDescription(String longDescription)
   {
      this.longDescription = longDescription;
   }

   public void setProperties(String properties)
   {
      this.properties = properties;
   }

   public void setWeapon(Weapon weapon)
   {
      this.weapon = weapon;
   }

   public void setCurrentHitPoints(Integer currentHitPoints)
   {
      this.currentHitPoints = currentHitPoints;
   }

   public void setMaxHitPoints(Integer maxHitPoints)
   {
      this.maxHitPoints = maxHitPoints;
   }

   public void setAttackDamage(Integer attackDamage)
   {
      this.attackDamage = attackDamage;
   };

   public RoomDynamic getCurrentRoom()
   {
      return currentRoom;
   }

   public void setCurrentRoom(RoomDynamic currentRoom)
   {
      this.currentRoom = currentRoom;
   }

   public Inventory getInventory()
   {
      return inventory;
   }

   public void setInventory(Inventory inventory)
   {
      this.inventory = inventory;
   }

   public int getCreatureInventorySize()
   {
      return creatureInventorySize;
   }

   public void setCreatureInventorySize(int creatureInventorySize)
   {
      this.creatureInventorySize = creatureInventorySize;
   }
   
}
