package LairOfTheForgottenBeast.domain;

import java.util.ArrayList;
import java.util.List;

class Inventory implements IInventory {

   List<Item> inventory;
   int inventorySize;
   
   Inventory( int inventoryLimit ) {
      this.inventory = new ArrayList<Item>();
   }
   
   @Override
   public List<Item> getInventory() {
      return inventory;
   }
   
   @Override
   public boolean setInventory( List<Item> newInventory ) {
      if (newInventory == null) 
         return false;
      this.inventory = newInventory;
      return true;
   }
   
   @Override
   public void addItem( Item item ) {
      inventory.add(item);
   }
   
   @Override
   public Item removeItem( int index ) {
      if (inventory.size() > inventorySize) {
         return null;
      }
      Item returnedItem = inventory.remove(index);
      return returnedItem;
   }
}
