package LairOfTheForgottenBeast.domain.prop;

public class Decoration implements Prop
{
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
   public String toString() {
      return name;
   }
}
