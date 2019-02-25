package com.baseframework.automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.baseframework.constants.BrowserDetails;

public class AppDriver {
	
	private static AppDriver appDriver;
	static WebDriver driver = null;
	

	
	
	private AppDriver() {
		BrowserDetails browserDetails = new BrowserDetails();
		String browserName = browserDetails.getBrowserName();
		System.out.println(browserName + "+++++++++++++++");
		if(AutomationConfiguration.getConfigurationValueForProperty("executionType").equals("single")){
			switch (browserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "Binaries/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
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
		}		
	}
	
	public static WebDriver getInstance() {
		if(driver == null){
			appDriver= new AppDriver();
			return driver;
		}
		return driver;
	}

}
