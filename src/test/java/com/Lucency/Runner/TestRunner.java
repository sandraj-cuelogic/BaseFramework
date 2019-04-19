package com.Lucency.Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.Lucency.Utilities.AppDriver;
import com.Lucency.Utilities.AutomationConfiguration;
import com.Lucency.Utilities.SaveScreenShots;
import com.Lucency.constants.BrowserDetails;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.bytebuddy.asm.Advice.This;

@CucumberOptions (
		features = "Feature", 
		glue = { "com.Lucency.StepDefinition" }, 
//		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		monochrome = true, 
		tags = {"@smoke" })

@RunWith(Cucumber.class)
public class TestRunner {
	@BeforeClass
	public static void beforeTest() {
		System.out.println("test case is about start execution");
		if (This.class.getName().contains("_")) {
			String[] browserName = This.class.getName().split("_");
			String browserNameString = browserName[0];
			System.out.println(browserNameString);
			BrowserDetails browserDetails = new BrowserDetails();
			browserDetails.setBrowserName(browserNameString);
			System.out.println(BrowserDetails.browserName);
		} else {
			System.out.println("No underscore in class name");
		}

	}

	@AfterClass
	public static void afterTest() {

		WebDriver driver = AppDriver.getInstance();
		SaveScreenShots saveScreenShots = new SaveScreenShots();
		saveScreenShots.customScreenshot("Final Screenshot");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) { // TODO
			// Auto-generated catch block
			e.printStackTrace();
		}

//		BrowserDetails browserDetails = new BrowserDetails();

		Reporter.loadXMLConfig(new File(AutomationConfiguration.getConfigurationValueForProperty("reportConfigPath")));

		if (driver != null) {
			driver.quit();
			System.out.println("WebDriver was found and quit() was called");
		} else {
			System.out.println("WebDriver was not found");
		}

	}
}
