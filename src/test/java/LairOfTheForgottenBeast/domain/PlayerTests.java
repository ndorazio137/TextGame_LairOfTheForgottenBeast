package LairOfTheForgottenBeast.domain;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerTests {

   /** 
    * Test to determine if the Player's name field is not null.
    */
   @Test
   public void playerNameTest() {
      
      /* Create a Player with a specified name */
      Player player = new Player("Brian");
      
      /* Get the player's name */
      String name = player.getName();
      
      /* Check: Does the player have a name? */
      assertThat(name).isNotNull();
   }
   
   /** 
    * Test to determine if the Player's name field is null.
    */
   @Test
   public void playerNameNullTest() {
      
      /* Create a Player without assigning anything to name field */
      Player player = new Player();
      
      /* Get the player's name */
      String name = player.getName();
      
      /* Check: Is the player's name null? */
      assertThat(name).isNull();
   }
}