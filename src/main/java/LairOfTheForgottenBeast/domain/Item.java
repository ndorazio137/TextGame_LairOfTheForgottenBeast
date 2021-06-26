package LairOfTheForgottenBeast.domain;

public class Item implements Prop
{
   Long Id;
   String name;
   String shortDescription; // This is read as the default description
   String longDescription; // This is read someone "examines" a prop object
   String properties; // Stone, Wood, leather, metal, etc.

   @Override
   public Long getId()
   {
      // TODO Auto-generated method stub
      return null;
   }
   @Override
   public String getName()
   {
      // TODO Auto-generated method stub
      return null;
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

}
