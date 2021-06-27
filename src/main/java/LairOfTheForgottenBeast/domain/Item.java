package LairOfTheForgottenBeast.domain;

// Needed to compile inventory for now.
public class Item {
   
   int i;
   public Item() {
      i = 5;
   }
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + i;
      return result;
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Item other = (Item) obj;
      if (i != other.i)
         return false;
      return true;
   }
   
   
}
