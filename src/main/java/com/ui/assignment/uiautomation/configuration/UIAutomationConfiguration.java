package com.ui.assignment.uiautomation.configuration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class UIAutomationConfiguration {
	
	
	@Bean

	@Autowired(required = true)
	public ChromeDriver getBrowserHelper() {
		return getBrowserHelper();
	}
	 
}
