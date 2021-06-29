package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.prop.Decoration;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.NatureProp;
import LairOfTheForgottenBeast.domain.prop.Puzzle;
import LairOfTheForgottenBeast.domain.prop.Trap;

public class PropTesting
{
   // These methods need to be renamed because they generate
   // real object, not mocks.
   public Item mockItem()
   {
      return new Item();
   }
   
   public Decoration mockDecoration()
   {
      return new Decoration();
   }
   
   public NatureProp mockNatureProp()
   {
      return new NatureProp();
   }
   
   public Trap mockTrap()
   {
      return new Trap();
   }
   public Puzzle mockPuzzle()
   {
      return new Puzzle();
   }  
}