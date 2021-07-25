package LairOfTheForgottenBeast.domain.commands;

import java.util.List;
import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Prop;

public class Attack implements ICommand<String> {

  @Override
  public <AnyType> String call(GameState gameState, CommandInfo commandInfo) {
    // debug
    List<String> command = commandInfo.getCommandList();
    printCommandList(command);

    // Get gamestate objects
    Player player = gameState.getPlayerMap().get(commandInfo.getUsername());
    RoomDynamic room = player.getCurrentRoom();
    List<Creature> creatures = room.getCreatures();

    // Handle attacking Props...
    List<Prop> props = room.getProps();
    String targetName = buildTargetString(command);
    Object target = room.findTarget(targetName);

    if (target == null)
      return UndefinedTargetString();

    if (target instanceof Prop) {
      return ((Prop) target).onAttacked();
    }

    // parse the command
    String attackString = buildAttackString(command);

    // account for no creatures, just the word attack, or an attack on a specific creature
    Creature creature;
    if (command.size() <= 1)
      return UndefinedTargetString();
    else if (creatures.size() <= 0)
      return nothingToAttackString();
    else {
      creature = findCreature(creatures, attackString);
      if (creature == null)
        return UndefinedTargetString();
      System.out.println(creature.toString());
    }

    // attack the creature reducing hitpoints
    String attackedString = attackCreature(creature, player);
    System.out.println("Attack.call(): Attack String: " + attackedString);
    // build return string
    String outputString = "";
    if (!attackedString.equals(""))
      outputString += attackedString + " ";
    if (creature.getCurrentHitPoints() <= 0) {
      room.removeCreature(creature);
      outputString += creature.toString() + " is dead";
      System.out.println("Attack.call(): Returning: " + outputString);
      return outputString;
    } else {
      outputString += creature.toString() + " has " + creature.getCurrentHitPoints() + " life left";
      System.out.println("Attack.call(): Returning: " + outputString);
      return outputString;
    }
  }

  private String attackCreature(Creature creature, Player player) {
    int playerAttack = player.getCombinedAttackDamage();
    String attackedString = creature.onAttacked(player);
    creature.reduceHitPointsBy(playerAttack);
    return attackedString;
  }

  private String buildAttackString(List<String> command) {
    String attackString = "";

    if (command.size() == 1)
      attackString += command.get(0);
    else if (command.size() > 1) {
      for (int i = 1; i < command.size(); i++) {
        if (i > 1) {
          attackString += " ";
        }
        attackString += command.get(i);
      }
    }

    return attackString;
  }

  private void printCommandList(List<String> sentence) {
    for (String word : sentence) {
      System.out.println(word);
    }
  }

  private void printCreatureList(List<Creature> command) {
    for (Creature creature : command) {
      System.out.println(creature);
    }
  }

  private Creature findCreature(List<Creature> creatures, String attackedCreature) {
    for (Creature creature : creatures) {
      if (creature.toString().equalsIgnoreCase(attackedCreature)) {
        return creature;
      }
    }

    return null;
  }

  public String nothingToAttackString() {
    return "There is nothing to attack";
  }

  public String UndefinedTargetString() {
    return "Attack needs a valid target";
  }

  private String buildTargetString(List<String> command) {
    String targetName = "";

    int commandSize = command.size();
    if (commandSize <= 1)
      return UndefinedTargetString();

    for (int i = 1; i < command.size(); i++) {
      if (i > 1) {
        targetName += " ";
      }
      targetName += command.get(i);
    }

    return targetName.toUpperCase();
  }
}
