package LairOfTheForgottenBeast.domain.map;

public class Room {
   
   String description;
   
   public Room() {}
   
   public Room(String desc) {
      this.description = desc;
   }
   
   public String getDescription() {
      return description;
   }
   
   public String setDescription(String desc) {
      return description = desc;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result
         + ((description == null) ? 0 : description.hashCode());
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
      
      Room other = (Room) obj;
      
      if (description == null) {
         if (other.description != null)
            return false;
      } else if (!description.equals(other.description))
         return false;
      
      return true;
   }

   @Override
   public String toString() {
      return "Room [description=" + description + "]";
   }
}

