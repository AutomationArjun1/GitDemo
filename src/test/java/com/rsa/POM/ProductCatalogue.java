package com.rsa.POM;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.quiz.Checkbox;

public class ProductCatalogue extends ReuseableCode {

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	
//	@FindBy(css=".cartSection h3")
//	List<WebElement> cartProducts;
//	
//	@FindBy(css=".totalRow button")
//	WebElement checkout;
	
	
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessege = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductsList() {
		waitForElementToAppear(productsBy);
		return products;
		
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod=products.stream().filter(product-> product
				.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	
	public  void addProductsToCart(String productName) {
		//prod.findElement(addToCart).click();
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessege);
		waitForElementToDisappear(spinner);
	}

	
	
//	public boolean verifyTheProductDisplay(String productName) {
//		boolean match = cartProducts.stream().anyMatch(cart-> cart.getText().equalsIgnoreCase(productName));
//		return match;
//	}
	
	
	
//	public CheckOutPage goToCheckout(String productName) {
//		Actions a= new Actions(driver);
//		a.moveToElement(checkout).click().perform();;
//		return new CheckOutPage(driver);
//	}
}
