package com.ui.assignment.uiautomation.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.ui.assignment.uiautomation.pom.CartPage;
import com.ui.assignment.uiautomation.utils.WorldObject;


public class PageValidation {
	

	@Autowired
	CartPage cartPage;

	public void priceValidation(String itemPrice) {		
		String subtotalPrice = cartPage.getSubTotal();
		String priceAtProductPage = WorldObject.world.get(itemPrice);
		assertThat(subtotalPrice).isEqualTo(priceAtProductPage);
	//	assertThat(subtotalPrice).withFailMessage("Sub Total Price < %s > did not match with product page price < %s >",subtotalPrice,priceAtProductPage).
	}
	
}
