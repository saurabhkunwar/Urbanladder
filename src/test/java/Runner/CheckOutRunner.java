

package Runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	    features = "src\\test\\resources\\features\\urbanlader.checkout.feature",
	    glue = "com.urbanladder.stepdefinitions",
	    plugin = {
	        "pretty",
	        "html:src/test/resources/Reports/cucumber-reports/CucumberTestReport.html",
	        "json:src/test/resources/Reports/cucumber-reports/CucumberTestReport.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    }
	)

public class CheckOutRunner extends AbstractTestNGCucumberTests { 

}
