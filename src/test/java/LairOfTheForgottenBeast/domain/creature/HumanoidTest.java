package LairOfTheForgottenBeast.domain.creature;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HumanoidTest {
  @Test
  public void test1() {
    CreatureTesting test1 = new CreatureTesting();
    String output = test1.createHuman().getName();
    System.out.println(output);
    assertEquals("Harry Castle", output);
  }
}
