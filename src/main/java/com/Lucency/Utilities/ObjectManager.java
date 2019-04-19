package com.Lucency.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Lucency.API.Tests.CreateSessionAPI;
import com.Lucency.PageObjects.AccountManagerPage;
import com.Lucency.PageObjects.AccountsPage;
import com.Lucency.PageObjects.HomePage;
import com.Lucency.PageObjects.LucencyHomePage;
import com.Lucency.PageObjects.PhalanxLoginPage;
import com.Lucency.PageObjects.PhoneNumbersPage;
import com.Lucency.constants.BrowserDetails;
import com.Lucency.constants.GenericFunctions;


public class ObjectManager{

	private AutomationLog automationLog;
	private BrowserDetails browsersDetails;
	private WebDriverWait webDriverWait;
//	private TestLinkStatusUpdate testLinkStatusUpdate;
	private AutomationConfiguration automationConfiguration;
	private HomePage homePage;
	private WebDriver appDriver;
	private GenericFunctions genericFunctions;
	private CreateSessionAPI createSessionAPI;
	private AccountsPage accountspage;
	private PhoneNumbersPage phonenumberpage;
	private AccountManagerPage accountManagerPage;
	private com.Lucency.PageObjects.LucencyHomePage homepage;

	/*
	 * public ObjectManager(WebDriver driver) { // TODO Auto-generated constructor
	 * stub driver = AppDriver.getInstance(); }
	 */

	public void ObjectManager() {

	}
	
	

	public WebDriver getAppDriver() {
		return (appDriver == null) ? appDriver = AppDriver.getInstance() : appDriver;
	}

	public BrowserDetails getBrowserDetails() {

		return (browsersDetails == null) ? browsersDetails = new BrowserDetails() : browsersDetails;
	}

	public AutomationLog getLogs() {
		return (automationLog == null) ? automationLog = new AutomationLog() : automationLog;
	}

	public WebDriverWait getWebDriverWait() {
		return (webDriverWait == null) ? webDriverWait = new WebDriverWait(appDriver, 120) : webDriverWait;
	}

	/*
	 * public TestLinkStatusUpdate getTestLinkStatusUpdate() {
	 * 
	 * return (testLinkStatusUpdate == null) ? testLinkStatusUpdate = new
	 * TestLinkStatusUpdate() : testLinkStatusUpdate; }
	 */
	public AccountsPage getAccountsPage() {
		return (accountspage==null)?accountspage=new AccountsPage(appDriver):accountspage;
	}
	
	public PhoneNumbersPage getPhoneNumbersPage(){
		
		return (phonenumberpage==null)?phonenumberpage=new PhoneNumbersPage(appDriver):phonenumberpage;
	}

	public AccountManagerPage getAccountManagerPage() {

		return (accountManagerPage == null) ? accountManagerPage = new AccountManagerPage(appDriver) : accountManagerPage;
	}
	public AutomationConfiguration getAutomationConfiguration() {
		return (automationConfiguration == null) ? automationConfiguration = new AutomationConfiguration()
				: automationConfiguration;
	}

	/*
	 * public PhalanxLoginPage getPhalanxLoginPage() { return (phalanxLoginPage ==
	 * null) ? phalanxLoginPage = new PhalanxLoginPage() : phalanxLoginPage; }
	 */
	
	public LucencyHomePage getHomePage() {
		return (homepage==null)?homepage=new LucencyHomePage(appDriver):homepage;
	}
	
	public GenericFunctions getGenericFunctions() {
		return (genericFunctions == null) ? genericFunctions = new GenericFunctions() : genericFunctions;
	}
	
	public CreateSessionAPI getCreateSession() {
		
		return(createSessionAPI==null)? createSessionAPI=new CreateSessionAPI():createSessionAPI;
	}
	
}
