package LairOfTheForgottenBeast.domain;

import java.util.HashMap;
import java.util.List;

public class CommandInterpreter {
   
   private CommandExecutor commandExecutor;
   
   public CommandInterpreter() {
      this.commandExecutor = new CommandExecutor();
   }
   
   public String processCommand(List<String> cmdArr) {
      if (cmdArr == null) {
         System.out.println("CommandInterpreter.processCommand(...): Received null List<String> cmdArr");
         return "Command received was null";
      }
      System.out.println("CommandInterpreter.processCommand(...): Received command List: ");
      System.out.println(cmdArr);
      if (cmdArr.get(0).equals("go") || (cmdArr.size() > 1 && isDirection(cmdArr.get(1)))) {
         return commandExecutor.go(cmdArr.get(1));
      } else if (isDirection(cmdArr.get(0))) {
         return commandExecutor.go(cmdArr.get(0));
      }
      if (cmdArr.get(0).equals("help") || cmdArr.get(0).equals("?"))
      {
         return commandExecutor.help();
      }  
      return null;
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
   
}
