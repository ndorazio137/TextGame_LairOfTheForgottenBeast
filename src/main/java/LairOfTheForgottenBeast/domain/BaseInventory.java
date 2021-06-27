package LairOfTheForgottenBeast.domain;

public interface BaseInventory {
   public Inventory createInventory(int inventoryLimit);
   public boolean addToInventory(Item inventoryObject);
   public Item removeFromInventory(Item item);
   public Inventory getInventory();
}
