package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.Prop;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

/**
 * Represents any command preceded by the word "take". Implements the ICommand Interface.
 * 
 * @author Nick D'Orazio, Brian James, Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Take implements ICommand<String> {
  /**
   * Contains the logic for what to do when the command "take" is called.
   * 
   * @return A String, determined by the Take logic, and used to update inventory
   */
  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {
    WorldMap worldMap = gameState.getWorldMap();
    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    boolean multiplayer = commandInfo.getMultiplayer();
    List<String> command = commandInfo.getCommandList();

    RoomDynamic takeRoom = player.getCurrentRoom();
    Inventory playerInventory = player.getInventory();

    System.out.println("Gamestate recieved in Take: " + gameState);
    System.out.println("Current Room: " + takeRoom.getLongDescription(multiplayer));

    printCommandList(command);

    // Need a list of props in the room to take and put into inventory
    // Need to get the inventory of player, then add the item to it.

    String itemName = "";
    Item item = new Item();
    // Class of prop we are looking for is
    // LairOfTheForgottenBeast.domain.prop.Item
    Class<? extends Item> itemClass = item.getClass();

    if (command.size() > 1) {
      for (int i = 1; i < command.size(); i++) {
        if (i > 1) {
          itemName += " ";
        }
        itemName += command.get(i);
      }

      System.out.println("Item name: \"" + itemName + "\"");
      // Get list of props from room
      List<Prop> itemList = takeRoom.getProps();
      System.out.println("Prop List: " + itemList.toString());
      for (Prop itemElement : itemList) {

        // Class of prop we are looking for is
        // LairOfTheForgottenBeast.domain.prop.Item
        Class<? extends Prop> propClass = itemElement.getClass();

        // Is the itemElement null? Does it have the name we are looking
        // for? Is this Prop an Item or some other type of Prop?
        // If the Prop is not an Item class, then we do not allow it
        // to be Taken.
        if ((itemElement.getName() != null) && (itemElement.getName().equals(itemName))
            && (propClass == itemClass)) {
          // add the item to the player's inventory.

          playerInventory.addItem((Item) itemElement);
          System.out.println("Player inventory: " + playerInventory);
          System.out.println("***Found the item***");
          takeRoom.removeProp((Item) itemElement);
          return "You pick up " + itemElement.getName() + ".";
        }
      }
    }

    return defaultString();
  }

  private String defaultString() {
    return "You can't take that.";
  }

  public void printCommandList(List<String> command) {
    for (int i = 0; i < command.size(); i++) {
      System.out.println(command.get(i));
    }
  }
}
