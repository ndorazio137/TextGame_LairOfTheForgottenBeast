package LairOfTheForgottenBeast.domain.prop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// fails.
@SpringBootTest
class ItemTest {
  @Test
  public void test1() {
    PropTesting test1 = new PropTesting();
    String output = test1.createItem().getName();
    System.out.println(output);
    assertEquals("sword", output);
  }
}
