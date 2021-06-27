package LairOfTheForgottenBeast.domain;

/* Non static Imports */
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a high level inventory container object to be used with the 
 * Player, Enemies, Objects, etc.
 * 
 * @version 0.0.1
 * @author Nick D'Orazio
 * @contactOfAuthor ndorazio@csumb.edu
 * @dateCreated 6/26/2021
 * @lastUpdate 6/26/2021 
 * @updateBy unchanged since creation
 */
public class BaseInventory implements Inventory {
   
   /**
    * The maximum number of items in a BaseInventory stack.
    */
   private int MAX_STACK = 50;
   
   /**
    * The inventory container.
    * 
    * @dataType List of Items
    */
   private List<Item> baseInventory;
   
   /** 
    * Constructor for Inventory Objects. Creates a new inventory of a 
    * specific length when passed a number representing the length of the inventory.
    *  
    * @param inventoryLimit The length of the inventory to be created.
    */
   public BaseInventory( int inventoryLimit ) {
      this.baseInventory = new ArrayList<Item>();
   }
   
   /** 
    * The size of the maximim number of items in an inventory stack
    */
   public int getMaxStackSize() {
      return MAX_STACK;
   }
   
   /** 
    * Gets the inventory.
    * 
    * @return inventory. A List of Items.
    */
   public List<Item> getAllItems() {
      return baseInventory;
   }
   
   /** 
    * Gets the number of items in the inventory.
    * 
    * @return The integer size of the inventory.
    */
   @Override
   public int getSize() {
      return baseInventory.size();
   }
   
   /**
    *  Instantiates a new inventory and sets the old one to null 
    *  for garbage collecton.
    *  
    *   @return A boolean to represent the status of the inventory being empty.
    */
   @Override
   public boolean clear() {
      this.baseInventory = null;
      baseInventory = new ArrayList<Item>();
      
      /* If inventory is not empty, return failure status false */
      if (!(baseInventory.isEmpty()))
         return false;
      
      return true;
   }
   
   /**
    * Given an item, the item will be added to the inventory.
    * 
    * @param inventoryItem The Item object to be added to inventory.
    * @return A boolean expression for whether or not the item was successfully added to inventory
    */
   @Override
   public boolean addItem(Item inventoryItem) {
      if (inventoryItem == null) 
         return false;
      baseInventory.add(inventoryItem);
      return true;
   }

   /** Given an item, the item will be removed from the inventory.
    * 
    * @param item The Item object to be removed from the inventory.
    * @return Upon successful removal of the item, the item will be returned. On Failure 
    * a null value will be returned.
    */
   @Override
   public Item removeItem(Item item) {
      if (baseInventory.isEmpty()) {
         System.out.println("Inventory is Empty");
         return null;
      }
      int index = baseInventory.indexOf(item);
      Item returnedItem = baseInventory.remove(index);
      return returnedItem;
   }
}

