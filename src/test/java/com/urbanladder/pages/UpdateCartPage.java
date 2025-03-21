package com.urbanladder.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.utils.Reports;

public class UpdateCartPage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	Properties properties;
	Actions actions;
	 WebElement element;
    Select select;
    int price=0;
 
	public UpdateCartPage(WebDriver driver,ExtentTest test)
	{
		 this.driver=driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			this.test = test;
			this.actions=  new Actions(driver);
		  
		 
	}
	private int  getCurrentPrice()
	{
		   By OrignalPrice= By.xpath("//div[@class=\"final-price\"]");
		    String  strprice=driver.findElement(OrignalPrice).getText() ;
		   
		    strprice = strprice.replaceAll("[^0-9]", ""); 

		    int price2 = Integer.parseInt(strprice);
		  
		    return price2;
		
	}
    public boolean verifyPage()
    {
    	boolean actResult;
    	try {
    		wait.until(ExpectedConditions.urlContains("cart"));
    		  Reports.generateReport(driver, test, Status.PASS, "The page on cart section");
   		   actResult=true;
   		 }catch(Exception e)
   		 {
   			   Reports.generateReport(driver, test, Status.FAIL, "The page is not in the cart section");
   			   actResult=false;
   			  
   		 }
   		 return actResult;
   		 
    	
    		
    	}
    public  boolean   increase(String value)
    {
          
    	 boolean actResult=true;
    	 By quantityDropdown=By.id("select_0_quantity");
    	 try {
 			Select quantity = new Select(driver.findElement(quantityDropdown));
 			quantity.selectByContainsVisibleText(value);
 			Reports.generateReport(driver, test, Status.PASS, "Quantity changed to 2");
 			actResult= true;
 		} catch (Exception e) {
 			Reports.generateReport(driver, test, Status.FAIL, "Quantity not changed to 2");
 			actResult= false;
 		}
    	 return actResult;

 	}


    	   
    	 
    
    public  boolean   verifyincrease()
    {    price=getCurrentPrice();
    	 boolean actResult=true;
    	 By quantityDropdown=By.xpath("//select[@id='select_0_quantity']");
    	 try {
    		element=wait.until(ExpectedConditions.visibilityOfElementLocated(quantityDropdown));
    		select=  new Select(element);
    	   
    	      String selectedValue = select.getFirstSelectedOption().getText();
    	        System.out.println("Selected Value: " + selectedValue);
    	        if(selectedValue.equals("2"))
    	        {
    	        	 Reports.generateReport(driver, test, Status.PASS, " it is correct..");
    	        	 actResult=true;
    	        }
    		
    		
    	 }catch(Exception e)
    	 {
    		  Reports.generateReport(driver, test, Status.FAIL, "The page is not in the cart section" + " " + e.getStackTrace());
  			   actResult=false;
    		 
    	 }
    	 return actResult;
    	 
    }
    public  boolean verifyUpdatedPrice()
     {
    
    	
    	 int newPrice= 2*price;
    	 if (newPrice == price) {
             Reports.generateReport(driver, test, Status.PASS, "Price updated correctly.");
             return true;
         } else {
             Reports.generateReport(driver, test, Status.FAIL, "Price update failed: Expected " + (2 * price) + ", but found " + newPrice);
             return false;
         }
 
    	    
    	 
     }
    public boolean removeProdcut()
    {
    	 boolean actValue=true;
    	 By cross =By.xpath("//a[@class=\"delete-item\"]/div[@class=\"icofont-cross_thin\"]");
    	                         
    	 try {
    		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cross));
    		 
    		 element=wait.until(ExpectedConditions.elementToBeClickable(cross));
    		 element.click();
    		 actValue=true;
    	 }
    		 catch(Exception e)
    		 {
    			 Reports.generateReport(driver, test, Status.FAIL, "failedd to delte the item");
    			 actValue= false;
    			 
    			 
    		 }
    	 return actValue;
    		 
    		 
    	 }
    public boolean verifyRemoval()
    {
    	 boolean actValue=true;
    	 By  emptybox =By.xpath("//div[@class=\"empty_cart\"]");
    	 try {
    		 wait.until(ExpectedConditions.visibilityOfElementLocated(emptybox));
    		 
    	
    		 actValue=true;
    	 }
    		 catch(Exception e)
    		 {
    			 Reports.generateReport(driver, test, Status.FAIL, "failedd to delte the item");
    			 actValue= false;
    			 
    			 
    		 }
    	 return actValue;
    		 
    		 
    	 }
    
    
    	 
    }


