package com.ui.assignment.uiautomation.pom;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Configuration;

@Configuration
public abstract class PomServiceConfig {
	@Lookup
	public HomePage getHomePage(WebDriver driver) {
		return null;
	}

	@Lookup
	public ProductPage getProductPage(WebDriver driver) {
		return null;
	}

	@Lookup
	public CartPage getCartPage(WebDriver driver) {
		return null;
	}
}
