package com.baseframework.constants;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseframework.automationFramework.AppDriver;
import com.baseframework.automationFramework.ObjectManager;

/**
 * @author Harshad
 *
 */
public class GenericFunctions  {

	

	static ObjectManager objManager;
	private static Actions action;
	public static WebDriver driver = objManager.getAppDriver();
	/*
	 * GenericFunctions(WebDriver driver){
	 * 
	 * this.driver=driver;
	 * 
	 * }
	 */
	public WebElement waitElementToBeClicable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public Boolean waitElemetToBeAvailable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeSelected(element));

	}

	public WebElement waitElemetToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element));

	}

	public Select selectByIndex(By numberType, int index) {
		Select sel = new Select(driver.findElement(numberType));
		sel.selectByIndex(index);
		return sel;

	}

	public void selectByValue(By numberType, String value) {
		Select sel = new Select(driver.findElement(numberType));
		sel.selectByValue(value);
	}

	public void selectByVisisbleText(By element, String visibletext) {
		Select sel = new Select(driver.findElement(element));
		sel.selectByVisibleText(visibletext);

	}

	public static void deSelectByIndex(WebElement element, int deselectbyindex) {
		Select sel = new Select(element);
		sel.deselectByIndex(deselectbyindex);

	}

	public static void deSelectByValue(WebElement element, String deselectbyvalue) {
		Select sel = new Select(element);
		sel.deselectByValue(deselectbyvalue);

	}

	public static void deSelectByVisbleText(WebElement element, String deselectbyvisibletext) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(deselectbyvisibletext);

	}

	public static void deSelectAll(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();

	}

	public static void getAllSelectedOptions(List<WebElement> element) {
		Select sel = new Select((WebElement) element);
		sel.getAllSelectedOptions();
	}

	public static void getFirstSelectedOption(WebElement element) {
		Select sel = new Select(element);
		sel.getFirstSelectedOption();

	}

	public static void getOptions(List<WebElement> element) {
		Select sel = new Select((WebElement) element);
		sel.getOptions();

	}

	public static void isMultiple(WebElement element) {
		Select sel = new Select(element);
		sel.isMultiple();

	}

//----------------------generic methods for Actions class---------------------------------------

	public static void contextClick(WebDriver driver, WebElement target) {
//		Actions action=new Actions(driver);
		action.contextClick(target).perform();
	}

	public static void moveToElement(WebDriver driver, WebElement target) {

		action.moveToElement(target).perform();
	}

	public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	public static void compositAction(WebDriver driver, WebElement target, CharSequence keys) {
		Actions action = new Actions(driver);
		action.sendKeys(target, keys).build().perform();
	}

	public static void doubleClick(WebDriver driver, WebElement target) {
		Actions action = new Actions(driver);
		action.doubleClick(target).perform();
	}

	public static void moveToMouseHover(WebDriver driver, WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
	}

	public String generateRandomText(int textLength) {
		String randomText = RandomStringUtils.randomAlphabetic(textLength);
		objManager.getLogs().info(randomText);
		return randomText;
	}

	public String generateRandomNumbers(int numberLength) {
		String randomNumbers = RandomStringUtils.randomNumeric(numberLength);
		objManager.getLogs().info(randomNumbers);
		return randomNumbers;
	}

	public String generateRandomEmailid() {
		String randomEmail = RandomStringUtils.randomNumeric(2) + RandomStringUtils.randomAlphabetic(5) + "@"
				+ "yopmail.com";
		objManager.getLogs().info(randomEmail);
		return randomEmail;

	}

	public static void sendKeysUsingJavaScript(String input, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=" + "'" + input + "'" + ";" + "", element);

	}

	public static void clickUsingJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

	public void javaScriptScrollUp(WebElement scrollBar, WebDriver driver) {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(500)", scrollBar);

		} catch (Throwable e) {
			objManager.getLogs().error(e.toString());
		}
	}

	public void javaScriptScrollUpPage(WebElement scrollBar, WebDriver driver) {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollByLines(10)", scrollBar);

		} catch (Throwable e) {
			objManager.getLogs().error(e.toString());
		}
	}

	public static void verifyEmail(String emailId, String EmailFrom, String EmailTitle) {
//		objManager = new ObjectManager();
//		homepage = objManager.getHomePage();
		try {
			/* enter email id in textbox */

			driver.findElement(objManager.getHomePage().LoginIcon).sendKeys(emailId);
			driver.findElement(By.xpath("//input[@value='Check Inbox']")).click();
			for (int i = 1; i <= 10;) {

				List<WebElement> frames = driver.findElements(By.tagName("iframe"));

				for (WebElement ele : frames) {

					System.out.println(ele.getAttribute("id"));

					if (ele.getAttribute("id").equals("ifinbox")) {
						driver.switchTo().frame("ifinbox");
//						driver.findElement(By.id("e0")).click();
						String emailFrom = driver
								.findElement(By.xpath("//*[@class='m'][" + i + "]/descendant::a/span[1]")).getText();
						String emailTitle = driver
								.findElement(By.xpath("//*[@class='m'][" + i + "]/descendant::a/span[2]")).getText();

						if (emailTitle.contains(EmailTitle)) {

							driver.findElement(By.xpath("//*[@class='m'][" + i + "]/descendant::a/span[1]")).click();
							driver.switchTo().defaultContent();
							driver.switchTo().frame("ifmail");
							System.out.println(
									driver.findElement(By.xpath("//a[contains(text(),'Reset Password')]")).getText());

							WebElement resetPassword = driver
									.findElement(By.xpath("//a[contains(text(),'Reset Password')]"));

							if (resetPassword.isDisplayed()) {
								resetPassword.click();
								driver.wait(10000);
							}
						}
						break;
					}
				}
				break;
			}
		} catch (Exception e) {
			objManager.getLogs().error("Failed to verify email " + e.toString());
		}

	}
}