package LairOfTheForgottenBeast.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import LairOfTheForgottenBeast.User;
import LairOfTheForgottenBeast.UserRepository;
import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomRepository;
import LairOfTheForgottenBeast.service.GameService;
import LairOfTheForgottenBeast.service.StaticFileReaderService;

@Controller
public class HomeController {

  @Autowired
  private RoomRepository roomRepository;
  
  @Autowired
  private UserRepository userRepository;

  private GameService gameService = new GameService();
  
  // A map of usernames and associated GameService instances
  private HashMap<String, GameService> gameServiceMap = new HashMap<String, GameService>();

  @GetMapping("/")
  public String logIn(Model model) {
    // Add a new user object onto the form.
    model.addAttribute("user", new User());
    return "logIn";
  }

  @PostMapping("/")
  public String logInReturningUser(@Valid User user, BindingResult result, Model model) throws ParseException {
    // Handle form validation errors
    if (result.hasErrors()) {
      model.addAttribute("user", user);
      return "logIn";
    }
    User loadedUser = userRepository.findByUsername(user.getUsername());
    if (loadedUser == null) {
      model.addAttribute("user", user);
      return "logIn";
    }

    model.addAttribute("user", user);
    return "console";
  }
  
  @GetMapping("/signUp")
  public String signUp(Model model) {
    // Add a new user object onto the form.
    model.addAttribute("user", new User());
    return "signUp";
  }
  
  @PostMapping("/signUp")
  public String createNewUser(@Valid User user, BindingResult result, Model model) throws ParseException {
    // Handle form validation errors
    if (result.hasErrors()) {
      model.addAttribute("user", user);
      return "signUp";
    }
    
    // Check if username is already taken. Must be a unique username.
    User username = userRepository.findByUsername(user.getUsername());
    if (username != null) {
      model.addAttribute("user", user);
      return "signUp";
    }
    
    // If username is not taken, then save to the database.
    userRepository.save(user);
    model.addAttribute("user", user);
    return "console";
  }
  
  @GetMapping("/console")
  public String greeting(Model model ) {
    model.addAttribute("output", " ");
    return "console";
  }

  @PostMapping("/console")
  @ResponseBody
  public ResultObject sendCommand(@RequestParam("commandString") String commandString, 
      @RequestParam("username") String username,
      @RequestParam("multiplayer") String multiplayer,
      Model model) {
    System.out.println("POST Request received: \"/console\" from user: \"" + username + "\"");
    username = username.toUpperCase();
    GameService gameService;
    
    if (multiplayer.equals("true")) {
      // If there is already a GameService set up for this user...
      if (gameServiceMap.containsKey("MULTIPLAYER")) {
        // ...then use the existing GameService for that user
        gameService = gameServiceMap.get("MULTIPLAYER");
      } else {
        // ...otherwise, make a new GameService and associate it with that user
        gameService = new GameService();
        gameServiceMap.put("MULTIPLAYER", gameService);
      }
      
      gameService = gameServiceMap.get("MULTIPLAYER");
    }
    else {
      // If there is already a GameService set up for this user...
      if (gameServiceMap.containsKey(username)) {
        // ...then use the existing GameService for that user
        gameService = gameServiceMap.get(username);
      } else {
        // ...otherwise, make a new GameService and associate it with that user
        gameService = new GameService();
        gameServiceMap.put(username, gameService);
      }
    }
    
    ResultObject resultObject = new ResultObject();
    System.out.println("Command String in home controller null?: " + commandString);
    resultObject.setCommandOutput(gameService.processCommand(username,multiplayer,commandString));
    resultObject.setLocationInfo("~~~" + gameService.getPlayer(username).getCurrentRoom().getName()
        + "~~~ <br />" + gameService.getPlayer(username).getCurrentRoom().getDescription());
    resultObject.setMapDims(new int[] {gameService.getGameState().getWorldMap().getSizeX(),
        gameService.getGameState().getWorldMap().getSizeY()});
    // This line gets the player's current Room, then passes it to WorldMap to get the player's
    // coords
    resultObject.setPlayerCoords(gameService.getGameState().getWorldMap()
        .getRoomCoords(gameService.getPlayer(username).getCurrentRoom()));
    // Get the player's current and max HP to display on the UI
    resultObject.setPlayerCurrentHp(gameService.getPlayer(username).getCurrentHitPoints());
    resultObject.setPlayerMaxHp(gameService.getPlayer(username).getMaxHitPoints());
    // Get the name of the currently equipped weapon to display on the UI
    resultObject.setPlayerWeapon(gameService.getPlayer(username).getWeaponName());
    // Get a List<String> of all item names in player's inventory to display on the UI
    resultObject
        .setPlayerInventoryItemNames(gameService.getPlayer(username).getInventory().getItemNameList());

    System.out.println(resultObject);
    model.addAttribute("mapDimX", resultObject.getMapDims()[0]);
    model.addAttribute("mapDimY", resultObject.getMapDims()[1]);
    model.addAttribute("playerCoords", resultObject.getPlayerCoords());
    if (multiplayer.equals("true")) {
      resultObject.setCommandOutput("Command received.");
    }
    return resultObject;
  }
  
  @PostMapping("/pullChats")
  @ResponseBody
  public ResultObject sendCommand(@RequestParam("username") String username, 
      Model model) {
//    System.out.println("POST Request received: \"/pullChats\" from user: \"" + username + "\"");
    username = username.toUpperCase();
    
    if (!gameServiceMap.containsKey("MULTIPLAYER")) {
      gameServiceMap.put("MULTIPLAYER",new GameService());
    }
    
    GameService gameService = gameServiceMap.get("MULTIPLAYER");
    
    ResultObject resultObject = new ResultObject();
    String chats = gameService.getChats(username);
    resultObject.setCommandOutput(chats);
//    System.out.println(resultObject.getCommandOutput());
    return resultObject;
  }

  @GetMapping("/rooms")
  public String allRooms(Model model) {
    List<Room> rooms = roomRepository.findAllOrderByIdDesc();
    model.addAttribute("rooms", rooms);
    return "room_list";
  }

  // Proof of concept: Displays static .txt file to screen
  @GetMapping("/asciiArtTemplate")
  public String getAscii(Model model) {
    StaticFileReaderService fr = new StaticFileReaderService();
    String[] fileString = fr.readFile("asciiArt/introArt");
    model.addAttribute("art", fileString);
    return "asciiArtTemplate";
  }
}

