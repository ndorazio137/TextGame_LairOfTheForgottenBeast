package LairOfTheForgottenBeast.domain;

import LairOfTheForgottenBeast.domain.map.WorldMap;

public class GameState {
   
   WorldMap WorldMap;
   Player player;
   
   public GameState(WorldMap _3DWorldMap, Player player) {
      this.WorldMap = _3DWorldMap;
      this.player = player;
   }

   public Player getPlayer() {
      return this.player;
   }

   public WorldMap getWorldMap() {
      return this.WorldMap;
   }
}