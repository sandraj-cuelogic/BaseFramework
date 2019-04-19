#@smoke
Feature: Login to Shadow Application
#@ignore
Scenario:
		Login with valid credentials
	Given User should navigate to login page and login to application
	Then verify that user has successful logged to application

#@ignore
Scenario:
		Login with invalid credentials
	Given Validate the login functionality with invalid credentials
#@ignore
Scenario:
		Verify the forgot password functionality
	Given Enter email id on ForgotPassword popup
	Then Verify email notification in the email