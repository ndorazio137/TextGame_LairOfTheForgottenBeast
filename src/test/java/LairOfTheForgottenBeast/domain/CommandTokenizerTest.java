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
   public void testAlphabeticStringWithOneSpace() {
      String token1 = "go";
      String token2 = "north";
      String command1 = token1 + " " + token2;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1.trim());
      expectedCommandArray.add(token2.trim());
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testAlphabeticString() {
      String token1 = "look";
      String command1 = token1;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1.trim());
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testAlphabeticStringWithTrailingSpaces() {
      String token1 = "go";
      String token2 = "north  ";
      String command1 = token1 + " " + token2;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1.trim());
      expectedCommandArray.add(token2.trim());
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testAlphabeticStringWithLeadingSpaces() {
      String token1 = "  go";
      String token2 = "north";
      String command1 = token1 + " " + token2;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1.trim());
      expectedCommandArray.add(token2.trim());
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testAlphabeticStringWithLeadingAndTrailingSpaces() {
      String token1 = "  go";
      String token2 = "north  ";
      String command1 = token1 + " " + token2;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1.trim());
      expectedCommandArray.add(token2.trim());
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   @Test
   public void testAlphabeticStringWithManyWords() {
      String token1 = "the";
      String token2 = "quick";
      String token3 = "brown";
      String token4 = "fox";
      String command1 = token1 + " " + token2 + " " + token3 + " " + token4;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1.trim());
      expectedCommandArray.add(token2.trim());
      expectedCommandArray.add(token3.trim());
      expectedCommandArray.add(token4.trim());
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
}
