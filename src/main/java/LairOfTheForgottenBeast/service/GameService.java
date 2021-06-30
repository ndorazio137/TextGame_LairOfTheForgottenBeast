package LairOfTheForgottenBeast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import LairOfTheForgottenBeast.domain.CommandInterpreter;
import LairOfTheForgottenBeast.domain.CommandTokenizer;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.Room;
import LairOfTheForgottenBeast.domain.map.RoomRepository;
import LairOfTheForgottenBeast.domain.map.StaticWorldMapGenerator;
import LairOfTheForgottenBeast.domain.map.WorldMap;
import LairOfTheForgottenBeast.domain.map.WorldMapGenerator;

public class GameService
{
   @Autowired
   RoomRepository roomRepository;
   private CommandTokenizer commandTokenizer = new CommandTokenizer();
   private CommandInterpreter commandInterpreter = new CommandInterpreter();
   private WorldMapGenerator worldMapGenerator = new StaticWorldMapGenerator();
   private WorldMap worldMap = worldMapGenerator.generateWorldMap(4,4,1); 
   private Player player = this.generatePlayer();
   private GameState gameState = new GameState(worldMap,player);
   
   
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