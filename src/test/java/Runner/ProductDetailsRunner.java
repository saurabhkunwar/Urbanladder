

package Runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	    features = "src/test/resources/features/urbanladder.productdetails.feature",
	    glue = "com.urbanladder.stepdefinitions",
	    tags = "@ProductDetails",
	    plugin = {
	        "pretty",
	        "html:src/test/resources/Reports/cucumber-reports/CucumberTestReport.html",
	        "json:src/test/resources/Reports/cucumber-reports/CucumberTestReport.json",
	        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    }
	)

public class ProductDetailsRunner extends AbstractTestNGCucumberTests { // Use "extends" instead of direct inheritance

} 
