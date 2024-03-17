package com.ui.assignment.uiautomation.stepdefinition;

import org.springframework.boot.test.context.SpringBootTest;

import com.ui.assignment.uiautomation.context.SpringContext;

import io.cucumber.java.After;
import io.cucumber.spring.CucumberContextConfiguration;


@CucumberContextConfiguration
@SpringBootTest(classes= {SpringContext.class})
public class Hooks extends CucumberStepDefinition {

//	@After
//	public void cleanUpWebDrivers() {
//		browserHelper.createChromDriver().quit();
//	}
}
