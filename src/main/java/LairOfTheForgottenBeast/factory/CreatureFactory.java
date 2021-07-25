package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.creature.Beast;
import LairOfTheForgottenBeast.domain.creature.Construct;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.creature.Humanoid;
import LairOfTheForgottenBeast.domain.creature.Undead;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;

public class CreatureFactory implements AbstractCreatureFactory<Creature> {
  PropFactory propFactory = new PropFactory();

  // Create method for only a creature type parameter. Non-unique creatures
  @Override
  public Creature create(String creatureType, RoomDynamic room) {
    if ("Human".equalsIgnoreCase(creatureType)) {
      Humanoid human = new Humanoid();
      human.setName("Generic Human");
      human.setShortDescription("Hi, I'm " + human.getName());
      human.setLongDescription(
          "Frank is a soldier, armed with an iron shortsword. Frank appears to be friendly.");
      Item weapon = new Item("iron sword", "a small shortsword",
          "a small sword forged from iron. good for cutting things.");
      human.setWeapon(weapon);
      human.setAttackDamage(65);
      human.setCurrentHitPoints(50);
      human.setMaxHitPoints(50);
      human.setCurrentRoom(room);
      return human;
    } else if ("Hobgoblin".equalsIgnoreCase(creatureType)) {
      Humanoid hobgoblin = new Humanoid();
      hobgoblin.setName("Generic Hobgoblin");
      hobgoblin.setShortDescription("some hobgoblin");
      hobgoblin.setLongDescription(
          "Burbar is a hobgoblin who wields a bronze shortsword. They seem to be hostile.");
      Item weapon = new Item("bronze sword", "a small shortsword",
          "A small sword forged from bronze. good for cutting things.");
      hobgoblin.setWeapon(weapon);
      hobgoblin.setAttackDamage(55);
      hobgoblin.setCurrentHitPoints(50);
      hobgoblin.setMaxHitPoints(50);
      hobgoblin.setCurrentRoom(room);
      return hobgoblin;
    } else if ("Statue".equalsIgnoreCase(creatureType)) {
      Construct construct = new Construct();
      construct.setName("Statue");
      construct.setShortDescription("a stone statue");
      construct.setLongDescription("A stone statue of a human soldier.");
      construct.setAttackDamage(55);
      construct.setCurrentHitPoints(50);
      construct.setMaxHitPoints(50);
      construct.setCurrentRoom(room);
      return construct;
    } else if ("Beast".equalsIgnoreCase(creatureType)) {
      Beast beast = new Beast();
      beast.setName("Generic Beast");
      beast.setShortDescription("short description default beast");
      beast.setLongDescription("long description default beast");
      beast.setAttackDamage(1);
      beast.setCurrentHitPoints(5);
      beast.setMaxHitPoints(5);
      beast.setCurrentRoom(room);
      return beast;
    } else if ("Spider".equalsIgnoreCase(creatureType)) {
      Beast spider = new Beast();
      spider.setName("spider");
      spider.setShortDescription("a big spider");
      spider.setLongDescription("This giant spider looks dangerous!");
      spider.setAttackDamage(65);
      spider.setCurrentHitPoints(50);
      spider.setMaxHitPoints(50);
      spider.setCurrentRoom(room);
      return spider;
    } else if ("Undead".equalsIgnoreCase(creatureType)) {
      Undead undead = new Undead();
      undead.setName("Generic Undead");
      undead.setShortDescription("short description generic undead");
      undead.setLongDescription("long description generic undead");
      undead.setAttackDamage(1);
      undead.setCurrentHitPoints(5);
      undead.setMaxHitPoints(5);
      undead.setCurrentRoom(room);
      return undead;
    } else if ("Beast Cultist".equalsIgnoreCase(creatureType)) {
      Humanoid hobgoblin = new Humanoid();
      hobgoblin.setName("Beast Cultist");
      hobgoblin.setShortDescription("a hobgoblin cultist");
      hobgoblin.setLongDescription(
          "A hobgoblin beast cultist wielding a ceremonial obsidian knife. They seem to be hostile.");
      Item ceremonialDagger = new Item("obsidian knife", "an obsidian knife",
          "a ceremonial knife made from volcanic glass.", 30);
      hobgoblin.setWeapon(ceremonialDagger);
      hobgoblin.setAttackDamage(35);
      hobgoblin.setCurrentHitPoints(50);
      hobgoblin.setMaxHitPoints(50);
      hobgoblin.setCurrentRoom(room);
      return hobgoblin;
    } else if ("Forgotten Beast".equalsIgnoreCase(creatureType)) {
      Beast forgottenBeast = new Beast();
      forgottenBeast.setName("The Forgotten Beast");
      forgottenBeast.setShortDescription("A horrifying beast.");
      forgottenBeast.setLongDescription("A horrifying beast. It gives off an aura of pure malice.");
      forgottenBeast.setAttackDamage(100);
      forgottenBeast.setCurrentHitPoints(100);
      forgottenBeast.setMaxHitPoints(100);
      forgottenBeast.setCurrentRoom(room);
      return forgottenBeast;
    } else if ("Cultist Regmur".equalsIgnoreCase(creatureType)) {
      Humanoid cultistRegmur = new Humanoid();
      cultistRegmur.setName("Cultist Regmer");
      cultistRegmur.setShortDescription("a hobgoblin cultist.");
      cultistRegmur.setLongDescription("a higher-ranking hobgoblin cultist");
      cultistRegmur.setAttackDamage(50);
      cultistRegmur.setCurrentHitPoints(50);
      cultistRegmur.setMaxHitPoints(50);
      cultistRegmur.setCurrentRoom(room);
      cultistRegmur.addToInventory((Item) propFactory.create("Item", "torn note"));
      return cultistRegmur;
    } else if ("Cultist Druthar".equalsIgnoreCase(creatureType)) {
      Humanoid cultistDruthar = new Humanoid();
      cultistDruthar.setName("Cultist Druthar");
      cultistDruthar.setShortDescription("a hobgoblin cultist.");
      cultistDruthar.setLongDescription("a higher-ranking hobgoblin cultist");
      cultistDruthar.setAttackDamage(50);
      cultistDruthar.setCurrentHitPoints(50);
      cultistDruthar.setMaxHitPoints(50);
      cultistDruthar.setCurrentRoom(room);
      cultistDruthar.addToInventory((Item) propFactory.create("Item", "burnt note"));
      return cultistDruthar;
    } else if ("Cultist Vegdot".equalsIgnoreCase(creatureType)) {
      Humanoid cultistVegdot = new Humanoid();
      cultistVegdot.setName("Cultist Vegdot");
      cultistVegdot.setShortDescription("a hobgoblin cultist.");
      cultistVegdot.setLongDescription("a higher-ranking hobgoblin cultist");
      cultistVegdot.setAttackDamage(50);
      cultistVegdot.setCurrentHitPoints(50);
      cultistVegdot.setMaxHitPoints(50);
      cultistVegdot.setCurrentRoom(room);
      cultistVegdot.addToInventory((Item) propFactory.create("Item", "soiled note"));
      return cultistVegdot;
    }

    return null;

  }

