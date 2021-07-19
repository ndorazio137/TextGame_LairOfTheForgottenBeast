package LairOfTheForgottenBeast.domain.inventorySystem;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

/* In-House Import Statements */
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.prop.Item;

/**
 * Unit test cases for the Player Class's inventory methods.
 * 
 * @author Nick D'Orazio
 * @version 0.0.1
 * @since 1.0.0
 */
@Tag("PlayerInventoryUnitTests") // TODO: This is really in the player class, update when time
                                 // permits.
public class PlayerInventoryUnitTest {

  /* Provides logging output for each test */
  private static Logger LOG = Logger.getLogger("PlayerInventoryUnitTest Logger");

  /* Class under testing */
  private Player player;

  /* Mock Dependency */
  @Mock
  private Item item;

  /**
   * Before each test case: run the logger and mock dependencies.
   * 
   * @author Nick D'Orazio
   * @since 1.0.0
   * 
   * @param testInfo An object created by a JUnit import to be able to get the method under test
   *        name.
   */
  @BeforeEach
  public void setupTests(TestInfo testInfo) {
    player = new Player();
    item = Mockito.mock(Item.class);
    LOG.info("Running Test Case " + testInfo.getDisplayName());
  }

  /**
   * Run the logger after each test case and do clean up.
   * 
   * @author Nick D'Orazio
   * @since 1.0.0
   * 
   * @param testInfo An object created by a JUnit import to be able to get the method under test
   *        name.
   */
  @AfterEach
  public void finishTest(TestInfo testInfo) {
    LOG.info("Finishing Test Case " + testInfo.getDisplayName());
    System.out.println();
    player = null;
    item = null;
  }

  /**
   * Test to determine if the Players inventory exists.
   * 
   * @author Nick D'Orazio
   * @since 1.0.0
   */
  @Test
  @Tag("UnitTest")
  public void playerInventoryTest() {
    /* Get the players inventory */
    Object playersInventory = player.getInventory();

    /* Check: Does the player have an inventory? */
    assertThat(playersInventory).isNotNull();
  }

  /**
   * Test to determine if the Players inventory returns Items.
   * 
   * @author Nick D'Orazio
   * @since 1.0.0
   */
  @Test
  @Tag("UnitTest")
  public void playerInventoryItemTest() {
    /* Add item to the players inventory */
    player.addToInventory(item);

    /* Remove the item from the players inventory */
    Object removedItem = player.removeFromInventory(item);

    /* Check: Is the item added to the inventory the same as the returned Item */
    assertThat(removedItem).isEqualTo(item);
  }
}
