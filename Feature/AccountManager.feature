@smoke
Feature: Verify Account Manager module

Scenario: 
	Verify Add User functionaity in Account Manager module
	
	Given Login to the application with Integrator and navigate to Users module.
	Then verify the Add User button is enable and create new Admin user.
	Then Create integrator user and verify it has listed in the tables.
	
Scenario:
	Verify Edit User functionality in Account Manager module
	
	When user is on Users module then click on Edit button of newly created user
	Then On Edit User popup, change the user name and user role and click on Save button
	Then verify Delete functionality for newly created user

