package LairOfTheForgottenBeast.domain.prop;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NaturePropTest
{
   @Test
   public void test3()
   {
      PropTesting test3 = new PropTesting();
      String output = test3.createNatureProp().getName();
      System.out.println(output);
      assertEquals("tree", output);
   }
}