package LairOfTheForgottenBeast.domain.commands;

import java.util.List;

import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;

public class Go implements Call<String>
{

   @Override
   public <AnyType> String call(Object gameState, List<String> command)
   {

      WorldMap worldMap = ((GameState) gameState).getWorldMap();
      Player player = ((GameState) gameState).getPlayer();

      Room currentRoom = player.getCurrentRoom();
      int[] coords = worldMap.getRoomCoords(currentRoom);

      System.out.println("Gamestate recieved in Go: " + gameState);

      for (int i = 0; i < command.size(); i++)
      {
         System.out.println(command.get(i));
      }

      String direction = "";

      try
      {
         if (command.size() == 2)
         {

            direction = command.get(1);
         } else
         {

            direction = command.get(0);
         }

      } catch (IndexOutOfBoundsException e)
      {
         return defaultString();
      }

      if (direction.equals("north") || direction.equals("n"))
      {
         coords[1]--;

      }

      if (direction.equals("south") || direction.equals("s"))
      {
         coords[1]++;

      }

      if (direction.equals("east") || direction.equals("e"))
      {
         coords[0]++;

      }

      if (direction.equals("west") || direction.equals("w"))
      {
         coords[0]--;

      }

      RoomDynamic potentialRoom = worldMap.getRoom(coords);
      if (potentialRoom == null)
      {
         return "You can't go there.";
      }
      player.setCurrentRoom(potentialRoom);
      return (potentialRoom.getName() + ": " + potentialRoom.getDescription());

   }

   public String defaultString()
   {
      return "You can't go there!";
   }
}
