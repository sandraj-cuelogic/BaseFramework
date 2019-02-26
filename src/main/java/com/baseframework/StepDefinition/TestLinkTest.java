package com.baseframework.StepDefinition;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;

public class TestLinkTest {
	public static WebDriver dr;
	public static String DEV_KEY = "25f31f7a4327e79ceeef71c7a9816eac7ade4f57b4c6b337ec31c5ef483e1665"; // Your API Key
	public static String PROJECT_NAME = "TestLink - Test";
	public static String PLAN_NAME = "Sprint 1";
	public static String BUILD_NAME = "Commit ID - 1";
	public static String SERVER_URL = "http://10.1.6.196/index.php"; // your testlink server url

//	@org.junit.Test
	public void TestOne() throws Exception {
		String result = "";
		String exception = null;
		try {
			dr = new FirefoxDriver();
			dr.get("https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1#identifier");
			dr.manage().window().maximize();
//			result = TestLinkAPIResults.TEST_PASSED;
			updateTestLinkResult("TL-1", null, result);
		} catch (Exception e) {
//			result = TestLinkAPIResults.TEST_FAILED;
			exception = e.getMessage();
			updateTestLinkResult("TL-1", exception, result);
		}
		try {
			dr.findElement(By.id("Email")).sendKeys("your gmail login id");
			Thread.sleep(2000);
			dr.findElement(By.id("next")).click();
			Thread.sleep(1000);
			dr.findElement(By.id("Passwd")).sendKeys("*********");
			Thread.sleep(1000);
			dr.findElement(By.id("signIn")).click();
//			result = TestLinkAPIResults.TEST_PASSED;
			updateTestLinkResult("TL-2", null, result);
		} catch (Exception e) {
//			result = TestLinkAPIResults.TEST_FAILED;
			exception = e.getMessage();
			updateTestLinkResult("TL-2", exception, result);
		}
	}

	private void updateTestLinkResult(String testCase, String exception,String result) throws TestLinkAPIException, MalformedURLException {
		URL url = new URL(SERVER_URL);
		TestLinkAPI testlinkAPIClient = new TestLinkAPI(url, DEV_KEY);
		System.out.println(testlinkAPIClient.getDevKey() + "***************************************");
//		testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME,testCase, BUILD_NAME, exception, result);
//		testlinkAPIClient.reportTCResult(testCase, "", PLAN_NAME, result, "", "", BUILD_NAME, "", "", "", "", "", "", "");
	}
	
	public static void main(String[] args) throws TestLinkAPIException, MalformedURLException {
		System.out.println("its in here");
		TestLinkTest test = new TestLinkTest();
		test.updateTestLinkResult("", "", "");
		System.out.println("it left");
	}
	

	
}
