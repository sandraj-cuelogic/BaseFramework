#@smoke
Feature: Accounts module verification

#@ignore
Scenario:
	Verify create user functionality using super admin login
	
	Given Login to the application with super admin and navigate to Accounts module
#	Then Add new User with Integrator role
	Then Add new user with Admin role
	
#@ignore
Scenario:
	Verify create user functionality using Integrator login
	
	Given Login to the application with Integrator and navigate to Users module
	
Scenario:
	Create new account with admin and integrator users.
	
	Given Login with superadmin to Lucency portal and verify create new account functionality by creating admin and integrator users
	Then Verify create new account functionality with alphanumeric account name
	Then Verify create new account functionality with numeric account name