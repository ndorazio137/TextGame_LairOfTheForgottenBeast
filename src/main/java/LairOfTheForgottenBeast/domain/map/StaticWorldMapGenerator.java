package LairOfTheForgottenBeast.domain.map;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.domain.prop.Prop;
import LairOfTheForgottenBeast.factory.CreatureFactory;
import LairOfTheForgottenBeast.factory.PropFactory;

public class StaticWorldMapGenerator implements WorldMapGenerator {
   
   PropFactory propFactory = new PropFactory();
   CreatureFactory creatureFactory = new CreatureFactory();
   
   @Override
   public WorldMap generateWorldMap(int sizeX, int sizeY, int sizeZ) {
      RoomDynamic[][][] rooms = new RoomDynamic[sizeX][sizeY][sizeZ];
      
      rooms[0][0][0] = new RoomDynamic(1, "Sinkhole", "The air is moist and earthy. A long, dark hole rises up through the ceiling of this natural cave.");
      rooms[0][1][0] = new RoomDynamic(2, "Web Room", "In this cave, there are webs covering every surface, and you hear a distant sound of skittering.");
      rooms[0][2][0] = new RoomDynamic(3, "Open Chamber", "This is an open natural chamber with nothing interesting to see here.");
      rooms[1][0][0] = new RoomDynamic(4, "Armory", "This room is the armory. There are weapons and armor neatly arranged for accessibility in case of an emergency.");
      rooms[1][1][0] = new RoomDynamic(5, "Dining Hall", "This is the dining hall. Tables and chairs fill the available space.");
      rooms[1][2][0] = new RoomDynamic(6, "Library", "You are in a library. Books line every wall.");
      rooms[2][0][0] = new RoomDynamic(7, "Living Area", "This room is a large living area with furniture.");
      rooms[2][1][0] = new RoomDynamic(8, "Barracks", "This is a dorm room that the guards use as barracks.");
      rooms[2][2][0] = new RoomDynamic(9, "Kitchen", "The kitchen is a room with an iron pot over a cooking fire.");
      
      rooms[0][3][0] = new RoomDynamic(10, "Stalagtite Room", "Icicle-shaped mineral formations hang from the ceiling of this cave. The entire area is wet and puddles of water are scattered throughout.");
      rooms[1][3][0] = new RoomDynamic(11, "Worship Chamber", "This room has been outfitted with religious decor.");
      rooms[2][3][0] = new RoomDynamic(12, "Sleeping Area", "This room has several beds that are each surrounded by curtains for privacy.");
      rooms[3][0][0] = new RoomDynamic(13, "Child Nursery", "Wooden toys and small furnishings cover the floor in a room where children sleep or play.");
      rooms[3][1][0] = new RoomDynamic(14, "Statue Room", "This quiet room has religious decorations on the walls and a stone statue of a human.");
      rooms[3][2][0] = new RoomDynamic(15, "Large Pool", "As the cave widens, you can see a large room with a pool of water covering most of the ground.");
      rooms[3][3][0] = new RoomDynamic(16, "Cave Collapse", "The passage has led to a large pile of cave rubble in the way. There is barely enough room to squeeze past the blockage.");
      
      
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
               rooms[x][y][z].addCreature( creatureFactory.create("Human", "Frank", "a human", "Humans are known for their adaptability." ) );
               rooms[x][y][z].addCreature( creatureFactory.create("Hobgoblin", "Burbar", "a hobgoblin", "Hobgoblins are human-sized goblins.") );
               rooms[x][y][z].addCreature( creatureFactory.create("Construct", "Statue", "a statue", "This statue depicts a soldier with a weapon and shield.") );
               
               Item flammableTestProp = (Item)propFactory.create("Item", "bomb", "a bomb", "a bomb, will explode when ignited");
               Burn burnBehavior = () -> { 
            	   flammableTestProp.setName("pile of rubble"); 
            	   flammableTestProp.setShortDescription("rubble left where a bomb was detonated");
            	   flammableTestProp.setLongDescription("a small pile of rubble left where a bomb was detonated");
            	   return "The bomb explodes violently!";
               };
               flammableTestProp.setBurn(burnBehavior);
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
