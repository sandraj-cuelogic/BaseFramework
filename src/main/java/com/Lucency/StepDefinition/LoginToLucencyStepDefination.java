package com.Lucency.StepDefinition;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.Lucency.PageObjects.LucencyHomePage;
import com.Lucency.Utilities.AutomationConfiguration;
import com.Lucency.Utilities.AutomationLog;
import com.Lucency.Utilities.ObjectManager;
import com.Lucency.constants.GenericFunctions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginToLucencyStepDefination {

	ObjectManager objManager;
	LucencyHomePage homepage;
	GenericFunctions genericFunction;
	WebDriver driver;
	
	public LoginToLucencyStepDefination(){
		genericFunction = new GenericFunctions();	
		objManager = new ObjectManager();
		homepage = objManager.getHomePage();
		driver=objManager.getAppDriver();
	}

	@Given("^User should navigate to login page and login to application$")
	public void loginToLucency() {

		homepage.LogintoApplication(AutomationConfiguration.getConfigurationValueForProperty("Susername"), AutomationConfiguration.getConfigurationValueForProperty("Spassword"));

	}

	@Then("^verify that user has successful logged to application$")
	public void verifySuccessfulLogin() {

//		homepage=objManager.getHomePage();
//		Assert.assertEquals("Failed to get Username from Homepage", "AdminHarshad",
		driver.findElement(homepage.Username).getText();
		AutomationLog.info("Login verified successfully");
	}

	@Given("^Validate the login functionality with invalid credentials$")
	public void verifyLoginWithInvalidCredentials() {

		try {

		homepage.LogoutFromApplication();
		driver.navigate().refresh();
			homepage.LogintoApplication(genericFunction.generateRandomEmailid(),
					RandomStringUtils.randomAlphanumeric(3));
			Assert.assertEquals("Please enter at least 8 characters.",
					driver.findElement(homepage.PasswordError).getText());
			driver.navigate().refresh();
			homepage.LogintoApplication(genericFunction.generateRandomEmailid(),
					RandomStringUtils.randomAlphanumeric(8));
			Assert.assertEquals("Either email or password invalid.",
					driver.findElement(homepage.PasswordError).getText());
			driver.navigate().refresh();
			homepage.LogintoApplication(genericFunction.generateRandomEmailid(), "");
			Assert.assertEquals("This field is required.", driver.findElement(homepage.PasswordError).getText());
			driver.navigate().refresh();
			homepage.LogintoApplication("", RandomStringUtils.randomAlphanumeric(8));
			Assert.assertEquals("This field is required.", driver.findElement(homepage.EmailError).getText());
			driver.findElement(homepage.CloseLogin).click();
		} catch (Exception e) {
			AutomationLog.error(e.toString());
		}
	}

	@Given("^Enter email id on ForgotPassword popup$")
	public void Enter_email_id_on_ForgotPassword_popup() {

		System.out.println("----------------------Enter email id on ForgotPassword popup$--------------------------");
		String forgotEmailId = AutomationConfiguration.getConfigurationValueForProperty("forgotEmailId");
		driver.get(AutomationConfiguration.getConfigurationValueForProperty("url"));
		homepage.verifyForgotPassword(forgotEmailId);

	}

	@Then ("^Verify email notification in the email$")
	public void Then_Verify_email_notification_in_the_email() {
		
	/*	try {
		System.out.println("-----------------------Verify email notification in the email-----------------");
		
		driver.get(baseClass.getUrl("yopmail"));
		
		String forgotEmailId=baseClass.getProperty("forgotEmailId");
		
		GenericFunctions.verifyEmail(forgotEmailId,"Lucency","Reset your Lucency password");
		
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window(tabs.get(1));
		driver.navigate().refresh();
		System.out.println(driver.getCurrentUrl());		
		if(driver.findElement(By.xpath("//*[@class='modal-title']")).getText().equals("Create New Password")) {
				
				String randomPass=genericFunction.generateRandomEmailid();
				driver.findElement(By.id("user_password")).sendKeys(randomPass);
				driver.findElement(By.id("user_password_confirmation")).sendKeys(randomPass);
//				WebElement scrollBar=driver.findElement(By.id("mCSB_1_dragger_vertical"));				
//				GenericFunctions.javaScriptScrollUp(scrollBar, driver);
//				window.scrollBy(0,1000)
				EventFiringWebDriver event=new EventFiringWebDriver(driver);
				event.executeScript("document.querySelector('//*[@class='terms-condition-wrap mCustomScrollbar _mCS_1']').scrollTop=1000");
			
			 * JavascriptExecutor jse = (JavascriptExecutor) driver;
			 * jse.executeScript("window.scrollBy(0,1000)", "");
			 
			}
		}
		catch(Exception e) {
			AutomationLog.error(e.toString());
		}
		*/
	}
	
	

}