package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;

/**
 * Represents any command preceded by the word "go". 
 * Implements the ICommand Interface.
 * 
 * @author Nick D'Orazio, Brian James, and Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Go implements ICommand<String>
{
   
   /**
    * Contains the logic for what to do when the command "go" is called.
    * 
    * @return A String, determined by the Go logic, and used to update the UI
    */
   @Override
   public <AnyType> String call(GameState gameState, List<String> command)
   {

      WorldMap worldMap = gameState.getWorldMap();
      Player player = gameState.getPlayer();

      Room currentRoom = player.getCurrentRoom();
      int[] coords = worldMap.getRoomCoords(currentRoom);

      for (int i = 0; i < command.size(); i++)
      {
         System.out.println(command.get(i));
      }

      String direction = "";

      try
      {
         if (command.size() == 2)
         {

            direction = command.get(1).toUpperCase();
         } else
         {

            direction = command.get(0).toUpperCase();
         }

      } catch (IndexOutOfBoundsException e)
      {
         return defaultString();
      }
      
      if (direction.equals("NORTH") || direction.equals("N"))
      {
         coords[1]--;

      }

      if (direction.equals("SOUTH") || direction.equals("S"))
      {
         coords[1]++;

      }

      if (direction.equals("EAST") || direction.equals("E"))
      {
         coords[0]++;

      }

      if (direction.equals("WEST") || direction.equals("W"))
      {
         coords[0]--;

      }

      RoomDynamic potentialRoom = worldMap.getRoom(coords);
      if (potentialRoom == null)
      {
         return defaultString();
      }
      player.setCurrentRoom(potentialRoom);
      return (potentialRoom.getName() + ": " + potentialRoom.getDescription());

   }
   
   private String defaultString()
   {
      return "You can't go there!";
   }
}
