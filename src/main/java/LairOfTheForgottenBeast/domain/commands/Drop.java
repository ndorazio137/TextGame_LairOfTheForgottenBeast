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
import LairOfTheForgottenBeast.inventorySystem.Inventory;

/**
 * Represents any command preceded by the word "drop". Implements the ICommand Interface.
 * 
 * @author Brian James
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Drop implements ICommand<String> {
  /**
   * Contains the logic for what to do when the command "drop" is called.
   * 
   * @return A String, determined by the Drop logic, and used to update inventory
   */
  /*
   * updateAuthor: Brian James and Kyle Oakes
   */
  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {

    WorldMap worldMap = gameState.getWorldMap();
    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    String itemName = "";

    RoomDynamic dropRoom = player.getCurrentRoom();
    Inventory playerInventory = player.getInventory();
    List<String> command = commandInfo.getCommandList();
    if (command.size() > 1) {
      for (int i = 1; i < command.size(); i++) {
        if (i > 1) {
          itemName += " ";
        }
        itemName += command.get(i);
      }
      // First check the equipped item
      Item weapon = player.getWeapon();
      Item item = playerInventory.getItem(itemName);
      System.out.println(weapon);
      if (weapon != null) {
        player.unequipWeapon();
        playerInventory.removeItem(weapon);
        dropRoom.addProp(weapon);
        return "You dropped the " + itemName + " onto the ground here.";
      } else if (item != null) {
      // Then check the inventory
        playerInventory.removeItem(item);
        dropRoom.addProp(item);
      } else 
        return defaultString();
    }
    return "You dropped the " + itemName + " onto the ground here.";
  }

  private String defaultString() {
    return "You don't have that item.";
  }
}
