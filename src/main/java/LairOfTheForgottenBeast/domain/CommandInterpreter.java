package LairOfTheForgottenBeast.domain;

/* Non-static Imports */
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Determines how to process a command.
 * 
 * @author Kyle Oakes
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
   /* 
    * updateAuthor: Nick D'Orazio
    * updateLog: updated to work with the command dictionary.
    */
   public String processCommand(Object gameState, List<String> cmdArr) {
      
      if (cmdArr == null) {
         System.out.println("CommandInterpreter.processCommand(...): Received null List<String> cmdArr");
         return "Command received was null";
      }
      
      Map<String, BiFunction<Object, List<String>,String>> cmdList = commandDictionary.getDictionary();
      
      String firstCommand = "";
      
      try {
         firstCommand = cmdArr.get(0);
      } catch (IndexOutOfBoundsException e) {
         // Do nothing...CommandDictionary has mapping for empty string.
         // TODO: This is where repeat last command could go.
         System.out.println("Caught Index out of bound exception...Do nothing");
      } 
      
      BiFunction<Object, List<String>,String> lambda = cmdList.get(firstCommand);
      String returnString = lambda.apply(gameState, cmdArr);
      return returnString;
      
//      System.out.println("CommandInterpreter.processCommand(...): Received command List: ");
//      System.out.println(cmdArr);
//      if (cmdArr.get(0).equals("go") && cmdArr.size() > 1 && isDirection(cmdArr.get(1))) {
//         return commandExecutor.go(gameState, standardizeDirection(cmdArr.get(1)));
//      } else if (isDirection(cmdArr.get(0))) {
//         return commandExecutor.go(gameState, standardizeDirection(cmdArr.get(0)));
//      }
//      if (cmdArr.get(0).equals("look"))
//      {
//         return commandExecutor.look(gameState);
//      } 
//      if (cmdArr.get(0).equals("help") || cmdArr.get(0).equals("?"))
//      {
//         return commandExecutor.help();
//      }  
      //return null;
   }

   // There might be a better way to handle this, but I am not sure
   private boolean isDirection(String direction) {
      return ( 
               direction.equals("north")
            || direction.equals("east")
            || direction.equals("south")
            || direction.equals("west")
            || direction.equals("n")
            || direction.equals("s")
            || direction.equals("e")
            || direction.equals("w")
            );
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
