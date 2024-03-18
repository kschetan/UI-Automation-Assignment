package com.ui.assignment.uiautomation.stepdefinition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.ui.assignment.uiautomation.action.PageAction;
import com.ui.assignment.uiautomation.validation.PageValidation;

import io.cucumber.java8.En;

public class AddCartStepDefinition extends CucumberStepDefinition implements En {
	
	// WebDriver driver = browserHelper.createChromDriver();
	 PageAction pageAction = new PageAction();
	 PageValidation pageValidation = new PageValidation();
	
	
	/*
	 * @Value("${url}") private String url;
	 * 
	 * @Value("${browserType}") private String browserType;
	 * 
	 * @Autowired PageAction pageAction;
	 * 
	 * @Autowired PageValidation pageValidation;
	 */
	
	public AddCartStepDefinition() {
		
		
		Given("I am on amazon home page", () -> {
			pageAction.navigateHomePage();

		});
		 		
		Then("I Search for an item {string} and press enter",(String item)->{
			pageAction.searchItem(item);

		});
		
		And ("I navigate to the product page and capture the {string} product price",(String itemName)->{
			pageAction.getProductPrice(itemName);
		});
		
	    And ("I add the item to the cart by clicking on Add to Cart button",()->{
	    	pageAction.addItemToCart();
	    });
	    
	    And ("I open the Cart by clicking the top-right cart icon",()->{
	    	pageAction.clickOnCart();
	    });
	    
	    Then ("I validate the sub total amount from cart with {string} product page price",(String item)->{
	    	
	    	pageValidation.priceValidation(item);
	    });
	}	

}
