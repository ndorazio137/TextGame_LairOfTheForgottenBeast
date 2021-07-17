package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;
import LairOfTheForgottenBeast.domain.Shock;

public class Item implements Prop
{
   Long Id;
   String name;
   String shortDescription; // This is read as the default description
   String longDescription; // This is read someone "examines" a prop object
   String properties; // Stone, Wood, leather, metal, etc.

   public Burn burnInterface;
   public Freeze freezeInterface;
   public Shock shockInterface;
   
   int attackDamage = 1;

   public Item() { }
   
   public Item(String name, String shortDesc, String longDesc) {
      this.name = name;
      this.shortDescription = shortDesc;
      this.longDescription = longDesc;
   }
   
   public Item(String name, int attackDamage, String shortDesc, String longDesc) {
	      this.name = name;
	      this.attackDamage = attackDamage;
	      this.shortDescription = shortDesc;
	      this.longDescription = longDesc;
	   }

   @Override
   public String toString() {
      return name;
   }
   
	

@Override
   public Long getId()
   {
      // TODO Auto-generated method stub
      return (long)1;
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
      return this.shortDescription;
   }
   @Override
   public String getLongDescription()
   {
      // TODO Auto-generated method stub
      return this.longDescription;
   }
   @Override
   public String getProperties()
   {
      // TODO Auto-generated method stub
      return "steel";
   }
	
	public boolean setName(String name) {
		if (name == null)
	         return false;
	      this.name = name;
	      return true;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	@Override
	public String burn() {
	   if (this.burnInterface == null) {
			return "The item is unaffected.";
		}
		return this.burnInterface.burn();
	}

	@Override
	public String freeze() {
		if (this.freezeInterface == null) {
			return "The item is unaffected.";
		}
		return this.freezeInterface.freeze();
	}
	
	@Override
	public String shock() {
		if (this.shockInterface == null) {
			return "The item is unaffected.";
		}
		return this.shockInterface.shock();
	}
	
	public void setBurn(Burn burnBehavior) {
		this.burnInterface = burnBehavior;
	}
	
	public void setFreeze(Freeze freezeBehavior) {
		this.freezeInterface = freezeBehavior;
	}
	
	public void setShock(Shock shockBehavior) {
		this.shockInterface = shockBehavior;
	}
	
}
