package LairOfTheForgottenBeast.domain;

/* Non-static Imports */
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import LairOfTheForgottenBeast.domain.commands.Examine;
/* In-House Imports */
import LairOfTheForgottenBeast.domain.commands.Go;
import LairOfTheForgottenBeast.domain.commands.Help;
import LairOfTheForgottenBeast.domain.commands.Look;

/**
 * A dictionary of all the mapped commands for the game. Used to filter user
 * input.
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
	Map<String, BiFunction<Object, List<String>, String>> commandDictionary;
	
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
		commandDictionary.put("help", (gamestate, command) -> {
			Help help = new Help();
			return help.call(gamestate, command);
		});
		commandDictionary.put("?", (gamestate, command) -> {
			Help help = new Help();
			return help.call(gamestate, command);
		});
		commandDictionary.put("go", (gamestate, command) -> {
			Go go = new Go();
			return go.call(gamestate, command);
		});
		commandDictionary.put("look", (gamestate, command) -> {
			Look look = new Look();
			return look.call(gamestate, command);
		});
        commandDictionary.put("examine", (gamestate, command) -> {
            Examine examine = new Examine();
            return examine.call(gamestate, command);
        });
		commandDictionary.put("east", (gamestate, command) -> {
			Go go = new Go();
			return go.call(gamestate, command);
		});

		commandDictionary.put("west", (gamestate, command) -> {
			Go go = new Go();
			return go.call(gamestate, command);
		});

		commandDictionary.put("south", (gamestate, command) -> {
			Go go = new Go();
			return go.call(gamestate, command);
		});

		commandDictionary.put("north", (gamestate, command) -> {
			Go go = new Go();
			return go.call(gamestate, command);
		});
		commandDictionary.put("e", (gamestate, command) -> {
			Go go = new Go();
			return go.call(gamestate, command);
		});

		commandDictionary.put("w", (gamestate, command) -> {
			Go go = new Go();
			return go.call(gamestate, command);
		});

		commandDictionary.put("s", (gamestate, command) -> {
			Go go = new Go();
			return go.call(gamestate, command);
		});

		commandDictionary.put("n", (gamestate, command) -> {
			Go go = new Go();
			return go.call(gamestate, command);
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
	public Map<String, BiFunction<Object, List<String>, String>> getDictionary() {
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
	public BiFunction<Object, List<String>, String> get(String command) {
		BiFunction<Object, List<String>, String> lambda = commandDictionary.get(command);
		return lambda;
	}
}
