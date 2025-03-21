package com.urbanladder.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pages.Login;
import com.urbanladder.pages.ProductDetailsPage;
import com.urbanladder.pages.Register;
import com.urbanladder.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UrbanladderProductDetails {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	Register register=new Register(driver,test);
	ProductDetailsPage  details = new ProductDetailsPage(driver,test);
	
	
	@Given("I am on the search result page")
	public void i_am_on_the_search_result_page() {
	
		
	 
	    boolean actResult;
	    actResult=details.verifyPage();
	    Assert.assertTrue(actResult);
	}

	@When("I click on a product")
	public void i_click_on_a_product() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult;
		    actResult=details.clickOnItem();
		 

		    Assert.assertTrue(actResult);
	}

	@Then("I should see the product title")
	public void i_should_see_the_product_title() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult;
		    actResult=details.verifyTitle();
		    Assert.assertTrue(actResult);
	}

	@Then("I should see the product description")
	public void i_should_see_the_product_description() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult;
		    actResult=details.verifyProductDetails();
		    Assert.assertTrue(actResult);
	}

	@Then("I should see the product price")
	public void i_should_see_the_product_price() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult;
		    actResult=details.verifyProuductPrice();
		    Assert.assertTrue(actResult);
	}



	@Then("I should see the product availability status")
	public void i_should_see_the_product_availability_status() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult;
		    actResult=details.verifyAvailibilty();
		    Assert.assertFalse(actResult);
	}

	@When("I click on the  Add to Wishlist button")
	public void i_click_on_the_add_to_wishlist_button() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult;
		    actResult=details.addToWishList();
		    Assert.assertTrue(actResult);
	}

	@Then("the product should be added to my wishlist")
	public void the_product_should_be_added_to_my_wishlist() {
	    // Write code here that turns the phrase above into concrete actions
		 boolean actResult;
		    actResult=details.verifyWishlist();
		    Assert.assertTrue(actResult);
	}

	@When("I click on the Add to Cart button")
	public void i_click_on_the_add_to_cart_button() {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
	    actResult=details.addToCart();
	    Assert.assertTrue(actResult);
	}

	@Then("the product should be added to my cart")
	public void the_product_should_be_added_to_my_cart() {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
	    actResult=details.verifyAddTocart();
	    Assert.assertTrue(actResult);
	}


}
