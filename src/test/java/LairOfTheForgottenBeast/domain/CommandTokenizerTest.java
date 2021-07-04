package LairOfTheForgottenBeast.domain;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * TDD Tests for the commandTokenizer class.
 * 
 * @author Kyle Oakes
 * @version 1.0.0
 */
public class CommandTokenizerTest {
   CommandTokenizer commandTokenizer = new CommandTokenizer();
   
   /**
    * Test null input to the commandTokenizer
    * @since 1.0.0
    */
   @Test
   public void testNullCommand() {
      String token1 = null;
      String command1 = token1;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = null;
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   /**
    * Tests an empty String input to the commandTokenizer.
    * @since 1.0.0
    */
   @Test
   public void testEmptyString() {
      String token1 = "";
      String command1 = token1;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   /**
    * Tests a String consisting of only alphabet characters and one space as input
    * to the commandTokenizer.
    * @since 1.0.0
    */
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
   
   /**
    * Tests a String of alphabet characters as input to the commandTokenizer.
    * @since 1.0.0
    */
   @Test
   public void testAlphabeticString() {
      String token1 = "look";
      String command1 = token1;
      
      List<String> actualCommandArray = commandTokenizer.tokenize(command1);
      
      List<String> expectedCommandArray = new ArrayList<String>();
      expectedCommandArray.add(token1.trim());
      
      assertThat(actualCommandArray).isEqualTo(expectedCommandArray);
   }
   
   /**
    * Tests a String of alphabet characters with a space and trailing white space 
    * as input to the commandTokenizer.
    * @since 1.0.0
    */
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
   
   /**
    * Tests a String of alphabet characters with a space and leading white space 
    * as input to the commandTokenizer.
    * @since 1.0.0
    */
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
   
   /**
    * Tests a String of alphabet characters with a space and both
    * leading and trailing white space as input to the commandTokenizer.
    * @since 1.0.0
    */
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
   
   /**
    * Tests a String with more than two words and spaces as input to 
    * the commandTokenizer.
    * @since 1.0.0
    */
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
