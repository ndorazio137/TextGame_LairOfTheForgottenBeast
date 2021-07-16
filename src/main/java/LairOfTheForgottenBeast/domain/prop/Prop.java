package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;

public interface Prop
{
   Long getId();
   String getName();
   String getShortDescription(); // This is read as the default description
   String getLongDescription(); // This is read someone "examines" a prop object
   String getProperties(); // Stone, Wood, leather, metal, etc.
   
   String toString();
   
   String burn(); // executed when a prop is ignited with fire
   String freeze(); // executed when a prop is exposed to freezing cold
}
