package com.rsa.POM;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitOderTest extends BaseTest{
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider = "getdata", groups = {"purchase"},enabled = true)
	public void submitOrder(HashMap<String,String> input) throws IOException {
		
		//logging to page
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("passwd"));
		
		//adding to cart
		
		productCatalogue.getProductsList();
		productCatalogue.addProductsToCart(input.get("product"));
		
		//navigating to cart
		CartPage cartPage=productCatalogue.goToCartPage();
		//verifying the cart
		boolean match = cartPage.verifyTheProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOutPage checkOutpage = cartPage.goToCheckOut();
		checkOutpage.selectCountry("India");
		ConfirmationPage confirmationPage = checkOutpage.submitOrder();
		String confirmationmessege = confirmationPage.getConfirmtionmessege();
		Assert.assertEquals(confirmationmessege, "THANKYOU FOR THE ORDER.");
	}
	
	@Test(dependsOnMethods = "submitOrder")
	public void orderTest() {
		ProductCatalogue productCatalogue1 = landingPage.loginApplication("malli151828@gmail.com", "Malli@828");
		OrderPage ordersPage = productCatalogue1.goToOrdersPage();
		ordersPage.verifyTheOrderDisplay(productName);
	}
	
//	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file= new File(System.getProperty("user.dir")+"//reports"+testCaseName+".png");
//		FileUtils.copyFile(source, file);
//		return System.getProperty("user.dir")+"//reports"+testCaseName+".png";
//	}
	
	@DataProvider
	public Object[][] getdata() throws IOException {

		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"/src/test/java/com/rsa/Data/PurchaseOrder.json");
		 
		return new Object [] [] {{data.get(0)},{data.get(1)}};
		
	}
	
//	public Object[][] getData() {
//		return new Object[][] {{"malli151828@gmail.com","Malli@828","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
//	}
	
	
//	 HashMap<String,String> map = new HashMap<String, String>();
//	 map.put("email", "malli151828@gmail.com");
//	 map.put("passwd", "Malli@828");
//	 map.put("productName", "ZARA COAT 3");
//	 
//	 HashMap<String,String> map1 = new HashMap<String, String>();
//	 map1.put("email", "shetty@gmail.com");
//	 map1.put("passwd", "Iamking@000");
//	 map1.put("productName", "ADIDAS ORIGINAL");	

}
