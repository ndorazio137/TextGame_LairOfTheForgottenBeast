package LairOfTheForgottenBeast.domain.creature;

/**
 * 
 * 
 * @author Brian James
 * @version 1.0.0
 * @since 1.0.0
 */
public class Humanoid extends Creature
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
      return this.name;
   }
   
   @Override
   public void setName(String name)
   {
      // TODO Auto-generated method stub
      this.name = name;
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
   
   

}
