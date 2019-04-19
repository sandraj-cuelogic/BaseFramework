package com.Lucency.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Lucency.Utilities.AutomationConfiguration;
import com.Lucency.Utilities.AutomationLog;
import com.Lucency.Utilities.ObjectManager;
import com.Lucency.constants.GenericFunctions;

import junit.framework.Assert;

public class LucencyHomePage {
	ObjectManager objManager = new ObjectManager();
	
	/*
	 * @FindBy (id="login") public WebElement LoginIcon;
	 */
	String signoutMsg;
	GenericFunctions genericFunction=new GenericFunctions();
	public  WebDriver driver = objManager.getAppDriver();
	public By RequestDemo=By.xpath("//a[contains(text(),'Request Demo') and @href='https://www.int.lucency.com/demo_requests/new']");
	public By LoginIcon=By.id("login");
	public By Emailid = By.id("user_email");
	public By Password = By.id("user_password");
	public By LoginButton = By.xpath("//input[@type='submit']");
	public By Username = By.id("dropdownProfile");
	public By Logoutlink= By.xpath("//a[@class='dropdown-item' and contains(text(),'Log Out')]");
	public By CloseLogin= By.xpath("//img[@class='icons']");
	public By EmailError=By.xpath("//*[@for='user_email' and contains(text(),'This field is required.')]");
	public By PasswordError= By.xpath("//label[@for='user_password']");
	By forgotPasswordLink=By.xpath("//a[contains(text(),'Forgot Password')]");
	By forgotPassword=By.xpath("//*[@class='modal-title']");
	
	/* Menu's on Integrator Home page */
	By IntegratorHome = By.xpath("//*[@class='active']/descendant::strong");
	public By AcountManager = By.xpath("//aside[@id='menu']/descendant::li[2]/a");
	public By User=By.xpath("//*[@id='collapseAccount']/descendant::a[1]/strong");
	public By APIKeys=By.xpath("//*[@id='collapseAccount']/descendant::a[2]/strong");
	public By Campaigns = By.xpath("//*[@class='menu-sub'][2]/descendant::strong[1]");
	public By PhoneNumbers = By.xpath("//*[@class='menu-sub'][3]/descendant::strong[1]");
	public By CountryPools=By.xpath("//*[@id='collapsePhone']/li[1]");
	public By Viewnumbers=By.xpath("//*[@id='collapsePhone']/li[2]");
	public By PhoneRequests=By.xpath("//*[@id='collapsePhone']/li[3]");
	public By Documentation = By.xpath("//*[@class='menu-sub'][4]/descendant::strong[1]");
	public By ErrorLog = By.xpath("//*[@class='menu-sub'][5]/descendant::strong[1]");
	public By SessionLookup = By.xpath("//*[@class='menu-sub'][6]/descendant::strong[1]");
	
