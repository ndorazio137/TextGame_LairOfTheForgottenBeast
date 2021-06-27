package LairOfTheForgottenBeast.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ConstructTest
{
   @Test
   public void test4()
   {
      CreatureTesting test4 = new CreatureTesting();
      String output = test4.mockConstruct().getName();
      System.out.println(output);
      assertEquals("Living Statue", output);
   }
}