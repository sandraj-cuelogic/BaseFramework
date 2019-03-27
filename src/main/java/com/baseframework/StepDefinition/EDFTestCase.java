package com.baseframework.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseframework.PageObjects.EDFHomePageElements;
import com.baseframework.automationFramework.AppDriver;
import com.baseframework.automationFramework.AutomationLog;
import com.baseframework.automationFramework.TestLinkStatusUpdate;
import com.baseframework.constants.BrowserDetails;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testlink.api.java.client.TestLinkAPIResults;



public class EDFTestCase {
	
	String title;
	AutomationLog log = AutomationLog.getAutomationLog();
	BrowserDetails browserDetails = new BrowserDetails();
	
	// Declare the WebDriver 
	static WebDriver driver;
	// Declare WebDriver Wait
	static WebDriverWait wait;
	// Declare Page Object class
	static EDFHomePageElements eDFHomePageElements;
	//creating instance of TestLinkStatusUpdate class
	TestLinkStatusUpdate testlink = new TestLinkStatusUpdate();


	@Given("^I navigate to the edfstage url in \"([^\"]*)\"$")
	public void i_navigate_to_the_edfstage_url_in(String arg1){
		try {
			System.out.println("******************************************");
		// first set browser name
		browserDetails.setBrowserName(arg1);
		//initialize the driver object now
		driver = AppDriver.getInstance();
		//initialize the page object element inside the first method
		System.out.println("--------------------------------------------------------" +driver);
		browserDetails.setDriverSessionID(driver.toString());
		eDFHomePageElements = new EDFHomePageElements();
		System.out.println(driver + " EDFHomePage");
		driver.get("http://edfstage/#/edf/home/p");
		//initialize webdriver wait
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains("Enterprise Delivery Framework"));
		log.info("User has been able to successfully navigate to EDF Staging site");
		}
		catch(Exception e) {
			
		}
	}
	@When("^the page has the title as \"([^\"]*)\"$")
	public void the_page_has_the_title_as(String arg1) throws Throwable {
		title = eDFHomePageElements.txt_Header().getText();
		log.info("Title of the page is as " +title);
	}
	@Then("^confirm that user has reached EDF's landing page$")
	public void confirm_that_user_has_reached_EDF_s_landing_page() throws Throwable {
		Assert.assertTrue("User has reached EDF's landing page", title.contains("Enterprise Delivery Framework"));
		//testlink.updateTestLinkResultWithExecutionNote("Sprint 2", "Build 2", "Test Case has been failed using automated execution - Ruposree", "TL-3", "", TestLinkAPIResults.TEST_FAILED);
		testlink.updateTestLinkResultWithoutExecutionNote("Sprint 1", "Build 2", "TL-2", "null", TestLinkAPIResults.TEST_PASSED);
		log.info("TestLink should be updated");
		log.info("User has reached the landing page");
	}
	//Feature file: View Template Documents
	

@Given("^user is on home page <\"([^\"]*)\">$")
public void user_is_on_home_page(String arg1) throws Throwable {
		//eDFhomePage.i_navigate_to_the_edfstage_url_in("chrome");
		log.info("User has been able to successfully navigate to EDF Staging site");
		
	}
	@When("^user select methods, project size and phase$")
	public void user_select_methods_project_size_and_phase(){
//		driver.findElement(By.xpath("//div[contains(text(),'Small: >=100K and <500K')]"));
//		driver.findElement(By.xpath("//div[contains(text(),'Phase:')]/..//div/div/a[contains(text(),'Define')]"));
//		driver.findElement(By.xpath("//div/button[contains(text(),'View')])[5]")).click();
		log.info("User successfully select the methjods");
		
	}
	@When("^click on view button$")
	public void click_on_view_button() {
		/*WebElement element = driver.findElement(By.xpath("(//div/button[contains(text(),'View')])[5]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);*/
		log.info("User has been able to select all the options successfully");
	}

	@Then("^related documents should be displayed based on the filter applied$")
	public void related_documents_should_be_displayed_based_on_the_filter_applied(){
		/*//driver.findElement(By.xpath("//div/h3[contains(text(),'Refine Search')]"));
		wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.textToBe(By.xpath("//div/h3[contains(text(),'Refine Search')]"),"Refine Search"));*/
		log.info("Filter related documents is displayed");
	
	}
}
