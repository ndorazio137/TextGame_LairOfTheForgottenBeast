package LairOfTheForgottenBeast.domain;

import LairOfTheForgottenBeast.domain.map.Room;
import LairOfTheForgottenBeast.domain.map.WorldMap;

public class CommandExecutor {
   
   WorldMap worldMap;
   Player player;
   
   public String go(String direction) {
      // TODO Auto-generated method stub
      System.out.println("CommandExecutor.go(...): go " + direction);
      
      Room currentRoom = player.getCurrentRoom();
      int[] coords = worldMap.getRoomCoords(currentRoom);
      
      Room potentialRoom = worldMap.getRoom(coords);
      if (potentialRoom == null) {
         return "You can't go there.";
      }
      
      player.setCurrentRoom(potentialRoom);
      return (potentialRoom.getName() + ": " + potentialRoom.getDescription());
   }

}
