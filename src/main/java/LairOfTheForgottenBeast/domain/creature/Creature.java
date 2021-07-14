package LairOfTheForgottenBeast.domain.creature;

public abstract class Creature
{
   Long id;
   String name;
   String shortDescription;
   String longDescription;
   String properties;

   public abstract Long getId();

   public abstract String getName();

   public abstract String getShortDescription();

   public abstract String getLongDescription();

   public abstract String getProperties();

   public abstract String toString();

   public void setName(String name)
   {
      this.name = name;
   }

   public void setShortDescription(String shortDescription)
   {
      this.shortDescription = shortDescription;
   }

   public void setLongDescription(String longDescription)
   {
      this.longDescription = longDescription;
   }

   public void setProperties(String properties)
   {
      this.properties = properties;
   };

}
