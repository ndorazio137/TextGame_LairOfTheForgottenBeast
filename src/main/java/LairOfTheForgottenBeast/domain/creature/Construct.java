package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.prop.Item;

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
	   public long getId()
	   {
	      return this.id;
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
	      return shortDescription;
	   }

	   @Override
	   public String getLongDescription()
	   {
	      return longDescription;
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
	   public int getCurrentHitPoints()
	   {
	      return this.currentHitPoints;
	   }

	   @Override
	   public int getMaxHitPoints()
	   {
	      return this.maxHitPoints;
	   }

	   @Override
	   public int getAttackDamage()
	   {
	      return this.attackDamage;
	   }

}
