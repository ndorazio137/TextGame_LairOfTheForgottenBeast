package LairOfTheForgottenBeast.domain;

/* Non-static Imports */
import java.util.List;

/**
 * A Wrapper to hold the user entered command.
 * 
 * @author Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 */
public class Command {
   private List<String> commands;
   
   /**
    * Constructor for Command Wrapper.
    * @since 1.0.0
    * @see List
    * 
    * @param command The users command input as a <code>List<code><<code>String<code>>
    */
   public Command(List<String> command) {
      this.commands = command;
   }
   
   /**
    * Retrieves the command.
    * @see List
    * @return a <code>List<code><<code>String<code>> of the words in the command
    */
   public List<String> getCommand() {
      return commands;
   }
}
