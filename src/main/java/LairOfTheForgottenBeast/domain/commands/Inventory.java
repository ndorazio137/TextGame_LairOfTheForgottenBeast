package LairOfTheForgottenBeast.domain.commands;

import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.inventorySystem.BaseInventory;

public class Inventory implements ICommand<String> {

  /**
   * 
   * Contains the logic for what to do when the command "inventory" is called.
   * 
   * @return A String, determined by the Inventory logic, and used to update the UI
   */
  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {
    System.out.println("Gamestate recieved in Inventory Command: " + gameState);
    System.out.println("In Inventory(): call");
    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    System.out.println("Inventory(" + player.getInventory() + ") ");
    BaseInventory playerInventory = (BaseInventory) player.getInventory();
    String inventoryString = playerInventory.toString();
    return inventoryString;
  }
}
