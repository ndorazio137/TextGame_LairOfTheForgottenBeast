package LairOfTheForgottenBeast.domain;

import java.util.List;

public interface IInventory {
   public List<Item> getInventory();
   public boolean setInventory(List<Item> newInventory);
   public void addItem(Item item);
   public Item removeItem(int index);
}
