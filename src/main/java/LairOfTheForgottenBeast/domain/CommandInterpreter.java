package LairOfTheForgottenBeast.domain;

/* Non-static Imports */
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

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
   public String processCommand(GameState gameState, List<String> cmdArr) {
      
      if (cmdArr == null) {
         System.out.println("CommandInterpreter.processCommand(...): "
         		+ "Received null List<String> cmdArr");
         return "Command received was null";
      }
      
      Map<String, BiFunction<GameState, List<String>, String>> cmdList = commandDictionary.getDictionary();

      // print statements for debugging null pointer error for lambda
      System.out.printf("cmdList before try/catch block: ", cmdList.values().toString());
      System.out.println();
      System.out.println("gameState before try/catch block: " + gameState);
      System.out.println();
      System.out.printf("cmdArr before try/catch block: " + cmdArr);
      System.out.println();
      
      String firstCommand = "";
      // System.out.printf("firstCommand before try/catch block: ", firstCommand);
      try {
         firstCommand = cmdArr.get(0);
         System.out.printf("firstCommand inside try/catch block: ", firstCommand);
         lastCommandUsed = cmdArr;
      } catch (IndexOutOfBoundsException e) {
         // Do nothing...CommandDictionary has mapping for empty string.
         // TODO: This is where repeat last command could go.
    		 
    	 if (lastCommandUsed == null){
    		 firstCommand = "help";
    	 } else {
    		 cmdArr = defaultCommand();
    		 firstCommand = cmdArr.get(0);
    	 }
    		 
    	 System.out.println(lastCommandUsed);
      } 
      
      // print statements for debugging null pointer error for lambda
      System.out.printf("firstCommand *after* try/catch block: ", firstCommand);
      System.out.println();
      System.out.printf("gameState *after* try/catch block: " +gameState);
      System.out.println();
      System.out.printf("cmdArr *after* try/catch block: " + cmdArr);
      System.out.println();
	  
      BiFunction<GameState, List<String>, String> lambda = cmdList.get(firstCommand);
	  String returnString = lambda.apply(gameState, cmdArr); 
      return returnString;

   }
   
   private List<String> defaultCommand() {
	   return lastCommandUsed;
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
