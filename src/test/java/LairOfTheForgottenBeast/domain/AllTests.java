package LairOfTheForgottenBeast.domain;

/* Non-static Imports */
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/* In-House Imports */
import LairOfTheForgottenBeast.domain.inventorySystem.BaseInventoryUnitTest;
import LairOfTheForgottenBeast.domain.inventorySystem.PlayerInventoryUnitTest;

/**
 * A Test Suite to run all Unit Tests.
 * 
 * @author Brian James
 * @version 1.0.0
 * @since 1.0.0
 */
/*
 * updateAuthor: Nick D'Orazio
 * updateLog: finished implementation to get suite working.
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({ CommandInterpreterUnitTest.class, 
				 BaseInventoryUnitTest.class,
				 PlayerInventoryUnitTest.class,
				 CommandTokenizerTest.class ,
				 PlayerTests.class})
@ExcludeTags("IntegrationTest")
public class AllTests {
	
}
