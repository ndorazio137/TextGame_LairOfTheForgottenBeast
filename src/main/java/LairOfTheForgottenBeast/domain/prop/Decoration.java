package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;

public class Decoration implements Prop
{

   long Id;
   String name;
   String shortDescription; // This is read as the default description
   String longDescription; // This is read someone "examines" a prop object
   String properties; // Stone, Wood, leather, metal, etc.

   public Burn burn;
   public Freeze freeze;
   
   int attackDamage = 1;

   public Decoration(String name, String shortDescription, String longDescription,
      int attackDamage)
   {
      super();
      this.name = name;
      this.shortDescription = shortDescription;
      this.longDescription = longDescription;
   }
   
   public Decoration(String name, String shortDescription,
      String longDescription)
   {
      super();
      this.name = name;
      this.shortDescription = shortDescription;
      this.longDescription = longDescription;
   }
   
   public Decoration() { }

   @Override
   public long getId()
   {
      return this.Id;
   }
   
   @Override
   public String getName()
   {
      return this.name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   @Override
   public String getShortDescription()
   {
      return this.shortDescription;
   }

   @Override
   public String getLongDescription()
   {
      return this.longDescription;
   }
   
   public void setShortDescription(String shortDescription)
   {
      this.shortDescription = shortDescription;
      
   }

   public void setLongDescription(String longDescription)
   {
      this.longDescription = longDescription;
      
   }
   
   @Override
   public String getProperties()
   {
      return this.properties;
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

   @Override
   public String toString()
   {
      return name;
   }

}
