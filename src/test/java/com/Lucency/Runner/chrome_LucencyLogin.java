package com.Lucency.Runner;


import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.Lucency.Utilities.AppDriver;
import com.Lucency.Utilities.AutomationConfiguration;
import com.Lucency.Utilities.CopyExecutionReportToReportsPath;
import com.Lucency.Utilities.SaveScreenShots;
import com.Lucency.constants.BrowserDetails;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.bytebuddy.asm.Advice.This;

@CucumberOptions(
		features = "Feature", 
		glue = { "com.baseframework.StepDefinition" }, 
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/chrome_LucencyLogin_Report.html" }, 
		monochrome = true,
		tags = "@chrome_LucencyLogin")
		
@RunWith(Cucumber.class)

public class chrome_LucencyLogin {
	@BeforeClass
	public static void beforeTest() {
		System.out.println("test case is about start execution");
		String className = "chrome_LucencyLogin";
		if(className.contains("_")) {
			String[] browserName = className.split("_");
			String browserNameString = browserName[0];
			System.out.println(browserNameString);
			BrowserDetails browserDetails = new BrowserDetails();
			browserDetails.setBrowserName(browserNameString);
			System.out.println(BrowserDetails.browserName  + " ______________________ from beforeTest method");
			
//			WebDriver driver = AppDriver.getInstance();
		} else {
			System.out.println("No underscore in class name");
		}
		
	}
	@AfterClass
	public static void afterTest() throws IOException {
		WebDriver driver = AppDriver.getInstance();
		SaveScreenShots saveScreenShots = new SaveScreenShots();
		saveScreenShots.customScreenshot("Final Screenshot");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.loadXMLConfig(new File(AutomationConfiguration.getConfigurationValueForProperty("reportConfigPath")));
		driver.close();
		
				
		CopyExecutionReportToReportsPath copyReports = new CopyExecutionReportToReportsPath();
		copyReports.copyReportToReportsPath("chrome_LucencyLogin_Report.html");
		
	}
}
