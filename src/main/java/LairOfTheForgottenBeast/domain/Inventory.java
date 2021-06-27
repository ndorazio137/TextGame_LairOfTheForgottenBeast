package LairOfTheForgottenBeast.domain;

/* Non static Imports */
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Inventory container to be used with the 
 * Player, Enemies, Objects, etc.
 * 
 * @version 0.0.1
 * @author Nick D'Orazio
 * @contactOfAuthor ndorazio@csumb.edu
 * @dateCreated 6/26/2021
 * @lastUpdate 6/26/2021 
 * @updateBy unchanges since creation
 */
public class Inventory {
   
   /**
    * The inventory list. Within the Inventory Class
    * 
    * @dataType List of Items
    */
   private List<Item> inventory;
   
   /** 
    * Constructor for Inventory Objects. Creates a new inventory of a 
    * specific length when passed a number representing the length of the inventory.
    *  
    * @param inventoryLimit The length of the inventory to be created.
    */
   public Inventory( int inventoryLimit ) {
      this.inventory = new ArrayList<Item>();
   }
   
   /** 
    * Gets the inventory.
    * 
    * @NOTE Used only for displaying inventory to screen. The exact implementation 
    * of the list will be hidden from the Objects calling the inventory class.
    * 
    * @return inventory. A List of Items.
    */
   public List<Item> getItemList() {
      return inventory;
   }
   
   /** 
    * Gets the number of items in the inventory.
    * 
    * @return The integer size of the inventory.
    */
   public int size() {
      return inventory.size();
   }
   
   /**
    *  Instantiates a new inventory and sets the old one to null 
    *  for garbage collecton.
    *  
    *   @return A boolean to represent the status of the inventory being empty.
    */
   public boolean clearInventory() {
      this.inventory = null;
      inventory = new ArrayList<Item>();
      
      /* If inventory is not empty, return failure status false */
      if (!(inventory.isEmpty()))
         return false;
      
      return true;
   }
   
   /**
    * Given an item, the item will be added to the inventory.
    * 
    * @param inventoryItem The Item object to be added to inventory.
    * @return A boolean expression for whether or not the item was successfully added to inventory
    */
   public boolean add(Item inventoryItem) {
      if (inventoryItem == null) 
         return false;
      inventory.add(inventoryItem);
      return true;
   }

   /** Given an item, the item will be removed from the inventory.
    * 
    * @param item The Item object to be removed from the inventory.
    * @return Upon successful removal of the item, the item will be returned. On Failure 
    * a null value will be returned.
    */
   public Item remove(Item item) {
      if (inventory.isEmpty()) {
         System.out.println("Inventory is Empty");
         return null;
      }
      int index = inventory.indexOf(item);
      Item returnedItem = inventory.remove(index);
      return returnedItem;
   }
}

