package StepDef;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import Utility.Base1;

public class Page1 {
    public static Base1 base;
    WebDriverWait wait;
    Select select;
    JavascriptExecutor js;

    By searchInput = By.xpath("//input[@class='form-control input-lg']");
    By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    
    By addToCart = By.xpath("//button[@type='button' and contains(@onclick, \"cart.add('43', '1')\")]");
    By cart = By.id("cart");
    By checkout = By.xpath("//strong[i[@class='fa fa-share'] and contains(text(), 'Checkout')]");
//    By Guest= By.xpath("//input[@name='account' and @value='guest']");
//    By GuestContinue= By.id("button-account");
   By firstName= By.id("input-payment-firstname");
    By lastName= By.id("input-payment-lastname");
    By email= By.id("input-payment-email");
    By TelePhone =By.id("input-payment-telephone");
    By address= By.id("input-payment-address-1");
  By city=By.id("input-payment-city");
    By postalcode=By.id("input-payment-postcode");
//    By checkbox=By.xpath("//input[@type='checkbox' and @name='shipping_address']");
    By continueBtn= By.id("button-payment-address");
//    
    By regionDropdown = By.id("input-payment-zone");
    By countryDropdown = By.id("input-payment-country");
    By checkbox2 = By.id("input-register-agree");
    By continueButton = By.id("button-account");
    By continueGuest = By.id("button-guest");
    By shippingAddressBtn=By.id("button-guest-shipping");
    By commentButton= By.id("button-shipping-method");
    By  textArea= By.id("//textarea[@name='comment']");
    By checkbox= By.xpath("//input[@type='checkbox' and @name='shipping_address']");
    By termsCondtion =By.xpath("//input[@type=checkbox and @name=agree]");
    public void Search(String product) {
        base.driver.findElement(searchInput).sendKeys(product);
        base.driver.findElement(searchButton).click();
    }

    public boolean Visible() {
        wait = new WebDriverWait(base.driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cart)).isDisplayed();
    }

    public void add_to_cart() {
        base.driver.findElement(addToCart).click();
        System.out.println("Adding product to the cart");
    }

    public boolean checkCart() {
      
        base.driver.findElement(cart).click();
        return true; // Add verification logic
    }

    public void Checkout() {
    
    	    wait = new WebDriverWait(base.driver, Duration.ofSeconds(10));

    	    try {
    	        WebElement checkoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(checkout));
    	        if (checkoutButton.isDisplayed() && checkoutButton.isEnabled()) {
    	            checkoutButton.click();
    	        } else {
    	            JavascriptExecutor js = (JavascriptExecutor) base.driver;
    	            js.executeScript("arguments[0].click();", checkoutButton);
    	        }
    	        System.out.println("Navigating to Payment Page...");
    	    } catch (TimeoutException e) {
    	        System.out.println("Checkout button not found or not clickable within timeout.");
    	        throw e;
    	    }
    	}

    

    public void Payment() {
    	  wait = new WebDriverWait(base.driver, Duration.ofSeconds(10));

    	WebElement continuebutton = wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
    	continuebutton.click();
    	base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
    	base.driver.findElement(firstName).sendKeys("saurabh");
    	base.driver.findElement(lastName).sendKeys("kunwar");
    	//base.driver.findElement(email).sendKeys("abc23@gmail.com");
    	base.driver.findElement(TelePhone).sendKeys("233434334344");
    	base.driver.findElement(city).sendKeys("Dehradun");
    	WebElement continueguest = wait.until(ExpectedConditions.presenceOfElementLocated(continueGuest));
    	continueguest.click();
    	WebElement check = wait.until(ExpectedConditions.elementToBeClickable(checkbox));
    	if(!check.isSelected())
    	{
    		check.click();
    	}
    	//base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	
    	base.driver.findElement(textArea).sendKeys("Order within a week");
//    	WebElement text= wait.until(ExpectedConditions.presenceOfElementLocated(textArea));
//    	text.sendKeys("order within a weeek");
    	WebElement check2 = wait.until(ExpectedConditions.elementToBeClickable(termsCondtion));
    	if(!check2.isSelected())
    	{
    		check2.click();
    	}
    	base.driver.findElement(commentButton).click();
    	
    }
}
