package LairOfTheForgottenBeast.domain.inventory;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/* In-House Import Statements */
import LairOfTheForgottenBeast.domain.Player;
import antlr.collections.List;
import LairOfTheForgottenBeast.domain.Inventory;
import LairOfTheForgottenBeast.domain.Item;

@SpringBootTest
public class PlayerInventoryTest {

   @Test
   public void playerInventoryTest() {
      
      /* Create a Player */
      Player player = new Player();
      
      /* Get the players inventory */
      Inventory playersInventory = player.getInventory();
      
      /* Check: Does the player have an inventory? */
      assertThat(playersInventory).isNotNull();
   }
   
   @Test
   public void playerInventoryItemTest() {
      
      /* Create a Player */
      Player player = new Player();
      
      /* Create an Item and add it to the players inventory */
      Item inventoryItem = new Item();
      player.addToInventory(inventoryItem);
      
      /* Remove the item from the players inventory */
      Item removedItem = player.removeFromInventory(inventoryItem);
      
      /* Check: Is the item added to the inventory the same as the returned Item */
      assertThat(removedItem).isEqualTo(inventoryItem);
   }
   
}
