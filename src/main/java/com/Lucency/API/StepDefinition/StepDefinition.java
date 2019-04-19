package com.Lucency.API.StepDefinition;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.Lucency.Utilities.AutomationLog;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.junit.Assertions;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.assertThat;
import org.hamcrest.Matcher.*;


/*
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import java.util.Map;
*/
public class StepDefinition{
	
		AutomationLog log = AutomationLog.getAutomationLog();
	  		
	  		Response resp;
	  		
	  		@When("^User Enter the baseURI$")
	  		public void user_Enter_the_baseURI() {	
	  				resp = RestAssured.get("https://jsonplaceholder.typicode.com/users");
					  		//	System.out.println(resp);
					  				String pprint = resp.prettyPrint();
					  				System.out.println("Beautify :"+pprint);
//					  			            Reporter.log(resp.asString(),true);
					  			            log.info(resp.asString());
	  		}
	  		
	  		@Then("^Status code should be (\\d+)$")
	  		public void status_code_should_be(int arg1){
				  			int sts_code = resp.getStatusCode();
				  			//Assert.assertEquals(sts_code /*actual value*/, 200 /*expected value*/, "Correct status code returned");//valid status code
				  			Assert.assertEquals( "Correct status code returned",sts_code /*actual value*/, 200 /*expected value*/); //invalid status code
				  			/*System.out.println(sts_code);
				  							Reporter.log("Status code is", sts_code,true);*/
				  			
				  			
				  			//validate response status line; get the status line and then validate
				  			String statusLine = resp.getStatusLine();
				  			Assert.assertEquals("Correct status code returned",statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/);
	  			
	  		}

	  		@Then("^response header should be displayed$")
	  		public void response_header_should_be_displayed(){
	  		//to get the header details in string format
				  			Headers header= resp.headers();
				  			//System.out.println(header.getValue(headerName));
				  						   System.out.println("header name: "+header.toString());
				  						   
				  						   // Reader header of a give name. In this line we will get
				  						   // Header named Content-Type
				  						 String contentType = resp.header("Content-Type");
				  						System.out.println("Content-Type value: " + contentType);
				  						
				  						
				  						// Reader header of a give name. In this line we will get
				  						// Header named Server
				  						String serverType =  resp.header("Server");
				  						System.out.println("Server value: " + serverType);
				  						

				  						// Reader header of a give name. In this line we will get
				  						// Header named Content-Encoding
				  						String acceptLanguage = resp.header("Content-Encoding");
				  						System.out.println("Content-Encoding: " + acceptLanguage);
				  						
				  					
				  						//to get all the headers present in a key value pair
				  						// Iterate over all the Headers
				  						for(Header headers: header)
				  						{
				  							System.out.println("Key: " + headers.getName() + " Value: " + headers.getValue());
				  						}
				  						
				  						
				  						//Validating the header
				  						
				  						//Content-type
				  						String expectedContentType="application/json; charset=utf-8";
				  						Assert.assertEquals(contentType /* actual value */, expectedContentType /* expected value */);
				  						//Server name
				  						Assert.assertEquals(serverType /* actual value */, "cloudflare" /* expected value */);
				  						//accept language
				  						Assert.assertEquals(acceptLanguage /* actual value */, "gzip" /* expected value */);
				  						
	  		}	
				  						//AND annotation is not showing: it replacing "And" with "Then"
				  						
