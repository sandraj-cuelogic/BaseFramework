package com.Lucency.StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Lucency.PageObjects.AccountManagerPage;
import com.Lucency.PageObjects.AccountsPage;
import com.Lucency.PageObjects.LucencyHomePage;
import com.Lucency.Utilities.AutomationConfiguration;
import com.Lucency.Utilities.AutomationLog;
import com.Lucency.Utilities.ObjectManager;
import com.Lucency.constants.GenericFunctions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
@SuppressWarnings("deprecation")
public class AccountsManagerStepDefination  {
	
	ObjectManager objManager;
	LucencyHomePage homepage;
	AccountManagerPage accountManagerpage;
	AccountsPage accountspage;
	GenericFunctions genericFunction;// = new GenericFunctions();
	WebDriver driver;
	
	public AccountsManagerStepDefination(){

		objManager=new ObjectManager();
		homepage=objManager.getHomePage();
		accountManagerpage=objManager.getAccountManagerPage();
		accountspage=objManager.getAccountsPage();
		driver = objManager.getAppDriver();
		genericFunction = new GenericFunctions();
	}
	
	@Given("^Login to the application with Integrator and navigate to Users module.$")
	public void login_to_the_application_with_Integrator_and_navigate_to_Users_module() throws Throwable {
//		driver.get("https://www.stg.lucency.com/");
		homepage.LogintoApplication(AutomationConfiguration.getConfigurationValueForProperty("Iusername"), AutomationConfiguration.getConfigurationValueForProperty("Ipassword"));
		try{
			
			driver.findElement(homepage.AcountManager).click();
			driver.findElement(homepage.User).click();
		  	}
		catch(Exception e){
			AutomationLog.error("Fail to navigate to User mode " + e.toString());
			e.printStackTrace();
		}
	}

	
	@Then("^verify the Add User button is enable and create new Admin user.$")
	public void verify_the_Add_User_button_is_enable_and_create_new_Admin_user() throws Throwable {

	    driver.findElement(accountManagerpage.AddUser).click();
	    accountspage.createUser("Admin");
	    genericFunction.waitElemetToBeVisible(driver.findElement(accountspage.flashMsg));
	    accountspage.searcUser();
	}

	@Then("^Create integrator user and verify it has listed in the tables.$")
	public void create_integrator_user_and_verify_it_has_listed_in_the_tables() throws Throwable {
		driver.findElement(accountManagerpage.AddUser).click();
	    accountspage.createUser("Integrator");
	    genericFunction.waitElemetToBeVisible(driver.findElement(accountspage.flashMsg));
	    accountspage.searcUser();
	}

	@When("^user is on Users module then click on Edit button of newly created user$")
	public void user_is_on_Users_module_then_click_on_Edit_button_of_newly_created_user()  {
	
		try {
			driver.navigate().refresh();
			driver.findElement(By.xpath("//*[@id='users-list']/tr[1]/td[7]/a/span[contains(text(),'Edit')]")).click();
			genericFunction.waitElemetToBeVisible(driver.findElement(By.id("modal-header")));
			System.out.println("--------------- "+driver.findElement(By.id("modal-header")).getText()+"-------------------------------------------------------");
			if(driver.findElement(By.id("modal-header")).getText().equals("Edit User")) {
							
							AutomationLog.info("Successfullay able to open Edit user popup");
				}
			}
			catch(Exception e) {
					AutomationLog.error("Fail to open Edit User popup for newly added user.");
			}
	}

	@Then("^On Edit User popup, change the user name and user role and click on Save button$")
	public void on_Edit_User_popup_change_the_user_name_and_user_role_and_click_on_Save_button() throws Throwable {
		
		try {
			
			driver.findElement(accountspage.firstName).clear();
			driver.findElement(accountspage.firstName).sendKeys("Edited Name "+ genericFunction.generateRandomText(5));
			GenericFunctions.selectByIndex(accountspage.userRole, 2);
			driver.findElement(accountspage.addUser).click();
			genericFunction.waitElemetToBeVisible(driver.findElement(accountspage.flashMsg));
			String msg=driver.findElement(accountspage.flashMsg).getText();
			Assert.assertEquals("User was successfully updated.", msg.subSequence(0, 30));
			AutomationLog.info("Successfully able to Edit the users firstname and role");
			}
			catch(Exception e) {
				AutomationLog.error("Failed to Edit newly created user due to : "+e.toString());
			}
		
	}

	@Then("^verify Delete functionality for newly created user$")
	public void verify_Delete_user_functionality_for_newly_created_user() throws Throwable {
			try {
			 driver.navigate().refresh();
			 WebElement search=driver.findElement(accountspage.searchUser);
				search.sendKeys(accountspage.emailId);
				search.sendKeys(Keys.ENTER);
			 driver.findElement(By.xpath("//*[@id='users-list']/tr[1]/td[7]/a/span[contains(text(),'Delete')]")).click();
			 driver.findElement(By.xpath("//*[@class='modal-content box']/descendant::a[@data-method='delete']")).click();
			 String msg=driver.findElement(accountspage.flashMsg).getText();
			 Assert.assertEquals("User was successfully destroyed.", msg.subSequence(0, 32));
			 AutomationLog.info("User was successfully destroyed.");
			 homepage.LogoutFromApplication();
			}
			 catch(Exception e) {
				 AutomationLog.error(e.toString());
			 }
		}

}
