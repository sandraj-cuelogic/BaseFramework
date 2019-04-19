#@smoke
Feature: Verify Create Country pool, view numbers and phone request modules
	
Scenario:

	Verify create country pool funtionality for integrator
	
	Given Login with Integrator and create country pool for IN country	
	Then Edit any of the country pool and request more numbers
	Then Verify the edit country pool if user clear the pool name also the Remove number should be disabled 