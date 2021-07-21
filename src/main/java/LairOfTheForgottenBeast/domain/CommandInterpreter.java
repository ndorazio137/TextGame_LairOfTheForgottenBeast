package LairOfTheForgottenBeast.domain;

/* Non-static Imports */
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import LairOfTheForgottenBeast.service.SpellService;

/**
 * Determines how to process a command.
 * 
 * @author Kyle Oakes and Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 */
public class CommandInterpreter {
  /**
   * A dictionary of commands that can be called.
   * 
   * @since 1.0.0
   * @see CommandDictionary
   */
  CommandDictionary commandDictionary;
  /**
   * The previous command ran
   */
  List<String> lastCommandUsed;

  /**
   * Constructor for the Command Interpreter.
   * 
   * @since 1.0.0
   */
  public CommandInterpreter(CommandDictionary commandDictionary) {
    this.commandDictionary = commandDictionary;
  }

  /**
   * Checks if the user command is in the dictionary, then runs the command.
   * 
   * @see CommandDictionary
   * @see ICommand
   * @see BiFunction
   * @see List
   * 
   * @param gameState A wrapper object for the current instance of the game.
   * @param cmdArr A parsed list of the words entered by the user.
   * @return a String to update the UI with new information for the player.
   */
  public String processCommand(String username, GameState gameState, List<String> cmdArr, String multiplayer) {
    if (cmdArr == null) {
      System.out.println(
          "CommandInterpreter.processCommand(...): " + "Received null List<String> cmdArr");
      return "Command received was null";
    }

    Map<String, BiFunction<GameState, CommandInfo, String>> cmdList =
        commandDictionary.getDictionary();

    String firstCommand = "";
    // System.out.printf("firstCommand before try/catch block: ", firstCommand);
    try {
      firstCommand = cmdArr.get(0);
      lastCommandUsed = cmdArr;
    } catch (IndexOutOfBoundsException e) {
      // Do nothing...CommandDictionary has mapping for empty string.
      // TODO: This is where repeat last command could go.

      if (lastCommandUsed == null) {
        firstCommand = "help";
      } else {
        cmdArr = defaultCommand();
        firstCommand = cmdArr.get(0);
      }

      System.out.println(lastCommandUsed);
    }
    
    CommandInfo commandInfo = new CommandInfo(username, cmdArr, multiplayer);
    
    BiFunction<GameState, CommandInfo, String> lambda = cmdList.get(firstCommand);
    if (lambda == null)
      return "Unknown command. Type 'help' or '?' to get a list of commands";
    String returnString = lambda.apply(gameState, commandInfo);
    return returnString;

  }

  private List<String> defaultCommand() {
    return lastCommandUsed;
  }

  // There might be a better way to handle this, but I am not sure
  private boolean isDirection(String direction) {
    return (direction.equals("north") || direction.equals("east") || direction.equals("south")
        || direction.equals("west") || direction.equals("n") || direction.equals("s")
        || direction.equals("e") || direction.equals("w"));
  }

  private String standardizeDirection(String direction) {
    if (direction == "n") {
      direction = "north";
    }
    if (direction == "e") {
      direction = "east";
    }
    if (direction == "s") {
      direction = "south";
    }
    if (direction == "w") {
      direction = "west";
    }
    return direction;
  }

  

}
