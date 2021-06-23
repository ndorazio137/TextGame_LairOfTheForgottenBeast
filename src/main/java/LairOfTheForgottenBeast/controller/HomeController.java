package LairOfTheForgottenBeast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import LairOfTheForgottenBeast.domain.map.Room;
import LairOfTheForgottenBeast.domain.map.RoomRepository;

@Controller 
public class HomeController {
   
   @Autowired
   RoomRepository roomRepository; 
   
   @GetMapping("/") 
   public String greeting( Model model ) { 
      return "console"; 
   }
   
   @GetMapping("/rooms") 
   public String allRooms( Model model ) { 
      Iterable<Room> rooms = roomRepository.findAllOrderByIdDesc();
      model.addAttribute("rooms", rooms);
      return "room_list"; 
   }  
   
}
