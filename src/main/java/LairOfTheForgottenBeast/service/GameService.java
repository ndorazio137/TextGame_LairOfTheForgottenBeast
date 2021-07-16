package LairOfTheForgottenBeast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import LairOfTheForgottenBeast.domain.CommandDictionary;
import LairOfTheForgottenBeast.domain.CommandInterpreter;
import LairOfTheForgottenBeast.domain.CommandTokenizer;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.StaticWorldMapGenerator;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.WorldMapGenerator;
import LairOfTheForgottenBeast.domain.map.rooms.RoomRepository;

public class GameService
{
   @Autowired
   RoomRepository roomRepository;
   private CommandTokenizer commandTokenizer = new CommandTokenizer();
   private CommandDictionary commandDictionary = new CommandDictionary();
   private CommandInterpreter commandInterpreter = new CommandInterpreter(commandDictionary);
   private WorldMapGenerator worldMapGenerator = new StaticWorldMapGenerator();
   private WorldMap worldMap = worldMapGenerator.generateWorldMap(4,4,1); 
   private Player player = this.generatePlayer();
   private SpellService spellService = new SpellService();
   private GameState gameState = new GameState(worldMap,player,spellService);
   
   public String processCommand(String publicCommand)
   {
      List<String> pubTokens = commandTokenizer.tokenize(publicCommand);
      String pubInterpretation = commandInterpreter.processCommand(gameState,pubTokens);
      return pubInterpretation;
   }
   
   // THIS IS HARDCODED FOR NOW BUT MUST BE IMPROVED LATER
   public Player generatePlayer() {
      Player player = new Player();
      player.setName("Player");
      player.setMaxHitPoints(100);
      player.setCurrentHitPoints(100);
      player.setAttackDamage(1);
      player.setCurrentRoom(this.worldMap.getRoom(0,0,0));
      return player;
   }
   
   public Player getPlayer() {
      return this.player;
   }

   public GameState getGameState() {
      return gameState;
   }
}