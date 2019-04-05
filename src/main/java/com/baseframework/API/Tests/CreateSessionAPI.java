package com.baseframework.API.Tests;

import java.util.Random;

import org.json.simple.JSONObject;

import com.baseframework.automationFramework.AutomationConfiguration;
import com.baseframework.automationFramework.AutomationLog;
import com.baseframework.automationFramework.ObjectManager;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateSessionAPI {
	
	JSONObject ipAddressJSON = new JSONObject();
	ObjectManager objManager = new ObjectManager();
	AutomationLog log = AutomationLog.getAutomationLog();
	Response res;
	
	public Response createSessionUsingCampaigns(int campaignIDs) {
		try {
			Random r = new Random();
			String ip = r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
			
			ipAddressJSON.put("ip", ip);
			log.info(ipAddressJSON.toString());
			objManager.getAutomationConfiguration();
			RestAssured.baseURI = AutomationConfiguration.getConfigurationValueForProperty("apiURL");
			
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");
			request.header("authorization",
					"Token token=\"DaXlKZTCszQEe9PJQziBcGBTIlcChYynvEKr4WWUhVpEIk3Jrh0BL6hm8PVl7UUX\"");
			request.body(ipAddressJSON.toJSONString());
			request.queryParam("campaigns", campaignIDs);
			res = request.post("/sessions");
			System.out.println(res.asString());
			return res;
		}
		catch(Exception e) {
			log.error(e.toString());
			return null;
		}
	}
	

}
