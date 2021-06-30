package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.prop.Decoration;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.NatureProp;
import LairOfTheForgottenBeast.domain.prop.Puzzle;
import LairOfTheForgottenBeast.domain.prop.Trap;

public class PropTesting
{
   public Item createItem()
   {
      return new Item();
   }
   
   public Decoration createDecoration()
   {
      return new Decoration();
   }
   
   public NatureProp createNatureProp()
   {
      return new NatureProp();
   }
   
   public Trap createTrap()
   {
      return new Trap();
   }
   public Puzzle createPuzzle()
   {
      return new Puzzle();
   }  
}