package cucumberOptions;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/login2.feature",
		glue = "stepDefinations"
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
}