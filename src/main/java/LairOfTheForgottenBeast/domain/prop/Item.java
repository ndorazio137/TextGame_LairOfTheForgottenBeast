package LairOfTheForgottenBeast.domain.prop;

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
      return (long)1;
   }
   @Override
   public String getName()
   {
      // TODO Auto-generated method stub
      return "sword";
   }
   @Override
   public String getShortDescription()
   {
      // TODO Auto-generated method stub
      return "The weapon of choice.";
   }
   @Override
   public String getLongDescription()
   {
      // TODO Auto-generated method stub
      return "Long Description";
   }
   @Override
   public String getProperties()
   {
      // TODO Auto-generated method stub
      return "steel";
   }

}
