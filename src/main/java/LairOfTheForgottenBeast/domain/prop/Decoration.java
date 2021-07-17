package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;

public class Decoration implements Prop
{

   Long Id;
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

   public Decoration() { }
   
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

   public Decoration(String name, String shortDescription,
      String longDescription)
   {
      super();
      this.name = name;
      this.shortDescription = shortDescription;
      this.longDescription = longDescription;
   }

   public void setShortDescription(String shortDescription)
   {
      this.shortDescription = shortDescription;
      
   }

   public void setLongDescription(String longDescription)
   {
      this.longDescription = longDescription;
      
   }
}
