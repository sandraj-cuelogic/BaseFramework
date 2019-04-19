package com.Lucency.StepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.Lucency.PageObjects.AccountsPage;
import com.Lucency.PageObjects.LucencyHomePage;
import com.Lucency.Utilities.AutomationConfiguration;
import com.Lucency.Utilities.AutomationLog;
import com.Lucency.Utilities.ObjectManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class AccountsStepDefination {

	ObjectManager objManager;
	LucencyHomePage homepage;
	AccountsPage accountspage;
	WebDriver driver;
	
	public AccountsStepDefination(){
		objManager = new ObjectManager();
		homepage = objManager.getHomePage();
		accountspage=objManager.getAccountsPage();
		driver = objManager.getAppDriver();
	}

@Given("^Login to the application with super admin and navigate to Accounts module$")
	public void loginWithSuperAdmin(){
    
		try {
			driver.get(AutomationConfiguration.getConfigurationValueForProperty("url"));
			homepage.LogintoApplication(AutomationConfiguration.getConfigurationValueForProperty("Susername"), AutomationConfiguration.getConfigurationValueForProperty("Spassword"));
			driver.findElement(homepage.Admin).click();
			driver.findElement(homepage.AdminAccounts).click();
			Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Admin Console')]")).getText(), "Admin Console");
			
			}
		catch(Exception e) {
			AutomationLog.error(e.toString());
					
		}
}

/* 
 * 
 * This method will create user with Integrator role in account 
 * 
 * */ 
@Then("^Add new User with Integrator role$") 
	public void add_New_User_with_Integrator_role(){
	
	driver.findElement(accountspage.searchAccount).sendKeys("Automation Account");
	
	for(int i=1; i<=100;i++) {
		
	String accountname=driver.findElement(By.xpath("//*[@class='pure-g quadros']["+i+"]/descendant::span[1]")).getText();
		
		if(accountname.equals("Automation Account")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@class='pure-g quadros']["+i+"]/descendant::a[3]")).click();
			accountspage.createUser("Integrator");
			break;
		}
	}
}

@Then("^Add new user with Admin role$")
	public void Add_new_user_with_integrator_role(){
driver.findElement(accountspage.searchAccount).sendKeys("Automation Account");
	
	for(int i=1; i<=100;i++) {
		
	String accountname=driver.findElement(By.xpath("//*[@class='pure-g quadros']["+i+"]/descendant::span[1]")).getText();
		
		if(accountname.equals("Automation Account")) {
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@class='pure-g quadros']["+i+"]/descendant::a[3]")).click();
			accountspage.createUser("Admin");
			break;
		}
	}
	driver.navigate().refresh();
	homepage.LogoutFromApplication();

}

@Given("^Login to the application with Integrator and navigate to Users module$") 
public void Login_to_the_application_with_Integrator_and_navigate_to_Users_module() {
			
		System.out.println(homepage);
    	homepage.LogintoApplication(AutomationConfiguration.getConfigurationValueForProperty("Iusername"), AutomationConfiguration.getConfigurationValueForProperty("Ipassword"));
    	driver.findElement(homepage.AcountManager).click();
    	driver.findElement(homepage.User).click();
    	try{
    	String moduleName=driver.findElement(By.xpath("//*[@id='adminAccount-list']/descendant::div[starts-with(@id,'admin-account-list')]/h2")).getText();
    	if(moduleName.equals("Users")) {
    		AutomationLog.info("Successful able to navigate to User module");
    	}
    	else {
    		AutomationLog.error("Failed to navigate to Users Module ");
    		throw new WebDriverException();
    	}}
    	catch(Exception e){
    		AutomationLog.error("Failed to navigate to Users Module ");
    	}
    	driver.navigate().refresh();
    	homepage.LogoutFromApplication();
}
	@Given("^Login with superadmin to Lucency portal and verify create new account functionality by creating admin and integrator users$") 
		public void Create_new_account_with_admin_and_integrator_user(){

		homepage.LogintoApplication(AutomationConfiguration.getConfigurationValueForProperty("Susername"), AutomationConfiguration.getConfigurationValueForProperty("Spassword"));
		
	    
			}

	
	@Then("^Verify create new account functionality with alphanumeric account name$")
	public void Verify_create_new_account_functionality_with_alphanumeric_account_name(){
	    // Write code here that turns the phrase above into concrete actions
	
	}
	
	@Then("^Verify create new account functionality with numeric account name$")
	public void Verify_create_new_account_functionality_with_numeric_account_name()  {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	

}
