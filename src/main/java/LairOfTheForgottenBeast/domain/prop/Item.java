package LairOfTheForgottenBeast.domain.prop;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;
import LairOfTheForgottenBeast.domain.Shock;
import LairOfTheForgottenBeast.domain.Wet;


public class Item implements Prop {
  Long id;
  String name;
  String shortDescription; // This is read as the default description
  String longDescription; // This is read someone "examines" a prop object
  String properties; // Stone, Wood, leather, metal, etc.

  public Burn burnInterface;
  public Freeze freezeInterface;
  public Shock shockInterface;
  public Wet wetInterface;
  
  int attackDamage = 1;
  String speechText = "There was no response";

  public Item(String name, String shortDescription, String longDescription, int attackDamage) {
    super();
    this.name = name;
    this.shortDescription = shortDescription;
    this.longDescription = longDescription;
    this.attackDamage = attackDamage;
  }

  public Item() {}

  public Item(String name, String shortDesc, String longDesc) {
    this.name = name;
    this.shortDescription = shortDesc;
    this.longDescription = longDesc;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getShortDescription() {
    return this.shortDescription;
  }

  @Override
  public String getLongDescription() {
    return this.longDescription;
  }

  @Override
  public String getProperties() {
    return this.properties;
  }

  public boolean setName(String name) {
    if (name == null)
      return false;
    this.name = name;
    return true;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  @Override
  public String burn() {
    if (this.burnInterface == null) {
      return "The item is warmer now.";
    }
    return this.burnInterface.burn();
  }

  @Override
  public String freeze() {
    if (this.freezeInterface == null) {
      return "The item is colder now.";
    }
    return this.freezeInterface.freeze();
  }

  @Override
  public String shock() {
    if (this.shockInterface == null) {
      return "The item seems unaffected.";
    }
    return this.shockInterface.shock();
  }
  
  @Override
  public String wet() {
    if (this.wetInterface == null) {
      return "The item is wet now.";
    }
    return this.wetInterface.wet();
  }

  public void setBurn(Burn burnBehavior) {
    this.burnInterface = burnBehavior;
  }

  public void setFreeze(Freeze freezeBehavior) {
    this.freezeInterface = freezeBehavior;
  }

  public void setShock(Shock shockBehavior) {
    this.shockInterface = shockBehavior;
  }
  
  public void setWet(Wet wetBehavior) {
    this.wetInterface = wetBehavior;
  }
  
  public int getAttackDamage() {
    return attackDamage;
  }
  
  public void setAttackDamage(int attackDamage) {
    this.attackDamage = attackDamage;
  }

  @Override
  public String getSpeechText() {
    return this.speechText;
  }
  
  @Override
  public void setSpeechText(String text) {
    this.speechText = text;
  }
}
