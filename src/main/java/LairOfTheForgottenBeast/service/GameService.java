package LairOfTheForgottenBeast.service;

import java.util.ArrayDeque;
import java.util.HashMap;
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
import LairOfTheForgottenBeast.domain.map.rooms.RoomDynamic;
import LairOfTheForgottenBeast.domain.map.rooms.RoomRepository;

public class GameService {
  @Autowired
  RoomRepository roomRepository;
  private CommandTokenizer commandTokenizer = new CommandTokenizer();
  private CommandDictionary commandDictionary = new CommandDictionary();
  private CommandInterpreter commandInterpreter = new CommandInterpreter(commandDictionary);
  private WorldMapGenerator worldMapGenerator = new StaticWorldMapGenerator();
  private WorldMap worldMap = worldMapGenerator.generateWorldMap(8, 8, 1);

  private HashMap<String, Player> playerMap = new HashMap<String, Player>();
  private SpellService spellService = new SpellService();
  private GameState gameState = new GameState(worldMap, playerMap, spellService);

  private HashMap<String, ArrayDeque<String>> chatLogs = new HashMap<String, ArrayDeque<String>>();

  public String processCommand(String username, String multiplayer, String commandString) {
    if (!playerMap.containsKey(username)) {
      playerMap.put(username, this.generatePlayer(username));
    }

    List<String> tokens = commandTokenizer.tokenize(commandString);

    String commandOutput =
        commandInterpreter.processCommand(username, gameState, tokens, multiplayer);

    if (multiplayer.equals("true")) {
      this.sendChat(username, "> " + commandString + "\n");
      if (!commandOutput.equals("")) {
        this.sendChat(username, commandOutput);
      }
    }

    return commandOutput;
  }

  // THIS IS HARDCODED FOR NOW BUT MUST BE IMPROVED LATER
  public Player generatePlayer(String username) {
    Player player = new Player();
    player.setName(username);
    player.setMaxHitPoints(100);
    player.setCurrentHitPoints(100);
    player.setAttackDamage(1);
    player.setCurrentRoom(this.worldMap.getRoom(0, 0, 0));
    this.worldMap.getRoom(0, 0, 0).addPlayer(player);
    return player;
  }

  public Player getPlayer(String username) {
    return this.playerMap.get(username);
  }

  public GameState getGameState() {
    return gameState;
  }

  public String getChats(String username) {
    ArrayDeque<String> chatLog;
    if (!chatLogs.containsKey(username)) {
      chatLogs.put(username, new ArrayDeque<String>());
    }
    chatLog = chatLogs.get(username);
    String chats = "";
    while (!chatLog.isEmpty()) {
      chats += chatLog.remove();
    }

    // sendChat("SomeGuy", "Hello!");

    return chats;
  }

  public void sendChat(String username, String chat) {
    Player player = playerMap.get(username);
    RoomDynamic room = player.getCurrentRoom();
    if (playerMap.size() > 1) {
      for (String user : chatLogs.keySet()) {
        if (!playerMap.containsKey(user)) {
          Player newPlayer = this.generatePlayer(user);
        }
        if (room.equals(playerMap.get(user).getCurrentRoom())) {
          chatLogs.get(user).add(username + " " + chat);
        }
      }
    } else {
      chatLogs.get(username).add("(" + username + "): " + chat);
    }

  }
}
