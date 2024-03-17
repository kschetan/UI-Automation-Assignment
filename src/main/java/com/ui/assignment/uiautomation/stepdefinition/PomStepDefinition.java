package com.ui.assignment.uiautomation.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ui.assignment.uiautomation.action.PageAction;
import com.ui.assignment.uiautomation.utils.BrowserHelper;

import io.cucumber.java8.En;

public class PomStepDefinition extends CucumberStepDefinition implements En{
	
	WebDriver driver = browserHelper.createChromDriver();
	PageAction action = new PageAction();
	
	
//	@Value("${url}")
//	private String url;
	
	public PomStepDefinition() {
		
		Given("I am on {string} page", (String url) ->{
					driver.get(url);
					driver.manage().window().maximize();
					action.searchItem(driver, "Monitor");
					action.selectOrderItem(driver, 1, "item1");
					
					
					
					
				});// TODO Auto-generated constructor stub
//		Then("I Search for an item {int} I Search for an item",(Integer order)->{
//			
//			browserHelper.getChromDriver().get(EMPTY_TAG_EXPRESSION)
//		});
		
		
		And ("I navigate to the product page and capture the product price",()->{
			
		}); 
	    And ("I add the item to the cart by clicking on Add to Cart button",()->{
	    	
	    });
	    And ("I open the Cart by clicking the top-right cart icon",()->{
	    	
	    });
	    Then ("I validate the sub total amount from cart with {string} product page price",(String item)->{
	    	
	    	
	    });
	}
	
	

}
