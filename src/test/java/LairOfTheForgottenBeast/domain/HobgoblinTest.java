package LairOfTheForgottenBeast.domain;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class HobgoblinTest
{
   @Test
   public void test5()
   {
      CreatureTesting test5 = new CreatureTesting();
      String output = test5.mockHobgoblin().getName();
      System.out.println(output);
      assertEquals("Hobgoblin Soldier", output);
   }
}