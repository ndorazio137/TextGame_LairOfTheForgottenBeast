package LairOfTheForgottenBeast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class HomeController {
  
   @GetMapping("/") 
   public String greeting( Model model ) { 
      return "console"; 
   }
  
   
}
