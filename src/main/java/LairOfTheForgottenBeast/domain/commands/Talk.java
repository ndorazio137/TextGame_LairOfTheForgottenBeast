package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Prop;

/**
 * Represents any command preceded by the word "talk". Implements the ICommand Interface.
 * 
 * @author Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */

public class Talk implements ICommand<String> {
  /**
   * Contains the logic for what to do when the command "talk" is called.
   * 
   * @return A String, determined by the Talk logic, and used to update the UI
   */
  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {

    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    List<String> command = commandInfo.getCommandList();
    RoomDynamic currentRoom = player.getCurrentRoom();
    boolean multiplayer = commandInfo.getMultiplayer();

    System.out.println("Current Room to Talk: " + currentRoom.getLongDescription(multiplayer));

    printCommand(command);

    String targetName = buildTargetString(command);
    Object target = currentRoom.findTarget(targetName);

    if (target == null)
      return defaultString();

    if (target instanceof Prop) {
      return ((Prop) target).getSpeechText();
    }

    if (target instanceof Creature) {
      return ((Creature) target).getSpeechText();
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
    return "They do not respond.";
  }
}
