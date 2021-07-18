package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;
import LairOfTheForgottenBeast.domain.Shock;

public class Decoration implements Prop
{
	
  public Burn burnInterface;
	public Freeze freezeInterface;
	public Shock shockInterface;
  String name;

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
   public String toString() {
      return name;
   }

}
