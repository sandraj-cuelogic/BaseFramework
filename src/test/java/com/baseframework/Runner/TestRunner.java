package com.baseframework.Runner;


import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.baseframework.automationFramework.AppDriver;
import com.baseframework.automationFramework.AutomationConfiguration;
import com.baseframework.automationFramework.SaveScreenShots;
import com.baseframework.constants.BrowserDetails;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = "Feature", glue = { "com.baseframework.StepDefinition" }, plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)
@RunWith(Cucumber.class)
public class TestRunner {
	@BeforeClass
	public static void beforeTest() {
		System.out.println("test case is about start execution");
	}

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
		Reporter.loadXMLConfig(new File(AutomationConfiguration.getConfigurationValueForProperty("reportConfigPath")));
		driver.close();
	}
}
