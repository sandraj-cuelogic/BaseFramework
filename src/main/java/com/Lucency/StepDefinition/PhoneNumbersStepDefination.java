package com.Lucency.StepDefinition;

import org.openqa.selenium.WebDriver;

import com.Lucency.PageObjects.AccountsPage;
import com.Lucency.PageObjects.LucencyHomePage;
import com.Lucency.PageObjects.PhoneNumbersPage;
import com.Lucency.Utilities.AutomationConfiguration;
import com.Lucency.Utilities.ObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PhoneNumbersStepDefination {

	ObjectManager objManager;
	PhoneNumbersPage phonepage;
	AccountsPage accountspage;
	LucencyHomePage homepage;
	WebDriver driver;
	
	public PhoneNumbersStepDefination(){
		objManager = new ObjectManager();
		phonepage=objManager.getPhoneNumbersPage();
		homepage=objManager.getHomePage();
		driver=objManager.getAppDriver();

	}
	
	@Given("^Login with Integrator and create country pool for IN country$")
	public void verify_create_Country_Pool() throws Exception{
		
		
		homepage.LogintoApplication(AutomationConfiguration.getConfigurationValueForProperty("Iusername"), AutomationConfiguration.getConfigurationValueForProperty("Ipassword"));		
		homepage.clickOnPhoneNumbers();
		driver.findElement(homepage.CountryPools).click();
		phonepage.createCountryPool();
	}
	@Then("^Edit any of the country pool and request more numbers$")
	public void Edit_any_of_the_country_pool_and_request_more_numbers(){
		
		phonepage.editAndRequestNumbersInPool();
		
	}
	
	@Then ("^Verify the edit country pool if user clear the pool name also the Remove number should be disabled$")
	public void Verify_the_edit_country_pool_if_user_clear_the_pool_name_also_the_Remove_number_should_be_disabled(){
		
	}
	
	
}
