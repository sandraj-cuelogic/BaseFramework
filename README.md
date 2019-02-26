# BaseFramework
Base Framework is a cucumber + maven + POM based framework with parallel execution of test cases enabled in it


Commands for Parallel Execution of test cases

Following are the commands :

1.	This command is to create the feature files from the feature template
		mvn clean compile exec:java -Dexec.mainClass=com.baseframework.automationFramework.FeatureBuilder
2.	This command is to create the testrunner files using the runnerTemplate
		mvn clean compile exec:java -Dexec.mainClass=com.baseframework.automationFramework.TestRunnerBuilder
3.	To execute the test cases on multiple browsers
		mvn -DBrowserCount=3  -DChrome="chrome_" -DFirefox="firefox_" -DIE="ie_"  test


Commands to check for duplicated code

Add the mvn plugin - pmd https://mvnrepository.com/artifact/net.sourceforge.pmd/pmd/6.12.0
Run the command "mvn pmd:cpd-check"
This will generate a report to show duplicated code in your \target folder in an xml format