package LairOfTheForgottenBeast.domain.creature;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BeastTest
{
   @Test
   public void test2()
   {
      CreatureTesting test2 = new CreatureTesting();
      String output = test2.createBeast().getName();
      System.out.println(output);
      assertEquals("Flail Snail", output);
   }
}