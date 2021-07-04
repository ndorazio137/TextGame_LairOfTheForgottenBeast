package LairOfTheForgottenBeast.inventorySystem;

import LairOfTheForgottenBeast.domain.prop.Item;

/**
 * A top level interface for the Inventory Management System.
 * 
 * @author Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Inventory {
   /**
    * Given an item, the item will be added to the inventory.
    * 
    * @param item The Item object to be added to inventory.
    * @return A boolean expression for whether or not the item was successfully added to inventory
    */
   public boolean addItem(Item item);
   /** Given an item, the item will be removed from the inventory.
    * 
    * @since 1.0.0
    * 
    * @param item The Item object to be removed from the inventory.
    * @return Item|null. Upon successful removal of the item, the item will be returned. On Failure 
    * a null value will be returned.
    */
   public Item removeItem(Item item);
   /** 
    * Gets the number of items in the inventory.
    * 
    * @since 1.0.0
    * 
    * @return The integer size of the inventory.
    */
   public int getSize();
   /**
    *  Clears the inventory of all items.
    *  
    *  @since 1.0.0
    *  
    *  @return A boolean representing if the inventory was successfully cleared.
    */
   public boolean clear();
}
