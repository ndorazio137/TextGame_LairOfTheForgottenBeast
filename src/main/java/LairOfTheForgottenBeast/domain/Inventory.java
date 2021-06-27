package LairOfTheForgottenBeast.domain;

public interface Inventory {
   public boolean addItem(Item inventoryObject);
   public Item removeItem(Item item);
   public int getSize();
   public boolean clear();
}
