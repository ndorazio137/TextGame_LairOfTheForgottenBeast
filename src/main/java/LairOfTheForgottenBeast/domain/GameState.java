package LairOfTheForgottenBeast.domain;

import LairOfTheForgottenBeast.domain.map.WorldMap;

public class GameState {
   
   WorldMap worldMap;
   Player player;
   
   public GameState(WorldMap worldMap, Player player) {
      this.worldMap = worldMap;
      this.player = player;
   }

   public Player getPlayer() {
      return this.player;
   }

   public WorldMap getWorldMap() {
      return this.worldMap;
   }
}