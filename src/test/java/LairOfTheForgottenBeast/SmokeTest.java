package LairOfTheForgottenBeast;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import LairOfTheForgottenBeast.controller.HomeController;

/**
 * A test to check if the controller has loaded properly.
 * 
 * @author Nick D'Orazio
 * @version 1.0.0
 */
@SpringBootTest
public class SmokeTest {

  @Autowired
  private HomeController controller;

  @Test
  public void contextLoads() throws Exception {
    assertThat(controller).isNotNull();
  }
}
