package LairOfTheForgottenBeast.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrapTest
{
   @Test
   public void test4()
   {
      PropTesting test4 = new PropTesting();
      String output = test4.mockTrap().getName();
      System.out.println(output);
      assertEquals("Tripwire", output);
   }
}