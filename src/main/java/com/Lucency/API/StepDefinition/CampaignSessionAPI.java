package com.Lucency.API.StepDefinition;

import java.net.URL;

import org.json.simple.JSONObject;

import com.Lucency.Utilities.AutomationConfiguration;
import com.Lucency.Utilities.AutomationLog;
import com.Lucency.Utilities.ObjectManager;
import com.mongodb.util.JSON;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CampaignSessionAPI {

	AutomationLog log = AutomationLog.getAutomationLog();
	Response res;

	JSONObject ipAddressJSON = new JSONObject();
	ObjectManager objManager = new ObjectManager();
	static String[] sessionIDs;

	@Given("^Creating (\\d+) session for the Campaign (\\d+)$")
	public void creating_session_for_the_Campaign(int counts, int campaignIDs) throws Throwable {
		counts = (90 * counts ) / 100 ;
		System.out.println(counts);
				sessionIDs = new String[counts+1	];

		try {
			for (int i = 0; i <= counts; i++) {
				res = objManager.getCreateSession().createSessionUsingCampaigns(campaignIDs);
				sessionIDs[i] = res.jsonPath().getString("session_id");
				System.out.println(i + "        " + sessionIDs[i]);
			}

			for (int i = 0; i < sessionIDs.length; i++) {
				System.out.println(sessionIDs[i]);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@When("^the session id is retrieved and saved in an array$")
	public void the_session_id_is_retrieved_and_saved_in_an_array() throws Throwable {

	}

	@Then("^the same session_id is continuously updated with random keys and its value$")
	public void the_same_session_id_is_continuously_updated_with_random_keys_and_its_value() throws Throwable {

	}

}
