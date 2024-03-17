package com.ui.assignment.uiautomation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Getter
//@Setter
public class BrowserHelper {
	
	/*
	 * @Autowired(required = true) public WebDriver createChromDriver() {
	 * 
	 * return new ChromeDriver(); }
	 */
	public WebDriver driver;
	
	public WebDriver getBrowser(String browser) {
		switch (browser) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
			driver.manage().window().maximize();
		}
		return driver;
	}
}
