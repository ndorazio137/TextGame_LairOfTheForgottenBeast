package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.prop.Decoration;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.Prop;

public class PropFactory implements AbstractPropFactory<Prop> {
  @Override
  public Prop create(String propType, String name, String shortDesc, String longDesc) {
    if ("Item".equalsIgnoreCase(propType)) {
      return new Item(name, shortDesc, longDesc);
    } else if ("Decoration".equalsIgnoreCase(propType)) {
      return new Decoration(name, shortDesc, longDesc);
    }
    System.out.println("!!!!!!!!!! PropFactory: Failed to generate a prop! : " + name);
    return null;
  }

  /**
   * Create props with prop type and name only.
   */
  public Prop create(String propType, String name) {
    /**
     * Weapons
     */
    if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("ceremonial dagger")) {
      Item ceremonialDagger = new Item("obsidian knife", "an obsidian knife",
          "a ceremonial knife made from volcanic glass.", 1);
      return ceremonialDagger;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("bronze dagger")) {
      Item bronzeDagger =
          new Item("bronze dagger", "a large knife", "a large knife for combat.", 1);
      return bronzeDagger;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("bronze sword")) {
      Item bronzeSword = new Item("bronze sword", "a small shortsword",
          "a small sword forged from bronze. good for cutting things.", 1);
      return bronzeSword;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("iron sword")) {
      Item ironSword = new Item("iron sword", "a small shortsword",
          "a small sword forged from iron. good for cutting things.", 1);
      return ironSword;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("stone sword")) {
      Item stoneSword =
          new Item("stone sword", "a small shortsword", "a small sword chiseled from rock.", 1);
      return stoneSword;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("meanacing dagger")) {
      Item meanacingDagger = new Item("meanacing dagger", "a meanacing dagger",
          "a frightening long dagger that has a dark purple aura.", 1);
      return meanacingDagger;
      /*
       * Armor
       */
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("armor")) {
      Item armor = new Item("armor", "a suit of body armor",
          "armor like this protects the soldier from attacks.");
      return armor;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("helm")) {
      Item helm = new Item("helm", "a helmet", "a helmet to avoid hits to the head in combat.");
      return helm;
      /**
       * Misc Items
       */
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("torn note")) {
      // Riddle Clue #1 Torn Note
      Item tornNote =
          new Item("torn note", "a strange note", "This note says, \"The knight is Jerroth.\"");
      return tornNote;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("burnt note")) {
      // Riddle Clue #2 Burnt Note
      Item burntNote =
          new Item("burnt note", "a strange note", "This note says, \"The knave is Harulon.\"");
      return burntNote;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("soiled note")) {
      // Riddle Clue #3 Soiled Note
      Item soiledNote =
          new Item("soiled note", "a strange note", "This note says, \"The spy is Komur.\"");
      return soiledNote;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("healing potion")) {
      Item healingPotion = new Item("healing potion", "a potion", "a potion which restores health");
      return healingPotion;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("candle")) {
      Item candle = new Item("candle", "a candle",
          "a candle, used to illuminate dark places or light things on fire");
      return candle;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("torch")) {
      Item torch =
          new Item("torch", "a torch", "used to illuminate dark places or light things on fire");
      return torch;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("iron pot")) {
      Item ironPot = new Item("iron pot", "an iron pot", "a large iron pot large enough to feed "
          + "many. It is usually placed over a cooking fire.");
      return ironPot;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("lamb shank")) {
      Item lambShank = new Item("lamb shank", "leg of lamb",
          "lamb's leg is a " + "favored dish among hobgoblins");
      return lambShank;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("kitchen knife")) {
      Item kitchenKnife = new Item("kitchen knife", "a knife for cutting food on the table",
          "kitchen knives are underrated weapons.");
      return kitchenKnife;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("serving scoop")) {
      Item servingScoop = new Item("serving scoop", "a large metal scoop",
          "this scoop is large enough to take soup out of the pot and fill a bowl in one try.");
      return servingScoop;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("bowl")) {
      Item bowl =
          new Item("bowl", "a regular bowl", "this bowl can hold enough soup to fill a person.");
      return bowl;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("spoon")) {
      Item spoon = new Item("spoon", "a spoon", "spoons are used to shovel food into a mouth.");
      return spoon;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("glowing mushroom")) {
      Item glowingMushroom = new Item("glowing mushroom", "a mushroom that glows",
          "a mushroom that glows in the dark with an eerie green light.");
      return glowingMushroom;
    } else if (propType.equalsIgnoreCase("Item") && name.equalsIgnoreCase("ruined book")) {
      Item book = new Item("ruined book", "a ruined book",
          "a book that is completely destroyed and unreadable. It is now only useful as fuel for a fireplace.");
      return book;
    }
    /**
     * Scrolls
     */
    else if (propType.equals("Item") && name.equalsIgnoreCase("scorched scroll")) {
      Item scroll = new Item("scorched scroll", "",
          "A scorched scroll that feels warm to the touch. To cast the spell, type \"invoke indra pyro shuf at TARGET\".");
      return scroll;
    } else if (propType.equals("Item") && name.equalsIgnoreCase("chilled scroll")) {
      Item scroll = new Item("chilled scroll", "",
          "A chilly scroll that feels cold to the touch. You can make out the runes, \"cryo shuf at\".");
      return scroll;
    } else if (propType.equals("Item") && name.equalsIgnoreCase("torn scroll")) {
      Item scroll = new Item("torn scroll", "",
          "A damaged scroll. Part of it seems to be missing. You can make out the runes, \"mito sgatra\".");
      return scroll;
    } else if (propType.equals("Item") && name.equalsIgnoreCase("ruined scroll")) {
      Item scroll = new Item("ruined scroll", "",
          "A damaged scroll. Part of it seems to be missing. You can make out the runes, \"zuna shuf\".");
      return scroll;
    } else if (propType.equals("Item") && name.equalsIgnoreCase("chewed scroll")) {
      Item scroll = new Item("chewed scroll", "",
          "A scroll riddles with bite and claw marks. Part of it seems to be missing. You see the runes, \"sgatra nili\".");
      return scroll;
    } else if (propType.equals("Item") && name.equalsIgnoreCase("crackling scroll")) {
      Item scroll = new Item("crackling scroll", "",
          "A scroll that crackles with static electricity. You see the runes, \"mito zap shuf\".");
      return scroll;
    } else if (propType.equals("Item") && name.equalsIgnoreCase("wet scroll")) {
      Item scroll = new Item("wet scroll", "",
          "A wet scroll that drips when you unroll it. You see the rune, \"aqua\".");
      return scroll;
    }
    /**
     * Decorations
     */
    else if (propType.equals("Decoration") && name.equalsIgnoreCase("cooking fire")) {
      Decoration cookingFire = new Decoration("cooking fire", "a fire",
          "a fire built in a kitchen area to boil the liquid in a cooking pot.");
      return cookingFire;
    } else if (propType.equalsIgnoreCase("Decoration") && name.equalsIgnoreCase("bed")) {
      Decoration bed = new Decoration("bed", "a bed.", "a bed for sleeping.");
      return bed;
    } else if (propType.equalsIgnoreCase("Decoration") && name.equalsIgnoreCase("chair")) {
      Decoration chair = new Decoration("chair", "a chair.", "a short bench seat for dining.");
      return chair;
    } else if (propType.equalsIgnoreCase("Decoration") && name.equalsIgnoreCase("dinner table")) {
      Decoration dinnerTable =
          new Decoration("dinner table", "a table.", "a long table for eating.");
      return dinnerTable;
    } else if (propType.equalsIgnoreCase("Decoration") && name.equalsIgnoreCase("bookshelf")) {
      Decoration bookshelf = new Decoration("bookshelf", "a large bookshelf.",
          "a large wooden " + "bookshelf used for holding many books.");
      return bookshelf;
    } else if (propType.equalsIgnoreCase("Decoration") && name.equalsIgnoreCase("sarcophagus")) {
      Decoration sarcophagus = new Decoration("sarcophagus", "a stone coffin.",
          "a stone coffin found in a burial crypt.");
      return sarcophagus;
    } else {
      // No static item was found with that name.
      System.out.println("!!!!!!!!!! PropFactory: Failed to generate a prop! : " + name);
      return null;
    }
  }
}
