package com.Lucency.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Lucency.Utilities.AutomationLog;
import com.Lucency.Utilities.ObjectManager;
import com.Lucency.constants.GenericFunctions;

import junit.framework.Assert;

public class AccountsPage{	
	
	ObjectManager objManager;
	LucencyHomePage homepage;
	
	public By searchAccount=By.id("searchAccounts");
	public By searchUser=By.id("searchUsers");
	public By firstName=By.id("first_name");
	public By userRole=By.id("user_role_id");
	public By flashMsg=By.xpath("//*[@id='flash-msg']/div");
	public By addUser=By.id("form-submit");
	By lastName=By.id("last_name");
	By phone=By.id("phone");
	By email=By.id("email");
	By re_enterEmail=By.id("email_confirmation");

	By close=By.className("icons");
	
	
	public String emailId="";
	GenericFunctions genericFunction = new GenericFunctions();
	 public  WebDriver driver = objManager.getAppDriver();
	
public AccountsPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

/**
 *  @Description This method will create new user as per require role
 *
 */

@SuppressWarnings({ "deprecation", "unused" })
public String createUser(String role) {
	try {
			
			driver.findElement(firstName).sendKeys(genericFunction.generateRandomText(5));
			
			driver.findElement(lastName).sendKeys(genericFunction.generateRandomText(5));
			GenericFunctions.sendKeysUsingJavaScript(genericFunction.generateRandomNumbers(11),driver.findElement(phone));
			emailId=genericFunction.generateRandomEmailid();
			driver.findElement(email).click();
			genericFunction.waitElementToBeClicable(driver.findElement(email));
			GenericFunctions.sendKeysUsingJavaScript(emailId, driver.findElement(email));
			GenericFunctions.sendKeysUsingJavaScript(emailId, driver.findElement(re_enterEmail));
				if(role.equalsIgnoreCase("Admin")) {
					genericFunction.selectByVisisbleText(userRole, "Administrator");	
					}
			driver.findElement(addUser).click();
/*			genericFunction.waitElemetToBeAvailable(driver.findElement(flashMsg));
				if(driver.findElement(flashMsg).isDisplayed()) {
					AutomationLogs.info("User created successfully");
					
					}*/
				/*else if (driver.findElement(By.xpath("//input[@id='phone']/following-sibling::label")).isDisplayed()) {
						driver.findElement(phone).sendKeys(genericFunction.generateRandomNumbers(11));
						driver.findElement(addUser).click();
						genericFunction.waitElementToBeClicable(driver.findElement(searchUser));
					
						
						}
				else if(driver.findElement(By.xpath("//input[@id='email']/following-sibling::label")).isDisplayed()){
						driver.findElement(email).clear();
						emailId=genericFunction.generateRandomEmailid();
						driver.findElement(email).sendKeys(emailId);
						driver.findElement(re_enterEmail).clear();
						driver.findElement(re_enterEmail).sendKeys(emailId);
						driver.findElement(addUser).click();
						genericFunction.waitElementToBeClicable(driver.findElement(searchUser));
					
						
					}
				else {
					driver.findElement(searchUser).clear();
				
				}
*/
			}
		catch(Exception e) {
			AutomationLog.error(" unable to create "+role+" user due to :"+e.toString());
			e.printStackTrace();
			
			}

	return emailId;
}

/**
 *  @Description This method will search the newly added user on the Users module by their email id's
 *
 */

public void searcUser() {
	try {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement search=driver.findElement(searchUser);
//	search.clear();
	search.sendKeys(emailId);
	search.sendKeys(Keys.ENTER);
	String emailid=driver.findElement(By.xpath("//*[@id='users-list']/tr[1]/td[5]/div")).getText();
	System.out.println("current emaild id: "+emailid );
	System.out.println("page class emaild id: "+emailId );
	if(emailid.equalsIgnoreCase(emailId)) {
		AutomationLog.info("Successfully able to search newly added user");
	} 
	else {
		AutomationLog.error("Failed to verify newly added user in the table");
	}
}
	catch(Exception e) {
		
	}
}
}
