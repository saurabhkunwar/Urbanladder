package com.urbanladder.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.urbanladder.pages.HomePage;
import com.urbanladder.utils.Base;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UrbanladderHomePage { 
    WebDriver driver = Base.driver;
    ExtentTest test = Hooks.test;  
    HomePage homepage = new HomePage(driver, test);

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        boolean actResult = homepage.validUrl();
        Assert.assertTrue("Home page URL validation failed", actResult);
    }

    @Then("the user should see Top Offers section")
    public void the_user_should_see_top_offers_section() {
        boolean actResult = homepage.verifyTopOffers();
        Assert.assertTrue("Top Offers section not visible", actResult);
    }

    @Then("the user should see Best Sellers section")
    public void the_user_should_see_best_sellers_section() {
        boolean actResult = homepage.verifyBestSeller();
        Assert.assertTrue("Best Sellers section not visible", actResult);
    }

    @Then("the user should see the search bar")
    public void the_user_should_see_the_search_bar() {
        boolean actResult = homepage.verifySeachBox(); // Fixed method name
        Assert.assertTrue("Search bar not visible", actResult);
    }
}
