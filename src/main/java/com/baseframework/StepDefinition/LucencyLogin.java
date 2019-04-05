package com.baseframework.StepDefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.baseframework.PageObjects.HomePage;
import com.baseframework.automationFramework.AppDriver;
import com.baseframework.automationFramework.ObjectManager;
import com.baseframework.constants.BrowserDetails;
import com.baseframework.constants.GenericFunctions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LucencyLogin  {

	
	ObjectManager objManager = new ObjectManager();
	public  WebDriver driver = objManager.getAppDriver();
	HomePage homePage = objManager.getHomePage();

	

	/*
	 * public LucencyLogin() { homePage = objManager.getHomePage();
	 * 
	 * }
	 */

	@Given("^User should navigate to login page and login to application to \"([^\"]*)\"$")
	public void user_should_navigate_to_login_page_and_login_to_application_to(String browserName) throws Throwable {
		System.out.println(browserName + "___________________________");
		driver = objManager.getAppDriver();
		System.out.println(driver + "------------------------------------ LucencyLogin");
		driver.get(objManager.getAutomationConfiguration().getConfigurationValueForProperty("applicationURL"));
		String username = objManager.getAutomationConfiguration().getConfigurationValueForProperty("Susername");
		String password = objManager.getAutomationConfiguration().getConfigurationValueForProperty("Spassword");
		objManager.getHomePage().LogintoApplication(username, password);

	}

	@Then("^verify that user has successful logged to application$")
	public void verifySuccessfulLogin() {

//		homepage=objManager.getHomePage();
//		Assert.assertEquals("Failed to get Username from Homepage", "AdminHarshad",
		driver.findElement(objManager.getHomePage().Username).getText();
		objManager.getLogs().info("Login verified successfully");
	}

	@Given("^Validate the login functionality with invalid credentials$")
	public void verifyLoginWithInvalidCredentials() {

		try {

			objManager.getHomePage().LogoutToApplication();
			driver.navigate().refresh();
			

			objManager.getHomePage().LogintoApplication(objManager.getGenericFunctions().generateRandomEmailid(),
					RandomStringUtils.randomAlphanumeric(3));
			Assert.assertEquals("Please enter at least 8 characters.",
					driver.findElement(objManager.getHomePage().PasswordError).getText());
			driver.navigate().refresh();
			objManager.getHomePage().LogintoApplication(objManager.getGenericFunctions().generateRandomEmailid(),
					RandomStringUtils.randomAlphanumeric(8));
			Assert.assertEquals("Either email or password invalid.",
					driver.findElement(objManager.getHomePage().PasswordError).getText());
			driver.navigate().refresh();
			objManager.getHomePage().LogintoApplication(objManager.getGenericFunctions().generateRandomEmailid(), "");
			Assert.assertEquals("This field is required.",
					driver.findElement(objManager.getHomePage().PasswordError).getText());
			driver.navigate().refresh();
			objManager.getHomePage().LogintoApplication("", RandomStringUtils.randomAlphanumeric(8));
			Assert.assertEquals("This field is required.",
					driver.findElement(objManager.getHomePage().EmailError).getText());
			driver.findElement(objManager.getHomePage().CloseLogin).click();
		} catch (Exception e) {
			objManager.getLogs().error(e.toString());
		}
	}

	@Given("^Enter email id on ForgotPassword popup$")
	public void Enter_email_id_on_ForgotPassword_popup() {

		System.out.println("----------------------Enter email id on ForgotPassword popup$--------------------------");
		String forgotEmailId = objManager.getAutomationConfiguration().getConfigurationValueForProperty("forgotEmailId");
		driver.get(objManager.getAutomationConfiguration().getConfigurationValueForProperty("applicationURL"));
		objManager.getHomePage().verifyForgotPassword(forgotEmailId);

	}

	@Then("^Verify email notification in the email$")
	public void Then_Verify_email_notification_in_the_email() {

		/*
		 * try { System.out.
		 * println("-----------------------Verify email notification in the email-----------------"
		 * );
		 * 
		 * driver.get(baseClass.getUrl("yopmail"));
		 * 
		 * String forgotEmailId=baseClass.getProperty("forgotEmailId");
		 * 
		 * GenericFunctions.verifyEmail(forgotEmailId,
		 * "Lucency","Reset your Lucency password");
		 * 
		 * ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		 * System.out.println(tabs.size()); driver.switchTo().window(tabs.get(1));
		 * driver.navigate().refresh(); System.out.println(driver.getCurrentUrl());
		 * if(driver.findElement(By.xpath("//*[@class='modal-title']")).getText().
		 * equals("Create New Password")) {
		 * 
		 * String randomPass=genericFunction.generateRandomEmailid();
		 * driver.findElement(By.id("user_password")).sendKeys(randomPass);
		 * driver.findElement(By.id("user_password_confirmation")).sendKeys(randomPass);
		 * // WebElement scrollBar=driver.findElement(By.id("mCSB_1_dragger_vertical"));
		 * // GenericFunctions.javaScriptScrollUp(scrollBar, driver); //
		 * window.scrollBy(0,1000) EventFiringWebDriver event=new
		 * EventFiringWebDriver(driver); event.
		 * executeScript("document.querySelector('//*[@class='terms-condition-wrap mCustomScrollbar _mCS_1']').scrollTop=1000"
		 * );
		 * 
		 * JavascriptExecutor jse = (JavascriptExecutor) driver;
		 * jse.executeScript("window.scrollBy(0,1000)", "");
		 * 
		 * } } catch(Exception e) { AutomationLogs.error(e.toString()); }
		 */
	}

}
