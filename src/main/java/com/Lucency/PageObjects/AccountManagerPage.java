package com.Lucency.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Lucency.Utilities.ObjectManager;


public class AccountManagerPage {

	ObjectManager objManager;
	LucencyHomePage homepage;
	
	public AccountManagerPage(WebDriver driver){
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*---------Buttons-------*/
	public By AddUser= By.xpath("//*[starts-with(@id,'admin-account-list')]/a");
	
}
