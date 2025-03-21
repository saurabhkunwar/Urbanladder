package com.urbanladder.pages;

import java.time.Duration;
import java.util.List;
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

public class ProductDetailsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;
	Properties properties;
	Actions actions;
	WebElement element;

	public ProductDetailsPage(WebDriver driver, ExtentTest test) {
		// super();
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.actions = new Actions(driver);

	}

	public boolean verifyPage() {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    String currentUrl = driver.getCurrentUrl();
	    boolean actResult;
	    
	    boolean isOnSearchResultsPage = currentUrl.contains("search") || currentUrl.contains("results");
	    boolean isOnProductPage = currentUrl.contains("products");
	    boolean isOnWishlistPage = currentUrl.contains("wishlist");
	    boolean isOnCartPage = currentUrl.contains("cart");
	    
	    System.out.println("Current URL: " + currentUrl);
	    
	    try {
	        if (isOnSearchResultsPage) {
	            By searchResult = By.xpath("//h2[@class='withsubtext']");
	            wait.until(ExpectedConditions.visibilityOfElementLocated(searchResult));
	            Reports.generateReport(driver, test, Status.PASS, "Search results are displayed");
	            actResult = true;
	        } else if (isOnProductPage) {
	            Reports.generateReport(driver, test, Status.PASS, "Already on the product page");
	            actResult = true;
	        } else if (isOnWishlistPage) {
	            By wishlistItem = By.xpath("//div[@class='wishlist-item']");  // Update XPath as needed
	            wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistItem));
	            Reports.generateReport(driver, test, Status.PASS, "Wishlist page is displayed with items");
	            actResult = true;
	        } else if (isOnCartPage) {
	            By cartItem = By.xpath("//div[@class='cart-items']");  // Update XPath as needed
	            wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));
	            Reports.generateReport(driver, test, Status.PASS, "Cart page is displayed with items");
	            actResult = true;
	        } else {
	            Reports.generateReport(driver, test, Status.FAIL, "Unexpected page");
	            actResult = false;
	        }
	    } catch (Exception e) {
	        Reports.generateReport(driver, test, Status.FAIL, "Verification failed due to missing elements");
	        actResult = false;
	    }
	    
	    return actResult;
	}



	public boolean clickOnItem() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		By product = By.xpath("//body/div[@class='container']/div[@id='wrapper']/div[@id='content']/div[@id='search-results']/div[@class='row']/ul[@class='productlist small-block-grid-3']/li[2]/div[1]");
List<WebElement> products = driver.findElements(By.xpath("//body/div[@class='container']/div[@id='wrapper']/div[@id='content']/div[@id='search-results']/div[@class='row']/ul[@class='productlist small-block-grid-3']/li[2]/div[1]"));
		
		System.out.println("The size of the element is :" + products.size());
	
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((product)));

		element=wait.until(ExpectedConditions.elementToBeClickable(product));
			element.click();

			Reports.generateReport(driver, test, Status.PASS, " Item is present there  and clicked successfully");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Item is not clickable or item is note there");

			actResult = false;

		}
		return actResult;
	}

	public boolean verifyTitle() {
		By pageTitle = By.xpath("//h1[@class='page-heading product-title no-margin']");
		

		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((pageTitle)));
			element = driver.findElement(pageTitle);

			Reports.generateReport(driver, test, Status.PASS, "Product Title  is  there");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Product Title  is not there");

			actResult = false;

		}
		return actResult;

	}

	public boolean verifyProductDetails() {
		By productTitle = By.xpath("//span[contains(text(), 'Product Details')]\r\n");
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((productTitle)));
			element = driver.findElement(productTitle);

			Reports.generateReport(driver, test, Status.PASS, "ProductDetails  are   there");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Product Details are not there");

			actResult = false;

		}
		return actResult;

	}

	public boolean verifyProuductPrice() {
		By MRP = By.xpath("//div[@class=\"price-components\"]//*[contains(text(),'MRP')]");
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((MRP)));
			element = driver.findElement(MRP);

			Reports.generateReport(driver, test, Status.PASS, "ProductDetails  are   there");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Product Details are not there");

			actResult = false;

		}
		return actResult;

	}

	public boolean verifyAvailibilty() {

		Reports.generateReport(driver, test, Status.FAIL, "The Availiblty of the prdoudct section is not there ");

		return false;

	}

	public boolean addToWishList() {
		By wishlist = By.xpath("//span[@class=\"icofont icofont-heart_outline_thick wishicon\"]");
		boolean actResult;
		try {
			  wait.until(ExpectedConditions.urlContains("products"));

			wait.until(ExpectedConditions.visibilityOfElementLocated((wishlist)));
		
			element=wait.until(ExpectedConditions.elementToBeClickable(wishlist));
			element.click();

			Reports.generateReport(driver, test, Status.PASS, "Wishlist is  there");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Wishlist is not there");

			actResult = false;

		}
		return actResult;

	}

	public boolean verifyWishlist() {
		By wishlist =By.id("shortlist-badge");
		By checkWishlist= By.xpath("//h1[text()=\"My wishlist\"]");
		boolean actResult;
		try {
			  wait.until(ExpectedConditions.urlContains("products"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(wishlist));
			
		element= wait.until(ExpectedConditions.elementToBeClickable(wishlist));
		element.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(checkWishlist));
			
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "passed....");
			driver.navigate().back();
		} catch (Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "faileddd");
			actResult = false;
		}
		
		return actResult;

	}

	public boolean addToCart() {
		By Cart = By.xpath("//button[contains(text(), 'Add to Cart')]");
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Cart)));
			element = driver.findElement(Cart);
			wait.until(ExpectedConditions.elementToBeClickable(Cart));
			element.click();

			Reports.generateReport(driver, test, Status.PASS, "Item  added o the Cart ");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Item is did not added to  the Cart");

			actResult = false;

		}
		

		return actResult;

	}

	public boolean verifyAddTocart() {
		By Cart = By.id("cart-line-item-head");
		boolean actResult;
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated((Cart)));
			element = driver.findElement(Cart);
			
		
			Reports.generateReport(driver, test, Status.PASS, "Navigating to the cart section...... ");

			actResult = true;
		} catch (Exception te) {

			Reports.generateReport(driver, test, Status.FAIL, "Navigation failed....");

			actResult = false;

		}

		return actResult;

	}

}
