package LairOfTheForgottenBeast.domain;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.BaseInventory;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

/**
 * Represents a Player in the game.
 * 
 * @author Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 */
public class Player {
   
   private RoomDynamic currentRoom;
   private String name;
   private Inventory inventory;
   private int playerInventorySize = 50;
   
   public Player() {
      this.inventory = (BaseInventory) createInventory(playerInventorySize);
   }
   
   public Player(String name) {
      this.name = name;
   }
   
   public Player(RoomDynamic currentRoom, String name) {
      this.currentRoom = currentRoom;
      this.name = name;
   }
   
   public RoomDynamic getCurrentRoom() {
      return currentRoom;
   }
   
   public void setCurrentRoom(RoomDynamic currentRoom) {
      this.currentRoom = currentRoom;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((currentRoom == null) ? 0 : currentRoom.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Player other = (Player) obj;
      if (currentRoom == null) {
         if (other.currentRoom != null)
            return false;
      } else if (!currentRoom.equals(other.currentRoom))
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "Player [currentRoom=" + currentRoom + ", name=" + name + "]";
   }

   /**
    * Adds an Item object to an Inventory object.
    * @author Nick D'Orazio
    * @since 1.0.0
    * 
    * @param inventoryItem The Item to be added to an inventory.
    * @return A boolean representing if the Item was successful added to the inventory.
    */
   public boolean addToInventory(Item inventoryItem) {
      if (inventoryItem == null) {
         return false;
      }
      
      inventory.addItem(inventoryItem);
      return true;
   }

   /**
    * Removes an Item object from an Inventory object.
    * @author Nick D'Orazio
    * @since 1.0.0
    * 
    * @param item An Item to be removed from the inventory.
    * @return A boolean representing if the Item was successful removed from the inventory.
    */
   public Item removeFromInventory(Item item) {
      Item returnedItem = inventory.removeItem(item);
      return returnedItem;
   }

   //TODO: Change to creating a PlayerInventory when that class is implemented.
   /**
    * Creates a new inventory with the specified inventory size of the parameter.
    * @author Nick D'Orazio
    * @since 1.0.0
    * 
    * @param inventoryLimit The size of the inventory.
    * @return The newly created Inventory object.
    */
   public Inventory createInventory(int inventoryLimit) {
      inventory = new BaseInventory(inventoryLimit);
      return inventory;
   }
   
   /**
    * Retrieves the current Inventory object.
    * 
    * @author Nick D'Orazio
    * @since 1.0.0
    * 
    * @return The Inventory object.
    */
   public Inventory getInventory() {
      return inventory;
   }
}

