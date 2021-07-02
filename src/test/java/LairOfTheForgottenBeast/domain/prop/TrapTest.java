package LairOfTheForgottenBeast.domain.prop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrapTest
{
   @Test
   public void test4()
   {
      PropTesting test4 = new PropTesting();
      String output = test4.createTrap().getName();
      System.out.println(output);
      assertEquals("Tripwire", output);
   }
}