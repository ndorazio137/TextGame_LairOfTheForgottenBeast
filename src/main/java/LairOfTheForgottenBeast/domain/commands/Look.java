package LairOfTheForgottenBeast.domain.commands;

import java.util.List;

public class Look implements Call<String> {

   @Override
   public <AnyType> String call(Object gameState, List<String> command) {
      
      System.out.println("Gamestate recieved in Look: " + gameState);
      
      System.out.println("In Look(): call");
      
      return "You looked!";
   }
}
