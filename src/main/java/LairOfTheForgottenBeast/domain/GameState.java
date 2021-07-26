package LairOfTheForgottenBeast.domain;

import java.util.HashMap;
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

    return "GameState [WorldMap=" + WorldMap + ", playerMap=" + playerMap + "]";
  }

  WorldMap WorldMap;
  HashMap<String, Player> playerMap;
  private SpellService spellService;

  public GameState(WorldMap _3DWorldMap, HashMap<String, Player> playerMap) {
    this.WorldMap = _3DWorldMap;
    this.playerMap = playerMap;
  }

  public GameState(WorldMap _3DWorldMap, HashMap<String, Player> playerMap,
      SpellService spellService) {
    this.WorldMap = _3DWorldMap;
    this.playerMap = playerMap;
    this.spellService = spellService;
  }

  public WorldMap getWorldMap() {
    return WorldMap;
  }

  public void setWorldMap(WorldMap worldMap) {
    WorldMap = worldMap;
  }

  public HashMap<String, Player> getPlayerMap() {
    return playerMap;
  }

  public void setPlayerMap(HashMap<String, Player> playerMap) {
    this.playerMap = playerMap;
  }

  public SpellService getSpellService() {
    return spellService;
  }

  public void setSpellService(SpellService spellService) {
    this.spellService = spellService;
  }

}
