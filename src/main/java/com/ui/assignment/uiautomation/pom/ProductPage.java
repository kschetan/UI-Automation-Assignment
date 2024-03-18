package com.ui.assignment.uiautomation.pom;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.ui.assignment.uiautomation.utils.CommonUtils;
import com.ui.assignment.uiautomation.utils.WorldObject;

@Component
public class ProductPage extends CommonUtils{
	
	/*
	 * public ProductPage(WebDriver driver) { super(driver); // TODO Auto-generated
	 * constructor stub }
	 */

	private static final String PRODUCT_PAGE_PRICE = "//div[contains(@id , 'corePriceDisplay_')]//span[@class='a-price-whole']";
	private static final String ADD_TO_CART = "//input[@id='add-to-cart-button']";
	private static final String CART_PRODUCT_PAGE = "//span[@id='attach-sidesheet-view-cart-button']";
	
	public boolean getProductPrice(String itemPrice) {
		switchToChildWindow();
		String productPrice = getWebElement("xpath", PRODUCT_PAGE_PRICE).getText();
		WorldObject.world.put(itemPrice, productPrice.replaceAll(",", ""));
		return productPrice.isEmpty();
	}
	
	public void addToCart() {
		scrollToView();
		//waitForElementToBeVisible(getWebElement("xpath", ADD_TO_CART), 20);
		getWebElement("xpath", ADD_TO_CART).click();
	}

}
