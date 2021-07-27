package LairOfTheForgottenBeast.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import LairOfTheForgottenBeast.domain.commands.Answer;
import LairOfTheForgottenBeast.domain.commands.Attack;
import LairOfTheForgottenBeast.domain.commands.Consume;
import LairOfTheForgottenBeast.domain.commands.Drop;
import LairOfTheForgottenBeast.domain.commands.Equip;
import LairOfTheForgottenBeast.domain.commands.Examine;
import LairOfTheForgottenBeast.domain.commands.Go;
import LairOfTheForgottenBeast.domain.commands.Help;
import LairOfTheForgottenBeast.domain.commands.Inventory;
import LairOfTheForgottenBeast.domain.commands.Invoke;
import LairOfTheForgottenBeast.domain.commands.Look;
import LairOfTheForgottenBeast.domain.commands.Say;
import LairOfTheForgottenBeast.domain.commands.Take;
import LairOfTheForgottenBeast.domain.commands.Talk;
import LairOfTheForgottenBeast.domain.commands.Unequip;

/**
 * A dictionary of all the mapped commands for the game. Used to filter user input.
 * 
 * @author Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 */
public class CommandDictionary {
  /**
   * A map of all the verb commands for the game.
   * 
   * @see List
   * @see BiFunction
   * @see Map
   */
  Map<String, BiFunction<GameState, CommandInfo, String>> commandDictionary;

  /**
   * Building the dictionary and putting all the commands in it
   * 
   * @since 1.0.0
   */
  public CommandDictionary() {
    commandDictionary = new HashMap<>();
    commandDictionary.put("", (gamestate, command) -> {
      return "Enter a command";
    });
    commandDictionary.put("HELP", (gamestate, command) -> {
      Help help = new Help();
      return help.call(gamestate, command);
    });
    commandDictionary.put("?", (gamestate, command) -> {
      Help help = new Help();
      return help.call(gamestate, command);
    });
    commandDictionary.put("GO", (gamestate, command) -> {
      Go go = new Go();
      return go.call(gamestate, command);
    });
    commandDictionary.put("LOOK", (gamestate, command) -> {
      Look look = new Look();
      return look.call(gamestate, command);
    });
    commandDictionary.put("EXAMINE", (gamestate, command) -> {
      Examine examine = new Examine();
      return examine.call(gamestate, command);
    });
    commandDictionary.put("TAKE", (gamestate, command) -> {
      Take take = new Take();
      return take.call(gamestate, command);
    });
    commandDictionary.put("GET", (gamestate, command) -> {
      Take take = new Take();
      return take.call(gamestate, command);
    });
    commandDictionary.put("INVENTORY", (gamestate, command) -> {
      Inventory inventory = new Inventory();
      return inventory.call(gamestate, command);
    });
    commandDictionary.put("DROP", (gamestate, command) -> {
      Drop drop = new Drop();
      return drop.call(gamestate, command);
    });
    commandDictionary.put("CONSUME", (gamestate, command) -> {
      Consume consume = new Consume();
      return consume.call(gamestate, command);
    });
    commandDictionary.put("UNEQUIP", (gamestate, command) -> {
      Unequip unequip = new Unequip();
      return unequip.call(gamestate, command);
    });   
    commandDictionary.put("DRINK", (gamestate, command) -> {
      Consume consume = new Consume();
      return consume.call(gamestate, command);
    });      
    commandDictionary.put("EAST", (gamestate, command) -> {
      Go go = new Go();
      return go.call(gamestate, command);
    });
    commandDictionary.put("WEST", (gamestate, command) -> {
      Go go = new Go();
      return go.call(gamestate, command);
    });
    commandDictionary.put("SOUTH", (gamestate, command) -> {
      Go go = new Go();
      return go.call(gamestate, command);
    });
    commandDictionary.put("NORTH", (gamestate, command) -> {
      Go go = new Go();
      return go.call(gamestate, command);
    });
    commandDictionary.put("E", (gamestate, command) -> {
      Go go = new Go();
      return go.call(gamestate, command);
    });
    commandDictionary.put("W", (gamestate, command) -> {
      Go go = new Go();
      return go.call(gamestate, command);
    });
    commandDictionary.put("S", (gamestate, command) -> {
      Go go = new Go();
      return go.call(gamestate, command);
    });
    commandDictionary.put("N", (gamestate, command) -> {
      Go go = new Go();
      return go.call(gamestate, command);
    });
    commandDictionary.put("ATTACK", (gamestate, command) -> {
      Attack attack = new Attack();
      return attack.call(gamestate, command);
    });
    commandDictionary.put("FIGHT", (gamestate, command) -> {
      Attack attack = new Attack();
      return attack.call(gamestate, command);
    });
    commandDictionary.put("INVOKE", (gamestate, command) -> {
      Invoke invoke = new Invoke();
      return invoke.call(gamestate, command);
    });
    commandDictionary.put("EQUIP", (gamestate, command) -> {
      Equip equip = new Equip();
      return equip.call(gamestate, command);
    });
    commandDictionary.put("TALK", (gamestate, command) -> {
      Talk talk = new Talk();
      return talk.call(gamestate, command);
    });
    commandDictionary.put("ANSWER", (gamestate, command) -> {
      Answer answer = new Answer();
      return answer.call(gamestate, command);
    });
    commandDictionary.put("SAY", (gamestate, command) -> {
      Say say = new Say();
      return say.call(gamestate, command);
    });
  }

  /**
   * Retrieves the dictionary of commands where the keys are verbs.
   * 
   * @since 1.0.0
   * @see List
   * @see BiFunction
   * @see Map
   * 
   * @return The map of all verb commands in the game
   */
  public Map<String, BiFunction<GameState, CommandInfo, String>> getDictionary() {
    return commandDictionary;
  }

  /**
   * Retrieves a value/lambda reference from the dictionary.
   * 
   * @since 1.0.0
   * @see List
   * @see BiFunction
   * @see Map
   * 
   * @param command The key/verb to look up.
   * @return A lambda reference for the command to execute.
   */
  public BiFunction<GameState, CommandInfo, String> get(String command) {
    BiFunction<GameState, CommandInfo, String> lambda = commandDictionary.get(command);
    return lambda;
  }
}
