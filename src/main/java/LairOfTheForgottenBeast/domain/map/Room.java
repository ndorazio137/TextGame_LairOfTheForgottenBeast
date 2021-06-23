package LairOfTheForgottenBeast.domain.map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Room {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   @Autowired
   String name;
   @Autowired
   String description;
   
   public Room(int id, String name, String description)
   {
      super();
      this.id = id;
      this.name = name;
      this.description = description;
   }

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

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((description == null) ? 0 : description.hashCode());
      result = prime * result + id;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
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
      if (id != other.id)
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "Room [id=" + id + ", name=" + name + ", description=" + description + "]";
   }

   public String getName() {
      return this.name;
   }
   
   public String setName(String name) {
      return (this.name = name);
   }
}

