package LairOfTheForgottenBeast.inventorySystem;

import LairOfTheForgottenBeast.domain.Item;

/**
 * A top level interface for the Inventory Management System.
 * 
 * @author Nick D'Orazio
 * @version 0.0.1
 * @dateCreated 6/26/2021
 * @lastUpdated 6/26/2021 
 * @updateBy unchanged since creation
 */
public interface Inventory {
   public boolean addItem(Item item);
   public Item removeItem(Item item);
   public int getSize();
   public boolean clear();
}
