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
 * @author Nick D'Orazio
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
	/* 
	 * updateAuthor: Brian James and Kyle Oakes
	 */
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
   
   private String defaultString()
   {
      return "You can't go there!";
   }
}
