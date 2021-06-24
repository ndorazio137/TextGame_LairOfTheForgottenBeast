package LairOfTheForgottenBeast.domain;

public class CommandInfo {
   private String commandString;
   
   public CommandInfo(String commandString) {
      super();
      this.commandString = commandString;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((commandString == null) ? 0 : commandString.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      CommandInfo other = (CommandInfo) obj;
      if (commandString == null) {
         if (other.commandString != null)
            return false;
      } else if (!commandString.equals(other.commandString))
         return false;
      return true;
   }

   public String getCommandString() {
      return commandString;
   }

   public void setCommandString(String commandString) {
      this.commandString = commandString;
   }
}
