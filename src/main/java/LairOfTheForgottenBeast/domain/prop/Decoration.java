package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;

public class Decoration implements Prop
{
	public Burn burn;
	public Freeze freeze;
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
		return this.burn.burn();
	}

	@Override
	public String freeze() {
		return this.freeze.freeze();
	}
	
	public void setBurn(Burn burn) {
		this.burn = burn;
	}
	
	public void setFreeze(Freeze freeze) {
		this.freeze = freeze;
	}

   @Override
   public String toString() {
      return name;
   }
}
