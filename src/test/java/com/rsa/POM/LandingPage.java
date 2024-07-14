package com.rsa.POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends ReuseableCode {
	 
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement email=driver.findElement(By.id("userEmail"));
	//PageFactory
	
	@FindBy(id="userEmail")
	WebElement emailElement;
	@FindBy(id="userPassword")
	WebElement passwordElement;
	@FindBy(id="login")
	WebElement sumbit;
	
	@FindBy(xpath="//div[contains(text(),'Incorrect email or password.')]")
	WebElement errMessege;
	
	public String getErrorMessege() {
		waitForElementToAppear(errMessege);
		System.out.println(errMessege.getText());
		return errMessege.getText();
			
	}


//	public List<WebElement> getProductsList() {
//			waitForElementToAppear(productsBy);
//			return products;
//			
//		}
	public ProductCatalogue loginApplication(String email, String password) {
		emailElement.sendKeys(email);
		passwordElement.sendKeys(password);
		sumbit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}

}