				  						@Then("^response body should be displayed$")
				  						public void response_body_should_be_displayed() {
				  						    // Write code here that turns the phrase above into concrete actions
				  							
				  							
				  							ResponseBody body = resp.getBody();
				  							System.out.println("Response Body is: " + body.asString());
				  							
				  							
//				  					 To check for sub string presence get the Response body as a String.
//				  					 Do a String.contains
//				  					if i want to check all the fields in the body
//				  							store all the values in a excel sheet
//				  							take a for each/for loop
//				  							put assert function into that loop and call the attributes from the excel sheet
				  					String bodyAsString = body.asString();
				  					Assert.assertEquals("Response body contains users",bodyAsString.contains("user") /*Expected value*/, true /*Actual Value*/);
				  					
				  					//ignore casesensitivity
				  			Assert.assertEquals("Response body contains users",bodyAsString.toLowerCase().contains("user") /*Expected value*/, true /*Actual Value*/);
				  							
				  							
//				  					Response interface gives you a mechanism to extract nodes based on a given JsonPath.
//				  					There is a method called Response.JsonPath(), which returns a io.restassured.path.json.JsonPath Object. 
//				  					This object can be used to further query specific parts of the Response Json.
//				  							
//				  					 First get the JsonPath object instance from the Response interface
				  						JsonPath jsonPathEvaluator = resp.jsonPath();
				  					
//				  					 Then simply query the JsonPath object to get a String value of the node 
//				  					 specified by JsonPath: City (Note: You should not put $. in the Java code)
				  						String id = jsonPathEvaluator.get("id").toString();
				  					
//				  					  Let us print the city variable to see what we got
				  						System.out.println("id received from Response " + id);
				  					
				  						// it will print all the username received from the response
					  					String username = jsonPathEvaluator.get("username").toString();
					  					System.out.println("username received from Response " + username);
				  					
				  					//it will print all the name received from the response
					  					String name = jsonPathEvaluator.get("name").toString();
					  					System.out.println("Name received from Response " + name);
				  					
				  					//It will print all the emails received from the response
					  					String email = jsonPathEvaluator.get("email").toString();
					  					System.out.println("Email received from Response " + email);
					  					
					  					
					  					
					  					
					  					
					  					//POST request
					  					//step1: Create a Request pointing to the service endpoint
					  					
					  					RestAssured.baseURI ="https://jsonplaceholder.typicode.com/users";
					  					RequestSpecification request = RestAssured.given();
					  					
					  					
					  					//Step2:Create a JSON request which contains all the fields
					  					// JSONObject is a class that represents a Simple JSON.
						  				// We can add Key - Value pairs using the put method
						  				JSONObject requestParams = new JSONObject();
						  				//requestParams.put("id", ""); 
						  				requestParams.put("name", "Ruposree Das");
						  				requestParams.put("username", "Rupo");
						  				
						  				JSONObject address = new JSONObject();
						  				requestParams.put("address",  address);
						  				address.put("street", "abc");
						  				address.put("suite", "abc");
						  				address.put("city", "abc");
						  				address.put("zipcode", "abc");
						  				
						  				JSONObject geo = new JSONObject();
						  				requestParams.put("geo",  geo);
						  				geo.put("lat", "-1.234");
						  				geo.put("lng", "82.890");
						  				
						  				
						  				requestParams.put("phone",  "someuser@gmail.com");
						  				requestParams.put("website",  "someuser@gmail.com");
						  				requestParams.put("company",  "someuser@gmail.com");
						  				//adding nested object
						  				JSONObject company = new JSONObject();
						  				requestParams.put("company",  company);
						  				company.put("name",  "someuser@gmail.com");
						  				company.put("catchPhrase",  "someuser@gmail.com");
						  				company.put("bs",  "someuser@gmail.com");
						  				
						  				
						  				
					  				
						  				//Step 3: Add JSON body in the request and send the Request
										//for post request how to fetch the data
					  					// Add a header stating the Request body is a JSON
					  					request.header("Content-Type", "application/json; charset=utf-8");
					  					
					  					// Add the Json to the body of the request
					  					request.body(requestParams.toJSONString());

					  					// Post the request and check the response
					  					Response response = request.post("https://jsonplaceholder.typicode.com/users");//need to be change
					  					System.out.println(response.asString());
					  					
					  					
					  	
					  					
					  					//Step 4: Validate the Response
					  					int statusCode = response.getStatusCode();
					  					Assert.assertEquals(statusCode, 201);
					  					/*
					  					String successCode = response.jsonPath().get("statuscode");
					  					System.out.println("successCode");*/
					  					
					  					//Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
					  					
					  					
					  					//field validation
					  					
//										How to make sure that my response, let's say it is in JSON, 
//										either contains or does not contain a specific field?
//										There has to be a way to assert whether my JSON will contain or not the fields age and surname.

					  					
					  					//request.body("surname", equals(null));
					  					
					  					
					  					//for authentication and authorization
					  					
					  					RestAssured.baseURI = System.getProperty("baseurl");
					  					PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
					  					authScheme.setUserName("admin");
					  					authScheme.setPassword("admin");
					  					RestAssured.authentication = authScheme;
					  					
				  						
				//Field validation: need to be check
					  					/*@Test
					  					 public void testMethod() {
					  						//given().when().get("http://www.google.com").then().statusCode(200);
					  						given()
					  						.when()
						  				    .get("/user/10")
						  				    .then()
						  				    .body("username", equals(null));
					  						
					  				
					  						 get("").then().assertThat().content("lotto.lottoId", equalTo());
					  						 
					  						get("").then().
					  			            root("x.%s"). // Root path with a placeholder
					  			            content(withArgs("firstName"), equalTo()).
					  			            content(withArgs("lastName"), equalTo());
					  						.body("$", hasKey("username"))
						  				   	.body("$", not(hasKey("phone")));
					  						
					  						given().when().get("/garage").then()
						  					.body(containsString("Acme garage"));
					  						
					
											Response resp = given().contentType("application/json").body(requestDto).when().post("/url");
					  					    ResponseDto response = resp.then().statusCode(200).as(ResponseDto.class);
					  					    Assertions.assertThat(response.getField()).isNotNull();
					  					    
					  					    
					  					    //given().auth().basic(username, password).when().get("/uri/").then().statusCode(200);
					  					    
					  					    }
					  					    
					  					  */
					  					 
				  						}
}
					  					
					  								
	  		
	  	 
	  	
	  		
	  		
	  	 
	

