package com.urbanladder.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.utils.Reports;

public class Shopping {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	Properties properties;
	Actions actions;

	public Shopping(WebDriver driver, ExtentTest test) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
		this.actions=  new Actions(driver);
	}
	public  boolean verifyPage()
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

}
