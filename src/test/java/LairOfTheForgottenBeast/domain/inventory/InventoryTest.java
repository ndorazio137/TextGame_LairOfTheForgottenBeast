package LairOfTheForgottenBeast.domain.inventory;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.BaseInventory;
import LairOfTheForgottenBeast.domain.Item;

@SpringBootTest
public class InventoryTest {
   
   @Test 
   public void inventoryCreationTest() {
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      assertThat(baseInventory).isNotNull();
   }
   
   @Test
   public void getInventory() {
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      List<Item> inventoryList = baseInventory.getAllItems();
      assertThat(inventoryList).isNotNull();
   }
   
   @Test
   public void clearInventory() {
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      Item item = new Item();
      baseInventory.addItem(item);
      baseInventory.clear();
      int inventorySize = baseInventory.getSize();
      assertThat(inventorySize).isEqualTo(0);
   }
   
   @Test
   public void addToInventoryTest() {
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      Item item = new Item();
      boolean b = baseInventory.addItem(item);
      assertThat(b).isEqualTo(true);
   }
   
   @Test 
   public void removeFromInventoryTest() {
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      Item item = new Item();
      baseInventory.addItem(item);
      Item removedItem = baseInventory.removeItem(item);
      assertThat(removedItem).isEqualTo(item);
   }
}
