package LairOfTheForgottenBeast.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;

import LairOfTheForgottenBeast.domain.map.rooms.Room;
import LairOfTheForgottenBeast.domain.map.rooms.RoomRepository;
import LairOfTheForgottenBeast.service.StaticFileReaderService;
import LairOfTheForgottenBeast.service.GameService;

@Controller 
public class HomeController {
   
   @Autowired
   RoomRepository roomRepository; 
   
   GameService gameService = new GameService();
   
   @GetMapping("/") 
   public String greeting( Model model ) { 
      model.addAttribute("output", " ");
      return "console"; 
   }
   
   @PostMapping("/console")
   @ResponseBody
   public ResultObject sendCommand(@RequestParam("commandString") String commandString, Model model) {
      System.out.println("POST Request received: /console");
      ResultObject resultObject = new ResultObject();
      resultObject.setCommandOutput(gameService.processCommand(commandString));
      resultObject.setLocationInfo(
            "~~~" +
            gameService.getPlayer().getCurrentRoom().getName() + "~~~ <br />" + 
            gameService.getPlayer().getCurrentRoom().getDescription()
      );
      resultObject.setMapDims( new int[] {
            gameService.getGameState().getWorldMap().getSizeX(),
            gameService.getGameState().getWorldMap().getSizeY()
      });
      // This line gets the player's current Room, then passes it to WorldMap to get the player's coords
      resultObject.setPlayerCoords( 
            gameService.getGameState().getWorldMap().getRoomCoords(
                  gameService.getGameState().getPlayer().getCurrentRoom()));
      System.out.println(resultObject);
      model.addAttribute("mapDimX", resultObject.getMapDims()[0]);
      model.addAttribute("mapDimY", resultObject.getMapDims()[1]);
      model.addAttribute("playerCoords", resultObject.getPlayerCoords());
      return resultObject;
   }
   
   @GetMapping("/rooms") 
   public String allRooms( Model model ) { 
      List<Room> rooms = roomRepository.findAllOrderByIdDesc();
      model.addAttribute("rooms", rooms);
      return "room_list"; 
   }
   
   // Proof of concept: Displays static .txt file to screen
   @GetMapping("/asciiArtTemplate") 
   public String getAscii( Model model ) { 
      StaticFileReaderService fr = new StaticFileReaderService();
      String[] fileString = fr.readFile("asciiArt/introArt");
      model.addAttribute("art", fileString);
      return "asciiArtTemplate"; 
   }
}

