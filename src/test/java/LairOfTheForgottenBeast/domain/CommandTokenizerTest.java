package LairOfTheForgottenBeast.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommandTokenizerTest {
   CommandTokenizer commandTokenizer = new CommandTokenizer();
   
   @Test
   public void testNullCommand() {
      String token1 = null;
      String command1 = token1;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = null;
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testEmptyString() {
      String token1 = "";
      String command1 = token1;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testGoNorth() {
      String token1 = "go";
      String token2 = "north";
      String command1 = token1 + " " + token2;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1);
      expectedCommandArray.add(token2);
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testGoEast() {
      String token1 = "go";
      String token2 = "east";
      String command1 = token1 + " " + token2;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1);
      expectedCommandArray.add(token2);
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testGoSouth() {
      String token1 = "go";
      String token2 = "south";
      String command1 = token1 + " " + token2;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1);
      expectedCommandArray.add(token2);
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testGoWest() {
      String token1 = "go";
      String token2 = "west";
      String command1 = token1 + " " + token2;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1);
      expectedCommandArray.add(token2);
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testLook() {
      String token1 = "look";
      String command1 = token1;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1);
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
}
