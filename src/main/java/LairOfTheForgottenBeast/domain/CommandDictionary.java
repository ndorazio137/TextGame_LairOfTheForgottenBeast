package LairOfTheForgottenBeast.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import LairOfTheForgottenBeast.domain.commands.Go;
import LairOfTheForgottenBeast.domain.commands.Help;
import LairOfTheForgottenBeast.domain.commands.Look;

public class CommandDictionary
{
   Map<String, BiFunction<Object, List<String>, String>> commandDictionary;

   public CommandDictionary()
   {
      commandDictionary = new HashMap<>();
      commandDictionary.put("", (gamestate, command) ->
      {
         return "Enter a command";
      });
      commandDictionary.put("help", (gamestate, command) ->
      {
         Help help = new Help();
         return help.call(gamestate, command);
      });
      commandDictionary.put("?", (gamestate, command) ->
      {
         Help help = new Help();
         return help.call(gamestate, command);
      });
      commandDictionary.put("go", (gamestate, command) ->
      {
         Go go = new Go();
         return go.call(gamestate, command);
      });
      commandDictionary.put("look", (gamestate, command) ->
      {
         Look look = new Look();
         return look.call(gamestate, command);
      });
      commandDictionary.put("east", (gamestate, command) ->
      {
         Go go = new Go();
         return go.call(gamestate, command);
      });

      commandDictionary.put("west", (gamestate, command) ->
      {
         Go go = new Go();
         return go.call(gamestate, command);
      });

      commandDictionary.put("south", (gamestate, command) ->
      {
         Go go = new Go();
         return go.call(gamestate, command);
      });

      commandDictionary.put("north", (gamestate, command) ->
      {
         Go go = new Go();
         return go.call(gamestate, command);
      });
      commandDictionary.put("e", (gamestate, command) ->
      {
         Go go = new Go();
         return go.call(gamestate, command);
      });

      commandDictionary.put("w", (gamestate, command) ->
      {
         Go go = new Go();
         return go.call(gamestate, command);
      });

      commandDictionary.put("s", (gamestate, command) ->
      {
         Go go = new Go();
         return go.call(gamestate, command);
      });

      commandDictionary.put("n", (gamestate, command) ->
      {
         Go go = new Go();
         return go.call(gamestate, command);
      });
   }

   public Map<String, BiFunction<Object, List<String>, String>> getDictionary()
   {
      return commandDictionary;
   }

   public BiFunction<Object, List<String>, String> get(String command)
   {
      BiFunction<Object, List<String>, String> lambda = commandDictionary
         .get(command);
      return lambda;
   }
}
