package LairOfTheForgottenBeast.domain.map;

import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Prop;
import LairOfTheForgottenBeast.factory.PropFactory;

public class StaticWorldMapGenerator implements WorldMapGenerator {
   
   PropFactory propFactory = new PropFactory();
   
   @Override
   public WorldMap generateWorldMap(int sizeX, int sizeY, int sizeZ) {
      RoomDynamic[][][] rooms = new RoomDynamic[sizeX][sizeY][sizeZ];
      
      rooms[0][0][0] = new RoomDynamic(1, "Sinkhole", "The air is moist and earthy.");
      rooms[0][1][0] = new RoomDynamic(2, "Web Room", "There are webs covering every surface, and you hear a distant sound of skittering.");
      rooms[0][2][0] = new RoomDynamic(3, "Open Chamber", "This is an open chamber with nothing exciting to see here.");
      rooms[1][0][0] = new RoomDynamic(4, "Armory", "This room is the armory. There are weapons and armor neatly arranged for accessibility in case of an emergency.");
      rooms[1][1][0] = new RoomDynamic(5, "Dining Hall", "This is the dining hall.");
      rooms[1][2][0] = new RoomDynamic(6, "Library", "You are in a library.");
      rooms[2][0][0] = new RoomDynamic(7, "Living Area", "This is a large living area with furniture.");
      rooms[2][1][0] = new RoomDynamic(8, "Barracks", "This is a dorm room that the guards use as barracks.");
      rooms[2][2][0] = new RoomDynamic(9, "Kitchen", "The kitchen is a room with an iron pot over a cooking fire.");
      
      rooms[0][3][0] = new RoomDynamic(10, "Sinkhole 2", "The air is moist and earthy.");
      rooms[1][3][0] = new RoomDynamic(11, "Web Room 2", "There are webs covering every surface, and you hear a distant sound of skittering.");
      rooms[2][3][0] = new RoomDynamic(12, "Open Chamber 2", "This is an open chamber with nothing exciting to see here.");
      rooms[3][0][0] = new RoomDynamic(13, "Armory 2", "This room is the armory. There are weapons and armor neatly arranged for accessibility in case of an emergency.");
      rooms[3][1][0] = new RoomDynamic(14, "Dining Hall 2", "This is the dining hall.");
      rooms[3][2][0] = new RoomDynamic(15, "Library 2", "You are in a library.");
      rooms[3][3][0] = new RoomDynamic(16, "Living Area 2", "This is a large living area with furniture.");
      
      
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
      
      //fill rooms with Props, then eventually Creatures
      
      // Currently, only using the default propFactory.create method to create
      // the same static set of static default props in every room.
      for (int z = 0; z < sizeZ; z++) {
         for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
               rooms[x][y][z].addProp( propFactory.create("Item", "iron sword", "a small shortsword", "a small sword forged from iron. good for cutting things.") );
               rooms[x][y][z].addProp( propFactory.create("Item", "healing potion", "a potion", "a potion which restores health") );
               rooms[x][y][z].addProp( propFactory.create("Item", "torch", "a torch", "a torch, used to illuminate dark places or light things on fire") );
            }
         }
      }
      
      
      WorldMap worldMap = new WorldMap(rooms,sizeX,sizeY,sizeZ);
      
      return worldMap;
   }

   @Override
   public WorldMap generateWorldMap(int sizeX, int sizeY, int sizeZ, String options) {
      return generateWorldMap(sizeX, sizeY, sizeZ);
   }
   
}
