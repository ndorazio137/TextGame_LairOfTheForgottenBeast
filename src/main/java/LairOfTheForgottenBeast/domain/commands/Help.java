package LairOfTheForgottenBeast.domain.commands;

import java.util.List;

public class Help implements Call<String> {

   @Override
   public <AnyType> String call(Object gameState, List<String> command) {
      System.out.println("Gamestate recieved in Help: " + gameState);
      
      System.out.println("CommandExecutor.help(): help or ? ");
      
      String str = "";
      
      try {
         str = command.get(1);
      } catch (IndexOutOfBoundsException e) {
         return defaultString();
      } 
      
      return additionalMenu(str);
   }
   
   public String defaultString() {
      return "Basic commands: \r\n"
         + "\"help\" or \"?\" : Usage information\r\n"
         + "\r\n"
         + "Directional Command List:\r\n"
         + "\"north\" , \"n\", \"go north\" , \"go n\" : walk north into the next room\r\n"
         + "\"east\"  , \"e\", \"go east\"  , \"go e\" : walk east into the next room\r\n"
         + "\"south\" , \"s\", \"go south\" , \"go s\" : walk south into the next room\r\n"
         + "\"west\"  , \"w\", \"go west\"  , \"go w\" : walk west into the next room\r\n"
         + "\r\n"
         + "Misc Commands List:\r\n"
         + "\"look\"          : get the room information in a description\r\n"
         + "\"examine\"       : Look at a specific object or a specific area within a single room.\r\n"
         + "\"inventory\"     : examine the items that you are holding";
   }
   
   public String additionalMenu(String str) {
      //TODO: Additional help menus. Finish if needed or time allows.
      return "This is how additional help menus are handled!";
   }
}

