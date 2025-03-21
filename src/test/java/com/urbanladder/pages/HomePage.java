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

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	Properties properties;
	// WebElements in the HomePage
	By discount = By.xpath("//div[contains(text(), 'Enjoy up to ')]");
	By bestSeller = By.xpath("//h2[text()=\"Our Bestsellers, Handpicked Just for You\"]");
	By searchBox = By.id("search");

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.test = test;
		this.properties = PropertyReader.readProperty();

	}

	public boolean validUrl() {

		String currURl = driver.getCurrentUrl();
		String actualURL = properties.getProperty("URL");
		boolean actResult;

		if (currURl.equals(actualURL)) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "Urbanladder is launched Successful");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Urbanladder is launched failure");
		}
		return actResult;

	}

	public boolean verifyTopOffers() {
		boolean actResult;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(discount));

		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "Urbanladder is launched Successful");
			System.out.println("element displayeed");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Urbanladder is failed to Launch");
			System.out.println("Element not displayed");
		}
		return actResult;

	}

	public boolean verifyBestSeller() {
		boolean actResult;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(bestSeller));

		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "Best Seller Element is  present on the Home Page");
			System.out.println("element displayeed for the best seller");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Best Seller Element is not present on the Home Page");
			System.out.println("Element not displayed");
		}
		return actResult;
	}

	public boolean verifySeachBox() {
		boolean actResult;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));

		if (element.isDisplayed()) {
			actResult = true;
			Reports.generateReport(driver, test, Status.PASS, "element is present in the page");
			System.out.println("Search box is there  ");
		} else {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "element is not in the page");
			System.out.println("Search Box is  not there ");
		}
		return actResult;

	}

}
