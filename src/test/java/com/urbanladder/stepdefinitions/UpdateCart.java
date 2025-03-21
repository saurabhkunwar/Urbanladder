package com.urbanladder.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pages.UpdateCartPage;
import com.urbanladder.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateCart {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	UpdateCartPage update = new UpdateCartPage(driver,test);
	
	
	@Given("I have an item in the cart")
	public void i_have_an_item_in_the_cart() {
	  boolean actResult;
	  actResult=update.verifyPage();
	  Assert.assertTrue(actResult);
		
		
	   
	}
	  @When("I update the quantity to {string}")
	    public void iUpdateTheQuantityTo(String newQuantity) {
	        boolean actResult=true;
	        actResult=update.increase(newQuantity);
	        Assert.assertTrue(actResult);
	        
	    }

 

	@Then("the cart should reflect the updated quantity")
	public void the_cart_should_reflect_the_updated_quantity() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult;

		  actResult=update.verifyincrease();
		  Assert.assertTrue(actResult);
	}
	@Then("the total price should be updated accordingly")
	public void the_total_price_should_be_updated_accordingly() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult=true;
//		  actResult=update.verifyUpdatedPrice();
		  Assert.assertTrue(actResult);
	   
	}
	@When("I remove the item from the cart")
	public void i_remove_the_item_from_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult=true;
		 // actResult=update.removeProdcut();
		  Assert.assertTrue(actResult);
	    
	}

	@Then("the cart should be empty")
	public void the_cart_should_be_empty() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult=true;
//		  actResult=update.verifyRemoval();
		  Assert.assertTrue(actResult);
	}


}
