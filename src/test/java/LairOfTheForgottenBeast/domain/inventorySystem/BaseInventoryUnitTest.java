package LairOfTheForgottenBeast.domain.inventorySystem;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.BaseInventory;

/**
 * Test cases for the BaseInventory Class.
 * 
 * @author Nick D'Orazio
 * @version 0.0.1
 * @dateCreated 6/26/2021
 * @lastUpdated 6/26/2021 
 * @updateBy unchanged since creation
 */
@Tag("BaseInventoryUnitTests")
public class BaseInventoryUnitTest {
   
	/* Provides logging output for each test */
	private static Logger LOG = Logger.getLogger("BaseInventoryTest Logger");
	
	/* Mocked dependency */
	@Mock
	private Item item;
	
	/**
	 * Before each test case: run the logger and mock dependencies.
	 * 
	 * @author Nick D'Orazio
	 * @since 1.0.0
	 * 
	 * @param testInfo An object created by a JUnit import to be able to get the method under test name.
	 */
	@BeforeEach
	public void setupTests(TestInfo testInfo) {
		LOG.info("Running Test Case " + testInfo.getDisplayName());
		item = Mockito.mock(Item.class);
	}
	
	/**
	 * Run the logger after each test case and do clean up.
	 * 
	 * @author Nick D'Orazio
	 * @since 1.0.0
	 * 
	 * @param testInfo An object created by a JUnit import to be able to get the method under test name.
	 */
	@AfterEach
	public void finishTest(TestInfo testInfo) {
		LOG.info("Finishing Test Case " + testInfo.getDisplayName());
		System.out.println();
		item = null;
	}
	
   /** 
    * Test to determine if the BaseInventory can be created.
    * 
    * @author Nick D'Orazio
    * @since 1.0.0
    */
   @Test 
   @Tag("UnitTest")
   public void unitTest_inventoryCreationTest() {
      /* Create a BaseInventory with a size of 1 */
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      /* Check: Was the inventory created? */
      assertThat(baseInventory).isNotNull();
   }
   
   /** 
    * Test to determine if the BaseInventory can be retrieved.
    * 
    * @author Nick D'Orazio
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
   public void unitTest_getInventory() {
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
    * 
    * @author Nick D'Orazio
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
   public void unitTest_clearInventory() {
      /* Create a BaseInventory with size 1 */
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      /* Create an Item and add it to the inventory */
      baseInventory.addItem(item);
      
      /* Clear the inventory and get the inventory size */
      baseInventory.clear();
      int inventorySize = baseInventory.getSize();
      
      /* Check: Is the inventory empty? */
      assertThat(inventorySize).isEqualTo(0);
   }
   
   /** 
    * Test to determine if an Item can be added to the BaseInventory.
    * 
    * @author Nick D'Orazio
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
   public void unitTest_addToInventoryTest() {
      /* Create a BaseInventory with size 1 */
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      /* Create an Item and add it to the inventory */
      boolean b = baseInventory.addItem(item);
      
      /* Check: Was the Item added? */
      assertThat(b).isEqualTo(true);
   }
   
   /** 
    * Test to determine if an Item can be removed from the BaseInventory.
    * 
    * @author Nick D'Orazio
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
   public void unitTest_removeFromInventoryTest() {
      /* Create a BaseInventory with size 1 */
      int inventoryLimit = 1;
      BaseInventory baseInventory = new BaseInventory(inventoryLimit);
      
      /* Create an Item and add it to the inventory */
      baseInventory.addItem(item);
      
      /* Remove the Item from the inventory */
      Item removedItem = baseInventory.removeItem(item);
      
      /* Check: Is the item removed the same as the item added? */
      assertThat(removedItem).isEqualTo(item);
   }
}
