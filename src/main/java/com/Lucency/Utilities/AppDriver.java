package com.Lucency.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.Lucency.constants.BrowserDetails;

public class AppDriver {

	private static AppDriver appDriver;
	protected static WebDriver driver = null;
	String browserName;
	
	public AppDriver() {
		if(AutomationConfiguration.getConfigurationValueForProperty("executionType").equals("single")) {
			browserName = AutomationConfiguration.getConfigurationValueForProperty("browser");
		} else {
			 browserName = BrowserDetails.browserName;
		}
		System.out.println(browserName + "+++++++++++++++");
		
		if (browserName != null && browserName != "") {
			switch (browserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "Binaries/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				//Initialize log file for folder
				break;

			case "internetExplorer":
				System.setProperty("webdriver.ie.driver", "Binaries/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "Binaries/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;

			default:
				System.setProperty("webdriver.chrome.driver", "Binaries/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			}
		} else {
			
			driver = null;
		}
	}

	public static WebDriver getInstance() {
		if (driver == null) {
			appDriver = new AppDriver();
			return driver;
		}
		return driver;
	}

}