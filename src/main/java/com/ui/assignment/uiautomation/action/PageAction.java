package com.ui.assignment.uiautomation.action;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import com.ui.assignment.uiautomation.pom.CartPage;
import com.ui.assignment.uiautomation.pom.HomePage;
import com.ui.assignment.uiautomation.pom.ProductPage;
import com.ui.assignment.uiautomation.utils.BrowserHelper;
import com.ui.assignment.uiautomation.utils.CommonAction;

public class PageAction {
	
	@Autowired
	CommonAction commonAction;
	
	@Autowired
	BrowserHelper browserHelper;
	
	@Autowired	
	HomePage homePage;
	
	@Autowired
	ProductPage productPage;

	@Autowired
	CartPage cartPage;
	
	
	/*
	 * public void navigateHomePage(String url, String browserType) {
	 * browserHelper.getBrowser(browserType); commonAction.launchWebUrl(url); }
	 * 
	 * public void searchItem(String item, String browserType) { // HomePage
	 * homePage = new HomePage(driver);
	 * pomService.getHomePage(browserHelper.getBrowser(browserType));
	 * homePage.searchItem(item); assertThat(homePage.searchItem(item)).
	 * withFailMessage("Lists of < %s > is not displyed in search result", item)
	 * .isTrue(); }
	 */


	
	public void navigateHomePage(String url, String browserType) {
		browserHelper.getBrowser(browserType);
		commonAction.launchWebUrl(url);
	}
	
	public void searchItem( String item) {
		//HomePage homePage = new HomePage(driver);
		homePage.searchItem(item);
		assertThat(homePage.searchItem(item)).withFailMessage("Lists of < %s > is not displyed in search result", item).isTrue();
	}

	public void selectOrderItem(int orderItem) {	
		homePage.selectSearchProducts(orderItem);
	}
	
	public void getProductPrice(String itemPrice) {

		productPage.getProductPrice(itemPrice);
		assertThat(productPage.getProductPrice(itemPrice)).withFailMessage("Product price is not currectly captured")
				.isTrue();
	}
	
	public void addItemToCart() {	
		productPage.addToCart();
	}
	
	public void clickOnCart()
	{
		cartPage.clickOnCart();
	}
}
