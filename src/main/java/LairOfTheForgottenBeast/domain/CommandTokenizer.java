package LairOfTheForgottenBeast.domain;

/* Non-static Imports */
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Used to tokenize <code>String</code>s into <code>List</code>s of <code>String</code>s.
 * 
 * @author Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 */
public class CommandTokenizer {

  /**
   * Converts a space-delineated string into a <code>List<String></code>. The commandString argument
   * should be a command received from the client. If an empty <code>String</code> is passed, this
   * method will return an empty <code>List</code>. If commandString is <code>null</code>, this
   * method will return null.
   * 
   * @since 1.0.0
   * @param commandString a command, such as "go north" or "look"
   * @return The command tokenized into a List<String>.
   * @see List
   */
  public List<String> tokenize(String commandString) {
    /* If command is empty, then do not process it */
    if (commandString == null) {
      System.out.println("CommandTokenizer.tokenize(...): Received null command.");
      System.out.print("CommandTokenizer.tokenize(...): Returning null.");
      return null;
    }

    /* If command exist, then parse the command and add the words to a list */
    StringTokenizer st = new StringTokenizer(commandString);
    System.out
        .println("CommandTokenizer.tokenize(...): Received command: \"" + commandString + "\"");
    List<String> commandList = new ArrayList<String>();
    while (st.hasMoreTokens()) {
      String token = st.nextToken();
      commandList.add(token);
    }

    /* Return the command to display to the screen */
    System.out.print("CommandTokenizer.tokenize(...): Tokenized array: ");
    System.out.println(commandList);
    return commandList;
  }
}
