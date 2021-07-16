package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;

/**
 * 
 * 
 * @author Brian James
 * @version 1.0.0
 * @since 1.0.0
 */
public class Humanoid extends Creature
{
   @Override
   public Long getId()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getName()
   {
      return this.name;
   }
   
   @Override
   public void setName(String name)
   {
      this.name = name;
   }

   @Override
   public String getShortDescription()
   {
      // TODO Auto-generated method stub
      return null;
   }
   
   @Override
   public void setShortDescription(String shortDesc)
   {
      this.shortDescription = shortDesc;
   }
   
   @Override
   public String getLongDescription()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void setLongDescription(String longDesc)
   {
      this.longDescription = longDesc;
   }
   
   @Override
   public String getProperties()
   {
      // TODO Auto-generated method stub
      return null;
   }


   @Override
   public String toString() {
      return name;
   }

   @Override
   public Item getWeapon()
   {
      return this.weapon;
   }

   @Override
   public Integer getCurrentHitPoints()
   {
      return this.currentHitPoints;
   }

   @Override
   public Integer getMaxHitPoints()
   {
      return this.maxHitPoints;
   }

   @Override
   public Integer getAttackDamage()
   {
      return this.attackDamage;
   }
   public RoomDynamic getCurrentRoom()
   {
      return currentRoom;
   }

   public void setCurrentRoom(RoomDynamic currentRoom)
   {
      this.currentRoom = currentRoom;
   }
   
}
