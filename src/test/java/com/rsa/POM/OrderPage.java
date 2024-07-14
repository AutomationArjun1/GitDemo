package com.rsa.POM;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends ReuseableCode{
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;

	public OrderPage(WebDriver driver ) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTheOrderDisplay(String productName) {
		boolean match = productNames.stream().anyMatch(cart-> cart.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	

}
