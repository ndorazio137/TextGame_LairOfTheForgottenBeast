package LairOfTheForgottenBeast.domain.prop;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DecorationTest
{
   @Test
   public void test2()
   {
      PropTesting test2 = new PropTesting();
      String output = test2.mockDecoration().getName();
      System.out.println(output);
      assertEquals("painting", output);
   }
}