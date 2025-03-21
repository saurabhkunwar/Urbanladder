package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features= "src\\test\\resources\\features\\urbanladder.searchFunc.feature",
	    glue = "com.urbanladder.stepdefinitions",
	    tags = "@search",
	    plugin = {"pretty","html:src/test/resources/Reports/cucumber-reports/CucumberTestReport.html",
				"json:src/test/resources/Reports/cucumber-reports/CucumberTestReport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}

	)

public class SearchRunner extends AbstractTestNGCucumberTests {

}
