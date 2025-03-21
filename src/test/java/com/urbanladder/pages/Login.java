package com.urbanladder.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.utils.Reports;

public class Login {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
//	Properties properties;
	Actions actions;

	public Login(WebDriver driver, ExtentTest test) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
		this.actions = new Actions(driver);
	}

	public boolean loginSection() {

		By profileIcon = By.xpath(
				"//span[@class='header-icon-link user-profile-icon']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]");
		By signUp = By.id("header-icon-login");
		By signInBox = By.xpath("//div[@class='popup-text text-center vert large-6 columns']");
		boolean actResult = true;

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			actions.moveToElement(driver.findElement(profileIcon)).moveToElement(driver.findElement(signUp)).click()
					.build().perform();

			WebElement signUpElement = wait.until(ExpectedConditions.visibilityOfElementLocated(signUp));

			signUpElement.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(signInBox));

			// Report success
			Reports.generateReport(driver, test, Status.PASS, "Navigation to Register is successful");
			actResult = true;
		} catch (Exception te) {
			// Capture failure
			Reports.generateReport(driver, test, Status.FAIL, "Navigation to Register failed: " + te.getMessage());
		}

		return actResult;
	}

	public boolean signIn(String unm1, String pass1) {

		boolean actResult;
		By email = By.xpath("//div[@id='password-credentials']//input[@id='spree_user_email']");
		By password = By.xpath("//div[@class='password-wrap']//input[@id='spree_user_password']");
		try {
			System.out.println("waiting for email field..");

			wait.until(ExpectedConditions.presenceOfElementLocated(email));
			wait.until(ExpectedConditions.elementToBeClickable(email));
			WebElement emailField = driver.findElement(email);
			emailField.clear();
			emailField.sendKeys(unm1);

			wait.until(ExpectedConditions.presenceOfElementLocated(password));
			wait.until(ExpectedConditions.elementToBeClickable(password));
			WebElement passwordField = driver.findElement(password);
			passwordField.clear();
			passwordField.sendKeys(pass1);
			Reports.generateReport(driver, test, Status.PASS, "Email section  and Password section is there");

			actResult = true;
		} catch (Exception te) {
			System.out.println("error in signin"+ te.getMessage());

			Reports.generateReport(driver, test, Status.FAIL, "Email section and Password section are not there");

			actResult = false;

		}

		return actResult;

	}

	public boolean submit() {
		boolean actResult;
		By Submit = By.xpath("//input[@id='ul_site_login']");
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

	public boolean validSignIn() {
		boolean actResult;
		String Homepage = "https://www.urbanladder.com/";

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
