package LairOfTheForgottenBeast.domain.creature;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@SuiteClasses(
{HumanoidTest.class, BeastTest.class, UndeadTest.class, 
   ConstructTest.class})
public class CreatureTestSuite
{
	
}
