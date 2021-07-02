package LairOfTheForgottenBeast.domain.commands;

import java.util.List;

import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;

public class Look implements Call<String> {

   @Override
   public <AnyType> String call(Object gameState, List<String> command) {
      System.out.println("Gamestate recieved in Look: " + gameState);
      System.out.println("In Look(): call");
      Player player = ((GameState) gameState).getPlayer();
      System.out.println("Look(" + player.getCurrentRoom().getName() + ") ");
      String roomLongDescription = player.getCurrentRoom().getLongDescription();
      return roomLongDescription;
   }
}