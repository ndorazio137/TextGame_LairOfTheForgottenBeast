package LairOfTheForgottenBeast.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.creature.Beast;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Prop;
import LairOfTheForgottenBeast.factory.CreatureFactory;

public class SpellService {

  private HashMap<String, String> magicWordDictionary;
  private final int SPELL_DAMAGE = 3;
  private final int BOSS_ROOM_ID = 64; // we might need to change this later
  private CreatureFactory creatureFactory;

  public SpellService() {
    this.initMagicWordDictionary();
    creatureFactory = new CreatureFactory();
  }

  private void initMagicWordDictionary() {
    magicWordDictionary = new HashMap<String, String>();
    HashMap<String, String> dict = this.magicWordDictionary;
    dict.put("INDRA", "create");
    dict.put("PYRO", "fire");
    dict.put("SHUF", "projectile");
    dict.put("CRYO", "frost");
    dict.put("SELF", "self-cast");
    dict.put("ZUNA", "teleportation");
    dict.put("WILD", "random");
    dict.put("NILI", "creature");
    dict.put("ZAP", "lightning");
    dict.put("AQUA", "water");
    dict.put("NULLA", "absorb");
    dict.put("VITAE", "life");
  }

  private String fizzleString() {
    return "The spell fizzles.";
  }

