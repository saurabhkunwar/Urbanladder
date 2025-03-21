package com.urbanladder.pages;

import java.time.Duration;
import java.util.Properties;

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

public class UpdateUser {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	Properties properties;
	Actions actions;
	 WebElement element;
    Select select;
    public UpdateUser(WebDriver driver,ExtentTest test) {
   	 this.driver=driver;
	 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
		this.actions=  new Actions(driver);
    	
    }
    public boolean NavigatetoSettings() {
        boolean actResult;
        By profileIcon = By.xpath("//span[contains(@class,'user-profile-icon')]");
        By editProfile = By.id("header-icon-profile");
        By accountPage = By.id("account-summary");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

          
            WebElement profileIconElement = wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
            actions.moveToElement(profileIconElement).perform();
            System.out.println("Hovered over profile icon.");

            
            WebElement editProfileElement = wait.until(ExpectedConditions.elementToBeClickable(editProfile));
            actions.moveToElement(editProfileElement).click().perform();
            System.out.println("Clicked edit profile.");

           
            wait.until(ExpectedConditions.visibilityOfElementLocated(accountPage));
            System.out.println("Account page is visible.");
            
            actResult = true;
            Reports.generateReport(driver, test, Status.PASS, "Navigation to Register is successful");
        } catch (Exception te) {
            Reports.generateReport(driver, test, Status.FAIL, "Navigation to Register failed: " + te.getMessage());
            System.out.println("Error: " + te.getMessage());
            actResult = false;
        }

        return actResult;
    }

	public boolean editPassword(String newPassword)
	{
		boolean actResult;
		By edit = By.xpath("//a[@id=\"edit\"]");
		By password = By.id("change_password");
		By passwodbox= By.id("user_password");
		By confirmPassbox= By.id("user_password_confirmation");
		try {
			System.out.println("waiting for email field..");

			wait.until(ExpectedConditions.presenceOfElementLocated(edit));
		  WebElement editbutton=wait.until(ExpectedConditions.elementToBeClickable(edit));
		  editbutton.click();
		

			wait.until(ExpectedConditions.presenceOfElementLocated(password));
			  WebElement changepassword=	wait.until(ExpectedConditions.elementToBeClickable(password));
			  changepassword.click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(passwodbox));
		    WebElement  ele= driver.findElement(passwodbox);
		       ele.clear();
		       ele.sendKeys(newPassword);
		       wait.until(ExpectedConditions.presenceOfElementLocated(confirmPassbox));
			   WebElement  ele2= driver.findElement(confirmPassbox);
			       ele2.clear();
			       ele2.sendKeys(newPassword);
			       
		       
		     
			
			Reports.generateReport(driver, test, Status.PASS, "Email section  and Password section is there");

			actResult = true;
		} catch (Exception te) {
			System.out.println("error in signin"+ te.getMessage());

			Reports.generateReport(driver, test, Status.FAIL, "Email section and Password section are not there");

			actResult = false;

		}

		return actResult;
	}
	public boolean update() {
		boolean actResult;
		By Submit = By.xpath("//input[@value='Update']");
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Submit)));
			Reports.generateReport(driver, test, Status.PASS, "Email section is there");
			driver.findElement(Submit).click();
			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Email section is not there");

			actResult = false;

		}
		return actResult;

	}
	public boolean verifyUpdate()
	{
		
		boolean actResult;
		String Homepage = "https://www.urbanladder.com/login";

		String actualTitle = driver.getCurrentUrl();
		if (actualTitle.equals(Homepage)) {

			Reports.generateReport(driver, test, Status.PASS, "SignUP succed..");

			actResult = true;
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "SignUp  Failed navigating to signup page");

			actResult = false;

		}
		return actResult;
	}

	
	}

	

