package LairOfTheForgottenBeast.controller;

public class ResultObject {
   String commandOutput;
   String locationInfo;
   
   
   public ResultObject() { }
   
   public ResultObject(String commandOutput, String locationInfo) {
      super();
      this.commandOutput = commandOutput;
      this.locationInfo = locationInfo;
   }
   @Override
   public String toString() {
      return "ResultObject [commandOutput=" + commandOutput + ", locationInfo=" + locationInfo + "]";
   }
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((commandOutput == null) ? 0 : commandOutput.hashCode());
      result = prime * result + ((locationInfo == null) ? 0 : locationInfo.hashCode());
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
      ResultObject other = (ResultObject) obj;
      if (commandOutput == null) {
         if (other.commandOutput != null)
            return false;
      } else if (!commandOutput.equals(other.commandOutput))
         return false;
      if (locationInfo == null) {
         if (other.locationInfo != null)
            return false;
      } else if (!locationInfo.equals(other.locationInfo))
         return false;
      return true;
   }
   public String getCommandOutput() {
      return commandOutput;
   }
   public void setCommandOutput(String commandOutput) {
      this.commandOutput = commandOutput;
   }
   public String getLocationInfo() {
      return locationInfo;
   }
   public void setLocationInfo(String locationInfo) {
      this.locationInfo = locationInfo;
   }
   
   
}
