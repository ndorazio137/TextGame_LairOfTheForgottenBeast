package LairOfTheForgottenBeast.domain;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
/* Non-static Imports */
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.inventorySystem.BaseInventory;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

@RunWith(MockitoJUnitRunner.class)
@Tag("PlayerUnitTests")
public class PlayerTests {

	/* Provides logging output for each test */
	private static Logger LOG = Logger.getLogger("CommandInterpreterUnitTests Logger");
	
	/* Class under testing */
	Player player;
	
	/* Mocked dependency */
	@Mock
	private Inventory inventory;
	@Mock
	private RoomDynamic currentRoom;
	
	/**
	 * Before each test case: 
	 * run the logger and mock dependencies of the Player Class.
	 * 
	 * @since 1.0.0
	 * 
	 * @param testInfo An object created by a JUnit import to be able to get the method under test name.
	 */
	@BeforeEach
	public void setupTests(TestInfo testInfo) {
		LOG.info("Running Test Case " + testInfo.getDisplayName());
	}
	
	/**
	 * Run the logger after each test case and do clean up.
	 * 
	 * @since 1.0.0
	 * 
	 * @param testInfo An object created by a JUnit import to be able to get the method under test name.
	 */
	@AfterEach
	public void finishTest(TestInfo testInfo) {
		LOG.info("Finishing Test Case " + testInfo.getDisplayName());
		System.out.println();
	}
	
   /** 
    * Test to determine if the Player's name field is not null.
    */
   @Test
   @Tag("UnitTest")
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
   @Tag("UnitTest")
   public void playerNameNullTest() {
      
      /* Create a Player without assigning anything to name field */
      Player player = new Player();
      
      /* Get the player's name */
      String name = player.getName();
      
      /* Check: Is the player's name null? */
      assertThat(name).isNull();
   }
   
   @Test
   @Tag("UnitTest")
   public void playerBaseInventoryInjectionTest() {
	   /* Create a BaseInventory */
	   int inventoryLimitSize = 1;
	   Inventory inventory = new BaseInventory(inventoryLimitSize);
	   
	   /* Assign the player the inventory */
	   Player player = new Player(inventory);
	   
	   /* Check: does the player now have an inventory? */
	   assertThat(player.getInventory()).isNotNull();
   }
}