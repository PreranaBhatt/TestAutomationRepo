package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src/test/resources/Feature/login.feature",
		glue = "stepDefinition",
		dryRun=false,
		//monochrome = true,
		plugin= { "pretty", "html:test-output"}
		
		)
public class testrun {

}
