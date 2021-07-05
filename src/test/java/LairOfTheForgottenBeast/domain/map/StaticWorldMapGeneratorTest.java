package LairOfTheForgottenBeast.domain.map;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StaticWorldMapGeneratorTest {

   /** 
    * Test to determine if the static map is not null.
    */
   @Test
   public void staticMapGenExistsTest() {
      
      /* Create a new map */
      StaticWorldMapGenerator newTestMap1 = new StaticWorldMapGenerator();
      
      /* Check: Does the map exist? */
      assertThat(newTestMap1).isNotNull();
      
   }
   
   /** 
    * Test to determine if the static map is null.
    */
   @Test
   public void staticMapGenNullTest() {
      
      /* Create a new null map */
      StaticWorldMapGenerator newTestMap2 = null;
      
      /* Check: Is the map null? */
      assertThat(newTestMap2).isNull();
   
   }

}