  public String castSpell(GameState gamestate, CommandInfo commandInfo) {
    Player player = gamestate.getPlayerMap().get(commandInfo.getUsername());
    boolean multiplayer = commandInfo.getMultiplayer();
    List<String> commandList = commandInfo.getCommandList();
    System.out.println("SpellService: Received command List: " + commandList);
    String spellString = "";
    String targetName = "";
    String outputString = "";
    System.out.println("SpellService: parsing target name and spell " + "string...");
    boolean foundAtToken = false;
    for (int i = 1; i < commandList.size() - 1; i++) {
      if (commandList.get(i).equals("at")) {
        targetName = concatTheRemainingTokens(commandList, i + 1);
        foundAtToken = true;
        System.out.println("SpellService: found target name: " + targetName);
      }
      if (!foundAtToken && i > 0) {
        spellString += magicWordDictionary.get(commandList.get(i).toUpperCase());
      }
      if (!foundAtToken) {
        spellString += " ";
      }
    }
    if (!foundAtToken) {
      spellString += (magicWordDictionary.get(commandList.get(commandList.size() - 1).toUpperCase()));
    }
    spellString = spellString.trim();
    System.out
        .println("SpellService.castSpell: Spell String constructed: " + "\"" + spellString + "\"");
    if (spellString.equals("create fire projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = castCreateProjectile(gamestate, player, "fire", targetName);
    } else if (spellString.equals("create frost projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = castCreateProjectile(gamestate, player, "frost", targetName);
    } else if (spellString.equals("self-cast fire projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = selfCastCreateProjectile(gamestate, "fire", player);
    } else if (spellString.equals("self-cast random projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = selfCastCreateProjectile(gamestate, "random", player);
    } else if (spellString.equals("self-cast frost projectile")) {
      System.out
          .println("SpellService.castSpell: identified spell \"" + "self-cast frost projectile\"");
      outputString = selfCastCreateProjectile(gamestate, "frost", player);
    } else if (spellString.equals("self-cast lightning projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = selfCastCreateProjectile(gamestate, "lightning", player);
    } else if (spellString.equals("self-cast random teleportation")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = selfCastRandomTeleport(gamestate, multiplayer, player);
    } else if (spellString.equals("self-cast teleportation projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = selfCastRandomTeleport(gamestate, multiplayer, player);
      return outputString;
    } else if (spellString.equals("create teleportation projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = castCreateProjectile(gamestate, player, "teleportation", targetName);
    } else if (spellString.equals("create lightning projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = castCreateProjectile(gamestate, player, "lightning", targetName);
    } else if (spellString.equals("create random projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = castCreateProjectile(gamestate, player, "random", targetName);
    } else if (spellString.equals("create water projectile")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = castCreateProjectile(gamestate, player, "water", targetName);
    } else if (spellString.equals("create random creature")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = castCreateCreature(gamestate, player, "random");
    } else if (spellString.equals("absorb creature life")) {
      System.out.println("SpellService.castSpell: identified spell \"" + spellString);
      outputString = castCreateProjectile(gamestate, player, "absorb life", targetName);
    } else {
      System.out.println("SpellService.castSpell: spell string did not "
          + "match any known spell... fizzling spell.");
      outputString = fizzleString();
    }

    return outputString;
  }

  private String castCreateCreature(GameState gamestate, Player player, String aspect) {
    if (aspect.equals("random")) {
      String outputString = "";
      Creature tinyCritter = getRandomCreature(player.getCurrentRoom());
      player.getCurrentRoom().addCreature(tinyCritter);
      return "Your spell generates a small puff of smoke, from which emerges a "
          + tinyCritter.getName() + ".";
    } else {
      return fizzleString();
    }
  }

  private String castCreateProjectile(GameState gamestate, Player player, String aspect,
      String targetName) {
    System.out.println("SpellService.castCreateProjectile: about to locate "
        + "target for casting \"create " + aspect + " projectile");
    if (targetName.equals("")) {
      return "This spell must be cast at a target.";
    }
    Object target = findTarget(gamestate, player, targetName);
    if (target == null) {
      return "You don't see a \"" + targetName + "\" to cast your spell at.";
    }

    if (aspect.equals("random")) {
      aspect = getRandomAspect();
    }

    if (target instanceof Creature) {
      return castCreateProjectileAtCreature(gamestate, player, aspect, (Creature) target);
    } else if (target instanceof Prop) {
      return castCreateProjectileAtProp(gamestate, aspect, (Prop) target);
    }
    return null;
  }

  private String castCreateProjectileAtCreature(GameState gamestate, Player player, String aspect,
      Creature target) {
    System.out
        .println("SpellService.castCreateProjectile: Casting " + "spell at creature: " + target);
    if (aspect.equals("teleportation")) {
      ((Creature) target).getCurrentRoom().removeCreature((Creature) target);
      RoomDynamic newRoom = gamestate.getWorldMap().getRandomValidRoom();
      ((Creature) target).setCurrentRoom(newRoom);
      newRoom.addCreature(((Creature) target));
      System.out.println(
          "SpellService.castCreateProjectile: " + "teleported " + ((Creature) target).getName()
              + " to " + " room: " + ((Creature) target).getCurrentRoom());
      return "You cast a blast of " + aspect + " energy at " + ((Creature) target).getName()
          + ". A swirling portal " + "surrounds it for a moment and it vanishes.";
    } else if (aspect.equals("fire") || aspect.equals("lightning") || aspect.equals("frost")
        || aspect.equals("water")) {
      ((Creature) target).reduceHitPointsBy(SPELL_DAMAGE);

      String outputString =
          "You cast a blast of " + aspect + " at " + ((Creature) target).getName() + ".";

      Creature creature = ((Creature) target);
      if (creature.getCurrentHitPoints() <= 0) {
        player.getCurrentRoom().removeCreature(creature);
        outputString += " " + creature.getName() + " is dead.";
      } else {
        outputString += " " + creature.toString() + " has " + creature.getCurrentHitPoints()
            + " hit points remaining.";
        outputString += creature.onAttacked(player);
      }
      return outputString;
    } else if (aspect.equals("absorb life")) {
      ((Creature) target).reduceHitPointsBy((int) (SPELL_DAMAGE / 2)+1);
      player.setCurrentHitPoints(player.getCurrentHitPoints() + ((int) (SPELL_DAMAGE / 2)+1));
      if (player.getCurrentHitPoints() > player.getMaxHitPoints())
        player.setCurrentHitPoints(player.getMaxHitPoints());

      String outputString =
          "You draw some life force from " + ((Creature) target).getName() + " and heal yourself.";

      Creature creature = ((Creature) target);
      if (creature.getCurrentHitPoints() <= 0) {
        player.getCurrentRoom().removeCreature(creature);
        outputString += " " + creature.getName() + " is dead.";
      } else {
        outputString += " " + creature.toString() + " has " + creature.getCurrentHitPoints()
            + " hit points remaining.";
        outputString += creature.onAttacked(player);
      }
      return outputString;
    } else {
      return "You cast a blast of chaotic energy that fizzles.";
    }
  }

  private String castCreateProjectileAtProp(GameState gamestate, String aspect, Prop target) {
    String targetName = target.getName();
    if (aspect.equals("fire") && (((Prop) target).burn() != null)) {
      System.out
          .println("SpellService.castCreateProjectile: Casting " + "fire spell at prop: " + target);
      return "You cast a blast of fire at the " + targetName + ". " + ((Prop) target).burn();
    } else if (aspect.equals("frost") && (((Prop) target).freeze() != null)) {
      System.out.println(
          "SpellService.castCreateProjectile: Casting " + "frost spell at prop: " + target);
      return "You cast a blast of frost at the " + targetName + ". " + ((Prop) target).freeze();
    } else if (aspect.equals("lightning") && (((Prop) target).freeze() != null)) {
      System.out.println(
          "SpellService.castCreateProjectile: Casting " + "lightning spell at prop: " + target);
      return "You cast a blast of lightning at the " + targetName + ". " + ((Prop) target).shock();
    } else if (aspect.equals("water") && (((Prop) target).wet() != null)) {
      System.out.println(
          "SpellService.castCreateProjectile: Casting " + "lightning spell at prop: " + target);
      return "You cast a blast of water at the " + targetName + ". " + ((Prop) target).wet();
    } else {
      return "You cast a blast of chaotic energy that fizzles.";
    }
  }

  // Concatenates all Strings from index i to the end of the List
  // Returns the concatenated String.
  private String concatTheRemainingTokens(List<String> tokens, int i) {
    String tokenString = "";

    for (int index = i; index < tokens.size(); index++) {
      tokenString += tokens.get(index);
      if (index < tokens.size() - 1) {
        tokenString += " ";
      }
    }

    return tokenString;
  }

  // Checks the Player's current room for a Creature or Prop with a name that matches targetName
  // and returns a reference to the Creature/Prop as an Object
  private Object findTarget(GameState gamestate, Player player, String targetName) {
    RoomDynamic room = player.getCurrentRoom();
    System.out.println(
        "SpellService.findTarget: finding target " + targetName + " in room " + room.getName());
    for (Creature creature : room.getCreatures()) {
      if (creature.getName().equalsIgnoreCase(targetName)) {
        System.out.println("SpellService.findTarget: Creature target " + "identified: " + creature);
        return creature;
      }
    }
    for (Prop prop : room.getProps()) {
      if (prop.getName().equalsIgnoreCase(targetName)) {
        System.out.println("SpellService.findTarget: Prop target " + "identified: " + prop);
        return prop;
      }
    }
    System.out.println(
        "SpellService.findTarget: target " + targetName + " not found in room " + room.getName());
    return null;
  }

  private String getRandomAspect() {
    System.out.println("SpellService.getRandomAspect: generating " + "random aspect...");
    Set<String> aspectSet = magicWordDictionary.keySet();
    List<String> aspectList = new ArrayList<String>();
    for (String aspect : aspectSet) {
      aspectList.add(aspect);
    }
    Random rand = new Random();
    String aspect;
    do {
      aspect = aspectList.get(rand.nextInt(aspectList.size()));
      aspect = magicWordDictionary.get(aspect.toUpperCase());
      System.out.println("SpellService.getRandomAspect: trying " + aspect);
    } while (!(aspect.equals("fire") || aspect.equals("frost") || aspect.equals("lightning")
        || aspect.equals("teleportation")));
    System.out.println("SpellService.getRandomAspect: accepted aspect: " + aspect);
    return aspect;
  }

  private Creature getRandomCreature(RoomDynamic room) {
    Random rand = new Random();
    int randInt = rand.nextInt(3);
    if (randInt == 0) {
      return creatureFactory.create("Beast", "butterfly", "a tiny butterfly",
          "a butterfly, a tiny fluttering insect", 0, 1, 1, room);
    } else if (randInt == 1) {
      return creatureFactory.create("Beast", "mouse", "a tiny mouse",
          "a mouse, a tiny squeaking mammal", 0, 1, 1, room);
    } else if (randInt == 2) {
      return creatureFactory.create("Beast", "tiny rabbit", "a tiny rabbit",
          "a rabbit, a tiny harmless mammal. It is warm and fuzzy.", 0, 1, 1, room);
    } else {
      return null;
    }
  }

  private String getRandomMagicWord() {
    Set<String> aspectSet = magicWordDictionary.keySet();
    List<String> aspectList = new ArrayList<String>();
    for (String aspect : aspectSet) {
      aspectList.add(aspect);
    }
    Random rand = new Random();
    return aspectList.get(rand.nextInt(aspectList.size()));
  }

  private String selfCastCreateProjectile(GameState gamestate, String aspect, Player player) {
    System.out.println(
        "SpellService.castCreateProjectile: Casting " + "spell at self: " + player.getName());
    player.setCurrentHitPoints(player.getCurrentHitPoints() - SPELL_DAMAGE);
    if (aspect.equalsIgnoreCase("random")) {
      aspect = "chaotic energy";
    }
    return "You cast a blast of " + aspect + " that explodes on yourself.";
  }

  private String selfCastRandomTeleport(GameState gamestate, boolean multiplayer, Player player) {
    RoomDynamic startRoom = player.getCurrentRoom();
    RoomDynamic endRoom;
    do {
      endRoom = gamestate.getWorldMap().getRandomValidRoom();
    } while (startRoom.equals(endRoom) || endRoom.getId() == BOSS_ROOM_ID);

    System.out.println("SpellService.selfCastRandomTeleport: attempting to"
        + " teleport the player from " + startRoom.getName() + " to " + endRoom.getName() + ".");
    player.setCurrentRoom(endRoom);
    return "A swirling portal surrounds you for a moment and when it fades "
        + "you find yourself in a new location. You are in " + endRoom.getName() + ": "
        + endRoom.getLongDescription(multiplayer);
  }
}
