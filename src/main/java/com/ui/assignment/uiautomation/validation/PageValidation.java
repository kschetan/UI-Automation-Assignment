package com.ui.assignment.uiautomation.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.ui.assignment.uiautomation.pom.CartPage;
import com.ui.assignment.uiautomation.pom.InitPages;
import com.ui.assignment.uiautomation.utils.WorldObject;


public class PageValidation extends InitPages{
	
	public void priceValidation(String itemPrice) {		
		String subtotalPrice = cartPage.getSubTotal();
		String priceAtProductPage = WorldObject.world.get(itemPrice);
		assertThat(subtotalPrice).isEqualTo(priceAtProductPage);
	}
	
}
