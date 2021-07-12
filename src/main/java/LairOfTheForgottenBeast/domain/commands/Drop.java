package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

/**
 * Represents any command preceded by the word "drop". Implements the ICommand
 * Interface.
 * 
 * @author Brian James
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Drop implements ICommand<String>
{
   /**
    * Contains the logic for what to do when the command "drop" is called.
    * 
    * @return A String, determined by the Drop logic, and used to update
    *         inventory
    */
   /*
    * updateAuthor: Brian James and Kyle Oakes
    */
   @Override
   public <AnyType> String call(GameState gameState, List<String> command)
   {

      WorldMap worldMap = gameState.getWorldMap();
      Player player = gameState.getPlayer();
      String itemName = "";

      RoomDynamic dropRoom = player.getCurrentRoom();
      Inventory playerInventory = player.getInventory();
      
      if (command.size() == 2)
      {
         itemName = command.get(1);
         Item item = playerInventory.getItem(itemName);
         playerInventory.removeItem(item);
         dropRoom.addProp(item);
      } else
         
      if (command.size() == 3)
      {
         // The item name has two words
         String itemName1 = command.get(1);
         String itemName2 = command.get(2);
         itemName = itemName1 + " " + itemName2;
         System.out.println("Concat: " + itemName);

         Item item = playerInventory.getItem(itemName);
         playerInventory.removeItem(item);
         dropRoom.addProp(item);
      }
      
      return "You dropped the " + itemName + " onto the ground here.";
   }

   private String defaultString()
   {
      return "You can't drop that.";
   }
}
