package com.baseframework.API.StepDefinition;

import org.junit.Assert;
import com.baseframework.automationFramework.AutomationLog;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqResAPIStatusCode {
	
	AutomationLog log = AutomationLog.getAutomationLog();
	Response res;

	@Given("^when the GET request is passed$")
	public void when_the_GET_request_is_passed() throws Throwable {
		res = RestAssured.get("https://reqres.in/api/users/2");
		String printResponse = res.prettyPrint();
		log.info("Response : " +printResponse);
	}

	@Then("^the response should contain (\\d+) in its response code$")
	public void the_response_should_contain_in_its_response_code(int responseCode) throws Throwable {
		int responseStatusCode = res.getStatusCode();
		Assert.assertEquals( "Correct status code returned",responseStatusCode /*actual value*/, responseCode /*expected value*/);
		log.info("Test Case has passed as the status code is same as 200");
	}	
}
