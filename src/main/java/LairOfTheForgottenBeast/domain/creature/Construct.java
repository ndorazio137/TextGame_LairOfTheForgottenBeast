package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.Weapon;

/**
 * 
 * 
 * @author Brian James
 * @version 1.0.0
 * @since 1.0.0
 */
public class Construct extends Creature
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
      // TODO Auto-generated method stub
      return this.name;
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

   @Override
   public Weapon getWeapon()
   {
      return this.weapon;
   }

}
