package com.Lucency.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.Lucency.Utilities.AutomationLog;
import com.Lucency.Utilities.ObjectManager;
import com.Lucency.constants.GenericFunctions;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PhoneNumbersPage {
	
	By PoolName=By.id("country_pool_name");
	By CountryCode=By.className("flag-container");
	By NumberType=By.id("country_pool_number_type");
	By CloseIcon=By.xpath("//*[@id='modal-header']/button/img");
	By RequestCount= By.id("request_count");
	
	/*	Buttons*/	
	By createCountryPool=By.xpath("//a[@class='btn hasicon default-colorbg right-float btn-medium']");
	By RequestCountryPoolNumbers=By.xpath("//*[@class='modal-content box']/descendant::input[@name='commit']");	
	By RequestNumbers=By.xpath("//a[@class='btn btn-main default-colorbg mr-1']");
	
	/*Objects*/
	GenericFunctions genericFunction=new GenericFunctions();
	ObjectManager objManager = new ObjectManager();
	LucencyHomePage homepage;
	public  WebDriver driver = objManager.getAppDriver();
	private String poolName;
	
	/*Constructor*/
	public PhoneNumbersPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	/** createCountryPool() method will create new country pool for US country and verify in the grid*/
	public void createCountryPool() throws  Exception{
		try{
			
		driver.findElement(createCountryPool).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		genericFunction.waitElemetToBeVisible(driver.findElement(By.xpath("//*[@class='modal-content box']//*[@id='modal-header']/h5")));
		if(driver.findElement(By.xpath("//*[@class='modal-content box']//*[@id='modal-header']/h5")).getText().equals("Create Country Pool")){
			genericFunction.waitElementToBeClicable(driver.findElement(PoolName));
			driver.findElement(PoolName).sendKeys("US"+genericFunction.generateRandomText(6));
			poolName=driver.findElement(PoolName).getAttribute("value");
			genericFunction.waitElementToBeClicable(driver.findElement(By.xpath("//*[@class='input-wrap select-field']")));
			driver.findElement(By.xpath("//*[@class='input-wrap select-field']")).click();
			driver.findElement(By.xpath("//*[@class='input-wrap select-field']/descendant::li[3]/label")).click();
			genericFunction.waitElementToBeClicable(driver.findElement(RequestCountryPoolNumbers));
			driver.findElement(RequestCountryPoolNumbers).click();
			driver.findElement(RequestCount).sendKeys("10");
			genericFunction.waitElementToBeClicable(driver.findElement(RequestCountryPoolNumbers));
			driver.findElement(RequestCountryPoolNumbers).click();
			homepage=objManager.getHomePage();
			genericFunction.waitElemetToBeVisible(driver.findElement(homepage.FlashMsg));
			
			try{
			if(driver.findElement(homepage.FlashMsg).getText().contains("Country Pool was successfully created.")){
				
				List<WebElement> Poolnames=driver.findElements(By.xpath("//*[@class='list']//td[@class='bordered country-pool-name']"));
				System.out.println("Total country pools : "+Poolnames.size());
				
				for(WebElement e:Poolnames){
					
//					System.out.println(e.getText());
					System.out.println(e.getText());
					if(e.getText().equals(poolName)){
						AutomationLog.info("Country Pool "+ poolName +" successfully created for US country");
						break;
					}
					else{
						continue;
					}
				}

			}
			
			else{
				AutomationLog.error("Failed to verify success message on screen");
				 throw new WebDriverException( "Failed to verify success message on screen");
				}
			}
			catch(Exception e){
				e.printStackTrace();
				}
			}
		}
		catch(Exception e){

			if(driver.findElement(By.xpath("//*[@id='flash-msg']/div[2]")).getText().startsWith("Rouge")){
			
				AutomationLog.error("Unable to verify created country pool due to Rogue server error");
				}
			else{
				
			AutomationLog.fatal(e.toString());
			e.printStackTrace();
			}
		}		
	}
	
	/** The editAndRequestNumbersInPool() method will request more phone numbers for selected country pool*/
	public void editAndRequestNumbersInPool(){
		try{
			driver.navigate().refresh();
		List<WebElement> Poolnames=driver.findElements(By.xpath("//*[@class='list']//td[@class='bordered country-pool-name']"));
		
		for(int i=1; i<Poolnames.size();i++){
			
			WebElement cpoolname=driver.findElement(By.xpath("//*[@class='list']/descendant::td[@class='bordered country-pool-name']["+i+"]/div"));
			
			String poolnames=cpoolname.getText();

			System.out.println(poolnames);
			if(i>11){
				driver.findElement(By.id("mCSB_1")).sendKeys(Keys.ARROW_DOWN);
			}

			if(poolnames.contains(poolName)){
				
				driver.findElement(By.xpath("//*[@class='list']/descendant::td[@class='bordered buttons center-align']["+i+"]/a[1]/span")).click();
				Assert.assertEquals("The actual and expected Country Pool is not same", poolName, driver.findElement(PoolName).getAttribute("value") );
				driver.findElement(RequestNumbers).click();
				driver.findElement(RequestCount).sendKeys("2");
				driver.findElement(RequestCountryPoolNumbers).click();
					if(driver.findElement(homepage.FlashMsg).getText().contains("Request to add numbers was successfully created.")){
					
						AutomationLog.info("Request to add numbers was successfully created for pool "+ poolName);
						
						break;
						}
							else{
									AutomationLog.error("Fail to verify success message of adding new number to pool");
									}
				}
					else{
						System.out.println("verifying next country pool");
						continue;
					}	
				}
			}
		catch(Exception e){
			
			AutomationLog.error(e.toString());
			e.printStackTrace();
			}
		}
	}
