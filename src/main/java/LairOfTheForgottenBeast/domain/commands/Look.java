package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.prop.Prop;

/**
 * Represents any command preceded by the word "look". Implements the ICommand Interface.
 * 
 * @author Nick D'Orazio, Brian James, and Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Look implements ICommand<String> {

  /**
   * Contains the logic for what to do when the command "look" is called.
   * 
   * @return A String, determined by the Look logic, and used to update the UI
   */
  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {

    System.out.println("Gamestate recieved in Look: " + gameState);
    System.out.println("In Look(): call");

    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    boolean multiplayer = commandInfo.getMultiplayer();

    System.out.println("Look(" + player.getCurrentRoom().getName() + ") ");
    String roomLongDescription = player.getCurrentRoom().getLongDescription(multiplayer);

    // Debugging messages
    List<Creature> creaturesList = player.getCurrentRoom().getCreatures();
    for (Creature creature : creaturesList) {
      System.out.println("Creature Name: " + creature.getName());
      System.out.println("Creature Weapon: " + creature.getWeapon());
    }

    // Debugging messages
    List<Prop> propsList = player.getCurrentRoom().getProps();
    for (Prop prop : propsList) {
      System.out.println("Prop Name: " + prop.getName());
    }

    return player.getCurrentRoom().getName() + ": " + roomLongDescription + "\n"
        + gameState.getWorldMap().getPassableDirectionMessage(player.getCurrentRoom());
  }
}
