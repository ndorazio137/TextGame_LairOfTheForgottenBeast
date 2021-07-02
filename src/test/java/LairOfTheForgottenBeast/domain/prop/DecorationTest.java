package LairOfTheForgottenBeast.domain.prop;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DecorationTest
{
   @Test
   public void test2()
   {
      PropTesting test2 = new PropTesting();
      String output = test2.createDecoration().getName();
      System.out.println(output);
      assertEquals("painting", output);
   }
}