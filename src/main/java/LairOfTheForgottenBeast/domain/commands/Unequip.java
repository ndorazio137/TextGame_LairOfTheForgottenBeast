package LairOfTheForgottenBeast.domain.commands;

import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
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
public class Unequip implements ICommand<String> {
  /**
   * Contains the logic for what to do when the command "unequip" is called.
   * 
   * @return A String, determined by the Unequip logic, to be returned to the screen
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
      return failedToUnEquipString();
    Item item = player.getWeapon();
    //
    if (item == null)
      return dontHaveItemString();
    boolean unEquippedSuccessfully = player.unequipWeapon();
    if (unEquippedSuccessfully)
      return unEquippedSuccessfullyString(itemName);
    return failedToUnEquipString();
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

  private String failedToUnEquipString() {
    return "Failed to unequip";
  }

  private String unEquippedSuccessfullyString(String itemName) {
    return "You unequip \"" + itemName + "\"";
  }

  private String dontHaveItemString() {
    return "You don't have that item.";
  }
}
