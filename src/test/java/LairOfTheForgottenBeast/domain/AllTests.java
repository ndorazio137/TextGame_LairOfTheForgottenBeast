package LairOfTheForgottenBeast.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import LairOfTheForgottenBeast.domain.creature.CreatureTestSuite;
import LairOfTheForgottenBeast.domain.prop.PropTestSuite;

@RunWith(Suite.class)
@SuiteClasses(
{
   CreatureTestSuite.class, PropTestSuite.class
})
public class AllTests
{
	
}
