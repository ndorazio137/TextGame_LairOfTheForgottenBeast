package LairOfTheForgottenBeast.domain.inventory;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

/* Non-static Imports */
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.Inventory;
import LairOfTheForgottenBeast.domain.Item;

@SpringBootTest
public class InventoryTest {
   
   @Test 
   public void inventoryCreationTest() {
      int inventoryLimit = 1;
      Inventory inventory = new Inventory(inventoryLimit);
      assertThat(inventory).isNotNull();
   }
   
   @Test
   public void getInventory() {
      int inventoryLimit = 1;
      Inventory inventory = new Inventory(inventoryLimit);
      List<Item> inventoryList = inventory.getItemList();
      assertThat(inventoryList).isNotNull();
   }
   
   @Test
   public void clearInventory() {
      int inventoryLimit = 1;
      Inventory inventory = new Inventory(inventoryLimit);
      
      Item item = new Item();
      inventory.add(item);
      inventory.clearInventory();
      int inventorySize = inventory.size();
      assertThat(inventorySize).isEqualTo(0);
   }
   
   @Test
   public void addToInventoryTest() {
      int inventoryLimit = 1;
      Inventory inventory = new Inventory(inventoryLimit);
      
      Item item = new Item();
      boolean b = inventory.add(item);
      assertThat(b).isEqualTo(true);
   }
   
   @Test void removeFromInventoryTest() {
      int inventoryLimit = 1;
      Inventory inventory = new Inventory(inventoryLimit);
      
      Item item = new Item();
      inventory.add(item);
      Item removedItem = inventory.remove(item);
      assertThat(removedItem).isEqualTo(item);
   }
}
