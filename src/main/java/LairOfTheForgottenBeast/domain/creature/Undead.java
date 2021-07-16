package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

/**
 * 
 * 
 * @author Brian James
 * @version 1.0.0
 * @since 1.0.0
 */
public class Undead extends Creature
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

	@Override
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Override
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	@Override
	public void setCurrentHitPoints(int currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}

	@Override
	public void setMaxHitPoints(int maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}

	@Override
	public void setAttackDamage(int attackDamage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoomDynamic getCurrentRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentRoom(RoomDynamic currentRoom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCreatureInventorySize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCreatureInventorySize(int creatureInventorySize) {
		// TODO Auto-generated method stub
		
	}

}