  // Create method that includes all parameters except the weapons
  @Override
  public Creature create(String creatureType, String name, String shortDesc, String longDesc,
      int attackDamage, int currentHitPoints, int maxHitPoints, RoomDynamic room) {
    if ("Human".equalsIgnoreCase(creatureType)) {
      Humanoid human = new Humanoid();
      human.setName(name);
      human.setShortDescription(shortDesc);
      human.setLongDescription(longDesc);
      human.setAttackDamage(attackDamage);
      human.setCurrentHitPoints(currentHitPoints);
      human.setMaxHitPoints(maxHitPoints);
      human.setCurrentRoom(room);
      return human;
    } else if ("Hobgoblin".equalsIgnoreCase(creatureType)) {
      Humanoid hobgoblin = new Humanoid();
      hobgoblin.setName(name);
      hobgoblin.setShortDescription(shortDesc);
      hobgoblin.setLongDescription(longDesc);
      hobgoblin.setAttackDamage(attackDamage);
      hobgoblin.setCurrentHitPoints(currentHitPoints);
      hobgoblin.setMaxHitPoints(maxHitPoints);
      hobgoblin.setCurrentRoom(room);
      return hobgoblin;
    } else if ("Construct".equalsIgnoreCase(creatureType)) {
      Construct construct = new Construct();
      construct.setName(name);
      construct.setShortDescription(shortDesc);
      construct.setLongDescription(longDesc);
      construct.setAttackDamage(attackDamage);
      construct.setCurrentHitPoints(currentHitPoints);
      construct.setMaxHitPoints(maxHitPoints);
      construct.setCurrentRoom(room);
      return construct;
    } else if ("Beast".equalsIgnoreCase(creatureType)) {
      Beast beast = new Beast();
      beast.setName(name);
      beast.setShortDescription(shortDesc);
      beast.setLongDescription(longDesc);
      beast.setAttackDamage(attackDamage);
      beast.setCurrentHitPoints(currentHitPoints);
      beast.setMaxHitPoints(maxHitPoints);
      beast.setCurrentRoom(room);
      return beast;
    } else if ("Undead".equalsIgnoreCase(creatureType)) {
      Undead undead = new Undead();
      undead.setName(name);
      undead.setShortDescription(shortDesc);
      undead.setLongDescription(longDesc);
      undead.setAttackDamage(attackDamage);
      undead.setCurrentHitPoints(currentHitPoints);
      undead.setMaxHitPoints(maxHitPoints);
      undead.setCurrentRoom(room);
      return undead;
    }
    return null;
  }

