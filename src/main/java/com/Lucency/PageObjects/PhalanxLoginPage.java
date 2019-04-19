package com.Lucency.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Lucency.Utilities.AppDriver;
import com.Lucency.Utilities.ObjectManager;

public class PhalanxLoginPage {

	 ObjectManager objManager = new ObjectManager();
	 
	public By txtUsername = By.id("user_email");
	public By txtPassword = By.id("user_password");
	public By btnLogin = By.xpath("//*[@id=\"new_user\"]/div[4]/*[@value=\"Login\"]");
}
