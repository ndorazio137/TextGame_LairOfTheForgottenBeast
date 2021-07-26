package LairOfTheForgottenBeast.domain.commands;

import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Prop;
import LairOfTheForgottenBeast.factory.CreatureFactory;

public class Answer implements ICommand<String> {

  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {

    // Get gamestate objects
    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    WorldMap worldMap = gameState.getWorldMap();
    RoomDynamic room = player.getCurrentRoom();
    CreatureFactory creatureFactory = new CreatureFactory();
    String correctString = "Jerroth Harulon Komur";
    List<Creature> creatures = room.getCreatures();
    int[] coords = worldMap.getRoomCoords(room);
    // parse the command
    List<String> command = commandInfo.getCommandList();
    String answerString = buildAnswerString(command);

    // Test to see if the player is in the Lair.
    if (!((coords[0] == 7) && (coords[1] == 7) && (coords[2] == 0))) {
      return nothingToAnswerString();
    } // account for no answer, just the word answer and check true or false
    else if (room.getLongDescription(commandInfo.getMultiplayer()).contains("open vault")) {
      return nothingToAnswerString();
    } else if (command.size() <= 1)
      return undefinedAnswerString();
    else if (answerString == null)
      return nothingToAnswerString();
    else if (getRiddleResult(correctString, answerString) == true) {
      // Unleash the Forgotten Beast!
      room.addCreature(creatureFactory.create("Forgotten Beast", room));
      List<Prop> props = room.getProps();
      for (Prop prop : props) {
        if (prop.getName().equalsIgnoreCase("giant vault")) {
          (prop).setName("open vault");
        }
      }
      return "The loud voice from the vault bellows out, \"It is true!\" \r\n"
          + "\"The knight is Jerroth, the knave is Harulon, and the spy is Komur.\"\r\n"
          + "\"You have solved the riddle...now face the beast!\" \r\n"
          + "A loud grinding noise comes from the vault. The vault doors slowly open toward you\r\n"
          + "until you can see what is inside. An enormous creature steps out from the interior.\r\n"
          + "You are face to face with the Forgotten Beast!\r\n";
    } else

      // Summon an additional cultist each time they fail a guess.
      room.addCreature(creatureFactory.create("Beast Cultist", room));
    return "The loud voice from the vault bellows out, \"You have failed to answer the riddle "
        + "correctly. Guards! There is an intruder to the sacred lair!\" A hobgoblin beast cultist"
        + " runs into the room, sees you, and rushes toward you to attack!";
  }

  private boolean getRiddleResult(String correctString, String answerString) {
    if (answerString.equalsIgnoreCase(correctString)) {
      return true;
    } else
      return false;
  }

  private String buildAnswerString(List<String> command) {
    String answerString = "";

    if (command.size() == 1)
      answerString += command.get(0);
    else if (command.size() > 1) {
      for (int i = 1; i < command.size(); i++) {
        if (i > 1) {
          answerString += " ";
        }
        answerString += command.get(i);
      }
    }
    return answerString;
  }

  public String nothingToAnswerString() {
    return "There is nothing to answer at this time.";
  }

  public String undefinedAnswerString() {
    return "answer needs a valid string";
  }
}
