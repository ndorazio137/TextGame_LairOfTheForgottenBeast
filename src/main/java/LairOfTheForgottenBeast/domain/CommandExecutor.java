package LairOfTheForgottenBeast.domain;

import LairOfTheForgottenBeast.domain.map.Room;
import LairOfTheForgottenBeast.domain.map.WorldMap;

public class CommandExecutor {
   
   WorldMap worldMap;
   Player player;
   
   public String go(String direction) {
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

   public String help()
   {
      // TODO Auto-generated method stub
      System.out.println("CommandExecutor.help(): help or ? ");
      
      return "Basic commands: \r\n"
         + "\"help\" or \"?\" : Usage information\r\n"
         + "\r\n"
         + "Directional Command List:\r\n"
         + "\"north\" , \"n\", \"go north\" , \"go n\" : walk north into the next room\r\n"
         + "\"east\"  , \"e\", \"go east\"  , \"go e\" : walk east into the next room\r\n"
         + "\"south\" , \"s\", \"go south\" , \"go s\" : walk south into the next room\r\n"
         + "\"west\"  , \"w\", \"go west\"  , \"go w\" : walk west into the next room\r\n"
         + "\r\n"
         + "Misc Commands List:\r\n"
         + "\"look\"          : get the room information in a description\r\n"
         + "\"examine\"       : Look at a specific object or a specific area within a single room.\r\n"
         + "\"inventory\"     : examine the items that you are holding";
   }
}
