package com.baseframework.StepDefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.baseframework.automationFramework.AppDriver;
import com.baseframework.automationFramework.ObjectManager;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PhalanxInvalidLogin  {
	
	 String title; 
	 WebDriver driver;
	 ObjectManager objManager = new ObjectManager();
	 
	 
	
	@Given("^I navigate to the phalanx url in \"([^\"]*)\"$")
	public void i_navigate_to_the_phalanx_url_in(String browserName) throws Throwable {
		System.out.println(browserName + "___________________________");
		objManager.getBrowserDetails().setBrowserName(browserName);
		driver = objManager.getAppDriver();
		System.out.println("Method 1: "+  driver);
		System.out.println(objManager.getBrowserDetails().getBrowserName());
		driver.get(objManager.getAutomationConfiguration().getConfigurationValueForProperty("applicationURL"));
		objManager.getWebDriverWait().until(ExpectedConditions.visibilityOf(driver.findElement(objManager.getPhalanxLoginPage().txtUsername)));
		System.out.println(driver.findElement(objManager.getPhalanxLoginPage().txtPassword));

	}

	@When("^login page is displayed$")
	public void login_page_is_displayed() throws Throwable {
		System.out.println("Method 2: "+  driver);
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^insert incorrect username and password$")
	public void insert_incorrect_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^click on the 'Login'button$")
	public void click_on_the_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^confirm when the error message is displayed to the user$")
	public void confirm_when_the_error_message_is_displayed_to_the_user() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
