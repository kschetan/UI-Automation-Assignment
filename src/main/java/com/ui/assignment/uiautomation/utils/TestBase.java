package com.ui.assignment.uiautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//@Getter
//@Setter
public class TestBase extends CommonUtils{
	
	/*
	 * @Autowired(required = true) public WebDriver createChromDriver() {
	 * 
	 * return new ChromeDriver(); }
	 */
	
	public void getBrowser(String browser) {
		switch (browser) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}

		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}	
		}
		driver.manage().window().maximize();
		//return driver;
	}
	
	public static void loadProperties() {
		Properties P = new Properties();
		File f;
		FileInputStream FI;

		f = new File(System.getProperty("user.dir") + "//src//main//resources//application.properties");
		try {
			FI = new FileInputStream(f);
			P.load(FI);
		} catch (IOException e) {
			Thread.currentThread().interrupt();
		}

	}

}
