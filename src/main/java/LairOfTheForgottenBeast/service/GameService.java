package LairOfTheForgottenBeast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import LairOfTheForgottenBeast.domain.CommandInterpreter;
import LairOfTheForgottenBeast.domain.CommandTokenizer;
import LairOfTheForgottenBeast.domain.Player;
import LairOfTheForgottenBeast.domain.map.WorldMap;

public class GameService
{
   private CommandTokenizer commandTokenizer = new CommandTokenizer();
   private CommandInterpreter commandInterpreter = new CommandInterpreter();
   WorldMap worldMap;
   Player player = new Player();
   
   public String processCommand(String publicCommand)
   {
      List<String> pubTokens = commandTokenizer.tokenize(publicCommand);
      String pubInterpretation = commandInterpreter.processCommand(pubTokens);
      return pubInterpretation;
   }
}