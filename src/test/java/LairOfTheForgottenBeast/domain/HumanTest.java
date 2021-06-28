package LairOfTheForgottenBeast.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HumanTest
{
   @Test
   public void test1()
   {
      CreatureTesting test1 = new CreatureTesting();
      String output = test1.mockHuman().getName();
      System.out.println(output);
      assertEquals("Harry Castle", output);
   }
}