package LairOfTheForgottenBeast.domain;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;

/* Non-static Imports */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.Mockito;

import LairOfTheForgottenBeast.domain.prop.Item;

/**
 * TDD Tests for the commandTokenizer class.
 * 
 * @author Kyle Oakes
 * @version 1.0.0
 * @since 1.0.0
 */
@Tag("CommandTokenizerUnitTests")
public class CommandTokenizerTest {
	
   /* Provides logging output for each test */
   private static Logger LOG = Logger.getLogger("CommandTokenizerTest Logger");
	
   /* Class under testing */
   CommandTokenizer commandTokenizer;
   
   /**
	 * Before each test case: run the logger.
	 * 
	 * @author Nick D'Orazio
	 * @since 1.0.0
	 * 
	 * @param testInfo An object created by a JUnit import to be able to get the method under test name.
	 */
   @BeforeEach
	public void setupTests(TestInfo testInfo) {
		LOG.info("Running Test Case " + testInfo.getDisplayName());
		commandTokenizer = new CommandTokenizer();
	}
   
   /**
	 * Run the logger after each test case and do clean up.
	 * 
	 * @author Nick D'Orazio
	 * @since 1.0.0
	 * 
	 * @param testInfo An object created by a JUnit import to be able to get the method under test name.
	 */
   @AfterEach
	public void finishTest(TestInfo testInfo) {
		LOG.info("Finishing Test Case " + testInfo.getDisplayName());
		System.out.println();
		commandTokenizer = null;
	}
   
   /**
    * Test null input to the commandTokenizer
    * 
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
   public void testNullCommand() {
      List<String> actualCommandArray = commandTokenizer.tokenize(null);
      
      assertThat(actualCommandArray).isEqualTo(null);
   }
   
   /**
    * Tests an empty String input to the commandTokenizer.
    * 
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
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
    * 
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
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
    * 
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
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
    * 
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
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
    * 
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
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
    * 
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
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
    * 
    * @since 1.0.0
    */
   @Test
   @Tag("UnitTest")
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
