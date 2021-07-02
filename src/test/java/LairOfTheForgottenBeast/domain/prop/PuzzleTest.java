package LairOfTheForgottenBeast.domain.prop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PuzzleTest
{
   @Test
   public void test5()
   {
      PropTesting test5 = new PropTesting();
      String output = test5.createPuzzle().getName();
      System.out.println(output);
      assertEquals("puzzle", output);
   }
}
