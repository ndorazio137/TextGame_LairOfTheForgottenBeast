package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.prop.Decoration;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.Prop;

public class PropFactory implements AbstractPropFactory<Prop> {
  @Override
  public Prop create(String propType) {
    if ("Item".equalsIgnoreCase(propType)) {
      return new Item("item", "a misc item", "some sort of item"); // weapons,
                                                                   // spellbooks,
                                                                   // potions,
                                                                   // coins,
                                                                   // containers
    }
    if ("Decoration".equalsIgnoreCase(propType)) {
      Decoration decoration = new Decoration();
      decoration.setName("Generic Decoration");
      decoration.setShortDescription("a decoration");
      decoration.setLongDescription("This is a long decoration.");
      return decoration;
    }

    return null;
  }

  @Override
  public Prop create(String propType, String name, String shortDesc, String longDesc) {
    if ("Item".equalsIgnoreCase(propType)) {
      return new Item(name, shortDesc, longDesc); // weapons, spellbooks,
                                                  // potions, coins,
                                                  // containers
    } else if ("Weapon".equalsIgnoreCase(propType)) {
      return new Item();
    } else if ("Decoration".equalsIgnoreCase(propType)) {
      Decoration decoration = new Decoration();
      decoration.setName(name);
      decoration.setShortDescription(shortDesc);
      decoration.setLongDescription(longDesc);
      return decoration;
    }
    return null;
  }

  /**
   * Create props with prop type and name only.
   */
  public Prop create(String propType, String name) {
    /**
     * Weapons
     */
    if (propType == "Item" && name == "ceremonialDagger") {
      Item ceremonialDagger = new Item("obsidian knife", "an obsidian knife",
          "a ceremonial knife made from volcanic glass.", 30);
      return ceremonialDagger;
    } else if (propType == "Item" && name == "bronzeDagger") {
      Item bronzeDagger =
          new Item("bronze dagger", "a large knife", "a large knife for combat.", 30);
      return bronzeDagger;
    } else if (propType == "Item" && name == "bronze sword") {
      Item bronzeSword = new Item("bronze sword", "a small shortsword",
          "a small sword forged from bronze. good for cutting things.", 50);
      return bronzeSword;
    } else if (propType == "Item" && name == "iron sword") {
      Item ironSword = new Item("iron sword", "a small shortsword",
          "a small sword forged from iron. good for cutting things.", 60);
      return ironSword;
    } else if (propType == "Item" && name == "stone sword") {
      Item stoneSword =
          new Item("stone sword", "a small shortsword", "a small sword chiseled from rock.", 50);
      return stoneSword;
      /*
       * Armor
       */
    } else if (propType == "Item" && name == "armor") {
      Item armor = new Item("armor", "a suit of body armor",
          "armor like this protects the soldier from attacks.");
      return armor;
    } else if (propType == "Item" && name == "helm") {
      Item helm = new Item("helm", "a helmet", "a helmet to avoid hits to the head in combat.");
      return helm;
      /**
       * Misc Items
       */
    } else if (propType == "Item" && name == "healing potion") {
      Item healingPotion = new Item("healing potion", "a potion", "a potion which restores health");
      return healingPotion;
    } else if (propType == "Item" && name == "candle") {
      Item candle = new Item("candle", "a candle",
          "a candle, used to illuminate dark places or light things on fire");
      return candle;
    } else if (propType == "Item" && name == "torch") {
      Item torch =
          new Item("torch", "a torch", "used to illuminate dark places or light things on fire");
      return torch;
    } else if (propType == "Item" && name == "iron pot") {
      Item ironPot = new Item("iron pot", "an iron pot", "a large iron pot large enough to feed "
          + "many. It is usually placed over a cooking fire.");
      return ironPot;
    } else if (propType == "Item" && name == "lamb shank") {
      Item lambShank = new Item("lamb shank", "leg of lamb",
          "lamb's leg is a " + "favored dish among hobgoblins");
      return lambShank;
    } else if (propType == "Item" && name == "kitchen knife") {
      Item kitchenKnife = new Item("kitchen knife", "a knife for cutting food on the table",
          "kitchen knives are underrated weapons.");      
      return kitchenKnife;
    } else if (propType == "Item" && name == "serving scoop") {
      Item servingScoop = new Item("serving scoop", "a large metal scoop",
          "this scoop is large enough to take soup out of the pot and fill a bowl in one try.");     
      return servingScoop;
    } else if (propType == "Item" && name == "bowl") {
      Item bowl = new Item("bowl", "a regular bowl", "this bowl can hold enough soup to fill a person.");     
      return bowl;
    } else if (propType == "Item" && name == "spoon") {
      Item spoon = new Item("spoon", "a spoon",
          "spoons are used to shovel food into a mouth.");      
      return spoon;
      /**
       * Decorations
       */
    } else if (propType == "Item" && name == "glowing mushroom") {
      Decoration glowingMushroom = new Decoration("glowing mushroom", "a mushroom that glows",
          "a mushroom that glows in the dark with an eerie green light.");
      return glowingMushroom;
    } else if (propType == "Decoration" && name == "cooking fire") {
      Decoration cookingFire = new Decoration("cooking fire", "a fire",
          "a fire built in a kitchen area to boil the liquid in a cooking pot.");
      return cookingFire;
    } else if (propType == "Decoration" && name == "bed") {
      Decoration bed = new Decoration("bed", "a bed.", "a bed for sleeping.");
      return bed;
    } else if (propType == "Decoration" && name == "chair") {
      Decoration chair = new Decoration("chair", "a chair.", "a short bench seat for dining.");
      return chair;
    } else if (propType == "Decoration" && name == "bookshelf") {
      Decoration bookshelf = new Decoration("bookshelf", "a large bookshelf.", "a large wooden "
          + "bookshelf used for holding many books.");
      return bookshelf;
            
    } else {
      // No static item was found with that name.
      return null;
    }

  }

}
