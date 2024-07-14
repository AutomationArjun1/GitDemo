package com.rsa.POM;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.net.httpserver.Authenticator.Retry;

public class ErrorValidationTest extends BaseTest{
	
	
	@Test(groups = {"ErrorHandling"}) //retryAnalyzer = Retry.class
	public void product() throws IOException, InterruptedException {
		SoftAssert soft = new SoftAssert();
		landingPage.loginApplication("Anshika@gmail.com", "Iamki000");
		soft.assertEquals("Incorrect email or password.", landingPage.getErrorMessege());
		soft.assertAll();
	}
	
//	@Test
//	public void productErrorvalidation() {
//		String productName = "ZARA COAT 3";
//		ProductCatalogue productCatalogue = landingPage.loginApplication("malli151828@gmail.com", "Malli@828");
//		
//		productCatalogue.getProductsList();
//		productCatalogue.addProductsToCart(productName);
//		CartPage cartPage=productCatalogue.goToCartPage();
//		boolean match = cartPage.verifyTheProductDisplay("ZARA COAT 3");
//		Assert.assertTrue(match);
//	}

}
