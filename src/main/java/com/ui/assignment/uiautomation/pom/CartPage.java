package com.ui.assignment.uiautomation.pom;

import org.openqa.selenium.WebDriver;

import com.ui.assignment.uiautomation.utils.CommonAction;

public class CartPage extends CommonAction {
	
	public CartPage(WebDriver driver) {
		super(driver);
	}

	private static final String CART = "//div[@id='nav-cart-count-container']";
	private static final String SUB_TOTAL_PRICE = "//span[@id='sc-subtotal-amount-buybox']//span[contains(@class, 'currency')]//..";
	private static final String CART_PRODUCT_PAGE = "//span[@id='attach-sidesheet-view-cart-button']";
	
	public boolean clickOnCart() {
		getWebElement("xpath", CART).click();
		return getWebElement("xpath", SUB_TOTAL_PRICE ).isDisplayed();
	}
	
	public String getSubTotal() {
		return getWebElement("xpath", SUB_TOTAL_PRICE).getText().replaceAll(",", "");
	}

}
