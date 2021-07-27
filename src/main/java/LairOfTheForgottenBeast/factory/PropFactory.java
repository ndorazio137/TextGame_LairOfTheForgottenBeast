package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.prop.Decoration;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.Prop;

public class PropFactory implements AbstractPropFactory<Prop> {
  @Override
  public Prop create(String propType) {
    if ("Item".equalsIgnoreCase(propType)) {
      return new Item("item", "a misc item", "some sort of item");
    }
    if ("Decoration".equalsIgnoreCase(propType)) {
      Decoration decoration = new Decoration();
      decoration.setName("Generic Decoration");
      decoration.setShortDescription("a decoration");
      decoration.setLongDescription("This is a long decoration.");
      return decoration;
    }
    System.out
        .println("!!!!!!!!!! PropFactory: Failed to generate a prop! : " + "Generic " + propType);
    return null;
  }

  @Override
  public Prop create(String propType, String name, String shortDesc, String longDesc) {
    if ("Item".equalsIgnoreCase(propType)) {
      return new Item(name, shortDesc, longDesc);
    } else if ("Weapon".equalsIgnoreCase(propType)) {
      return new Item();
    } else if ("Decoration".equalsIgnoreCase(propType)) {
      Decoration decoration = new Decoration();
      decoration.setName(name);
      decoration.setShortDescription(shortDesc);
      decoration.setLongDescription(longDesc);
      return decoration;
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
    if (propType.equals("Item") && name.equals("ceremonial dagger")) {
      Item ceremonialDagger = new Item("obsidian knife", "an obsidian knife",
          "a ceremonial knife made from volcanic glass.", 1);
      return ceremonialDagger;
    } else if (propType.equals("Item") && name.equals("bronze dagger")) {
      Item bronzeDagger =
          new Item("bronze dagger", "a large knife", "a large knife for combat.", 1);
      return bronzeDagger;
    } else if (propType.equals("Item") && name.equals("bronze sword")) {
      Item bronzeSword = new Item("bronze sword", "a small shortsword",
          "a small sword forged from bronze. good for cutting things.", 1);
      return bronzeSword;
    } else if (propType.equals("Item") && name.equals("iron sword")) {
      Item ironSword = new Item("iron sword", "a small shortsword",
          "a small sword forged from iron. good for cutting things.", 1);
      return ironSword;
    } else if (propType.equals("Item") && name.equals("stone sword")) {
      Item stoneSword =
          new Item("stone sword", "a small shortsword", "a small sword chiseled from rock.", 1);
      return stoneSword;
    } else if (propType.equals("Item") && name.equals("meanacing dagger")) {
      Item meanacingDagger = new Item("meanacing dagger", "a meanacing dagger",
          "a frightening long dagger that has a dark purple aura.", 1);
      return meanacingDagger;
      /*
       * Armor
       */
    } else if (propType.equals("Item") && name.equals("armor")) {
      Item armor = new Item("armor", "a suit of body armor",
          "armor like this protects the soldier from attacks.");
      return armor;
    } else if (propType.equals("Item") && name.equals("helm")) {
      Item helm = new Item("helm", "a helmet", "a helmet to avoid hits to the head in combat.");
      return helm;
      /**
       * Misc Items
       */
    } else if (propType.equals("Item") && name.equals("torn note")) {
      // Riddle Clue #1 Torn Note
      Item tornNote =
          new Item("torn note", "a strange note", "This note says, \"The knight is Jerroth.\"");
      return tornNote;
    } else if (propType.equals("Item") && name.equals("burnt note")) {
      // Riddle Clue #2 Burnt Note
      Item burntNote =
          new Item("burnt note", "a strange note", "This note says, \"The knave is Harulon.\"");
      return burntNote;
    } else if (propType.equals("Item") && name.equals("soiled note")) {
      // Riddle Clue #3 Soiled Note
      Item soiledNote =
          new Item("soiled note", "a strange note", "This note says, \"The spy is Komur.\"");
      return soiledNote;
    } else if (propType.equals("Item") && name.equals("healing potion")) {
      Item healingPotion = new Item("healing potion", "a potion", "a potion which restores health");
      return healingPotion;
    } else if (propType.equals("Item") && name.equals("candle")) {
      Item candle = new Item("candle", "a candle",
          "a candle, used to illuminate dark places or light things on fire");
      return candle;
    } else if (propType.equals("Item") && name.equals("torch")) {
      Item torch =
          new Item("torch", "a torch", "used to illuminate dark places or light things on fire");
      return torch;
    } else if (propType.equals("Item") && name.equals("iron pot")) {
      Item ironPot = new Item("iron pot", "an iron pot", "a large iron pot large enough to feed "
          + "many. It is usually placed over a cooking fire.");
      return ironPot;
    } else if (propType.equals("Item") && name.equals("lamb shank")) {
      Item lambShank = new Item("lamb shank", "leg of lamb",
          "lamb's leg is a " + "favored dish among hobgoblins");
      return lambShank;
    } else if (propType.equals("Item") && name.equals("kitchen knife")) {
      Item kitchenKnife = new Item("kitchen knife", "a knife for cutting food on the table",
          "kitchen knives are underrated weapons.");
      return kitchenKnife;
    } else if (propType.equals("Item") && name.equals("serving scoop")) {
      Item servingScoop = new Item("serving scoop", "a large metal scoop",
          "this scoop is large enough to take soup out of the pot and fill a bowl in one try.");
      return servingScoop;
    } else if (propType.equals("Item") && name.equals("bowl")) {
      Item bowl =
          new Item("bowl", "a regular bowl", "this bowl can hold enough soup to fill a person.");
      return bowl;
    } else if (propType.equals("Item") && name.equals("spoon")) {
      Item spoon = new Item("spoon", "a spoon", "spoons are used to shovel food into a mouth.");
      return spoon;
    } else if (propType.equals("Item") && name.equals("glowing mushroom")) {
      Item glowingMushroom = new Item("glowing mushroom", "a mushroom that glows",
          "a mushroom that glows in the dark with an eerie green light.");
      return glowingMushroom;
    } else if (propType.equals("Item") && name.equals("ruined book")) {
      Item book = new Item("ruined book", "a ruined book",
          "a book that is completely destroyed and unreadable. It is now only useful as fuel for a fireplace.");
      return book;
      /**
       * Decorations
       */
    } else if (propType.equals("Decoration") && name.equals("cooking fire")) {
      Decoration cookingFire = new Decoration("cooking fire", "a fire",
          "a fire built in a kitchen area to boil the liquid in a cooking pot.");
      return cookingFire;
    } else if (propType.equals("Decoration") && name.equals("bed")) {
      Decoration bed = new Decoration("bed", "a bed.", "a bed for sleeping.");
      return bed;
    } else if (propType.equals("Decoration") && name.equals("chair")) {
      Decoration chair = new Decoration("chair", "a chair.", "a short bench seat for dining.");
      return chair;
    } else if (propType.equals("Decoration") && name.equals("dinner table")) {
      Decoration dinnerTable =
          new Decoration("dinner table", "a table.", "a long table for eating.");
      return dinnerTable;
    } else if (propType.equals("Decoration") && name.equals("bookshelf")) {
      Decoration bookshelf = new Decoration("bookshelf", "a large bookshelf.",
          "a large wooden " + "bookshelf used for holding many books.");
      return bookshelf;
    } else {
      // No static item was found with that name.
      System.out.println("!!!!!!!!!! PropFactory: Failed to generate a prop! : " + name);
      return null;
    }
  }
}
