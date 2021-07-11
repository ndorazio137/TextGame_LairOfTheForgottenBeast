package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Prop;

/**
 * Represents any command preceded by the word "examine". 
 * Implements the ICommand Interface.
 * 
 * @author Brian James and Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Examine implements ICommand<String>
{
   
   /**
    * Contains the logic for what to do when the command "examine" is called.
    * 
    * @return A String, determined by the Examine logic, and used to update the UI
    */
   @Override
   public <AnyType> String call(GameState gameState, List<String> command)
   {

      WorldMap worldMap = gameState.getWorldMap();
      Player player = gameState.getPlayer();

      Room currentRoom = player.getCurrentRoom();
      int[] coords = worldMap.getRoomCoords(currentRoom);
      RoomDynamic examineRoom = worldMap.getRoom(coords);

      System.out.println("Gamestate recieved in Examine: " + gameState);
      System.out.println("Current Room to Examine: " + examineRoom.getLongDescription());

      for (int i = 0; i < command.size(); i++)
      {
         System.out.println(command.get(i));
      }
      
      // Need a list of props in the room to examine for long description
      String longDescription = "";
      String propName = "";     
      try
      {
         if (command.size() == 2)
         {
            propName = command.get(1);
            List<Prop> propList = examineRoom.getProps();  
            for(Prop prop : propList) {
               if(prop.getName() != null && prop.getName().contains(propName))
               {
                  return prop.getLongDescription();
               }
            }            
                        
         } 
         else if (command.size() == 3)
         {
            // The prop name has two words
            String propName1 = command.get(1);
            String propName2 = command.get(2);
            String propNameConcat = propName1 + " " + propName2;
            System.out.println("Concat: " + propNameConcat);
            
            List<Prop> propList = examineRoom.getProps();  
            for(Prop prop : propList) {
               if(prop.getName() != null && prop.getName().contains(propNameConcat))
               {
                  return prop.getLongDescription();
               }
            }            
                        
         } 
         else
         {
            propName = command.get(0);
            return defaultString();
         }

      } catch (IndexOutOfBoundsException e)
      {
         return defaultString();
      }
      return longDescription;
   }
   
   private String defaultString()
   {
      return "You can't examine that.";
   }
}
