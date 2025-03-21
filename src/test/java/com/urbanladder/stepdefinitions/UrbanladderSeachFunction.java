package com.urbanladder.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pages.SearchPage;
import com.urbanladder.utils.Base;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;





public class UrbanladderSeachFunction {
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	SearchPage searchpage= new SearchPage(driver,test);
	
	@When("the user searches for {string}")
	public void the_user_searches_for(String item) {
		boolean actResult;
		actResult=searchpage.insertSearch(item);
		Assert.assertTrue(actResult);
		
		
	}

	@Then("the search results should be displayed")
	public void the_search_results_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult=searchpage.verifySearchResult();
		Assert.assertTrue(actResult);
		
	}

	@When("the user applies the {string} filter")
	public void the_user_applies_the_filter(String string) {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult=searchpage.applyFilter();
		Assert.assertTrue(actResult);
	}

	@Then("only {string} should be shown")
	public void only_should_be_shown(String string) {
		boolean actResult;
		actResult=searchpage.verifyFilter();
		
		Assert.assertTrue(actResult);


		
	}

	@When("the user filters by price range {string}")
	public void the_user_filters_by_price_range(String string) {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult=searchpage.setPrice();
		Assert.assertTrue(actResult);

	}

	@Then("only products within the price range should be shown")
	public void only_products_within_the_price_range_should_be_shown() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Test excuted....");
	}

	@When("the user filters by {string} rating")
	public void the_user_filters_by_rating(String string) {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult=searchpage.verifRatings();
		Assert.assertFalse(actResult);
	
	}

	@Then("only products with {string} ratings and above should be shown")
	public void only_products_with_ratings_and_above_should_be_shown(String string) {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult=searchpage.verifRatings();
		Assert.assertFalse(actResult);
		
	}



}
