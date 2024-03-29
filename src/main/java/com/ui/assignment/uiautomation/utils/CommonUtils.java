package com.ui.assignment.uiautomation.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.FileCopyUtils;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtils {

	public static WebDriver driver;
	public Actions action = null ;
	
	/*
	 * @Autowired BrowserHelper browserHelper;
	 */

	/*
	 * public CommonAction(WebDriver driver) { this.driver = driver; }
	 */

	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement webElement = null;
		switch (locatorType) {
		case "id": {
			webElement = driver.findElement(By.name(locatorValue));
			break;
		}

		case "name": {
			webElement = driver.findElement(By.name(locatorValue));
			break;
		}

		case "css": {
			webElement = driver.findElement(By.cssSelector(locatorValue));
			break;
		}

		case "xpath": {
			webElement = driver.findElement(By.xpath(locatorValue));
			break;
		}

		case "className": {
			webElement = driver.findElement(By.className(locatorValue));
			break;
		}

		case "linkText": {
			webElement = driver.findElement(By.linkText(locatorValue));
			break;
		}

		case "partialLinkText": {
			webElement = driver.findElement(By.partialLinkText(locatorValue));
			break;
		}
		default:
			webElement= null;
		
		}
		return waitForElementToBeVisible(webElement , 20);
	}

	private WebElement waitForElementToBeVisible(WebElement wb, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(wb));
		return wb;
	}

	private WebDriverWait waitForElementToBeClickable(WebElement wb, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(wb));
		return wait;
	}

	public void defaultframe() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void frame(String name) {
		try {
			driver.switchTo().frame(name);
		} catch (Exception e) {
		}
	}

	public void tearbrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
		}
	}

	public void takeScreenshot(String name) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileCopyUtils.copy(src, new File(System.getProperty("user.dir") + "\\src\\test\\java\\screenshot\\" + name
					+ System.currentTimeMillis() + ".jpg"));
		}
		catch (IOException e) {
		}
	}
	
	public Select getSelect(WebElement element) {
		Select select = new Select(element);
		return select;
	}

		
	public void scrollToView() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,-700);", "");
	}
	
	public void scrollToElement(WebElement element) {
		action = new Actions(driver);
		action.scrollToElement(element).click().perform();
	}
	
	public void moveToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	/*
	 * public void launchWebUrl(String url) { driver.get(url); }
	 */
	public void switchToChildWindow() {

		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String child : windows) {
			if (!child.equals(parent)) {

				driver.switchTo().window(child);

			}

		}
	}
}
