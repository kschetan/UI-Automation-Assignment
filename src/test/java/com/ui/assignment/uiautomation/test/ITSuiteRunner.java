package com.ui.assignment.uiautomation.test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/features",
		glue = {"com.ui.assignment.uiautomation.stepdefinition"},
//		plugin = {"html:target/reports/cucumber/index.html","json:target/report.json"},
		stepNotifications = true
		
		)
public class ITSuiteRunner {

}
