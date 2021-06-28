package LairOfTheForgottenBeast.domain.prop;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ItemTest
{
   @Test
   public void test1()
   {
      PropTesting test1 = new PropTesting();
      String output = test1.mockItem().getName();
      System.out.println(output);
      assertEquals("sword", output);
   }
}