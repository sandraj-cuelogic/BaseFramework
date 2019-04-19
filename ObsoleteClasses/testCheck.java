/*
 * package com.baseframework.StepDefinition;
 * 
 * import org.junit.Assert; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import com.baseframework.PageObjects.EDFHomePageElements; import
 * com.baseframework.automationFramework.AppDriver; import
 * com.baseframework.automationFramework.AutomationLog; import
 * com.baseframework.automationFramework.TestLinkStatusUpdate; import
 * com.baseframework.constants.BrowserDetails;
 * 
 * import cucumber.api.PendingException; import cucumber.api.java.en.Given;
 * import cucumber.api.java.en.Then; import cucumber.api.java.en.When; import
 * testlink.api.java.client.TestLinkAPIResults;
 * 
 * public class testCheck {
 * 
 * String title; AutomationLog log = AutomationLog.getAutomationLog();
 * BrowserDetails browserDetails = new BrowserDetails(); // Declare the
 * WebDriver static WebDriver driver; // Declare WebDriver Wait static
 * WebDriverWait wait; // Declare Page Object class static EDFHomePageElements
 * eDFHomePageElements; TestLinkStatusUpdate testlink = new
 * TestLinkStatusUpdate();
 * 
 * 
 * @Given("^I navigate  to edfstage url in \"([^\"]*)\"$") public void
 * i_navigate_to_edfstage_url_in(String arg1) throws Throwable {
 * browserDetails.setBrowserName(arg1); //initialize the driver object now
 * driver = AppDriver.getInstance(); //initialize the page object element inside
 * the first method eDFHomePageElements = new EDFHomePageElements();
 * System.out.println(driver + " EDFHomePage");
 * driver.get("http://edfstage/#/edf/home/p"); //initialize webdriver wait wait
 * = new WebDriverWait(driver, 60);
 * wait.until(ExpectedConditions.titleContains("Enterprise Delivery Framework"))
 * ;
 * log.info("User has been able to successfully navigate to EDF Staging site");
 * // throw new PendingException(); }
 * 
 * @When("^the page has title as \"([^\"]*)\"$") public void
 * the_page_has_title_as(String arg1) throws Throwable { title =
 * eDFHomePageElements.txt_Header().getText();
 * log.info("Title of the page is as " +title);
 * 
 * }
 * 
 * @Then("^confirm that user has reached EDF's landing webpage$") public void
 * confirm_that_user_has_reached_EDF_s_landing_webpage() throws Throwable {
 * Assert.assertTrue("User has reached EDF's landing page",
 * title.contains("Enterprise Delivery Framework"));
 * testlink.updateTestLinkResultWithExecutionNote("Sprint 1", "Commit ID - 1",
 * "Test Case has passed using automated execution", "TL-1", "",
 * TestLinkAPIResults.TEST_PASSED);
 * log.info("User has reached the landing page"); }
 * 
 * }
 */