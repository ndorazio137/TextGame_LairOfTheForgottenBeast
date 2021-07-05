package LairOfTheForgottenBeast.inventorySystem;

/* Non static Imports */
import java.util.ArrayList;
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.prop.Item;

/**
 * Represents a high level inventory container object to be used with the 
 * Player, Enemies, Objects, etc.
 * 
 * @author Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseInventory implements Inventory {
   
   /**
    * The maximum number of items in a BaseInventory stack.
    * 
    * @since 1.0.0
    */
   private int MAX_STACK = 50;
   
   /**
    * The inventory container.
    * 
    * @since 1.0.0
    */
   private List<Item> baseInventory;
   
   /** 
    * Constructor for Inventory Objects. Creates a new inventory of a 
    * specific length when passed a number representing the length of the inventory.
    * 
    * @since 1.0.0
    * 
    * @param inventoryLimit The length of the inventory to be created.
    */
   public BaseInventory( int inventoryLimit ) {
      this.baseInventory = new ArrayList<Item>();
   }
   
   /** 
    * The size of the maximim number of items in an inventory stack
    * 
    * @since 1.0.0
    */
   public int getMaxStackSize() {
      return MAX_STACK;
   }
   
   /** 
    * Gets the inventory.
    * 
    * @since 1.0.0
    * 
    * @return inventory. A List of Items.
    */
   public List<Item> getAllItems() {
      return baseInventory;
   }
   
   /* Inherits Javadoc from interface */
   @Override
   public int getSize() {
      return baseInventory.size();
   }
   
   /* Inherits Javadoc from interface */
   @Override
   public boolean clear() {
      this.baseInventory = null;
      baseInventory = new ArrayList<Item>();
      
      /* If inventory is not empty, return failure status false */
      if (!(baseInventory.isEmpty()))
         return false;
      
      return true;
   }
   
   /* Inherits Javadoc from interface */
   @Override
   public boolean addItem(Item item) {
      if (item == null) 
         return false;
      baseInventory.add(item);
      return true;
   }
   
   /* Inherits Javadoc from interface */
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

