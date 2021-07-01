package LairOfTheForgottenBeast.domain;

import LairOfTheForgottenBeast.domain.map._3DWorldMap;

public class GameState {
   
   _3DWorldMap _3DWorldMap;
   Player player;
   
   public GameState(_3DWorldMap _3DWorldMap, Player player) {
      this._3DWorldMap = _3DWorldMap;
      this.player = player;
   }

   public Player getPlayer() {
      return this.player;
   }

   public _3DWorldMap getWorldMap() {
      return this._3DWorldMap;
   }
}
