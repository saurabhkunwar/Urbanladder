package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src\\test\\resources\\features\\urbanladder.Register.feature",

   
    glue = "com.urbanladder.stepdefinitions",
    tags = "@login",
    		
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json",
    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"		
    }
) 
public class RegisterRunner extends AbstractTestNGCucumberTests {

}
