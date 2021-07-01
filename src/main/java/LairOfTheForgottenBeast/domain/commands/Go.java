package LairOfTheForgottenBeast.domain.commands;

import java.util.List;

public class Go implements Call<String> {

   @Override
   public <AnyType> String call(List<String> command) {
      
      for(int i=0;i<command.size();i++){
         System.out.println(command.get(i));
      } 
      
      String direction = "";
      
      try {
         direction = command.get(1);
      } catch (IndexOutOfBoundsException e) {
         return defaultString();
      } 
      
      if (direction.equals("north"))
         return goNorth();
      
      if (direction.equals("south"))
         return goSouth();
      
      if (direction.equals("east"))
         return goEast();
      
      if (direction.equals("west"))
         return goWest();
      
      return defaultString();
   }
   
   public String goNorth() {
      return "You went north.";
   }
   
   public String goSouth() {
      return "You went south.";
   }
   
   public String goWest() {
      return "You went west.";
   }
   
   public String goEast() {
      return "You went east.";
   }
   
   public String defaultString() {
      return "You can't go there!";
   }
}

