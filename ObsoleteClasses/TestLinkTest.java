//package com.baseframework.StepDefinition;
//
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
////import org.testng.annotations.Test;
//import testlink.api.java.client.TestLinkAPIClient;
//import testlink.api.java.client.TestLinkAPIException;
//import testlink.api.java.client.TestLinkAPIResults;
//
//
//public class TestLinkTest {
//		public static WebDriver dr;
//		public static String DEV_KEY = "e22b16aa20a53349fd7b61386d5f3d88"; //Your API Key
//		public static String SERVER_URL = "http://10.1.6.196/lib/api/xmlrpc/v1/xmlrpc.php"
//				+ ""; //your testlink server url
//		public static String PROJECT_NAME = "TestLink - Test"; 
//		public static String PLAN_NAME = "Sprint 1";
//		public static String BUILD_NAME = "Commit ID - 1";
//
//@Test
//public void TestOne() throws Exception
//{
//	String result = "";
//	String exception = null;
//		try{
//				dr = new FirefoxDriver();
//				dr.get("https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1#identifier");
//				dr.manage().window().maximize();
//				result = TestLinkAPIResults.TEST_PASSED;
//				updateTestLinkResult("TL-1", null, result);
//			} 
//		catch (Exception e){
//				result = TestLinkAPIResults.TEST_FAILED;
//				exception = e.getMessage();
//				updateTestLinkResult("TL-1", exception, result);
//			}
//		try {
//				dr.findElement(By.id("Email")).sendKeys("your gmail login id");
//				Thread.sleep(2000);
//				dr.findElement(By.id("next")).click();
//				Thread.sleep(1000);
//				dr.findElement(By.id("Passwd")).sendKeys("*********");
//				Thread.sleep(1000);
//				dr.findElement(By.id("signIn")).click();
//				result = TestLinkAPIResults.TEST_PASSED;
//				updateTestLinkResult("TL-2", null, result);
//			} 
//		catch (Exception e) {
//				result = TestLinkAPIResults.TEST_FAILED;
//				exception = e.getMessage();
//				updateTestLinkResult("TL-2", exception, result);
//			}
//		}
//		private void updateTestLinkResult(String testCase, String exception, String result) throws TestLinkAPIException{
//			System.out.println(DEV_KEY);
//			System.out.println(SERVER_URL);
//		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY, SERVER_URL);
//		System.out.println("it started execution");
//		System.out.println(testlinkAPIClient.isConnected);
//		String builds = testlinkAPIClient.getBuildsForTestPlan(6).toString();
//		System.out.println(builds);
//		//Without comment for the execution
////		testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase, BUILD_NAME, exception, result);
//		//With comment for the execution
//		testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase, BUILD_NAME, "This was passed using automation", result);
//	}
//}
