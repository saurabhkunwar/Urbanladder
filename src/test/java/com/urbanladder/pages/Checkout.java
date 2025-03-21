package com.urbanladder.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.utils.PropertyReader;
import com.urbanladder.utils.Reports;

public class Checkout {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	Properties properties;
	WebElement element;
	// WebElements in the HomePage
	By discount = By.xpath("//div[contains(text(), 'Enjoy up to ')]");
	By bestSeller = By.xpath("//h2[text()=\"Our Bestsellers, Handpicked Just for You\"]");
	By searchBox = By.id("search");

	public Checkout(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
		this.properties = PropertyReader.readProperty();
	

		
	}
	public boolean verifyPage()
	{
		boolean actResult=true;
		 By cartlist= By.id("cart-line-item-head");
		 try {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(cartlist));
		   Reports.generateReport(driver, test, Status.PASS, "Navigation to Register is successful");
		   actResult=true;
		 }catch(Exception e)
		 {
			   Reports.generateReport(driver, test, Status.FAIL, "Navigation to Register is successful");
			   actResult=false;
			  
		 }
		 return actResult;
	}
	public boolean proceedtoCheckout()
	{
		By checoutButton=By.xpath("//div[@class='col-md-5']//button[@id='checkout-link']");
		boolean actResult;
		try {
	
		 wait.until(ExpectedConditions.visibilityOfElementLocated(checoutButton));
		element= wait.until(ExpectedConditions.elementToBeClickable(checoutButton));
		element.click();
		
		   Reports.generateReport(driver, test, Status.PASS, "Navigation to Register is successful");
		   actResult=true;
		 }catch(Exception e)
		 {
			   Reports.generateReport(driver, test, Status.FAIL, "Navigation to Register is successful");
			   actResult=false;
			  
		 }
		 return actResult;
		
	}
	public boolean checkoutPage()
	{
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   boolean	actResult=true;
	  
		   boolean checkout=driver.getCurrentUrl().contains("checkout");
		   if(checkout==true)
		   {
			   Reports.generateReport(driver, test, Status.PASS, "Navigation to Register is successful");
			   actResult=true;
		   }
		   else {
			   Reports.generateReport(driver, test, Status.FAIL, "Navigation to Register is successful");
			   actResult=false;
			  
			   
		   }
		   return  actResult;
	   
	   
		
	}
	public boolean verifyOrderSummary()
	{
		boolean actResult=true;
		 By summary= By.xpath("//h4[text()=\"Order Summary\"]");
		 try {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(summary));
		   Reports.generateReport(driver, test, Status.PASS, "Navigation to Register is successful");
		   actResult=true;
		 }catch(Exception e)
		 {
			   Reports.generateReport(driver, test, Status.FAIL, "Navigation to Register is successful");
			   actResult=false;
			  
		 }
		 return actResult;
		
	}
	

}
