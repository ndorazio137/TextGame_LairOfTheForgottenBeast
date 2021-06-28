package LairOfTheForgottenBeast.domain;

/* In-House Import Statements */
import LairOfTheForgottenBeast.domain.map.Room;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.BaseInventory;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

public class Player {
   
   private Room currentRoom;
   private String name;
   private Inventory baseInventory;
   private int playerInventorySize = 50;
   
   public Player() {
      this.baseInventory = (BaseInventory) createInventory(playerInventorySize);
   }
   
   public Player(String name) {
      this.name = name;
   }
   
   public Player(Room currentRoom, String name) {
      this.currentRoom = currentRoom;
      this.name = name;
   }
   
   public Room getCurrentRoom() {
      return currentRoom;
   }
   
   public void setCurrentRoom(Room currentRoom) {
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

   //TODO: Move into player inventor class when created
   public boolean addToInventory(Item inventoryItem) {
      if (inventoryItem == null) {
         return false;
      }
      
      baseInventory.addItem(inventoryItem);
      return true;
   }

   //TODO: Move into player inventor class when created
   public Item removeFromInventory(Item item) {
      Item returnedItem = baseInventory.removeItem(item);
      return returnedItem;
   }

   //TODO: Move into player inventor class when created
   public Inventory createInventory(int inventoryLimit) {
      baseInventory = new BaseInventory(inventoryLimit);
      return baseInventory;
   }
   
   //TODO: Move into player inventory class when created
   public Inventory getInventory() {
      return baseInventory;
   }
}

