package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.Prop;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

/**
 * Represents any command preceded by the word "take". 
 * Implements the ICommand Interface.
 * 
 * @author Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Take implements ICommand<String>
{
   /**
    * Contains the logic for what to do when the command "take" is called.
    * 
    * @return A String, determined by the Take logic, and used to update inventory
    */
    /* 
     * updateAuthor: Brian James and Kyle Oakes
     */
   @Override
   public <AnyType> String call(GameState gameState, List<String> command)
   {

      WorldMap worldMap = gameState.getWorldMap();
      Player player = gameState.getPlayer();

      Room currentRoom = player.getCurrentRoom();
      Inventory playerInventory = player.getInventory();
      int[] coords = worldMap.getRoomCoords(currentRoom);
      RoomDynamic takeRoom = worldMap.getRoom(coords);

      System.out.println("Gamestate recieved in Take: " + gameState);
      System.out.println("Current Room: " + takeRoom.getLongDescription());

      for (int i = 0; i < command.size(); i++)
      {
         System.out.println(command.get(i));
      }
      
      // Need a list of props in the room to take and put into inventory    
      // Need to get the inventory of player, then add the item to it.
      
      String itemName = "";
      Item item = new Item();
      
      // Class of prop we are looking for is
      // LairOfTheForgottenBeast.domain.prop.Item
      Class<? extends Item> itemClass = item.getClass();
      try
      {
         if (command.size() == 2)
         {
            itemName = command.get(1);
            
            // Get list of props from room
            List<Prop> itemList = takeRoom.getProps(); 
            System.out.println("Prop List: " + itemList.toString());            
            for(Prop itemElement : itemList) {
               
               // Class of prop we are looking for is
               // LairOfTheForgottenBeast.domain.prop.Item
               Class<? extends List> propClass = 
                  (Class<? extends List>) itemElement.getClass();
               
               // Is the itemElement null? Does it have the name we are looking
               // for? Is this Prop an Item or some other type of Prop? 
               // If the Prop is not an Item class, then we do not allow it 
               // to be Taken.
               if((itemElement.getName() != null) && 
                  (itemElement.getName().contains(itemName)) &&
                  (propClass == itemClass))                  
               {
                  // add the item to the player's inventory.
                  item = new Item(itemElement.getName(), 
                     itemElement.getShortDescription(), 
                     itemElement.getLongDescription());
                  
                  playerInventory.addItem(item);
                  System.out.println("Inventory");
                  System.out.println("Player inventory: " + playerInventory);
                  System.out.println("Inventory");
                  System.out.println("I found the one word item!!!");
                  return "Removed item from room: "+ takeRoom.removeProp(item);
               }
            }                                    
         } 
         else if (command.size() == 3)
         {
            // The prop name has two words
            String itemName1 = command.get(1);
            String itemName2 = command.get(2);
            itemName = itemName1 + " " + itemName2;
            System.out.println("Concat: " + itemName);
            
            List<Prop> itemList = takeRoom.getProps(); 
            System.out.println("Prop List: " + itemList.toString());
            for(Prop itemElement : itemList) {
               Class<? extends List> propClass = 
                  (Class<? extends List>) itemElement.getClass();
               
               if(itemElement.getName() != null && 
                  itemElement.getName().contains(itemName) &&
                  propClass == itemClass)
                  
               {
                  // add the item to the player's inventory.
                  playerInventory.addItem(item);
                  System.out.println("Player inventory: " + playerInventory);
                  System.out.println("I found the two word item!!!");
                  return "Removed item from room: "+ takeRoom.removeProp(item);
               }
            }        
         } 
         else
         {
            return defaultString();
         }
      } catch (IndexOutOfBoundsException e)
      {
         return defaultString();
      }
      return itemName;
      
//      System.out.println("Item");
//      System.out.println(item);
//      System.out.println("Remove Prop");
//      System.out.println(takeRoom.removeProp(item).toString());
//      System.out.println("Item");
//      System.out.println(item);
      
      // Remove the item from the room's itemList
      
   }   
   private String defaultString()
   {
      return "You can't take that.";
   }
}
