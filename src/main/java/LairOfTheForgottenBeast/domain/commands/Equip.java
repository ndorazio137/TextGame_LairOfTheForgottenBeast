package LairOfTheForgottenBeast.domain.commands;

import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

/**
 * Represents any command preceded by the word "drop". Implements the ICommand Interface.
 * 
 * @author Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Equip implements ICommand<String> {
  /**
   * Contains the logic for what to do when the command "equip" is called.
   * 
   * @return A String, determined by the Equip logic, to be returned to the screen
   */
  /*
   * updateAuthor: Kyle Oakes
   */
  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {
    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    List<String> command = commandInfo.getCommandList();
    Inventory playerInventory = player.getInventory();
    String itemName = itemStringBuilder(command);
    if (itemName == null)
      return failedToEquipString();
    Item item = playerInventory.getItem(itemName);
    if (item == null)
      return dontHaveItemString();
    boolean equippedSuccessfully = player.equipWeapon(item);
    if (equippedSuccessfully)
      return equippedSuccessfullyString(itemName);
    return failedToEquipString();
  }

  private String itemStringBuilder(List<String> command) {
    String itemName = "";
    if (command.size() > 1) {
      for (int i = 1; i < command.size(); i++) {
        if (i > 1) {
          itemName += " ";
        }
        itemName += command.get(i);
      }
    }
    return itemName;
  }

  private String failedToEquipString() {
    return "Failed to equip";
  }

  private String equippedSuccessfullyString(String itemName) {
    return "You equip \"" + itemName + "\"";
  }

  private String dontHaveItemString() {
    return "You don't have that item.";
  }
}
