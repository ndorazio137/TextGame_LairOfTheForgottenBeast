package LairOfTheForgottenBeast.controller;

/* Non-static Imports */
import java.util.Arrays;

/**
 * 
 * 
 * @author Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 */
public class ResultObject {
   String commandOutput;
   String locationInfo;
   int[] mapDims;
   int[] playerCoords;
   
   public ResultObject() { }
   
   public ResultObject(String commandOutput, String locationInfo, int[] mapDims, int[] playerCoords) {
      super();
      this.commandOutput = commandOutput;
      this.locationInfo = locationInfo;
      this.mapDims = mapDims;
      this.playerCoords = playerCoords;
   }
   
   @Override
   public String toString() {
      return "ResultObject [commandOutput=" + commandOutput + ", locationInfo=" + locationInfo + ", mapDims="
            + Arrays.toString(mapDims) + ", playerCoords=" + Arrays.toString(playerCoords) + "]";
   }
   
   

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((commandOutput == null) ? 0 : commandOutput.hashCode());
      result = prime * result + ((locationInfo == null) ? 0 : locationInfo.hashCode());
      result = prime * result + Arrays.hashCode(mapDims);
      result = prime * result + Arrays.hashCode(playerCoords);
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
      if (!Arrays.equals(mapDims, other.mapDims))
         return false;
      if (!Arrays.equals(playerCoords, other.playerCoords))
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

   public int[] getMapDims() {
      return mapDims;
   }

   public void setMapDims(int[] mapDims) {
      this.mapDims = mapDims;
   }

   public int[] getPlayerCoords() {
      return playerCoords;
   }

   public void setPlayerCoords(int[] playerCoords) {
      this.playerCoords = playerCoords;
   }
   
}
