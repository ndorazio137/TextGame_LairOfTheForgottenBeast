package LairOfTheForgottenBeast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import LairOfTheForgottenBeast.domain.CommandInterpreter;
import LairOfTheForgottenBeast.domain.CommandTokenizer;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.Room;
import LairOfTheForgottenBeast.domain.map.RoomRepository;
import LairOfTheForgottenBeast.domain.map.WorldMap;

public class GameService
{
   private CommandTokenizer commandTokenizer = new CommandTokenizer();
   private CommandInterpreter commandInterpreter = new CommandInterpreter();
   WorldMap worldMap = this.generateWorldMap(); // TODO: generate the world map. This should be the last thing we need to get the player exploring.
   Player player = this.generatePlayer();
   GameState gameState = new GameState(worldMap,player);
   RoomRepository roomRepository;
   
   public String processCommand(String publicCommand)
   {
      List<String> pubTokens = commandTokenizer.tokenize(publicCommand);
      String pubInterpretation = commandInterpreter.processCommand(gameState,pubTokens);
      return pubInterpretation;
   }
   
   
   
   
   // THIS IS A TEMPORARY MAP GENERATION METHOD TO ENABLE FURTHER TESTING AND DEVELOPMENT.
   // THIS WILL NEED TO BE UPDATED LATER, AND BE CAREFUL NOT TO BUILD ANYTHING OFF OF THIS
   // THAT DEPENDS ON IT FUNCTIONING THE WAY IT DOES!!! THIS IS BAD AND MUST CHANGE SOON!!!
   public WorldMap generateWorldMap() {
      Room[][][] rooms = new Room[3][3][3];
      
      rooms[0][0][0] = new Room(1, "Sinkhole", "The air is moist and earthy.");
      rooms[0][1][0] = new Room(2, "Web Room", "There are webs covering every surface, and you hear a distant sound of skittering.");
      rooms[0][2][0] = new Room(3, "Open Chamber", "This is an open chamber with nothing exciting to see here.");
      rooms[1][0][0] = new Room(4, "Armory", "This room is the armory. There are weapons and armor neatly arranged for accessibility in case of an emergency.");
      rooms[1][1][0] = new Room(5, "Dining Hall", "This is the dining hall.");
      rooms[1][2][0] = new Room(6, "Library", "You are in a library.");
      rooms[2][0][0] = new Room(7, "Living Area", "This is a large living area with furniture.");
      rooms[2][1][0] = new Room(8, "Barracks", "This is a dorm room that the guards use as barracks.");
      rooms[2][2][0] = new Room(9, "Kitchen", "The kitchen is a room with an iron pot over a cooking fire.");
      
      WorldMap worldMap = new WorldMap(rooms, 3);
      
      return worldMap;
   }
   // THIS IS ALSO HARDCODED FOR NOW BUT MUST BE IMPROVED LATER
   public Player generatePlayer() {
      Player player = new Player();
      player.setName("Steve");
      player.setCurrentRoom(this.worldMap.getRoom(0,0,0));
      return player;
   }

   
   public Player getPlayer() {
      return this.player;
   }
}