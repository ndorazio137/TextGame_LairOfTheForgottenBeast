package LairOfTheForgottenBeast.domain.inventory;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.BaseInventory;
import LairOfTheForgottenBeast.domain.Inventory;
import LairOfTheForgottenBeast.domain.Item;

/**
 * Test cases for the BaseInventory Class.
 * 
 * @author Nick D'Orazio
 * @version 0.0.1
 * @dateCreated 6/26/2021
 * @lastUpdated 6/26/2021 
 * @updateBy unchanged since creation
 */
@SpringBootTest
public class BaseInventoryTest {
   
   /** 
    * Test to determine if the BaseInventory can be created.
    */
   @Test 
   public void inventoryCreationTest() {
      /* Create a BaseInventory with a size of 1 */
      int inventoryLimit = 1;
      Inventory baseInventory = new BaseInventory(inventoryLimit);
      
      /* Check: Was the inventory created? */
      assertThat(baseInventory).isNotNull();
   }
   
   /** 
    * Test to determine if the BaseInventory can be retrieved.
    */
   @Test
   public void getInventory() {
      /* Create a BaseInventory with size 1 */
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      /* Retrieve all the items in the inventory */
      List<Item> inventoryList = baseInventory.getAllItems();
      
      /* Check: Does it return an inventory container? */
      assertThat(inventoryList).isNotNull();
   }
   
   /** 
    * Test to determine if the BaseInventory can be cleared.
    */
   @Test
   public void clearInventory() {
      /* Create a BaseInventory with size 1 */
      int inventoryLimit = 1;
      Inventory baseInventory = new BaseInventory(inventoryLimit);
      
      /* Create an Item and add it to the inventory */
      Item item = new Item();
      baseInventory.addItem(item);
      
      /* Clear the inventory and get the inventory size */
      baseInventory.clear();
      int inventorySize = baseInventory.getSize();
      
      /* Check: Is the inventory empty? */
      assertThat(inventorySize).isEqualTo(0);
   }
   
   /** 
    * Test to determine if an Item can be added to the BaseInventory.
    */
   @Test
   public void addToInventoryTest() {
      /* Create a BaseInventory with size 1 */
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      /* Create an Item and add it to the inventory */
      Item item = new Item();
      boolean b = baseInventory.addItem(item);
      
      /* Check: Was the Item added? */
      assertThat(b).isEqualTo(true);
   }
   
   /** 
    * Test to determine if an Item can be removed from the BaseInventory.
    */
   @Test 
   public void removeFromInventoryTest() {
      /* Create a BaseInventory with size 1 */
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      /* Create an Item and add it to the inventory */
      Item item = new Item();
      baseInventory.addItem(item);
      
      /* Remove the Item from the inventory */
      Item removedItem = baseInventory.removeItem(item);
      
      /* Check: Is the item removed the same as the item added? */
      assertThat(removedItem).isEqualTo(item);
   }
}
