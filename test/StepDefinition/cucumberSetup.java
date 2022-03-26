//Bijesh Bajracharya
package StepDefinition;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Runner Class

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/report.html","json:target/cucumber/report.json"},
        tags = "@Bowling",
        features={"src/test/resources/features"},
        glue={"StepDefinition"})

public class cucumberSetup {
}
