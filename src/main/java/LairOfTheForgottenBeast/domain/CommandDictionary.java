package LairOfTheForgottenBeast.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import LairOfTheForgottenBeast.domain.commands.Go;
import LairOfTheForgottenBeast.domain.commands.Help;
import LairOfTheForgottenBeast.domain.commands.Look;

public class CommandDictionary {
   Map<String, Function<List<String>,String>> commandDictionary;
   CommandExecutor commandExecutor;
   
   public CommandDictionary() {
      commandExecutor = new CommandExecutor();
      commandDictionary = new HashMap<>();
      commandDictionary.put("", (command) -> { return "Enter a command"; });
      commandDictionary.put("help", (command) -> { Help help = new Help();
                                                   return help.call(command); 
                                                  });
      commandDictionary.put("?", (command) -> { Help help = new Help();
                                                return help.call(command); 
                                               });
      commandDictionary.put("go", (command) -> { Go go = new Go(); 
                                                 return go.call(command); 
                                                });
      commandDictionary.put("look", (command) -> { Look look = new Look(); 
                                                   return look.call(command); 
                                                  });
   }
   
   public Map<String, Function<List<String>,String>> getDictionary() {
      return commandDictionary;
   }
   
   public Function<List<String>, String> get(String command) {
      Function<List<String>, String> lambda  = commandDictionary.get(command);
      return lambda;
   }
}
