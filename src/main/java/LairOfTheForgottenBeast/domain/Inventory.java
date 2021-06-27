package LairOfTheForgottenBeast.domain;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

   List<Item> inventory;
   int inventorySize;
   
   public Inventory( int inventoryLimit ) {
      this.inventory = new ArrayList<Item>();
      
   }
   
   public List<Item> getItemList() {
      return inventory;
   }
   
   public int size() {
      return inventory.size();
   }
   
   public boolean clearInventory() {
      this.inventory = null;
      inventory = new ArrayList<Item>();
      return true;
   }
   
   public boolean add(Item inventoryItem) {
      if (inventoryItem == null) 
         return false;
      inventory.add(inventoryItem);
      return true;
   }

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

