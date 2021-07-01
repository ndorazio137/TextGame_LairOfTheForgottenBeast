package LairOfTheForgottenBeast.domain.creature;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ConstructTest
{
   @Test
   public void test4()
   {
      CreatureTesting test4 = new CreatureTesting();
      String output = test4.createConstruct().getName();
      System.out.println(output);
      assertEquals("Living Statue", output);
   }
}