package LairOfTheForgottenBeast.domain.commands;

import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Prop;

/**
 * Represents any command preceded by the word "say". Implements the ICommand Interface.
 * 
 * @author Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */

public class Say implements ICommand<String> {
  /**
   * Contains the logic for what to do when the command "say" is called.
   * 
   * @return A String, determined by the Say logic, and used to update the UI
   */
  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {

    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    List<String> command = commandInfo.getCommandList();
    RoomDynamic currentRoom = player.getCurrentRoom();

    printCommand(command);

    String speechText = buildSpeechText(command);

    // return player.getName() + " says, \"" + speechText + "\"";
    return "";
  }

  private String buildSpeechText(List<String> command) {
    String speechText = "";
    for (int i = 1; i < command.size(); i++) {
      speechText += command.get(i);
      if (i < command.size() - 1) {
        speechText += " ";
      }
    }
    return speechText;
  }

  private void printCommand(List<String> command) {
    System.out.println(command.toString());
  }

  private String defaultString() {
    return "They do not respond.";
  }
}
