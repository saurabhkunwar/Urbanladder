package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "D:\\Selenium Projects\\Urbanladder\\src\\test\\resources\\features\\urbanladder.productdetails.feature",
    glue = "com.urbanladder.stepdefinitions", 
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json",
    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"	
		}
    
)
public class TestRunner extends AbstractTestNGCucumberTests {
} 
