package com.urbanladder.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.utils.Reports;

public class SearchPage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	Properties properties;
	Actions actions;

	public SearchPage(WebDriver driver, ExtentTest test) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.test = test;
		this.actions = new Actions(driver);
	}

	public boolean insertSearch(String item)

	{
		By searchBox = By.id("search");

		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((searchBox)));
			WebElement searchFeild = driver.findElement(searchBox);
			searchFeild.sendKeys(item);
			searchFeild.sendKeys(Keys.ENTER);
			Reports.generateReport(driver, test, Status.PASS, "Searching the item..");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Searching of the item failedd");

			actResult = false;

		}
		return actResult;

	}

	public boolean verifySearchResult() {
		By searchResult = By.xpath(
				"//div[@class='headersection row text-center']/" + "h2[contains(text(), 'Search results for')]\r\n");
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((searchResult)));

			Reports.generateReport(driver, test, Status.PASS, "Search  Result is not there");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Search Result  is not there");

			actResult = false;

		}
		return actResult;

	}

	public boolean applyFilter() {
		By filter = By.xpath("//div[span[text()='Recommended']]");
		By newArrival = By.xpath("//li[normalize-space()='New Arrivals']");
		boolean actResult = true;

		try {

			actions.moveToElement(driver.findElement(filter)).moveToElement(driver.findElement(newArrival)).click()
					.build().perform();

			// Report success
			Reports.generateReport(driver, test, Status.PASS, "Navigation to Register is successful");
			actResult = true;
		} catch (Exception te) {
			// Capture failure
			Reports.generateReport(driver, test, Status.FAIL, "Navigation to Register failed: " + te.getMessage());
			actResult = false;
		}

		return actResult;
	}

	public boolean verifyFilter() {
		boolean actResult = true;

		By newArrival = By.xpath("//div[@class='gname']/span");
		WebElement spanElement = driver.findElement(newArrival);

		String spanText = spanElement.getText();
		System.out.println(spanText);

		try {
			if (spanText.equals("New Arrivals")) {
				actResult = true;
			}
			Reports.generateReport(driver, test, Status.PASS, "Navigation to Register is successful");

		} catch (Exception te) {
			Reports.generateReport(driver, test, Status.FAIL, "Navigation to Register failed: " + te.getMessage());
			actResult = false;

		}
		return actResult;

	}

	public boolean setPrice() {
		By price = By.xpath("//div[normalize-space()='Price']");
		By leftsl = By.xpath("//div[@class='noUi-handle noUi-handle-lower']");
		By rightsl = By.xpath("//div[@class='noUi-handle noUi-handle-upper']");
		boolean actResult = true;

		try {

			actions.moveToElement(driver.findElement(price)).click();

			WebElement leftSlider = driver.findElement(leftsl);
			WebElement rightSlider = driver.findElement(rightsl);
			actions.clickAndHold(leftSlider).moveByOffset(50, 0).release();
			actions.clickAndHold(rightSlider).moveByOffset(-100, 0).release();
			
			System.out.println("passeddd...");
			Reports.generateReport(driver, test, Status.PASS, "Navigation to Register is successful");
			actResult = true;
		} catch (Exception te) {
			System.out.println("failedd....");
			Reports.generateReport(driver, test, Status.FAIL, "Navigation to Register failed: " + te.getMessage());
			actResult = false;
		}

		return actResult;
	}

	public boolean verifRatings() {
		boolean actResult;

		Reports.generateReport(driver, test, Status.FAIL, " Unable to find the verifyRatings..");
		actResult = false;

		return actResult;

	}

}
