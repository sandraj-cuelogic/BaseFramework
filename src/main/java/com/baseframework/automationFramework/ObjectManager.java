package com.baseframework.automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseframework.PageObjects.HomePage;
import com.baseframework.PageObjects.PhalanxLoginPage;
import com.baseframework.constants.BrowserDetails;
import com.baseframework.constants.GenericFunctions;

public class ObjectManager{

	private AutomationLog automationLog;
	private BrowserDetails browsersDetails;
	private WebDriverWait webDriverWait;
	private TestLinkStatusUpdate testLinkStatusUpdate;
	private AutomationConfiguration automationConfiguration;
	private PhalanxLoginPage phalanxLoginPage;
	private HomePage homePage;
	private WebDriver appDriver;
	private GenericFunctions genericFunctions;

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

	public TestLinkStatusUpdate getTestLinkStatusUpdate() {

		return (testLinkStatusUpdate == null) ? testLinkStatusUpdate = new TestLinkStatusUpdate()
				: testLinkStatusUpdate;
	}

	public AutomationConfiguration getAutomationConfiguration() {
		return (automationConfiguration == null) ? automationConfiguration = new AutomationConfiguration()
				: automationConfiguration;
	}

	public PhalanxLoginPage getPhalanxLoginPage() {
		return (phalanxLoginPage == null) ? phalanxLoginPage = new PhalanxLoginPage() : phalanxLoginPage;
	}
	
	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage() : homePage;
	}
	
	public GenericFunctions getGenericFunctions() {
		return (genericFunctions == null) ? genericFunctions = new GenericFunctions() : genericFunctions;
	}
	
}