  // Create method using all the parameters including weapons
  @Override
  public Creature create(String creatureType, String name, String shortDesc, String longDesc,
      Item weapon, int attackDamage, int currentHitPoints, int maxHitPoints, RoomDynamic room) {
    if ("Human".equalsIgnoreCase(creatureType)) {
      Humanoid human = new Humanoid();
      human.setName(name);
      human.setShortDescription(shortDesc);
      human.setLongDescription(longDesc);
      human.setWeapon(weapon);
      human.setAttackDamage(attackDamage);
      human.setCurrentHitPoints(currentHitPoints);
      human.setMaxHitPoints(maxHitPoints);
      human.setCurrentRoom(room);
      return human;
    } else if ("Hobgoblin".equalsIgnoreCase(creatureType)) {
      Humanoid hobgoblin = new Humanoid();
      hobgoblin.setName(name);
      hobgoblin.setShortDescription(shortDesc);
      hobgoblin.setLongDescription(longDesc);
      hobgoblin.setWeapon(weapon);
      hobgoblin.setAttackDamage(attackDamage);
      hobgoblin.setCurrentHitPoints(currentHitPoints);
      hobgoblin.setMaxHitPoints(maxHitPoints);
      hobgoblin.setCurrentRoom(room);
      return hobgoblin;
    } else if ("Construct".equalsIgnoreCase(creatureType)) {
      Construct construct = new Construct();
      construct.setName(name);
      construct.setShortDescription(shortDesc);
      construct.setLongDescription(longDesc);
      construct.setWeapon(weapon);
      construct.setAttackDamage(attackDamage);
      construct.setCurrentHitPoints(currentHitPoints);
      construct.setMaxHitPoints(maxHitPoints);
      construct.setCurrentRoom(room);
      return construct;
    } else if ("Beast".equalsIgnoreCase(creatureType)) {
      Beast beast = new Beast();
      beast.setName(name);
      beast.setShortDescription(shortDesc);
      beast.setLongDescription(longDesc);
      beast.setWeapon(weapon);
      beast.setAttackDamage(attackDamage);
      beast.setCurrentHitPoints(currentHitPoints);
      beast.setMaxHitPoints(maxHitPoints);
      beast.setCurrentRoom(room);
      return beast;
    } else if ("Undead".equalsIgnoreCase(creatureType)) {
      Undead undead = new Undead();
      undead.setName(name);
      undead.setShortDescription(shortDesc);
      undead.setLongDescription(longDesc);
      undead.setWeapon(weapon);
      undead.setAttackDamage(attackDamage);
      undead.setCurrentHitPoints(currentHitPoints);
      undead.setMaxHitPoints(maxHitPoints);
      undead.setCurrentRoom(room);
      return undead;
    }
    return null;
  }

}
