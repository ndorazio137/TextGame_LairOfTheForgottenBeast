package LairOfTheForgottenBeast.domain;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.BaseInventory;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

/**
 * Represents a Player in the game.
 * 
 * @author Kyle Oakes and Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 */
public class Player {
   
	/**
	 * The current room the player is in.
	 */
   private RoomDynamic currentRoom;
   /**
    * The players username.
    */
   private String name;
   /**
    * The inventory attached to a player
    */
   private Inventory inventory;
   /**
    * The max number of items that can be in a players inventory
    */
   private int playerInventorySize = 50;
   /**
    * The weapon the player currently yields.
    */
   private Item weapon; 
   
   public Player() {
      createInventory(playerInventorySize);
   }
   
   public Player(Inventory inventory) {
	   this.inventory = inventory;
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
    * @since 1.0.0
    * 
    * @param inventoryItem The Item to be added to an inventory.
    * @return A boolean representing if the Item was successfully added to the inventory.
    */
   public boolean addToInventory(Item inventoryItem) {
      if (inventoryItem == null)
         return false;
      inventory.addItem(inventoryItem);
      return true;
   }

   /**
    * Removes an Item object from an Inventory object.
    * @since 1.0.0
    * 
    * @param item An Item to be removed from the inventory.
    * @return Item|null. The Item removed from inventory
    */
   public Item removeFromInventory(Item item) {
	  if (item == null) 
		  return null;
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
    * @return T|F. A boolean representing if the inventory was successfully created.
    */
   public boolean createInventory(int inventoryLimit) {
	   if(inventoryLimit >= 0) {
		   inventory = new BaseInventory(inventoryLimit);
		   return true;
	   }
	   
	   return false;
   }
   
   /**
    * Retrieves the current Inventory object.
    * @since 1.0.0
    * 
    * @return The Inventory object.
    */
   public Inventory getInventory() {
      return inventory;
   }
   
   /**
    * Clears the inventory.
    * 
    * @return A boolean expression representing if the inventory was successfully cleared.
    */
   public boolean clearInventory() {
	   return inventory.clear();
   }
   
   /**
    * A check if the player has a set (non-null) inventory object.
    * 
    * @return A boolean expression representing if the player has been assigned an inventory.
    */
   public boolean hasInventory() {
	   if (inventory != null)
		   return true;
	   return false;
   }
   
   /**
    * Retrieves the name of the weapon the player is currently yielding.
    * 
    * @return The weapons name.
    */
   public String getWeaponName() {
	   return weapon.getName();
   }
   
   /**
    * Sets a weapon to the player.
    * 
    * @param weapon the weapon the player is yielding.
    */
   public void setWeapon(Item weapon) {
	   this.weapon = weapon;
   }
   
   /**
    * Equips any item as a weapon
    * 
    * @param weapon The item to be used as a weapon
    * @return A boolean expression (sanity check) representing whether the item was successfully equipped.
    */
   public boolean equipWeapon(Item weapon) {
	   boolean isWeaponEquippable = isWeaponInInventory(weapon);
	   if (isWeaponEquippable)  {
		   this.weapon = weapon;
		   inventory.removeItem(weapon);
		   return true;
	   }
	   return false;
   }
   
   /**
    * Moves the equipped item to the players inventory while removing it from the weapon players slot.
    * 
    * @return A boolean expression (sanity check) representing if the item was successfully unequipped and moved to the inventory.
    */
   public boolean unequipWeapon() {
	   if (weapon != null) {
		   inventory.addItem(weapon);
		   weapon = null;
	   	   return true;
	   }
	   
	   return false;
   }
   
   /**
    * A helper method to check if the player has the desired weapon to equip.
    * 
    * @param weapon The weapon to check for in the player inventory.
    * @return A boolean representing if the weapon is currently in the players inventory.
    */
   private boolean isWeaponInInventory(Item weapon) {
	   for (Item item : inventory) {
		   if (item.equals(weapon)) 
			   return true;
	   }
	   
	   return false;
   }
}

