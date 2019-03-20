package com.baseframework.Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.baseframework.automationFramework.AppDriver;
import com.baseframework.automationFramework.AutomationConfiguration;
import com.baseframework.automationFramework.SaveScreenShots;
import com.baseframework.constants.BrowserDetails;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = "Feature", glue = { "com.baseframework.StepDefinition" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)


@RunWith(Cucumber.class)
public class TestRunner {
	@BeforeClass
	public static void beforeTest() {
		System.out.println("test case is about start execution");
	}

	

	public static ExtentHtmlReporter htmlReporter;
    
	@AfterClass
	public static void afterTest() {
		WebDriver driver = AppDriver.getInstance();
		SaveScreenShots saveScreenShots = new SaveScreenShots();
		saveScreenShots.customScreenshot();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrowserDetails browserDetails = new BrowserDetails();
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "target/"+browserDetails.getBrowserName()+".html");

		Reporter.loadXMLConfig(new File(AutomationConfiguration.getConfigurationValueForProperty("reportConfigPath")));
		if(driver != null) {
			driver.quit();
			System.out.println("WebDriver was found and quit() was called");
		}
		else {
			System.out.println("WebDriver was not found");
		}
		
		
	}
}
