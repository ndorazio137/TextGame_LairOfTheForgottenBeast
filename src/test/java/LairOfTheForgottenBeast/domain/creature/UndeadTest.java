package LairOfTheForgottenBeast.domain.creature;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UndeadTest {
  @Test
  public void test3() {
    CreatureTesting test3 = new CreatureTesting();
    String output = test3.createUndead().getName();
    System.out.println(output);
    assertEquals("Skeleton", output);
  }
}
