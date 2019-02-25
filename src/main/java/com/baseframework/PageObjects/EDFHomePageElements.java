package com.baseframework.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseframework.automationFramework.AppDriver;
import com.baseframework.constants.BrowserDetails;

public class EDFHomePageElements {
	
	BrowserDetails browserDetails = new BrowserDetails();
	WebDriver driver = AppDriver.getInstance();
	
	public WebElement element;
	
	public WebElement txt_Header(){
		try{
			element = driver.findElement(By.className("header-title"));
			return element;
		} catch(Exception e){
			throw e;
		}
	}

}
