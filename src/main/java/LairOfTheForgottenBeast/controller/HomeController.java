package LairOfTheForgottenBeast.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import LairOfTheForgottenBeast.domain.CommandInfo;
import LairOfTheForgottenBeast.domain.map.Room;
import LairOfTheForgottenBeast.domain.map.RoomRepository;
import LairOfTheForgottenBeast.service.StaticFileReaderService;
import LairOfTheForgottenBeast.service.GameService;

@Controller 
public class HomeController {
   
   @Autowired
   RoomRepository roomRepository; 
   
   GameService gameService = new GameService();
   
   @GetMapping("/") 
   public String greeting( Model model ) { 
      return "console"; 
   }
   
   @PostMapping("/console")
   public String sendCommand(@Valid CommandInfo commandInfo, BindingResult result, Model model ) {
      System.out.println("POST Request received: /console");
      // TODO: update this line to reflect  
      // the correct form field name
      gameService.processCommand(commandInfo.getCommandString());
      return "console";
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

