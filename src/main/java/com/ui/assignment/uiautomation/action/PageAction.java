package com.ui.assignment.uiautomation.action;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.assignment.uiautomation.utils.WorldObject;

public class PageAction {

	private static final String SEARCH_ITEM = "//*[@id='twotabsearchtextbox']";
	private static final String PRODUCT_PAGE_PRICE = "//div[contains(@id , 'corePriceDisplay_')]//span[@class='a-price-whole']";
	private static final String ADD_TO_CART = "//input[@id='add-to-cart-button']";
	private static final String SUB_TOTAL_PRICE = "//span[@id='sc-subtotal-amount-buybox']//span[contains(@class, 'currency')]//..";
	private static final String ITEM_ORDER = "//div[@*='s-search-result'][%s]";
	private static final String CART = "//div[@id='nav-cart-count-container']";
	private static final String CART_PRODUCT_PAGE = "//span[@id='attach-sidesheet-view-cart-button']";

	public void searchItem(WebDriver driver, String item) {

		driver.findElement(By.xpath(SEARCH_ITEM)).click();
		driver.findElement(By.xpath(SEARCH_ITEM)).sendKeys(item);
		driver.findElement(By.xpath(SEARCH_ITEM)).sendKeys(Keys.ENTER);

	}

	public void selectOrderItem(WebDriver driver, int orderItem, String itemPrice) throws Exception {
//		driver.
		Actions action = new Actions(driver);

//		action.scrollToElement(driver.findElement(By.xpath(String.format(ITEM_ORDER, orderItem))));
		driver.findElement(By.xpath(String.format(ITEM_ORDER, orderItem))).click();
		Thread.sleep(20000);
		getProductPrice(driver, itemPrice);
		addToCart(driver);
		navigateToCart(driver);

		if (Double.parseDouble(getSubTotal(driver)) == Double.parseDouble(WorldObject.world.get(itemPrice))) {
			System.out.println("Price are same");
		}
	}

	public void addToCart(WebDriver driver) throws Exception {
//		Actions action = new Actions(driver);
//		action.scrollToElement(driver.findElement(By.xpath(ADD_TO_CART)));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,-700);", "");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(8000));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ADD_TO_CART))));
		driver.findElement(By.xpath(ADD_TO_CART)).click();
		Thread.sleep(8000);
	}

	public void getProductPrice(WebDriver driver, String itemPrice) {
		System.out.println(driver.getWindowHandles());
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		System.out.println("Product price is ::::::::::::::::::::::::::::"
				+ driver.findElement(By.xpath(PRODUCT_PAGE_PRICE)).getText());
		WorldObject.world.put(itemPrice, driver.findElement(By.xpath(PRODUCT_PAGE_PRICE)).getText().replaceAll(",", ""));


	}

	public void navigateToCart(WebDriver driver) {
		if (driver.findElement(By.xpath(CART_PRODUCT_PAGE)).isDisplayed()) {
			driver.findElement(By.xpath(CART_PRODUCT_PAGE)).click();
		} else {
			driver.findElement(By.xpath(CART)).click();
		}
	}

	public String getSubTotal(WebDriver driver) {
		System.out.println(
				"subTotalPrice::::::::::::::::::::::" + driver.findElement(By.xpath(SUB_TOTAL_PRICE)).getText());
		driver.findElement(By.xpath(SUB_TOTAL_PRICE));
		return driver.findElement(By.xpath(SUB_TOTAL_PRICE)).getText().replaceAll(",", "");
	}

}
