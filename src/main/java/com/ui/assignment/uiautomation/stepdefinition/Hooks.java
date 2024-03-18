package com.ui.assignment.uiautomation.stepdefinition;

import com.ui.assignment.uiautomation.utils.TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
public class Hooks extends TestBase{
	
	@Before
	public void setUp() {
		loadProperties();
		getBrowser("chrome");
	}
	
	@After
	public void tearDown() {
		tearbrowser();
	}


}
