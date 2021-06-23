package LairOfTheForgottenBeast.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/** Used to tokenize <code>String</code>s into <code>List</code>s of <code>String</code>s.
 * @author Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
*/
public class CommandTokenizer {
   
   /**
   * Converts a space-delineated string into a <code>List<String></code>.
   * The commandString argument should be a command received from the client.
   * If an empty <code>String</code> is passed, this method will return an empty <code>List</code>.
   * If commandString is <code>null</code>, this method will return null.
   * @param  commandString  a command, such as "go north" or "look"
   * @return      The command tokenized into a List<String>.
   * @see         List
   */
   public List<String> tokenize(String commandString) {
      if (commandString == null) { 
         System.out.println("CommandTokenizer.tokenize(...): Received null command.");
         System.out.print("CommandTokenizer.tokenize(...): Returning null.");
         return null; 
      }
      
      StringTokenizer st = new StringTokenizer(commandString);
      System.out.println("CommandTokenizer.tokenize(...): Received command: \"" + commandString + "\"");
      List<String> commandArray = new ArrayList<String>();
      while (st.hasMoreTokens()) {
         String token = st.nextToken();
         commandArray.add(token);
      }
      System.out.print("CommandTokenizer.tokenize(...): Tokenized array: ");
      System.out.println(commandArray);
      return commandArray;
   }
}
