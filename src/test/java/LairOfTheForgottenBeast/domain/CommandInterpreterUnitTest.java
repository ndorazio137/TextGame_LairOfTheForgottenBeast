package LairOfTheForgottenBeast.domain;

/* Static Imports */
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;

/* Non-static Imports */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * A Test Class for CommandInterpreter comprised of Unit test cases.
 * 
 * @author Nick D'Orazio
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RunWith(MockitoJUnitRunner.class)
@Tag("CommandInterpreterUnitTests")
public class CommandInterpreterUnitTest {
	
	/* Provides logging output for each test */
	private static Logger LOG = Logger.getLogger("CommandInterpreterUnitTests Logger");
	
	/* Class under testing */
	private CommandInterpreter interpreter;
	
	/* Mocked dependency */
	@Mock
	private CommandDictionary commandDictionary;
	
	/**
	 * Before each test case: Set up a new Instance of the CommandInterpreter, 
	 * run the logger and mock dependencies of the CommandInterpreter Class.
	 * 
	 * @author Nick D'Orazio
	 * @since 1.0.0
	 * 
	 * @param testInfo An object created by a JUnit import to be able to get the method under test name.
	 */
	@BeforeEach
	public void setupTests(TestInfo testInfo) {
		LOG.info("Running Test Case " + testInfo.getDisplayName());
		commandDictionary = Mockito.mock(CommandDictionary.class);
		interpreter = new CommandInterpreter(commandDictionary);
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
		interpreter = null;
	}
	
	/**
	 * Test the behavior of a null value being passed as the command List parameter.
	 * 
	 * @author Nick D'Orazio
	 * @since 1.0.0
	 */
	@Test
	@Tag("UnitTest")
	public void unitTest_CommandProcess_CmdListIsNullReturnsString() {
		/* Create an object to act as the GameState object parameter */
		Object gameState = new Object();
		
		/* Setup null parameter to pass */
		List<String> given = null;
		
		/* Output to screen the passed value */
		System.out.println("GIVEN: " + given);
		
		/* Get return value when the command List is null */
		String returnedValue = interpreter.processCommand(gameState, given);
		
		/* Output to screen the returned value */
		System.out.println("RETURNED: " + returnedValue);
		
		/* Check: Is a String to update the UI provided when the command List is Null? */
		assertThat(returnedValue).isNotNull();
	}
	
	/**
	 * 
	 * 
	 * @author Nick D'Orazio
	 * @since 1.0.0
	 */
	@Test
	@Tag("UnitTest")
	public void unitTest_CommandProcess_RetreivesCommandMapping() {
		
		/* Create an object to act as the GameState object parameter */
		Object gameState = new Object();
		
		/* Create a List to act as the cmdArr parameter */
		List<String> commandList = new ArrayList<String>();
		commandList.add("");
		
		/* Create and output the expected value to screen */
		String valueToBeReturned = "Returned Command";
		System.out.println("GIVEN: " + valueToBeReturned);
		
		/* Set expected value as the return value of the mapped command */
		Map<String, BiFunction<Object, List<String>,String>> map;
		map = new HashMap<>();
		map.put("", (gamestate, command) -> {
			return valueToBeReturned;
		});
		
		/* When retrieving the dictionary return the mocked dictionary */
		given(commandDictionary.getDictionary()).willReturn(map);
		
		/* Call function under test */
		String valueReturned = interpreter.processCommand(gameState, commandList);
		
		/* Output the actual returned value to screen */
		System.out.println("RETURN: " + valueReturned);
		
		/* 
		 * Check: Does the Interpreter return the expected command? 
		 */
		Assert.assertEquals(valueToBeReturned, valueReturned);
		
		/* 
		 * Verify that the function was actually called and it was called only one time.
		 */
	    Mockito.verify(commandDictionary, times(1)).getDictionary();
	}
}
