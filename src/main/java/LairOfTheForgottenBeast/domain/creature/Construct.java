package LairOfTheForgottenBeast.domain.creature;

import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;

/**
 * 
 * 
 * @author Brian James
 * @version 1.0.0
 * @since 1.0.0
 */
public class Construct extends Creature {

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getShortDescription() {
    return this.shortDescription;
  }

  @Override
  public void setShortDescription(String shortDesc) {
    this.shortDescription = shortDesc;
  }

  @Override
  public String getLongDescription() {
    return this.longDescription;
  }

  @Override
  public void setLongDescription(String longDesc) {
    this.longDescription = longDesc;
  }

  @Override
  public String getProperties() {
    return this.properties;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public Item getWeapon() {
    return this.weapon;
  }

  @Override
  public void setWeapon(Item weapon) {
    this.weapon = weapon;
  }

  @Override
  public int getCurrentHitPoints() {
    return this.currentHitPoints;
  }

  @Override
  public int getMaxHitPoints() {
    return this.maxHitPoints;
  }

  @Override
  public int getAttackDamage() {
    return this.attackDamage;
  }

  public RoomDynamic getCurrentRoom() {
    return currentRoom;
  }

  public void setCurrentRoom(RoomDynamic currentRoom) {
    this.currentRoom = currentRoom;
  }

}