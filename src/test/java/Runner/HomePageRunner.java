package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\resources\\features\\urbanladder.Home.feature",
    glue = "com.urbanladder.stepdefinitions", 
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
    
)
public class HomePageRunner extends AbstractTestNGCucumberTests {
} 
