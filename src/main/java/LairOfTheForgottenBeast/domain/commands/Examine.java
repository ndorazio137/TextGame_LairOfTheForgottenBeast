package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Prop;

/**
 * Represents any command preceded by the word "examine". Implements the ICommand Interface.
 * 
 * @author Brian James and Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Examine implements ICommand<String> {

  /**
   * Contains the logic for what to do when the command "examine" is called.
   * 
   * @return A String, determined by the Examine logic, and used to update the UI
   */
  @Override
  public <AnyType> String call(GameState gameState, List<String> command) {

    Player player = gameState.getPlayer();
    RoomDynamic currentRoom = player.getCurrentRoom();

    System.out.println("Current Room to Examine: " + currentRoom.getLongDescription());

    printCommand(command);

    String targetName = buildTargetString(command);
    Object target = currentRoom.findTarget(targetName);
    
    if (target == null)
      return defaultString();
    
    if (target instanceof Prop) {
      return ((Prop) target).getLongDescription();
    }
    
    if (target instanceof Creature) {
      return ((Creature) target).getLongDescription();
    }
    
    return defaultString();
  }

  private String buildTargetString(List<String> command) {
    String targetName = "";
    
    int commandSize = command.size();
    if (commandSize <= 1) 
      return defaultString();
    
    for (int i = 1; i < command.size(); i++) {
      if (i > 1) {
        targetName += " ";
      }
      targetName += command.get(i);
    }
    
    return targetName.toUpperCase();
  }
  
  private void printCommand(List<String> command) {
    System.out.println(command.toString());
  }
    
  private String defaultString() {
    return "You can't examine that.";
  }
}
