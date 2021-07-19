package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;

/**
 * Represents any command preceded by the word "help". Implements the ICommand Interface.
 * 
 * @author Nick D'Orazio, Brian James, and Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Help implements ICommand<String> {

  /**
   * Contains the logic for what to do when the command "help" is called.
   * 
   * @return A String, determined by the Help logic, and used to update the UI
   */
  @Override
  public <AnyType> String call(GameState gameState, List<String> command) {

    String str = "";

    try {
      str = command.get(1);
    } catch (IndexOutOfBoundsException e) {
      return defaultString();
    }

    return additionalMenu(str);
  }

  /**
   * A high-level help menu.
   * 
   * @since 1.0.0
   * @return A String of menu options.
   */
  public String defaultString() {
    return "Basic commands: \r\n" + "\"help\" or \"?\" : Usage information\r\n" + "\r\n"
        + "Directional Command List:\r\n"
        + "\"north\" , \"n\", \"go north\" , \"go n\" : walk north into the next room\r\n"
        + "\"east\"  , \"e\", \"go east\"  , \"go e\" : walk east into the next room\r\n"
        + "\"south\" , \"s\", \"go south\" , \"go s\" : walk south into the next room\r\n"
        + "\"west\"  , \"w\", \"go west\"  , \"go w\" : walk west into the next room\r\n" + "\r\n"
        + "Misc Commands List:\r\n"
        + "\"look\"          : get the room information in a description\r\n"
        + "\"examine\"       : Look at a specific object or a specific area within a single room.\r\n"
        + "\"inventory\"     : examine the items that you are holding";
  }

  /**
   * A Logic helper method to determine the additional menu to use.
   * 
   * @param an additional option string to specific the menu to use.
   * @since 1.0.0
   */
  private String additionalMenu(String str) {
    // TODO: Additional help menus. Finish if needed or time allows.
    return "Additional help menus are not implemented at this time.";
  }
}

