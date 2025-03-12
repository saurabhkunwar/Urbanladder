package StepDef;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= {"src/test/java/Features/Shopping.feature"},glue= {"StepDef"})


public class ShoppingRunner extends AbstractTestNGCucumberTests {
	

}
