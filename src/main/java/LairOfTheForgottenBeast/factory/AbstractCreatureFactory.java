package LairOfTheForgottenBeast.factory;

import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;

public interface AbstractCreatureFactory<T> {

  T create(String creatureType, String name, String shortDesc, String longDesc, int attackDamage,
      int currentHitPoints, int maxHitPoints, RoomDynamic room);

  T create(String creatureType, String name, String shortDesc, String longDesc, Item weapon,
      int attackDamage, int currentHitPoints, int maxHitPoints, RoomDynamic room);

  T create(String creatureType, RoomDynamic room);

}