package com.urbanladder.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pages.Checkout;
import com.urbanladder.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UrbanladderChekout {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	Checkout checkout= new Checkout(driver,test);
	


	@Given("I have items in the cart")
	public void i_have_items_in_the_cart() {
		boolean actResult;
		actResult=checkout.verifyPage();
		Assert.assertTrue(actResult);
		
		 
	    
	   
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		boolean actResult;
		actResult=checkout.proceedtoCheckout();
		Assert.assertTrue(actResult);
		
	}

	@Then("I should be redirected to the checkout page")
	public void i_should_be_redirected_to_the_checkout_page() {
		boolean actResult;
		actResult=checkout.checkoutPage();
		Assert.assertTrue(actResult);
		
	    
	}

	@Then("the order summary should be displayed")
	public void the_order_summary_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	  
		boolean actResult;
		actResult=checkout.verifyOrderSummary();
		Assert.assertTrue(actResult);
	}

	

}
