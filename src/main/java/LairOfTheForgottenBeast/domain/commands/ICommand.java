package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;

/**
 * An interface for unify the way commands are called from the dictionary.
 * @author Nick D'Orazio
 * @since 1.0.0
 *
 * @param <Return> A generic datatype the interface should return. 
 */
public interface ICommand<Return> {
	/**
	 * An abstract method to call the command classes.
	 * @since 1.0.0
	 * 
	 * @param <AnyType> A generic parameter for what the functional interface can receive.
	 * @param gameState The current state of the players game.
	 * @param command The user input command
	 * @return A String created from the command called.
	 */
	/* <AnyType> is the parameter datatype, String is the returned datatype */
    public <AnyType> String call(Object gameState, List<String> command);
}