	/* Elements on Admin Home page */
	public By AdminHome = By.xpath("//*[@class='menu-sub']/descendant::strong[contains(text(),'Home')]");
	public By AdminDocumentation = By.xpath("//strong[contains(text(),'Documentation')]");
	public By AdminSessionLookup = By.xpath("//strong[contains(text(),'Session Lookup')]");
	public By Admin = By.xpath("//*[@class='menu-sub'][3]/a/strong");
	public By AdminAccounts=By.xpath("//*[@id='collapseAdmin']/li[2]/a");
	public By AdminCreateAccounts=By.xpath("//*[@id='collapseAdmin']/li[1]");
	public By AdminUserRole=By.xpath("//*[@id='collapseAdmin']/li[3]");
	public By AdminPhoneRequests=By.xpath("//*[@id='collapseAdmin']/li[4]");
	public By AdminRestingNumbers=By.xpath("//*[@id='collapseAdmin']/li[5]");
	public By FlashMsg=By.xpath("//*[@id='flash-msg']/div");
	/*
	 * @FindBy (id="user_email") public WebElement EmailId;
	 * 
	 * @FindBy (id="user_password") public WebElement Password;
	 * 
	 * @FindBy (xpath="//input[@type='submit']") public WebElement LoginButton;
	 * 
	 * @FindBy (xpath="//*[@class='active']/descendant::strong") public WebElement
	 * Home;
	 * 
	 * @FindBy (xpath="//*[@class='menu-sub'][1]/descendant::strong[1]") public
	 * WebElement AcountManager;
	 * 
	 * @FindBy (xpath="//*[@class='menu-sub'][2]/descendant::strong[1]") public
	 * WebElement Campaigns;
	 * 
	 * @FindBy (xpath="//*[@class='menu-sub'][3]/descendant::strong[1]") public
	 * WebElement PhoneNumbers;
	 * 
	 * @FindBy (xpath="//*[@class='menu-sub'][4]/descendant::strong[1]") public
	 * WebElement Documentation;
	 * 
	 * @FindBy (xpath="//*[@class='menu-sub'][5]/descendant::strong[1]") public
	 * WebElement ErrorLog;
	 * 
	 * @FindBy (xpath="//*[@class='menu-sub'][6]/descendant::strong[1]") public
	 * WebElement SessionLookup;
	 */
	
	
	public LucencyHomePage(WebDriver driver) {
		
		driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	/**This function will click on Home menu available for Integrator on homepage*/	
	public void clickOnHome() {
		driver.findElement(IntegratorHome).click();
		
	}
	/**This function will click on Account Manager menu available for Integrator on homepage*/	
	public void clickOnAcountManager() {
		driver.findElement(AcountManager).click();
//		AcountManager.click();
	}
	
	/**This function will click on Campaign menu available for Integrator on homepage*/	
	public void clickOnCampaigns() {
		driver.findElement(Campaigns).click();
//		Campaigns.click();
	}
	/**This function will click on Phone Numbers menu available for Integrator on homepage*/
	public void clickOnPhoneNumbers() {
		driver.findElement(PhoneNumbers).click();
//		PhoneNumbers.click();
		}
	/**This function will click on Documents menu available for Integrator on homepage*/
	public void clickOnDocumentation() {
		driver.findElement(Documentation).click();
//		Documentation.click();
	}

	/**This function will click on ErrorLogs menu available for Integrator on homepage*/
	public void clickOnErrorLog() {
		driver.findElement(ErrorLog).click();
//		ErrorLog.click();
	}
	/**This function will click on Session Lookup menu available for Integrator on homepage*/
	public void clickOnSessionLookup() {
		
		driver.findElement(SessionLookup).click();
//		SessionLookup.click();
	}
	
	
	
	
	/**This method will perform login to Lucency application as an integrator or admin by passing username and password as a parameter*/
	public void LogintoApplication(String username, String password) {
			try {
			driver.get(AutomationConfiguration.getConfigurationValueForProperty("url"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.navigate().refresh();
			driver.findElement(LoginIcon).click();
			driver.findElement(Emailid).click();
			GenericFunctions.sendKeysUsingJavaScript(username, driver.findElement(Emailid));
			GenericFunctions.sendKeysUsingJavaScript(password, driver.findElement(Password));
			driver.findElement(LoginButton).click();
			if(driver.findElement(Username).isDisplayed()){
				AutomationLog.info("Successful login to Lucency Applciation");
				
			}
			else{
				Assert.fail("Failed to login to Application");
			}
			
			}
			catch(Exception e) {
				
				AutomationLog.error("Failed to login Application : "+ e.toString());
				e.printStackTrace();
			
			}
		}
	
	public void LogoutFromApplication() {
		try {
		genericFunction.waitElementToBeClicable(driver.findElement(Username));
		driver.findElement(Username).click();
		driver.findElement(Logoutlink).click();
		if(driver.findElement(RequestDemo).isDisplayed()){
			AutomationLog.info("Successfully logged out from Application");
		}
		}
		catch(Exception e) {
			
			AutomationLog.error("Failed to Logout from Application : "+e.toString());
			e.printStackTrace();
			
		}
	}
	public void verifyForgotPassword(String forgotEmailId) {
		try {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(LoginIcon).click();	
		driver.findElement(forgotPasswordLink).click();
		String popupTitle=driver.findElement(forgotPassword).getText();
		System.out.println("Reset PopUp screen title : "+popupTitle);
		driver.findElement(Emailid).sendKeys(forgotEmailId);
		driver.findElement(LoginButton).click();
		
		AutomationLog.info("Reset password link sent to email account : "+ forgotEmailId);
		
		}
		
		catch(Exception e) {
			
			AutomationLog.error("Unable to send forgot password email : "+ e.toString());
			e.printStackTrace();
		}
	}
	
	
}
