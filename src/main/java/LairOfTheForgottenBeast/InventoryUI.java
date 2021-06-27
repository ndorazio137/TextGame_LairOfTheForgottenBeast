package LairOfTheForgottenBeast;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.Inventory;
import LairOfTheForgottenBeast.domain.Item;

public class InventoryUI {

   private Inventory inventory;
   
   public void setInventory(Inventory inventory) {
      this.inventory = inventory;
   }
   
   public void showInventory(Inventory inventory) {
      for (Item item: inventory.getItemList()) {
         System.out.println(item);
      }
   }
}
