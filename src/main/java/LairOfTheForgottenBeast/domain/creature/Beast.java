package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.prop.Item;

/**
 * 
 * 
 * @author Brian James
 * @version 1.0.0
 * @since 1.0.0
 */
public class Beast extends Creature
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
      // TODO Auto-generated method stub
      this.name = name;
   }

   @Override
   public String getShortDescription()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getLongDescription()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getProperties()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String toString()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Item getWeapon()
   {
      return this.weapon;
   }

   @Override
   public Integer getCurrentHitPoints()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Integer getMaxHitPoints()
   {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Integer getAttackDamage()
   {
      // TODO Auto-generated method stub
      return null;
   }

}
