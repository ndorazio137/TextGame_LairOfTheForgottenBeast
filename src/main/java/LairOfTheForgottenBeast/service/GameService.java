package LairOfTheForgottenBeast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import LairOfTheForgottenBeast.domain.CommandInterpreter;
import LairOfTheForgottenBeast.domain.CommandTokenizer;
import LairOfTheForgottenBeast.domain.GameState;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map._3DWorldMap;
import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomRepository;

public class GameService
{
   @Autowired
   RoomRepository roomRepository;
   private CommandTokenizer commandTokenizer = new CommandTokenizer();
   private CommandInterpreter commandInterpreter = new CommandInterpreter();
   _3DWorldMap _3DWorldMap = this.generateWorldMap(3,3,1); 
   Player player = this.generatePlayer();
   GameState gameState = new GameState(_3DWorldMap,player);
   
   
   public String processCommand(String publicCommand)
   {
      List<String> pubTokens = commandTokenizer.tokenize(publicCommand);
      String pubInterpretation = commandInterpreter.processCommand(gameState,pubTokens);
      return pubInterpretation;
   }
   
   
   // This is a little better than before, but it still needs to be improved later.
   public _3DWorldMap generateWorldMap(int sizeX, int sizeY, int sizeZ) {
      Room[][][] rooms = new Room[sizeX][sizeY][sizeZ];
      
      rooms[0][0][0] = new Room(1, "Sinkhole", "The air is moist and earthy.");
      rooms[0][1][0] = new Room(2, "Web Room", "There are webs covering every surface, and you hear a distant sound of skittering.");
      rooms[0][2][0] = new Room(3, "Open Chamber", "This is an open chamber with nothing exciting to see here.");
      rooms[1][0][0] = new Room(4, "Armory", "This room is the armory. There are weapons and armor neatly arranged for accessibility in case of an emergency.");
      rooms[1][1][0] = new Room(5, "Dining Hall", "This is the dining hall.");
      rooms[1][2][0] = new Room(6, "Library", "You are in a library.");
      rooms[2][0][0] = new Room(7, "Living Area", "This is a large living area with furniture.");
      rooms[2][1][0] = new Room(8, "Barracks", "This is a dorm room that the guards use as barracks.");
      rooms[2][2][0] = new Room(9, "Kitchen", "The kitchen is a room with an iron pot over a cooking fire.");
      
//      List<Room> roomList = roomRepository.findAllOrderByIdDesc();
//      int roomListIndex = 0;
//      for (int z = 0; z < sizeZ; z++) {
//         for (int y = 0; y < sizeY; y++) {
//            for (int x = 0; x < sizeX; x++) {
//               rooms[x][y][z] = roomList.get(roomListIndex++);
//            }
//         }
//      }
//      
//      WorldMap worldMap = new WorldMap(rooms, sizeX, sizeY, sizeZ);
      _3DWorldMap _3DWorldMap = new _3DWorldMap(rooms,3,3,1);
      
      return _3DWorldMap;
   }
   // THIS IS ALSO HARDCODED FOR NOW BUT MUST BE IMPROVED LATER
   public Player generatePlayer() {
      Player player = new Player();
      player.setName("Player");
      player.setCurrentRoom(this._3DWorldMap.getRoom(0,0,0));
      return player;
   }

   
   public Player getPlayer() {
      return this.player;
   }
}