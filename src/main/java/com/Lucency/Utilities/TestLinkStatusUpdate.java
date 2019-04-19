package com.Lucency.Utilities;
/*
 * package com.baseframework.automationFramework;
 * 
 * import testlink.api.java.client.TestLinkAPIClient; import
 * testlink.api.java.client.TestLinkAPIException;
 * 
 * public class TestLinkStatusUpdate {
 * 
 * public static String DEV_KEY =
 * AutomationConfiguration.getConfigurationValueForProperty("testLinkAPIKey");
 * public static String
 * SERVER_URL=AutomationConfiguration.getConfigurationValueForProperty(
 * "testLinkURL"); public static String
 * PROJECT_NAME=AutomationConfiguration.getConfigurationValueForProperty(
 * "testLinkProjectName");
 * 
 * 
 * public void updateTestLinkResultWithExecutionNote(String PLAN_NAME, String
 * BUILD_NAME, String EXECUTION_COMMENT, String testCase, String exception,
 * String result) throws TestLinkAPIException{
 * 
 * TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY,
 * SERVER_URL); AutomationLog.info("TestLink Connection has been established : "
 * +testlinkAPIClient.isConnected); //With comment for the execution
 * testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase,
 * BUILD_NAME, EXECUTION_COMMENT, result);
 * 
 * }
 * 
 * public void updateTestLinkResultWithoutExecutionNote(String PLAN_NAME, String
 * BUILD_NAME, String testCase, String exception, String result) throws
 * TestLinkAPIException{
 * 
 * TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY,
 * SERVER_URL); AutomationLog.info("TestLink Connection has been established : "
 * +testlinkAPIClient.isConnected); //Without comment for the execution
 * testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase,
 * BUILD_NAME, exception, result); }
 * 
 * public void updateTestLinkResultWithBugIDAndNotes(int PLAN_ID, int BUILD_ID,
 * int testCaseID, Boolean guess, String execNotes, String result, int bugID)
 * throws TestLinkAPIException{
 * 
 * TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY,
 * SERVER_URL); AutomationLog.info("TestLink Connection has been established : "
 * +testlinkAPIClient.isConnected); //With comment and bugID
 * testlinkAPIClient.reportTestCaseResult(PLAN_ID, testCaseID, BUILD_ID, bugID,
 * guess, execNotes, result); }
 * 
 * public void updateTestLinkResultUsingIDs(int testPlanID, int testCaseID, int
 * buildID, String execNotes, String testResultStatus) throws
 * TestLinkAPIException{
 * 
 * TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY,
 * SERVER_URL); AutomationLog.info("TestLink Connection has been established : "
 * +testlinkAPIClient.isConnected); //With comment and bugID
 * testlinkAPIClient.reportTestCaseResult(testPlanID, testCaseID, buildID,
 * execNotes, testResultStatus); }
 * 
 * }
 */