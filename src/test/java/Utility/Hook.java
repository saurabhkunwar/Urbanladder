package Utility;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	public static Base1 base;
	@Before
	public void initBrowser()
	{
		System.out.println("opening the browser :Chrome");
		base.driver= new ChromeDriver();
		
		
	}
	@After 
	public void Close(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			CaptureScreenShot screenshot= new CaptureScreenShot();
			screenshot.getErrorScrnShot(base.driver);
			
		}
		
	//base.driver.close();
		
	}

}
