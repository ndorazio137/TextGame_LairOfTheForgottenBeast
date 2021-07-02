package LairOfTheForgottenBeast.domain;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class CommandInterpreter {
   CommandDictionary commandDictionary;
   
   public CommandInterpreter() {
      this.commandDictionary = new CommandDictionary();
   }
   
   // This is not a very good implementation. Ideally, we should map verbs to method calls.
   public String processCommand(Object gameState, List<String> cmdArr) {
      
      if (cmdArr == null) {
         System.out.println("CommandInterpreter.processCommand(...): Received null List<String> cmdArr");
         return "Command received was null";
      }
      
      Map<String, BiFunction<Object, List<String>,String>> cmdList = commandDictionary.getDictionary();
//      for (Entry<String, Function<List<String>,String>> entry : cmdList.entrySet())
//         System.out.println("Key = " + entry.getKey() +
//                          ", Value = " + entry.getValue());
      
      String firstCommand = "";
      
      try {
         firstCommand = cmdArr.get(0);
      } catch (IndexOutOfBoundsException e) {
         // Do nothing...CommandDictionary has mapping for empty string.
         // TODO: This is where repeat last command goes.
         System.out.println("Caught Index out of bound exception...Do nothing");
      } 
      
      BiFunction<Object, List<String>,String> lambda = cmdList.get(firstCommand);
      // java.lang.NullPointerException: Cannot invoke "java.util.function.BiFunction.apply(Object, Object)" because "lambda" is null
      // at LairOfTheForgottenBeast.domain.CommandInterpreter.processCommand(CommandInterpreter.java:39) ~[classes/:na]
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
