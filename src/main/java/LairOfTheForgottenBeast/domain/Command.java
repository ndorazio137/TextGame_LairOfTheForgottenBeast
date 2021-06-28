package LairOfTheForgottenBeast.domain;

import java.util.List;

public class Command {
   private List<String> commands;
   
   public Command(List<String> command) {
      this.commands = command;
   }
   
   public List<String> getCommand() {
      return commands;
   }
}
