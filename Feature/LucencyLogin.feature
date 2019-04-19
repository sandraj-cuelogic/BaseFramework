@FeatureFileName 
Feature: Login to Shadow Application 
#@ignore
Scenario Outline: Login with valid credentials 
	Given User should navigate to login page and login to application to "<browserName>"
	Then verify that user has successful logged to application 
	Examples: 
		| browserName |
		
		
		#@ignore
Scenario Outline: Login with invalid credentials
	Given Validate the login functionality with invalid credentials to "<browserName>"
	Examples: 
		| browserName |
		
		
		#@ignore
Scenario Outline: Verify the forgot password functionality
	Given Enter email id on ForgotPassword popup to "<browserName>"
	Then Verify email notification in the email 
	Examples: 
		| browserName |
		| chrome |