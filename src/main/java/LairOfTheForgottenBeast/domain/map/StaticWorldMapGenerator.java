package LairOfTheForgottenBeast.domain.map;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;
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
      
      /**
       * Room 1: Sinkhole
       */      
      rooms[0][0][0] = new RoomDynamic(1, "Sinkhole", "The air is moist and earthy. A long, dark hole rises up through the ceiling of this natural cave.");
      rooms[0][0][0].addProp( propFactory.create("Item", "iron sword", "a small shortsword", "a small sword forged from iron. good for cutting things." ) );
      rooms[0][0][0].addProp( propFactory.create("Item", "healing potion", "a potion", "a potion which restores health") );
      
      // Create flammable torch
      Item torch = (Item)propFactory.create("Item", "torch", "a torch", "a torch, used to illuminate dark places or light things on fire");
      Burn torchBurnBehavior = () -> { 
         return "The torch is burning.";
      };
      torch.setBurn(torchBurnBehavior);
      Freeze torchFreezeBehavior = () -> { 
          return "The torch is extinguished.";
       };
       torch.setFreeze(torchFreezeBehavior);
      rooms[0][0][0].addProp(torch);
      
      rooms[0][0][0].addCreature( creatureFactory.create("Human", "Frank") );
      /**
       * Room 2: Web Room
       */   
      rooms[0][1][0] = new RoomDynamic(2, "Web Room", "In this cave, there are webs covering every surface, and you hear a distant sound of skittering.");
      rooms[0][1][0].addCreature( creatureFactory.create("Beast", "Spider") );
      /**
       * Room 3: Open Chamber
       */   
      rooms[0][2][0] = new RoomDynamic(3, "Open Chamber", "This is an open natural chamber with nothing interesting to see here.");
      /**
       * Room 4: Armory
       */   
      rooms[1][0][0] = new RoomDynamic(4, "Armory", "This room is the armory. There are weapons and armor neatly arranged for accessibility in case of an emergency.");
      rooms[1][0][0].addProp( propFactory.create("Item", "bronze sword", "a small shortsword", "a small sword forged from bronze. good for cutting things." ) );
      rooms[1][0][0].addProp( propFactory.create("Item", "bronze dagger", "a large knife", "a large knife for combat." ) );
      rooms[1][0][0].addProp( propFactory.create("Item", "suit of armor", "body armor", "armor like this protects the soldier from attacks.") );
      rooms[1][0][0].addProp( propFactory.create("Item", "helm", "a helm", "a helmet to avoid hits to the head in combat.") );
      
      // Create a flammable Item and add it to the room
      Item bomb = (Item)propFactory.create("Item", "bomb", "a bomb", "a bomb, will explode when ignited");
      Burn bombBurnBehavior = () -> { 
         bomb.setName("pile of rubble"); 
         bomb.setShortDescription("rubble left where a bomb was detonated");
         bomb.setLongDescription("a small pile of rubble left where a bomb was detonated");
         return "The bomb explodes violently!";
      };
      bomb.setBurn(bombBurnBehavior);
      rooms[1][0][0].addProp(bomb);
      
      /**
       * Room 5: Dining Hall
       */   
      rooms[1][1][0] = new RoomDynamic(5, "Dining Hall", "This is the dining hall. Tables and chairs fill the available space.");
      rooms[1][1][0].addProp( propFactory.create("Decoration", "dinner table", "a table.", "a long table for eating." ) );
      rooms[1][1][0].addProp( propFactory.create("Decoration", "chair", "a chair.", "a short bench seat for dining." ) );
      /**
       * Room 6: Library
       */   
      rooms[1][2][0] = new RoomDynamic(6, "Library", "You are in an old, ruined library. Books line every wall, but are completely unreadable due to years of decay.");
      rooms[1][2][0].addProp( propFactory.create("Decoration", "book", "a book.", "a long book that describes creatures that lived a long time ago." ) );
      rooms[1][2][0].addProp( propFactory.create("Decoration", "chair", "a chair.", "a chair for reading." ) );
      /**
       * Room 7: Living Area
       */   
      rooms[2][0][0] = new RoomDynamic(7, "Living Area", "This room is a large living area with furniture.");
      rooms[2][0][0].addCreature( creatureFactory.create("Hobgoblin", "Hemorok") );
      /**
       * Room 8: Barracks
       */   
      rooms[2][1][0] = new RoomDynamic(8, "Barracks", "This is a dorm room that the guards use as barracks.");
      rooms[2][1][0].addCreature( creatureFactory.create("Hobgoblin", "Kuld") );
      /**
       * Room 9: Kitchen
       */   
      rooms[2][2][0] = new RoomDynamic(9, "Kitchen", "The kitchen is a room with an iron pot over a cooking fire.");
      rooms[2][2][0].addProp( propFactory.create("Decoration", "kitchen table", "a kitchen table.", "a long table used to prepare a lot of food." ) );
      rooms[2][2][0].addCreature( creatureFactory.create("Hobgoblin", "Rawra") );
      /**
       * Room 10: Stalagtite Room
       */   
      rooms[0][3][0] = new RoomDynamic(10, "Stalagtite Room", "Icicle-shaped mineral formations hang from the ceiling of this cave. The entire area is wet and puddles of water are scattered throughout.");
      rooms[0][3][0].addProp( propFactory.create("Decoration", "stalagmite", "a stalagmite.", "a long, cone-shaped stone composed of minerals that points up from the floor." ) );
      rooms[0][3][0].addProp( propFactory.create("Decoration", "stalagtite", "a stalagtite.", "a long, cone-shaped stone composed of minerals that points down from the ceiling." ) );
      /**
       * Room 11: Worship Chamber
       */   
      rooms[1][3][0] = new RoomDynamic(11, "Worship Chamber", "This room has been outfitted with religious decor.");
      rooms[1][3][0].addProp( propFactory.create("Item", "obsidian knife", "an obsidian knife", "a ceremonial knife made from volcanic glass." ) );
      rooms[1][3][0].addCreature( creatureFactory.create("Hobgoblin", "Rawra") );
      /**
       * Room 12: Sleeping Area
       */   
      rooms[2][3][0] = new RoomDynamic(12, "Sleeping Area", "This room has several beds that are each surrounded by curtains for privacy.");
      rooms[2][3][0].addProp( propFactory.create("Decoration", "bed", "a bed.", "a bed for sleeping." ) );
      rooms[2][3][0].addCreature( creatureFactory.create("Hobgoblin", "Rawra") );
      /**
       * Room 13: Child Nursery
       */   
      rooms[3][0][0] = new RoomDynamic(13, "Child Nursery", "Wooden toys and small furnishings cover the floor in a room where children sleep or play.");
      rooms[3][0][0].addProp( propFactory.create("Decoration", "crib", "a baby crib.", "a small baby crib." ) );
      rooms[3][0][0].addCreature( creatureFactory.create("Hobgoblin", "Rawra") );
      /**
       * Room 14: Statue Room
       */   
      rooms[3][1][0] = new RoomDynamic(14, "Statue Room", "This quiet room has religious decorations on the walls and a stone statue of a human.");
      rooms[3][1][0].addCreature( creatureFactory.create("Construct", "Statue") );
      /**
       * Room 15: Large Pool
       */   
      rooms[3][2][0] = new RoomDynamic(15, "Large Pool", "As the cave widens, you can see a large room with a pool of water covering most of the ground.");
      rooms[3][2][0].addProp( propFactory.create("Decoration", "pool", "a pool.", "a large pool of water." ) );
      /**
       * Room 16: Cave Collapse
       */   
      rooms[3][3][0] = new RoomDynamic(16, "Cave Collapse", "The passage has led to a large pile of cave rubble in the way. There is barely enough room to squeeze past the blockage.");
      rooms[3][3][0].addProp( propFactory.create("Decoration", "boulder", "a boulder.", "a big blockage of stone." ) );
      
      WorldMap worldMap = new WorldMap(rooms,sizeX,sizeY,sizeZ);
      
      return worldMap;
   }

   @Override
   public WorldMap generateWorldMap(int sizeX, int sizeY, int sizeZ, String options) {
      return generateWorldMap(sizeX, sizeY, sizeZ);
   }
   
}
