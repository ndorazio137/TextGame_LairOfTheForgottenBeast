package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.Prop;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

public class Consume implements ICommand<String> {
  /**
   * Contains the logic for what to do when the command "consume" is called.
   * 
   * @return A String, determined by the Consume logic, and used to update inventory
   */
  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {
    WorldMap worldMap = gameState.getWorldMap();
    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    boolean multiplayer = commandInfo.getMultiplayer();
    List<String> command = commandInfo.getCommandList();
    RoomDynamic consumeRoom = player.getCurrentRoom();
    Inventory playerInventory = player.getInventory();
    System.out.println("Gamestate recieved in Take: " + gameState);
    System.out.println("Current Room: " + consumeRoom.getLongDescription(multiplayer));
    printCommandList(command);
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
      // Get list of props from room
      List<Prop> itemList = consumeRoom.getProps();
      // Get list of props from room
      Inventory invList = player.getInventory();
      System.out.println("Prop List: " + itemList.toString());
      System.out.println("Inventory List: " + invList.toString());
      for (Item invElement : invList) {
        // Class of prop we are looking for is
        // LairOfTheForgottenBeast.domain.prop.Item
        Class<? extends Item> ItemClass = invElement.getClass();
        // Is the itemElement null? Does it have the name we are looking
        // for? Is this Prop an Item or some other type of Prop?
        // If the Prop is not an Item class, then we do not allow it
        // to be Taken.
        if ((invElement.getName() != null) && (invElement.getName().equals(itemName))
            && (ItemClass == itemClass)) {
          // remove item from the player's inventory.
          playerInventory.removeItem((Item) invElement);
          // Execute the effect that comes from consuming the object.
          if (invElement.getName() == "healing potion") {
            System.out
                .println("Healing spell on player. Current Hit Points now Equals Max Hit Points");
            player.setCurrentHitPoints(player.getMaxHitPoints());

          }
          return "You consume a " + invElement.getName() + ".";
        }
      }
      for (Prop itemElement : itemList) {
        // Class of prop we are looking for is
        // LairOfTheForgottenBeast.domain.prop.Item
        Class<? extends Prop> ItemClass = itemElement.getClass();
        // Is the itemElement null? Does it have the name we are looking
        // for? Is this Prop an Item or some other type of Prop?
        // If the Prop is not an Item class, then we do not allow it
        // to be Taken.
        if ((itemElement.getName() != null) && (itemElement.getName().equals(itemName))
            && (ItemClass == itemClass)) {
          // remove item from room.
          consumeRoom.removeProp((Item) itemElement);
          // Execute the effect that comes from consuming the object.
          if (itemElement.getName() == "healing potion") {
            System.out
                .println("Healing spell on player. Current Hit Points now Equals Max Hit Points");
            player.setCurrentHitPoints(player.getMaxHitPoints());
          }
          return "You consume a " + itemElement.getName() + ".";
        }
      }
    }
    return defaultString();
  }

  private String defaultString() {
    return "You can't consume that.";
  }

  public void printCommandList(List<String> command) {
    for (int i = 0; i < command.size(); i++) {
      System.out.println(command.get(i));
    }
  }
}
