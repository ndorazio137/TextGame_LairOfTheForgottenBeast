package LairOfTheForgottenBeast.domain.commands;

import java.util.List;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;

public class Attack implements ICommand<String> {

  @Override
  public <AnyType> String call(GameState gameState, List<String> command) {
    // debug
    printCommandList(command);
    
    // Get gamestate objects
    Player player = gameState.getPlayer();
    RoomDynamic room = player.getCurrentRoom();
    List<Creature> creatures = room.getCreatures();
    
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
    attackCreature(creature, player);
    
    // build return string
    if (creature.getCurrentHitPoints() <= 0) {
      room.removeCreature(creature);
      return creature.toString() + " is dead";
    }
    else
      return creature.toString() + " has " + creature.getCurrentHitPoints() + " life left";
  }
  
  private void attackCreature(Creature creature, Player player) {
    int playerAttack = player.getCombinedAttackDamage();
    creature.reduceHitPointsBy(playerAttack);
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
}
