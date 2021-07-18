package LairOfTheForgottenBeast.domain.commands;

/* Non-static Imports */
import java.util.List;

import LairOfTheForgottenBeast.domain.Directions;
/* In-House Imports */
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;

/**
 * Represents any command preceded by the word "go". Implements the ICommand Interface.
 * 
 * @author Nick D'Orazio, Brian James, and Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 * @see ICommand
 */
public class Go implements ICommand<String> {

  /**
   * Contains the logic for what to do when the command "go" is called.
   * 
   * @return A String, determined by the Go logic, and used to update the UI
   */
  @Override
  public <AnyType> String call(GameState gameState, List<String> command) {
    WorldMap worldMap = gameState.getWorldMap();
    Player player = gameState.getPlayer();
    Room currentRoom = player.getCurrentRoom();
    int[] coords = worldMap.getRoomCoords(currentRoom);

    printCommandList(command);
    String directionString = buildDirectionString(command);
    Directions direction = extractDirection(directionString);

    if (direction == Directions.UNKNOWN) {
      return defaultString();
    }

    if (direction == Directions.NORTH) {
      coords[1]--;
    }

    if (direction == Directions.SOUTH) {
      coords[1]++;
    }

    if (direction == Directions.EAST) {
      coords[0]++;
    }

    if (direction == Directions.WEST) {
      coords[0]--;
    }

    RoomDynamic potentialRoom = worldMap.getRoom(coords);
    if (potentialRoom == null) {
      return defaultString();
    }
    if (potentialRoom.getName().equalsIgnoreCase("Wall")) {
      return defaultString();
    }
    player.setCurrentRoom(potentialRoom);
    return (potentialRoom.getName() + ": " + potentialRoom.getDescription());

  }

  private String defaultString() {
    return "You can't go there!";
  }

  private Directions extractDirection(String directionString) {
    Directions direction = Directions.UNKNOWN;

    direction = Directions.contains(directionString);
    if (!(direction.equals(Directions.UNKNOWN))) {
      System.out.println("Direction chosen: " + direction);
      return direction;
    }

    return direction;
  }

  private String buildDirectionString(List<String> command) {
    String directionString = "";

    if (command.size() == 1)
      directionString += command.get(0);
    else if (command.size() > 1) {
      for (int i = 1; i < command.size(); i++) {
        if (i > 1) {
          directionString += " ";
        }
        directionString += command.get(i);
      }
    }

    return directionString;
  }

  private void printCommandList(List<String> command) {
    for (int i = 0; i < command.size(); i++) {
      System.out.println(command.get(i));
    }
  }
}