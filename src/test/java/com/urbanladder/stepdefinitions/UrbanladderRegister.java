package com.urbanladder.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.pages.Login;
import com.urbanladder.pages.Register;
import com.urbanladder.pages.UpdateUser;
import com.urbanladder.utils.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UrbanladderRegister {
	
	WebDriver driver = Base.driver;
	ExtentTest test = Hooks.test;
	Register register=new Register(driver,test);
	Login login = new Login(driver,test);
	UpdateUser updateuser=  new UpdateUser(driver,test);

	@When("the user navigates to the registration page")
	public void the_user_navigates_to_the_registration_page() {

		boolean actResult;
		actResult=register.navigateToRegister();
		Assert.assertTrue(actResult);
	   
	}

	@When("Provides {string} and {string}")
	public void enters_and(String unm1, String unm2) {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult= register.signUp(unm1, unm2);
		
		Assert.assertTrue(actResult);
	     
	}

	@When("submits the registration form")
	public void submits_the_registration_form() {
	    // Write code here that turns the phrase above into concrete actions
		   // Write code here that turns the phrase above into concrete actions
				boolean actResult;
	 			actResult= register.submit();
				Assert.assertTrue(actResult);
	    
	}

	@Then("the account should be created successfully")
	public void the_account_should_be_created_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult= register.validSignUp();
		Assert.assertTrue(actResult);
	  
	}

	@When("the user navigates to the login page")
	public void the_user_navigates_to_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult= login.loginSection();
		Assert.assertTrue(actResult);
	  
	}

	@When("enters {string} and {string}")
	public void clicks_the_login_button(String unm1,String unm2) {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult= login.signIn(unm1,unm2);
		System.out.println(unm1 +" " + unm2);
		System.out.println(actResult);
		Assert.assertTrue(actResult);
	}
	@When("clicks the login button")
	public void clicks_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(true);
	}
	

	@Then("the user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult= login.submit();
		Assert.assertTrue(actResult);
		  
	}

	@Given("the user is logged in")
	public void the_user_is_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult= login.validSignIn();
		Assert.assertTrue(actResult);
	}

	@When("the user navigates to the account settings page")
	public void the_user_navigates_to_the_account_settings_page() {
		
		boolean actResult;
		actResult= updateuser.NavigatetoSettings();
		Assert.assertTrue(actResult);
		
	}

	@When("updates the password from {string} to {string}")
	public void updates_the_password_from_to(String string, String string2) {
		
		boolean actResult;
		actResult= updateuser.editPassword(string2);
		Assert.assertTrue(actResult);
	   
	   
	}

	@When("saves the changes")
	public void saves_the_changes() {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult= updateuser.update();
		Assert.assertTrue(actResult);
	}

	@Then("the password should be updated successfully")
	public void the_password_should_be_updated_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		boolean actResult;
		actResult= updateuser.verifyUpdate();
		Assert.assertTrue(actResult);
	}


}
