package com.Lucency.StepDefinition;


import com.Lucency.Utilities.SaveScreenShots;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public static void beforeTest() {
		
		System.out.println("test case is about start execution");
		
		 
	}
	
	 @After
	 public void tearDown(Scenario scenario) {
		 System.out.println("This is teardown method");
		 if(scenario.isFailed()) {
			 
			 SaveScreenShots.customScreenshot(scenario.getName());
		 	 
		 }
		 
	 }
}
