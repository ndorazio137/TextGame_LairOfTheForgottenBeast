package LairOfTheForgottenBeast.domain.prop;

public interface Prop
{
   Long getId();
   String getName();
   String getShortDescription(); // This is read as the default description
   String getLongDescription(); // This is read someone "examines" a prop object
   String getProperties(); // Stone, Wood, leather, metal, etc.
   
   String toString();
   
}
