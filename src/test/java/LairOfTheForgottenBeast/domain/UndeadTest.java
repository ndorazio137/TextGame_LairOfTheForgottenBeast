package LairOfTheForgottenBeast.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UndeadTest
{
   @Test
   public void test3()
   {
      CreatureTesting test3 = new CreatureTesting();
      String output = test3.mockUndead().getName();
      System.out.println(output);
      assertEquals("Skeleton", output);
   }
}