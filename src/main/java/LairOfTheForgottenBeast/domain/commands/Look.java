package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;

/**
 * Represents any command preceded by the word "look". 
 * Implements the ICommand Interface.
 * 
 * @author Nick D'Orazio, Brian James, and Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Look implements ICommand<String> {

   /**
	* Contains the logic for what to do when the command "look" is called.
	* 
	* @return A String, determined by the Look logic, and used to update the UI
	*/
   @Override
   public <AnyType> String call(GameState gameState, List<String> command) {
      System.out.println("Gamestate recieved in Look: " + gameState);
      System.out.println("In Look(): call");
      Player player = gameState.getPlayer();
      System.out.println("Look(" + player.getCurrentRoom().getName() + ") ");
      String roomLongDescription = player.getCurrentRoom().getLongDescription();
      return roomLongDescription;
   }
}