package runnerFile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions( 
		features="features",
		glue = "stepsdefn",
		plugin = {"pretty", "html:target/cucumber-report.html"}
		)

public class runnerCl {

}
