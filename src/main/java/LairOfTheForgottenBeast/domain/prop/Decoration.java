package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;

public class Decoration implements Prop
{
   public Burn burn;
   public Freeze freeze;
   Long Id;
   String name;
   String shortDescription; // This is read as the default description
   String longDescription; // This is read someone "examines" a prop object
   String properties; // Stone, Wood, leather, metal, etc.

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

   @Override
   public String getProperties()
   {
      return this.properties;
   }

   @Override
   public String burn()
   {
      if (this.burn == null)
      {
         return "The item is unaffected.";
      }
      return this.burn.burn();
   }

   @Override
   public String freeze()
   {
      if (this.freeze == null)
      {
         return "The item is unaffected.";
      }
      return this.freeze.freeze();
   }

   public void setBurn(Burn burn)
   {
      this.burn = burn;
   }

   public void setFreeze(Freeze freeze)
   {
      this.freeze = freeze;
   }

   @Override
   public String toString()
   {
      return name;
   }

   @Override
   public Long getId()
   {
      return this.Id;
   }
}
