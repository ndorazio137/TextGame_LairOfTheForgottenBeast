package LairOfTheForgottenBeast.domain.map;

import LairOfTheForgottenBeast.domain.Burn;
import LairOfTheForgottenBeast.domain.Freeze;
import LairOfTheForgottenBeast.domain.OnAttacked;
import LairOfTheForgottenBeast.domain.OnExamined;
import LairOfTheForgottenBeast.domain.OnTalk;
import LairOfTheForgottenBeast.domain.creature.Creature;
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.prop.Decoration;
import LairOfTheForgottenBeast.domain.prop.Item;
import LairOfTheForgottenBeast.factory.CreatureFactory;
import LairOfTheForgottenBeast.factory.PropFactory;

public class StaticWorldMapGenerator implements WorldMapGenerator {

  PropFactory propFactory = new PropFactory();
  CreatureFactory creatureFactory = new CreatureFactory();
  Burn torchBurnBehavior = () -> {
    return "The torch is burning.";
  };
  Burn candleBurnBehavior = () -> {
    return "The candle is burning.";
  };
  Freeze torchFreezeBehavior = () -> {
    return "The torch is extinguished.";
  };
  Freeze candleFreezeBehavior = () -> {
    return "The candle is extinguished.";
  };
  
  @Override
  public WorldMap generateWorldMap(int sizeX, int sizeY, int sizeZ) {
    RoomDynamic[][][] rooms = new RoomDynamic[sizeX][sizeY][sizeZ];

    /**
     * Walls:
     */
    rooms[0][4][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[0][5][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[0][6][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[0][7][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[1][1][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[1][2][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[1][5][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[1][6][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[1][7][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[2][3][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[2][7][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[3][1][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[3][3][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[3][4][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[3][5][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[3][7][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[4][0][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[4][1][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[4][5][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[4][7][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[5][0][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[5][1][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[5][3][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[6][0][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[6][1][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[6][5][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[6][7][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[7][0][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[7][1][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[7][3][0] = new RoomDynamic(63, "Wall", "This is a wall.");
    rooms[7][5][0] = new RoomDynamic(63, "Wall", "This is a wall.");

    /**
     * Room 1: Sinkhole
     */
    createSinkholeRoom(rooms);

    /**
     * Room 2: Web Room
     */
    createWebRoom(rooms);

    /**
     * Room 3: Open Chamber
     */
    createOpenChamberRoom(rooms);

    /**
     * Room 4: Armory
     */
    createArmoryRoom(rooms);

    /**
     * Room 5: Dining Hall
     */
    createDiningHallRoom(rooms);

    /**
     * Room 6: Library
     */
    createLibraryRoom(rooms);

    /**
     * Room 7: Living Area
     */
    createLivingAreaRoom(rooms);

    /**
     * Room 8: Barracks
     */
    createBarracksRoom(rooms);

    /**
     * Room 9: Kitchen
     */
    createKitchenRoom(rooms);

    /**
     * Room 10: Stalagtite Room
     */
    createStalagtiteRoom(rooms);

    /**
     * Room 11: Worship Chamber
     */
    createWorshipChamberRoom(rooms);
    
    /**
     * Room 12: Sleeping Area
     */
    createSleepingAreaRoom(rooms);

    /**
     * Room 13: Child Nursery
     */
    createChildNurseryRoom(rooms);

    /**
     * Room 14: Statue Room
     */
    createStatueRoom(rooms);

    /**
     * Room 15: Large Pool
     */
    createLargePoolRoom(rooms);
    
    /**
     * Room 16: Cave Collapse
     */
    createCaveCollapseRoom(rooms);
    
    /**
     * Room 17: Natural Cavern 17
     */
    createNaturalCavern17(rooms);
    
    /**
     * Room 18: Natural Cavern 18
     */
    createNaturalCavern18(rooms);
    
    /**
     * Room 19: Natural Cavern 19
     */
    createNaturalCavern19(rooms);
    
    /**
     * Room 20: Natural Cavern 20
     */
    createNaturalCavern20(rooms);
    
    /**
     * Room 21: Mushroom Cave
     */
    createMushroomCave(rooms);

    /**
     * Room 22: Natural Cavern 22
     */
    createNaturalCavern22(rooms);
    
    /**
     * Room 23: Natural Cavern 23
     */
    createNaturalCavern23(rooms);
    
    /**
     * Room 24: Natural Cavern 24
     */
    createNaturalCavern24(rooms);
    
    /**
     * Room 25: Natural Cavern 25
     */
    createNaturalCavern25(rooms);
    
    /**
     * Room 26: Developed Area 26
     */
    createDevelopedArea26(rooms);

    /**
     * Room 27: Developed Area 27
     */
    createDevelopedArea27(rooms);

    /**
     * Room 28: Developed Area 28
     */
    createDevelopedArea28(rooms);

    /**
     * Room 29: Developed Area 29
     */
    createDevelopedArea29(rooms);
    
    /**
     * Room 30: Developed Area 30
     */
    createDevelopedArea30(rooms);

    /**
     * Room 31: Developed Area 31
     */
    createDevelopedArea31(rooms);

    /**
     * Room 32: Developed Area 32
     */
    createDevelopedArea32(rooms);

    /**
     * Room 64: Lair of the Forgotten Beast
     */
    createLairOfTheForgottenBeast(rooms);

    WorldMap worldMap = new WorldMap(rooms, sizeX, sizeY, sizeZ);
    return worldMap;
  }
  
  public void createSinkholeRoom(RoomDynamic[][][] rooms) {
    rooms[0][0][0] = new RoomDynamic(1, "Sinkhole",
        "The air is moist and earthy. A long, dark hole rises up through the ceiling of this "
        + "natural cave. There are a series of arcane runes carved into one wall alongside a "
        + "picture that looks like a ball of fire. The runes read, \"invoke INDRA PYRO SHUF\"");
    rooms[0][0][0].addProp(propFactory.create("Item", "iron sword"));
    rooms[0][0][0].addProp(propFactory.create("Item", "healing potion"));
    Item weapon1 = (Item) propFactory.create("Item", "iron sword");
    Creature frank = creatureFactory.create("Human", "Frank", "Frank is a human",
        "Frank is a human soldier", weapon1, 1, 10, 10, rooms[0][0][0]);
    String frankSpeechText =
        "\"Another human! And you don't look like one of the Beast Cultists... Hello. My name is "
        + "Frank. I was a soldier until I fell down here. I could really use your help escaping. "
        + "If you want to get out of here, you will have to find the \'giant vault\' that contains "
        + "a horrible monster called the Forgotten Beast. To open the vault, you'll have to answer "
        + "a riddle. Either you can figure it out yourself, or you can find and slay 3 Beast "
        + "Cultists who each guard one of the 3 fragments of the answer. In any case, good luck on "
        + "your journey!";
    frank.setSpeechText(frankSpeechText);
    frank.setCurrentRoom(rooms[0][0][0]);
    rooms[0][0][0].addCreature(frank);
    
    // Create flammable torch
    Item torch = (Item) propFactory.create("Item", "torch");
    torch.setBurn(torchBurnBehavior);
    torch.setFreeze(torchFreezeBehavior);
    rooms[0][0][0].addProp(torch);
  }
  
  public void createWebRoom(RoomDynamic[][][] rooms) {
    rooms[0][2][0] = new RoomDynamic(2, "Web Room",
        "In this cave, there are webs covering every surface, and you hear a distant sound of skittering.");
    rooms[0][2][0].addCreature(creatureFactory.create("Spider", rooms[0][2][0]));
    // Create glowing mushroom
    rooms[0][2][0].addProp(propFactory.create("Item", "glowing mushroom"));
    rooms[0][2][0].addProp(propFactory.create("Item", "chewed scroll"));
    rooms[0][2][0].addProp(propFactory.create("Item", "chilled scroll"));
  }
  
  public void createOpenChamberRoom(RoomDynamic[][][] rooms) {
    rooms[0][1][0] = new RoomDynamic(3, "Open Chamber",
        "This is an open natural chamber with nothing interesting to see here.");
    rooms[0][1][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createArmoryRoom(RoomDynamic[][][] rooms) {
    rooms[6][3][0] = new RoomDynamic(4, "Armory",
        "This room is the armory. There are weapons and armor neatly arranged for accessibility in case of an emergency.");
    rooms[6][3][0].addProp(propFactory.create("Item", "bronze sword"));
    rooms[6][3][0].addProp(propFactory.create("Item", "bronze dagger"));
    rooms[6][3][0].addProp(propFactory.create("Item", "armor"));
    rooms[6][3][0].addProp(propFactory.create("Item", "helm"));
    // Create flammable torch
    Item torch4 = (Item) propFactory.create("Item", "torch");
    torch4.setBurn(torchBurnBehavior);
    torch4.setFreeze(torchFreezeBehavior);
    rooms[6][3][0].addProp(torch4);
    // Create a flammable Item and add it to the room
    Item bomb =
        (Item) propFactory.create("Item", "bomb", "a bomb", "a bomb, will explode when ignited");
    Burn bombBurnBehavior = () -> {
      bomb.setName("pile of rubble");
      bomb.setShortDescription("rubble left where a bomb was detonated");
      bomb.setLongDescription("a small pile of rubble left where a bomb was detonated");
      return "The bomb explodes violently!";
    };
    bomb.setBurn(bombBurnBehavior);
    rooms[6][3][0].addProp(bomb);
    // Create a flammable Item and add it to the room
    Item lifeDrainDagger = (Item) propFactory.create("Item", "meanacing dagger");
    rooms[6][3][0].addProp(lifeDrainDagger);
  }
  
  public void createDiningHallRoom(RoomDynamic[][][] rooms) {
    rooms[4][4][0] = new RoomDynamic(5, "Dining Hall",
        "This is the dining hall. Furniture and dishes are the main features.");
    rooms[4][4][0].addProp(propFactory.create("Decoration", "dinner table"));
    rooms[4][4][0].addProp(propFactory.create("Decoration", "chair"));
    rooms[4][4][0].addProp(propFactory.create("Decoration", "chair"));
    rooms[4][4][0].addProp(propFactory.create("Decoration", "chair"));
    rooms[4][4][0].addProp(propFactory.create("Decoration", "chair"));
    rooms[4][4][0].addProp(propFactory.create("Item", "bowl"));
    rooms[4][4][0].addProp(propFactory.create("Item", "spoon"));
    rooms[4][4][0].addProp(propFactory.create("Item", "bowl"));
    rooms[4][4][0].addProp(propFactory.create("Item", "spoon"));
    rooms[4][4][0].addProp(propFactory.create("Item", "bowl"));
    rooms[4][4][0].addProp(propFactory.create("Item", "spoon"));
    rooms[4][4][0].addProp(propFactory.create("Item", "bowl"));
    rooms[4][4][0].addProp(propFactory.create("Item", "spoon"));
    // Create flammable torch
    Item torch5 = (Item) propFactory.create("Item", "torch");
    torch5.setBurn(torchBurnBehavior);
    torch5.setFreeze(torchFreezeBehavior);
    rooms[4][4][0].addProp(torch5);
    // Create flammable candle
    Item candle5 = (Item) propFactory.create("Item", "candle");
    candle5.setBurn(candleBurnBehavior);
    candle5.setFreeze(candleFreezeBehavior);
    rooms[4][4][0].addProp(candle5);
  }
  
  public void createLibraryRoom(RoomDynamic[][][] rooms) {
    rooms[4][6][0] = new RoomDynamic(6, "Library",
        "You are in an old, ruined library. Books line every wall, but are completely unreadable due to years of decay.");
    rooms[4][6][0].addProp(propFactory.create("Decoration", "bookshelf"));
    rooms[4][6][0].addProp(propFactory.create("Decoration", "bookshelf"));
    rooms[4][6][0].addProp(propFactory.create("Decoration", "bookshelf"));
    rooms[4][6][0].addProp(propFactory.create("Decoration", "bookshelf"));
    for (int i = 0; i < 103; i++)
      rooms[4][6][0].addProp(propFactory.create("Item", "ruined book"));
    rooms[4][6][0].addProp(propFactory.create("Item", "green book", "a book.",
        "a long book that describes creatures that lived a long time ago."));
    rooms[4][6][0].addProp(propFactory.create("Item", "yellow book", "a book.",
        "a long book that describes local citizenry that lived a long time ago."));
    rooms[4][6][0].addProp(propFactory.create("Item", "red book", "a book.",
        "a long book that describes foreign nations that lived a long time ago."));
    rooms[4][6][0].addProp(propFactory.create("Item", "blue book", "a book.",
        "a long book that describes royal families that lived a long time ago."));
    rooms[4][6][0].addProp(propFactory.create("Decoration", "chair"));
    // Create flammable torch
    Item torch6 = (Item) propFactory.create("Item", "torch");
    torch6.setBurn(torchBurnBehavior);
    torch6.setFreeze(torchFreezeBehavior);
    rooms[4][6][0].addProp(torch6);
    // Create flammable candle
    Item candle6 = (Item) propFactory.create("Item", "candle");
    candle6.setBurn(candleBurnBehavior);
    candle6.setFreeze(candleFreezeBehavior);
    rooms[4][6][0].addProp(candle6);
    // Beast Cultist is holding one of the riddle clues.
    rooms[4][6][0].addCreature(creatureFactory.create("Cultist Regmur", rooms[4][6][0]));
    rooms[4][6][0].addProp(propFactory.create("Item", "ruined scroll"));
    rooms[4][6][0].addProp(propFactory.create("Item", "torn scroll"));
    rooms[4][6][0].addProp(propFactory.create("Item", "scorched scroll"));
    rooms[4][6][0].addProp(propFactory.create("Item", "wet scroll"));
  }
  
  public void createLivingAreaRoom(RoomDynamic[][][] rooms) {
    rooms[6][4][0] =
        new RoomDynamic(7, "Living Area", "This room is a large living area with furniture.");
    Item weapon7 = new Item("bronze sword", "a small shortsword",
        "a small sword forged from bronze. good for cutting things.", 1);
    rooms[6][4][0].addCreature(creatureFactory.create("Hobgoblin", "Hemorok", "a hobgoblin",
        "A hobgoblin wielding a bronze shortsword. They appear to be hostile.", weapon7, 1, 10, 10,
        rooms[6][4][0]));
    // Create flammable torch
    Item torch7 = (Item) propFactory.create("Item", "torch");
    torch7.setBurn(torchBurnBehavior);
    torch7.setFreeze(torchFreezeBehavior);
    rooms[6][4][0].addProp(torch7);
    // Create flammable candle
    Item candle7 = (Item) propFactory.create("Item", "candle");
    candle7.setBurn(candleBurnBehavior);
    candle7.setFreeze(candleFreezeBehavior);
    rooms[6][4][0].addProp(candle7);
    rooms[6][4][0].addProp(propFactory.create("Decoration", "chair"));
    rooms[6][4][0].addProp(propFactory.create("Decoration", "chair"));
    rooms[6][4][0].addProp(propFactory.create("Decoration", "chair"));
    rooms[6][4][0].addProp(propFactory.create("Decoration", "chair"));
  }
  
  public void createBarracksRoom(RoomDynamic[][][] rooms) {
    rooms[6][2][0] =
        new RoomDynamic(8, "Barracks", "This is a dorm room that the guards use as barracks.");
    rooms[6][2][0].addProp(propFactory.create("Decoration", "bed"));
    rooms[6][2][0].addProp(propFactory.create("Decoration", "bed"));
    rooms[6][2][0].addProp(propFactory.create("Decoration", "bed"));
    rooms[6][2][0].addProp(propFactory.create("Decoration", "bed"));
    Item weapon8 = new Item("bronze sword", "a small shortsword",
        "a small sword forged from bronze. good for cutting things.", 1);
    rooms[6][2][0].addCreature(creatureFactory.create("Hobgoblin", "Kuld", "a hobgoblin",
        "A hobgoblin wielding a bronze shortsword. They appear to be hostile.", weapon8, 1, 10, 10,
        rooms[6][2][0]));
    // Create flammable torch
    Item torch8 = (Item) propFactory.create("Item", "torch");
    torch8.setBurn(torchBurnBehavior);
    torch8.setFreeze(torchFreezeBehavior);
    rooms[6][2][0].addProp(torch8);
  }
  
  public void createKitchenRoom(RoomDynamic[][][] rooms) {
    rooms[5][4][0] = new RoomDynamic(9, "Kitchen",
        "You smell food in the air. This room is warmer than the rest.");
    rooms[5][4][0].addProp(propFactory.create("Decoration", "kitchen table", "a kitchen table.",
        "a long table used to prepare a lot of food."));
    rooms[5][4][0].addProp(propFactory.create("Item", "kitchen knife"));
    rooms[5][4][0].addProp(propFactory.create("Item", "serving scoop"));
    rooms[5][4][0].addProp(propFactory.create("Item", "lamb shank"));
    rooms[5][4][0].addProp(propFactory.create("Item", "bowl"));
    rooms[5][4][0].addProp(propFactory.create("Item", "spoon"));
    Item weapon9 = new Item("bronze sword", "a small shortsword",
        "a small sword forged from bronze. good for cutting things.", 1);
    rooms[5][4][0].addCreature(creatureFactory.create("Hobgoblin", "Riso", "a hobgoblin",
        "A hobgoblin wielding a bronze shortsword. They appear to be hostile.", weapon9, 1, 10, 10,
        rooms[5][4][0]));
    // Create flammable torch
    Item torch9 = (Item) propFactory.create("Item", "torch");
    torch9.setBurn(torchBurnBehavior);
    torch9.setFreeze(torchFreezeBehavior);
    rooms[5][4][0].addProp(torch9);
    Item ironPot = (Item) propFactory.create("Item", "iron pot");
    rooms[5][4][0].addProp(ironPot);
    // Create flammable cooking fire
    Decoration cookingFire = (Decoration) propFactory.create("Decoration", "cooking fire");
    Burn cookingFireBurnBehavior = () -> {
      cookingFire.setLongDescription(
          "a fire built in a kitchen area to boil the liquid in a cooking pot. The fire is burning.");
      return "The cooking fire is burning.";
    };
    cookingFire.setBurn(cookingFireBurnBehavior);
    Freeze cookingFireFreezeBehavior = () -> {
      cookingFire.setLongDescription(
          "a fire built in a kitchen area to boil the liquid in a cooking pot. The fire is currently extinguished.");
      return "The cooking fire is extinguished.";
    };
    cookingFire.setFreeze(cookingFireFreezeBehavior);
    rooms[5][4][0].addProp(cookingFire);
    rooms[5][4][0].addProp(propFactory.create("Item", "scorched scroll"));
    rooms[5][4][0].addProp(propFactory.create("Item", "chilled scroll"));
  }
  
  public void createStalagtiteRoom(RoomDynamic[][][] rooms) {
    rooms[1][0][0] = new RoomDynamic(10, "Stalagtite Room",
        "Icicle-shaped mineral formations hang from the ceiling of this cave. The entire area is wet and puddles of water are scattered throughout.");
    rooms[1][0][0].addProp(propFactory.create("Decoration", "stalagmite", "a stalagmite.",
        "a long, cone-shaped stone composed of minerals that points up from the floor."));
    rooms[1][0][0].addProp(propFactory.create("Decoration", "stalagtite", "a stalagtite.",
        "a long, cone-shaped stone composed of minerals that points down from the ceiling."));
    rooms[1][0][0].addProp(propFactory.create("Item", "glowing mushroom"));
    rooms[1][0][0].addProp(propFactory.create("Item", "wet scroll"));
  }
  
  public void createWorshipChamberRoom(RoomDynamic[][][] rooms) {
    rooms[7][6][0] = new RoomDynamic(11, "Worship Chamber",
        "This room has been outfitted with religious decor.");
    rooms[7][6][0].addProp(propFactory.create("Item", "ceremonial dagger"));
    Item weapon11 = new Item("bronze sword", "a small shortsword",
        "a small sword forged from bronze. good for cutting things.", 1);
    rooms[7][6][0].addCreature(creatureFactory.create("Hobgoblin", "Rawra", "a hobgoblin",
        "A hobgoblin wielding a bronze shortsword. They appear to be hostile.", weapon11, 1, 10, 10,
        rooms[7][6][0]));
    // Create flammable candle
    Item candle11 = (Item) propFactory.create("Item", "candle");
    candle11.setBurn(candleBurnBehavior);
    candle11.setFreeze(candleFreezeBehavior);
    rooms[7][6][0].addProp(candle11);
  }
  
  public void createSleepingAreaRoom(RoomDynamic[][][] rooms) {
    rooms[7][4][0] = new RoomDynamic(12, "Sleeping Area",
        "This room has several beds that are each surrounded by curtains for privacy.");
    rooms[7][4][0].addProp(propFactory.create("Decoration", "bed"));
    rooms[7][4][0].addProp(propFactory.create("Decoration", "bed"));
    rooms[7][4][0].addProp(propFactory.create("Decoration", "bed"));
    rooms[7][4][0].addProp(propFactory.create("Decoration", "bed"));
    Item weapon12 = new Item("bronze sword", "a small shortsword",
        "a small sword forged from bronze. good for cutting things.", 1);
    rooms[7][4][0].addCreature(creatureFactory.create("Hobgoblin", "Ard", "a hobgoblin",
        "A hobgoblin wielding a bronze shortsword. They appear to be hostile.", weapon12, 1, 10, 10,
        rooms[7][4][0]));
    // Create flammable candle
    Item candle12 = (Item) propFactory.create("Item", "candle");
    candle12.setBurn(candleBurnBehavior);
    candle12.setFreeze(candleFreezeBehavior);
    rooms[7][4][0].addProp(candle12);
    // Beast Cultist is holding one of the riddle clues.
    rooms[7][4][0].addCreature(creatureFactory.create("Cultist Druthar", rooms[7][4][0]));
  }
  
  public void createChildNurseryRoom(RoomDynamic[][][] rooms) {
    rooms[5][7][0] = new RoomDynamic(13, "Child Nursery",
        "Wooden toys and small furnishings cover the floor in a room where children sleep or play.");
    rooms[5][7][0]
        .addProp(propFactory.create("Decoration", "crib", "a baby crib.", "a small baby crib."));
    rooms[5][7][0]
        .addProp(propFactory.create("Decoration", "crib", "a baby crib.", "a small baby crib."));
    rooms[5][7][0]
        .addProp(propFactory.create("Decoration", "crib", "a baby crib.", "a small baby crib."));
    rooms[5][7][0].addProp(propFactory.create("Decoration", "bed"));
    Item weapon13 = new Item("bronze sword", "a small shortsword",
        "a small sword forged from bronze. good for cutting things.", 1);
    rooms[5][7][0].addCreature(creatureFactory.create("Hobgoblin", "Kup", "a hobgoblin",
        "A hobgoblin wielding a bronze shortsword. They appear to be hostile.", weapon13, 1, 10, 10,
        rooms[5][7][0]));
    // Create flammable candle
    Item candle13 = (Item) propFactory.create("Item", "candle");
    candle13.setBurn(candleBurnBehavior);
    candle13.setFreeze(candleFreezeBehavior);
    rooms[5][7][0].addProp(candle13);
  }
  
  public void createStatueRoom(RoomDynamic[][][] rooms) {
    rooms[4][3][0] = new RoomDynamic(14, "Statue Room",
        "This quiet room has religious decorations on the walls and a stone statue of a human.");

    // Create statue prop that can come to life, becoming a creature
    Decoration statueProp = (Decoration) propFactory.create("Decoration", "Statue", "a statue",
        "This a stone statue of a human.");
    OnAttacked onAttackedBehavior = () -> {
      rooms[4][3][0].removeProp(statueProp);
      Item weapon14 =
          new Item("stone sword", "a small shortsword", "a small sword chiseled from rock.", 1);
      Creature statue = creatureFactory.create("Construct", "Animated Statue", "an animated statue",
          "This an animated stone statue of a human that wields a stone shortsword.", weapon14, 1,
          10, 10, rooms[4][3][0]);
      rooms[4][3][0].addCreature(statue);
      return "The statue animates!";
    };
    statueProp.setOnAttacked(onAttackedBehavior);
    OnExamined onExaminedBehavior = () -> {
      rooms[4][3][0].removeProp(statueProp);
      Item weapon14 =
          new Item("stone sword", "a small shortsword", "a small sword chiseled from rock.", 1);
      Creature statue = creatureFactory.create("Construct", "Animated Statue", "an animated statue",
          "This an animated stone statue of a human that wields a stone shortsword.", weapon14, 1,
          10, 10, rooms[4][3][0]);
      rooms[4][3][0].addCreature(statue);
      return "As you examine it, the statue suddenly animates!";
    };
    statueProp.setOnExamined(onExaminedBehavior);
    OnTalk onTalkBehavior = () -> {
      rooms[4][3][0].removeProp(statueProp);
      Item weapon14 =
          new Item("stone sword", "a small shortsword", "a small sword chiseled from rock.", 1);
      Creature statue = creatureFactory.create("Construct", "Animated Statue", "an animated statue",
          "This an animated stone statue of a human that wields a stone shortsword.", weapon14, 1,
          10, 10, rooms[4][3][0]);
      rooms[4][3][0].addCreature(statue);
      return "As you begin to speak, the statue suddenly animates!";
    };
    statueProp.setOnTalk(onTalkBehavior);
    rooms[4][3][0].addProp(statueProp);
    // Create flammable torch
    Item torch14 = (Item) propFactory.create("Item", "candle");
    torch14.setBurn(torchBurnBehavior);
    torch14.setFreeze(torchFreezeBehavior);
    rooms[4][3][0].addProp(torch14);
  }
  
  public void createLargePoolRoom(RoomDynamic[][][] rooms) {
    rooms[3][0][0] = new RoomDynamic(15, "Large Pool",
        "As the cave widens, you can see a large room with a pool of water covering most of the ground.");
    rooms[3][0][0]
        .addProp(propFactory.create("Decoration", "pool", "a pool.", "a large pool of water."));
    rooms[3][0][0].addProp(propFactory.create("Item", "glowing mushroom"));
    rooms[3][0][0].addProp(propFactory.create("Item", "wet scroll"));
  }
  
  public void createCaveCollapseRoom(RoomDynamic[][][] rooms) {
    rooms[2][5][0] = new RoomDynamic(16, "Cave Collapse",
        "The passage has led to a large pile of cave rubble in the way. There is barely enough room to squeeze past the blockage.");
    rooms[2][5][0].addProp(
        propFactory.create("Decoration", "boulder", "a boulder.", "a big blockage of stone."));
    rooms[2][5][0].addProp(propFactory.create("Item", "glowing mushroom"));
    rooms[2][5][0].addProp(propFactory.create("Item","crackling scroll"));
    rooms[2][5][0].addProp(propFactory.create("Item","crackling scroll"));
  }
  
  public void createNaturalCavern17(RoomDynamic[][][] rooms) {
    rooms[2][0][0] = new RoomDynamic(33, "Natural Cavern 17",
        "This is an open natural chamber with nothing interesting to see here.");
    rooms[2][0][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createNaturalCavern18(RoomDynamic[][][] rooms) {
    rooms[0][3][0] = new RoomDynamic(33, "Natural Cavern 18",
        "This is an open natural chamber with nothing interesting to see here.");
    rooms[0][3][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createNaturalCavern19(RoomDynamic[][][] rooms) {
    rooms[2][1][0] = new RoomDynamic(33, "Natural Cavern 19",
        "This is an open natural chamber with nothing interesting to see here.");
    rooms[2][1][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createNaturalCavern20(RoomDynamic[][][] rooms) {
    rooms[2][2][0] = new RoomDynamic(33, "Natural Cavern 20",
        "This is an open natural chamber with nothing interesting to see here.");
    rooms[2][2][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createMushroomCave(RoomDynamic[][][] rooms) {
    rooms[1][3][0] = new RoomDynamic(21, "Mushroom Cave",
        "This is a wide open cave with hundreds of glowing mushrooms everywhere, making the room "
            + "bright with a green glow.");
    for (int i = 0; i < 849; i++)
      rooms[1][3][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createNaturalCavern22(RoomDynamic[][][] rooms) {
    rooms[1][4][0] = new RoomDynamic(33, "Natural Cavern 22",
        "This is an open natural chamber with nothing interesting to see here.");
    rooms[1][4][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createNaturalCavern23(RoomDynamic[][][] rooms) {
    rooms[2][4][0] = new RoomDynamic(33, "Natural Cavern 23",
        "This is an open natural chamber with nothing interesting to see here.");
    rooms[2][4][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createNaturalCavern24(RoomDynamic[][][] rooms) {
    rooms[3][2][0] = new RoomDynamic(33, "Natural Cavern 24",
        "This is an open natural chamber with nothing interesting to see here.");
    rooms[3][2][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createNaturalCavern25(RoomDynamic[][][] rooms) {
    rooms[2][6][0] = new RoomDynamic(33, "Natural Cavern 25",
        "This is an open natural chamber with nothing interesting to see here.");
    rooms[2][6][0].addProp(propFactory.create("Item", "glowing mushroom"));
  }
  
  public void createDevelopedArea26(RoomDynamic[][][] rooms) {
    rooms[4][2][0] = new RoomDynamic(34, "Developed Area 26",
        "This is a developed area with nothing interesting to see here.");
    // Create flammable torch
    Item torch26 = (Item) propFactory.create("Item", "torch");
    torch26.setBurn(torchBurnBehavior);
    torch26.setFreeze(torchFreezeBehavior);
    rooms[4][2][0].addProp(torch26);
  }
  
  public void createDevelopedArea27(RoomDynamic[][][] rooms) {
    rooms[5][2][0] = new RoomDynamic(34, "Developed Area 27",
        "This is a developed area with nothing interesting to see here.");
    // Create flammable torch
    Item torch27 = (Item) propFactory.create("Item", "torch");
    torch27.setBurn(torchBurnBehavior);
    torch27.setFreeze(torchFreezeBehavior);
    rooms[5][2][0].addProp(torch27);
  }
  
  public void createDevelopedArea28(RoomDynamic[][][] rooms) {
    rooms[7][2][0] = new RoomDynamic(34, "Developed Area 28",
        "This is a developed area with nothing interesting to see here.");
    // Create flammable torch
    Item torch28 = (Item) propFactory.create("Item", "torch");
    torch28.setBurn(torchBurnBehavior);
    torch28.setFreeze(torchFreezeBehavior);
    rooms[7][2][0].addProp(torch28);
    // Beast Cultist is holding one of the riddle clues.
    rooms[7][2][0].addCreature(creatureFactory.create("Cultist Vegdot", rooms[7][2][0]));
    rooms[7][2][0].addProp(propFactory.create("Item","crackling scroll"));
  }
  
  public void createDevelopedArea29(RoomDynamic[][][] rooms) {
    rooms[5][5][0] = new RoomDynamic(34, "Developed Area 29",
        "This is a developed area with nothing interesting to see here.");
    // Create flammable torch
    Item torch29 = (Item) propFactory.create("Item", "torch");
    torch29.setBurn(torchBurnBehavior);
    torch29.setFreeze(torchFreezeBehavior);
    rooms[5][5][0].addProp(torch29);
  }
  
  public void createDevelopedArea30(RoomDynamic[][][] rooms) {
    rooms[3][6][0] = new RoomDynamic(34, "Developed Area 30",
        "This is a developed area with nothing interesting to see here.");
    // Create flammable torch
    Item torch30 = (Item) propFactory.create("Item", "torch");
    torch30.setBurn(torchBurnBehavior);
    torch30.setFreeze(torchFreezeBehavior);
    rooms[3][6][0].addProp(torch30);
  }
  
  public void createDevelopedArea31(RoomDynamic[][][] rooms) {
    rooms[5][6][0] = new RoomDynamic(34, "Developed Area 31",
        "This is a developed area with nothing interesting to see here.");
    // Create flammable torch
    Item torch31 = (Item) propFactory.create("Item", "torch");
    torch31.setBurn(torchBurnBehavior);
    torch31.setFreeze(torchFreezeBehavior);
    rooms[5][6][0].addProp(torch31);
  }
  
  public void createDevelopedArea32(RoomDynamic[][][] rooms) {
    rooms[6][6][0] = new RoomDynamic(34, "Developed Area 32",
        "This is a developed area with nothing interesting to see here.");
    // Create flammable torch
    Item torch32 = (Item) propFactory.create("Item", "torch");
    torch32.setBurn(torchBurnBehavior);
    torch32.setFreeze(torchFreezeBehavior);
    rooms[6][6][0].addProp(torch32);
  }
  
  public void createLairOfTheForgottenBeast(RoomDynamic[][][] rooms) {
    rooms[7][7][0] = new RoomDynamic(64, "Lair of the Forgotten Beast",
        "This is the lair of the Forgotten Beast.");
    // Create flammable torch
    Item torch641 = (Item) propFactory.create("Item", "left torch", "a torch",
        "a torch, used to illuminate dark places or light things on fire");
    torch641.setBurn(torchBurnBehavior);
    torch641.setFreeze(torchFreezeBehavior);
    rooms[7][7][0].addProp(torch641);
    // Create flammable torch
    Item torch642 = (Item) propFactory.create("Item", "right torch", "a torch",
        "a torch, used to illuminate dark places or light things on fire");
    torch642.setBurn(torchBurnBehavior);
    torch642.setFreeze(torchFreezeBehavior);
    rooms[7][7][0].addProp(torch642);
    // an examine command on the giant vault will trigger the riddle to start.
    rooms[7][7][0].addProp(propFactory.create("Decoration", "giant vault", "a giant stone vault.",
        "As you examine the vault for a possible way in, a loud booming voice from the vault cries out, \"To unlock the vault of the Forgotten Beast and release him from a centuries old magic prison, you must first answer this riddle:\n"
            + "Long ago, in the great realm, the king received an anonymous letter. The letter was written to him by a knight he never met before from a distant land. The letter told the king that there is a spy living among the royal court. The report stated that the spy was intending to kill the King, and must be stopped. The knight warned that there is also a knave within the court that always lies.\n"
            + "“Knights always tell the truth and knaves always lie!”, thought the king. “Beware the spy that is in our midst! A spy could either tell the truth or lie depending on the situation,” he told his guards that day.\n"
            + "The knight travelled to the king’s court to look for the spy among their royal court members. The knight kept a low profile, and attempted to blend into the court in an effort to observe the nefarious actor. Days went by, and nothing was discovered. \n"
            + "One day, a fight erupted in the throne room. The royal guard ran into the area to break up the conflict and take the people into custody. The three people told the guards that their names were Jerroth, Komur, and Harulon. The royal guards were informed by the King that they might encounter an undercover knight, a knave, and a spy in the court. \n"
            + "Jerroth yells out, “Your majesty, Harulon is the knave!”\n"
            + "Komur insists, “Jerroth is a knight.”\n" + "Harulon announces, “I am a spy.”\"\n"
            + "To answer this riddle, use the following command but fill in the missing names with \n"
            + "your answers and remove the brackets:  answer [knight's name] [knave's name] [spy's name]\n"
            + "\n"));

    /*
     * Answer: If Komur were telling the truth, then there would be two knights. We know there is
     * only one knight, so he is not telling the truth. Komur could be either a spy or a knave. If
     * Harulon was the knight, then her statement would be a lie. Harulon cannot be the knight. If
     * neither Komur nor Harulon can be the knight, then Jerroth must be the knight. Komur,
     * therefore, must be the spy since the spy sometimes tells the truth. Harulon is the knave.
     */
  }

  @Override
  public WorldMap generateWorldMap(int sizeX, int sizeY, int sizeZ, String options) {
    return generateWorldMap(sizeX, sizeY, sizeZ);
  }
}
