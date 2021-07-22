package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.OnAttacked;
import LairOfTheForgottenBeast.domain.OnExamined;
import LairOfTheForgottenBeast.domain.OnTalk;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.inventorySystem.BaseInventory;
import LairOfTheForgottenBeast.inventorySystem.Inventory;

public abstract class Creature {
  Long id;

  String shortDescription;
  String longDescription;
  String properties;
  String speechText = "There was no response";
  
  public OnAttacked onAttackedInterface;
  public OnExamined onExaminedInterface;
  public OnTalk onTalkInterface;

  /**
   * The current room the creature is in.
   */
  RoomDynamic currentRoom;
  /**
   * The creature's name.
   */
  String name;
  /**
   * The inventory attached to a creature
   */
  Inventory inventory = new BaseInventory(50);
  /**
   * The max number of items that can be in a creatures inventory
   */
  int creatureInventorySize = 50;

  /**
   * The weapon the creature currently wields.
   */
  Item weapon;
  /**
   * The hit points the creature currently has.
   */
  int currentHitPoints;
  /**
   * The maximum hit points a creature has.
   */
  int maxHitPoints;
  /**
   * The damage the creature currently does.
   */
  int attackDamage;

  public abstract Long getId();

  public abstract String getName();

  public abstract String getShortDescription();

  public abstract String getLongDescription();

  public abstract String getProperties();

  public abstract String toString();

  public abstract Item getWeapon();

  public abstract int getCurrentHitPoints();

  public abstract int getMaxHitPoints();

  public abstract int getAttackDamage();
  
  public String getSpeechText() {
    return speechText;
  }
  
  public void setSpeechText(String text) {
    this.speechText = text;
  }
  
  public boolean addToInventory(Item inventoryItem) {
    if (inventoryItem == null)
      return false;
    inventory.addItem(inventoryItem);
    return true;
  }
  
  public int reduceHitPointsBy(int attackDamage) {
    if (currentHitPoints - attackDamage <= 0) {
      currentHitPoints = 0;
      this.dropInventory();
    }
    else {
      currentHitPoints = currentHitPoints - attackDamage;
      if (currentHitPoints <= 0) dropInventory();
    }
    return currentHitPoints;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public void setProperties(String properties) {
    this.properties = properties;
  }

  public void setWeapon(Item weapon) {
    this.weapon = weapon;
  }

  public void setCurrentHitPoints(int currentHitPoints) {
    this.currentHitPoints = currentHitPoints;
  }

  public void setMaxHitPoints(int maxHitPoints) {
    this.maxHitPoints = maxHitPoints;
  }

  public void setAttackDamage(int attackDamage) {
    this.attackDamage = attackDamage;
  };

  public RoomDynamic getCurrentRoom() {
    return currentRoom;
  }

  public void setCurrentRoom(RoomDynamic currentRoom) {
    this.currentRoom = currentRoom;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public void setInventory(Inventory inventory) {
    this.inventory = inventory;
  }

  public int getCreatureInventorySize() {
    return creatureInventorySize;
  }

  public void setCreatureInventorySize(int creatureInventorySize) {
    this.creatureInventorySize = creatureInventorySize;
  }
  
  public void dropInventory() {
    if (this.weapon != null) {
      this.inventory.addItem(weapon);
      this.weapon = null;
    }
    ((BaseInventory)inventory).dropAllItems(this.currentRoom);
  }
  
  public String onAttacked() {
    if (this.onAttackedInterface == null) {
      return "The creature is injured by the attack.";
    }
    return this.onAttackedInterface.onAttacked();
  }
  
  public String onExamined() {
    if (this.onExaminedInterface == null) {
      return "";
    }
    return this.onExaminedInterface.onExamine();
  }
  
  public String onTalk() {
    if (this.onTalkInterface == null) {
      return "";
    }
    return this.onTalkInterface.onTalk();
  }

  public void setOnAttacked(OnAttacked onAttackedBehavior) {
    this.onAttackedInterface = onAttackedBehavior;
  }
  
  public void setOnExamined(OnExamined onExaminedBehavior) {
    this.onExaminedInterface = onExaminedBehavior;
  }

  public void setOnTalk(OnTalk onTalkBehavior) {
    this.onTalkInterface = onTalkBehavior;
  }

}
