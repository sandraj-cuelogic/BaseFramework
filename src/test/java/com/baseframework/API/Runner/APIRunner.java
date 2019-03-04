package com.baseframework.API.Runner;

import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(features = "API_Features", glue = { "com.baseframework.API.StepDefinition" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)

@RunWith(Cucumber.class)
public class APIRunner {

	@BeforeClass
	public static void beforeTest() {
		System.out.println("test case is about start execution: Before class called");
	}

	@AfterClass
	public static void afterTest() {
		System.out.println("After class called ");

	}
}
