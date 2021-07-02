package LairOfTheForgottenBeast.domain.map.rooms;

import java.util.ArrayList;
import java.util.List;

import LairOfTheForgottenBeast.domain.prop.Prop;

/** Expands on Room with fields that are added when building the map
 * and filling rooms with objects, and interacting with rooms.
*/
public class RoomDynamic extends Room {
   
   List<Prop> props;
   
   // wrapper for superclass constructor
   public RoomDynamic(int id, String name, String description) {
      super(id, name, description);
      this.props = new ArrayList<Prop>();
   }
   
   public String getLongDescription() {
      String baseDescription = super.getDescription();
      String propsDescription = "";
//      String propsDescription = this.getProps().toString();
      List<Prop> props = this.getProps();
      for (int i = 0; i < props.size(); i++) {
         propsDescription += props.get(i).getName();
         if (i == props.size()-2) {
            propsDescription += ", and ";
         } else if (i != props.size()-1) {
            propsDescription += ", ";
         }
      }
      String longDescription = 
            baseDescription + 
            " The following objects are in this room: " +
            propsDescription + 
            ".";
      return longDescription;
   }
   
   
   public List<Prop> getProps() {
      return props;
   }

   public void setProps(List<Prop> props) {
      this.props = props;
   }
   
   // Maybe we should update this to return the prop added
   // instead of a boolean?
   public boolean addProp(Prop prop) {
      return this.props.add(prop);
   }
   
   // Maybe we should update this to return the prop removed
   // instead of a boolean?
   public boolean removeProp(Prop prop) {
      return this.props.add(prop);
   }
   
   @Override
   public boolean equals(Object obj) {
      
      if (!super.equals(obj))
         return false;
      
      if (this == obj)
         return true;
      if (!super.equals(obj))
         return false;
      if (getClass() != obj.getClass())
         return false;
      RoomDynamic other = (RoomDynamic) obj;
      if (props == null) {
         if (other.props != null)
            return false;
      } else if (!props.equals(other.props))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "RoomObject [id=" + id + ", name=" + name + ", description=" + description + ", props=" + props + " ]";
   }
   
}
