package LairOfTheForgottenBeast.domain.inventorySystem;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/* In-House Import Statements */
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.inventorySystem.BaseInventory;
import LairOfTheForgottenBeast.inventorySystem.Inventory;
import antlr.collections.List;
import LairOfTheForgottenBeast.domain.Item;

/**
 * Test cases for the Player Class's inventory methods.
 * 
 * @author Nick D'Orazio
 * @version 0.0.1
 * @dateCreated 6/26/2021
 * @lastUpdated 6/26/2021 
 * @updateBy unchanged since creation
 */
@SpringBootTest
public class PlayerInventoryTest {

   /** 
    * Test to determine if the Players inventory exists.
    */
   @Test
   public void playerInventoryTest() {
      
      /* Create a Player */
      Player player = new Player();
      
      /* Get the players inventory */
      Inventory playersInventory = player.getInventory();
      
      /* Check: Does the player have an inventory? */
      assertThat(playersInventory).isNotNull();
   }
   
   /** 
    * Test to determine if the Players inventory returns Items.
    */
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
