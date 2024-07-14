package com.rsa.cucumber;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.rsa.POM.BaseTest;
import com.rsa.POM.CartPage;
import com.rsa.POM.CheckOutPage;
import com.rsa.POM.ConfirmationPage;
import com.rsa.POM.LandingPage;
import com.rsa.POM.ProductCatalogue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl extends BaseTest{
	
	public LandingPage landingPage;
	ProductCatalogue productCatalogue;
	ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce page")
	public void  I_landed_on_Ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {
		ProductCatalogue productCatalogue = landingPage.loginApplication(username, password);

	}
	
	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_Cart(String productName) {
		
		//List<WebElement> products = 
		productCatalogue.getProductsList();
		productCatalogue.addProductsToCart(productName);
		
	}
	@And("^Checkout (.+) and submit the order$")
	private void Checkout_and_submit_the_order(String productName) {
		CartPage cartPage=productCatalogue.goToCartPage();
		boolean match = cartPage.verifyTheProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutpage = cartPage.goToCheckOut();
		checkOutpage.selectCountry("India");
		confirmationPage = checkOutpage.submitOrder();
	}
	
	@Then("{String} messege is displayed on ConfirmationPage")
	private void messege_is_displayed_on_ConfirmationPage(String string) {
		String confirmationmessege = confirmationPage.getConfirmtionmessege();
		Assert.assertEquals(confirmationmessege, "THANKYOU FOR THE ORDER.");
		driver.close();
	}
	
	@Then("^\"([^\"]*)\" messege is displayed$")
    public void something_messege_is_displayed(String strArg1) throws Throwable {
		Assert.assertEquals(strArg1, landingPage.getErrorMessege());
		driver.close();
    }
	

}
