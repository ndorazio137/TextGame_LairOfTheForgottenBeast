package LairOfTheForgottenBeast.domain;

import LairOfTheForgottenBeast.domain.map.Room;
import LairOfTheForgottenBeast.domain.map.WorldMap;

public class CommandExecutor {
   
   public String go(GameState gameState, String direction) {
      System.out.println("CommandExecutor.go(...): go " + direction);
      
      WorldMap worldMap = gameState.getWorldMap();
      Player player = gameState.getPlayer();
      
      Room currentRoom = player.getCurrentRoom();
      int[] coords = worldMap.getRoomCoords(currentRoom);
      
      if (direction.equals("north")) {
         coords[1]++;
      }
      if (direction.equals("east")) {
         coords[0]++;
      }
      if (direction.equals("south")) {
         coords[1]--;
      }
      if (direction.equals("west")) {
         coords[0]--;
      }
      
      Room potentialRoom = worldMap.getRoom(coords);
      if (potentialRoom == null) {
         return "You can't go there.";
      }
      
      player.setCurrentRoom(potentialRoom);
      return (potentialRoom.getName() + ": " + potentialRoom.getDescription());
   }

   public String look(GameState gameState)
   {
      Player player = gameState.getPlayer();
      System.out.println("CommandExecutor.look(): "+player.getCurrentRoom().getName());
      return (player.getCurrentRoom().getName() + ": " + player.getCurrentRoom().getDescription());
   }
   
   public String help()
   {
      // TODO Auto-generated method stub
      System.out.println("CommandExecutor.help(): help or ? ");
      
      return "Basic commands: help or ? ";
   }
}
