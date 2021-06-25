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
      model.addAttribute("output", " ");
      return "console"; 
   }
   
   @PostMapping("/console")
   @ResponseBody
   public String sendCommand(@RequestParam("commandString") String commandString, Model model) {
      System.out.println("POST Request received: /console");
      String output = gameService.processCommand(commandString);
      model.addAttribute("output", output);
      return output;
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

