package LairOfTheForgottenBeast.domain;

import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.service.SpellService;

/**
 * A wrapper object to save the players current game world state.
 * 
 * @author Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 */
public class GameState {

  @Override
  public String toString() {

    return "GameState [WorldMap=" + WorldMap + ", player=" + player + "]";
  }

  WorldMap WorldMap;
  Player player;
  private SpellService spellService;

  public GameState(WorldMap _3DWorldMap, Player player) {
    this.WorldMap = _3DWorldMap;
    this.player = player;
  }

  public GameState(WorldMap _3DWorldMap, Player player, SpellService spellService) {
    this.WorldMap = _3DWorldMap;
    this.player = player;
    this.spellService = spellService;
  }

  public Player getPlayer() {
    return this.player;
  }

  public WorldMap getWorldMap() {

    return this.WorldMap;

  }

  public SpellService getSpellService() {
    return spellService;
  }

  public void setSpellService(SpellService spellService) {
    this.spellService = spellService;
  }

}
