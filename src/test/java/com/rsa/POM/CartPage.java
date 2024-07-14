package com.rsa.POM;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends ReuseableCode{
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;

	public CartPage(WebDriver driver ) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTheProductDisplay(String productName) {
		boolean match = cartProducts.stream().anyMatch(cart-> cart.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckOut() {
		Actions a= new Actions(driver);
		a.moveToElement(checkoutEle).click().perform();;
		return new CheckOutPage(driver);
		
	}
	
	

}
